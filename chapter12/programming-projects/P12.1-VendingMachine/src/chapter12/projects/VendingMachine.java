package chapter12.projects;

import java.util.ArrayList;

/**
 * Represents a vending machine.
 * A vending machine is a self-regulating shop.
 * It sells products which can be purchased by customers.
 * A customer selects a product from a list of available products.
 * Then a customer adds coins to the vending machine.
 * If the coins are insufficient or the product is out of stock, they are returned.
 * Otherwise, the product is dispensed.
 * The vending machine does not give change if too much money was added.
 * Products can be restocked and money removed by an operator.
 */
public class VendingMachine
{
   private final ArrayList<StockedProduct> stockedProducts;
   private VendingMachineStatus state;
   private StockedProduct selectedStockedProduct;
   private final ArrayList<Coin> enteredCoins;
   private Money balance;

   /**
    * Constructs a new vending machine with the provided stocked products.
    * The vending machine starts in the SELECT state, with 0 balance.
    * @param stockedProducts the products stocked by the vending machine.
    */
   public VendingMachine(ArrayList<StockedProduct> stockedProducts, chapter12.projects.Currency currency)
   {
      this.stockedProducts = new ArrayList<>();
      this.addProducts(stockedProducts);
      state = VendingMachineStatus.SELECT;
      selectedStockedProduct = null;
      enteredCoins = new ArrayList<Coin>();
      balance = new Money(currency, 0.0);
   }

   /**
    * Gets the state of this vending machine.
    * Either SELECT when waiting for a product to be selected,
    * ENTER when waiting for the user to enter more coins,
    * or DISPENSE when dispensing change or a product to the user.
    * @return the state of this vending machine
    */
   public VendingMachineStatus getState()
   {
      return this.state;
   }

   /**
    * Adds stocked products to this vending machine.
    * If a product is already stocked in this vending machine its stock is incremented by the stocked product amount.
    * Otherwise, the new product is stocked in this vending machine by the stocked product amount.
    * @param stockToAdd the stocked products to add to the stock of this vending machine
    */
   private void addProducts(ArrayList<StockedProduct> stockToAdd)
   {
      for (StockedProduct newStockedProduct : stockToAdd)
      {
         boolean alreadyStocked = false;
         for (StockedProduct currenctStockedProduct : this.stockedProducts)
         {
            if (newStockedProduct.getProduct().equals(currenctStockedProduct.getProduct()))
            {
               alreadyStocked = true;
               currenctStockedProduct.restock(newStockedProduct.getStock());
            }
         }
         if (!alreadyStocked)
         {
            this.stockedProducts.add(newStockedProduct);
         }
      }
   }

   /**
    * Gets a list of the products stocked by this vending machine.
    * @return a list of products stocked by this vending machine
    */
   public ArrayList<StockedProduct> getStock()
   {
      return new ArrayList<>(this.stockedProducts);
   }

   /**
    * Selects a stocked product, and sets the state to ENTER.
    * (Precondition: state is SELECT)
    * @param stockedProduct the stocked product to select
    */
   public void selectProduct(StockedProduct stockedProduct)
   {
      if (this.state != VendingMachineStatus.SELECT)
      {
         throw new IncorrectStateException("Vending machine status must be SElECT to select a product.");
      }
      this.selectedStockedProduct = stockedProduct;
      this.state = VendingMachineStatus.ENTER;
   }

   /**
    * Accepts a coin from the customer.
    * (Precondition: state is ENTER)
    * @param coin the coin to accept
    */
   public void acceptCoin(Coin coin)
   {
      if (this.state != VendingMachineStatus.ENTER)
      {
         throw new IncorrectStateException("State must be ENTER to enter coins.");
      }
      if (!coin.getCurrency().equals(this.balance.getCurrency()))
      {
         throw new IllegalArgumentException
               (
                     "Entered coin currency must be the same as the vending machine currency.\n"
                     + "entered coin: " + coin + "\n"
                     + "vending machine currency: " + this.balance.getCurrency()
               );
      }
      this.enteredCoins.add(coin);
   }

   /**
    * Tells the vending machine to stop receiving coins,
    * and sets state to DISPENSE.
    * (Precondition: state is ENTER)
    */
   public void stopReceivingCoins()
   {
      if (!(this.state == VendingMachineStatus.ENTER))
      {
         throw new IncorrectStateException("Cannot stop receiving coins if vending machine state is not ENTER.");
      }
      this.state = VendingMachineStatus.DISPENSE;
   }

   /**
    * Gets a list of the coins entered by the customer.
    * @return a list of the coins entered by the customer
    */
   public ArrayList<Coin> getEnteredCoins()
   {
      return new ArrayList<>(this.enteredCoins);
   }

   /**
    * Gets the numeric value of the entered coins.
    * @return the numeric value of the entered coins
    */
   public double getEnteredCoinsNumericValue()
   {
      double total = 0;
      for (Coin coin : enteredCoins)
      {
         total = total + coin.getNumericValue();
      }
      return total;
   }

   /**
    * Gets the selected product.
    * (Precondition: state is ENTER or DISPENSE)
    * @return the selected product
    */
   public StockedProduct getSelectedStockedProduct()
   {
      if (this.state == VendingMachineStatus.SELECT)
      {
         throw new IncorrectStateException("Cannot get selected product if in the SELECT state.");
      }
      return this.selectedStockedProduct;
   }

   /**
    * Dispenses the selected product.
    * (Precondition: state is DISPENSE)
    */
   public void dispenseSelectedProduct()
   {
      if (!(this.state == VendingMachineStatus.DISPENSE))
      {
         throw new IncorrectStateException("Cannot dispense selected product if not in the DISPENSE state.");
      }
      for (StockedProduct stockedProduct : this.stockedProducts)
      {
         if (stockedProduct.getProduct().equals(this.selectedStockedProduct.getProduct()))
         {
            stockedProduct.setStock(stockedProduct.getStock() - 1);
            return;
         }
      }
   }

   /**
    * Adds the coins entered into the vending machine to the balance of this vending machine.
    */
   public void addEnteredCoinsToBalance()
   {
      this.balance = new Money
            (
                  this.balance.getCurrency(),
                  this.balance.getNumericValue() + this.getEnteredCoinsNumericValue()
            );
   }

   /**
    * Sets the state of this vending machine to the SELECT state.
    */
   public void returnToSelectStateAfterTransaction()
   {
      this.selectedStockedProduct = null;
      this.enteredCoins.clear();
      this.state = VendingMachineStatus.SELECT;
   }

   /**
    * Gets a list of the products that need to be restocked because their stock is 0.
    * @return a list of the products that need to be restocked
    */
   public ArrayList<Product> getProductsToRestock()
   {
      ArrayList<Product> products = new ArrayList<>();
      for (StockedProduct product : stockedProducts) {
         if (product.getStock() == 0)
         {
            products.add(product.getProduct());
         }
      }
      return products;
   }

   /**
    * Restocks a product by a specified quantity
    * @param product the product to restock
    * @param quantity the quantity to restock it by
    */
   public void restock(Product product, int quantity)
   {
      for (StockedProduct stockedProduct : this.stockedProducts)
      {
         if (stockedProduct.getProduct().equals(product))
         {
            stockedProduct.restock(quantity);
            return;
         }
      }
   }

   /**
    * Gets the balance of this vending machine.
    * @return the balance of this vending machine
    */
   public Money getBalance()
   {
      return this.balance;
   }

   /**
    * Empties the balance of this vending machine.
    */
   public void emptyBalance()
   {
      this.balance = new Money(this.balance.getCurrency(), 0.0);
   }
}
