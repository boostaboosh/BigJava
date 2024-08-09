package chapter12.projects;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Contains a program which simulates a vending machine.
 */
public class VendingMachineSimulator
{
   /**
    * Runs the vending machine simulator program.
    */
   public static void main(String[] args)
   {
      Currency usd = new Currency
            (
                  "United States Dollar",
                  '$',
                  new ArrayList<>(Arrays.asList(0.01, 0.05, 0.1, 0.25, 0.5))
            );
      ArrayList<StockedProduct> startingStock = new ArrayList<>();
      startingStock.add(new StockedProduct(new Product("Choco-bar-inho", new Money(usd, 1.0)), 4));
      startingStock.add(new StockedProduct(new Product("Crispy Crisps", new Money(usd, 1.09)), 1));
      startingStock.add(new StockedProduct(new Product("Java ice coffee", new Money(usd, 1.49)), 2));
      startingStock.add(new StockedProduct(new Product("Super Cola", new Money(usd, 2.5)), 10));
      startingStock.add(new StockedProduct(new Product("Salted Peanuts", new Money(usd, 0.5)), 0));

      VendingMachine vendingMachine = new VendingMachine(startingStock, usd);

      Scanner inputGetter = new Scanner(System.in);
      boolean on = true;
      while(on)
      {
         boolean isCustomer = false;
         boolean isOperator = false;
         System.out.println("Are you a customer or an operator? (c/o)");
         String input = inputGetter.nextLine();
         if (input.equalsIgnoreCase("c"))
         {
            isCustomer = true;
         }
         else if (input.equalsIgnoreCase("o"))
         {
            isOperator = true;
         }
         else // input is not o or c
         {
            System.out.println("Invalid input. Enter \"c\" or \"o\".");
         }

         if (isCustomer)
         {
            boolean customerInteractionDone = false;
            while (!customerInteractionDone)
            {
               if (vendingMachine.getState() == VendingMachineStatus.SELECT)
               {
                  displayProducts(vendingMachine);
                  System.out.print("Select a product by number: ");
                  int selectedItemNumber = inputGetter.nextInt();
                  inputGetter.nextLine();
                  vendingMachine.selectProduct(vendingMachine.getStock().get(selectedItemNumber - 1));
               }
               else if (vendingMachine.getState() == VendingMachineStatus.ENTER)
               {
                  boolean validInput = false;
                  while (!validInput)
                  {
                     System.out.println("Do you want to enter more coins? (y/n)");
                     String answer = inputGetter.nextLine();
                     if (answer.equalsIgnoreCase("y"))
                     {
                        validInput = true;
                        Currency vendingMachineCurrency = vendingMachine.getBalance().getCurrency();
                        if (vendingMachine.getEnteredCoins().isEmpty())
                        {
                           System.out.println("Vending machine currency is " + vendingMachineCurrency.getName());
                           System.out.println("Coin denominations are: ");
                           for (Double value : vendingMachineCurrency.getCoinDenominations())
                           {
                              System.out.println("" + vendingMachineCurrency.getSymbol() + value);
                           }
                        }
                        System.out.print("Enter value of coin to enter: ");
                        double inputCoinValue = inputGetter.nextDouble();
                        inputGetter.nextLine();
                        vendingMachine.acceptCoin(new Coin(inputCoinValue, vendingMachineCurrency));
                        System.out.println
                              (
                                    "Balance: "
                                    + vendingMachineCurrency.getSymbol()
                                    + vendingMachine.getEnteredCoinsNumericValue()
                              );
                     }
                     else if (answer.equalsIgnoreCase("n"))
                     {
                        validInput = true;
                        vendingMachine.stopReceivingCoins();
                     }
                     else
                     {
                        System.out.println("Invalid input. Enter 'y' or 'n'.");
                     }
                  }
               }
               else if (vendingMachine.getState() == VendingMachineStatus.DISPENSE)
               {
                  StockedProduct selectedProduct = vendingMachine.getSelectedStockedProduct();
                  Money selectedProductPrice = selectedProduct.getProduct().getPrice();
                  boolean insufficientFunds = false;
                  if (vendingMachine.getEnteredCoinsNumericValue() < selectedProductPrice.getNumericValue())
                  {
                     insufficientFunds = true;
                     System.out.println
                           (
                                 "Insufficient funds. Provided: "
                                 + vendingMachine.getBalance().getCurrency().getSymbol()
                                 + vendingMachine.getEnteredCoinsNumericValue()
                                 + ". Required: "
                                 + selectedProductPrice.getCurrency().getSymbol()
                                 + selectedProductPrice.getNumericValue()
                           );
                  }
                  else if (selectedProduct.isOutOfStock())
                  {
                     System.out.println(selectedProduct.getProduct().getName() + " is out of stock.");
                  }
                  if (insufficientFunds || selectedProduct.isOutOfStock())
                  {
                     System.out.println("Returning entered coins: ");
                     for (Coin coin : vendingMachine.getEnteredCoins())
                     {
                        System.out.println("" + coin.getCurrency().getSymbol() + coin.getNumericValue());
                     }
                  }
                  else
                  {
                     vendingMachine.dispenseSelectedProduct();
                     vendingMachine.addEnteredCoinsToBalance();
                     System.out.println(selectedProduct.getProduct().getName() + " dispensed successfully.");
                  }
                  vendingMachine.returnToSelectStateAfterTransaction();
                  customerInteractionDone = true;
               }
            }
         }
         else if (isOperator)
         {
            boolean validResponse = false;
            while (!validResponse)
            {
               System.out.println("Do you want to restock, remove money, or turn off the vending machine? (rs/rm/to)");
               String operatorInput = inputGetter.nextLine();
               validResponse = true;
               if (operatorInput.equalsIgnoreCase("rs"))
               {
                  ArrayList<Product> productsToRestock = vendingMachine.getProductsToRestock();
                  System.out.println("Products that need restocking: ");
                  int productCounter = 1;
                  for (Product product : productsToRestock)
                  {
                     System.out.println(productCounter + ") " + product.getName());
                     productCounter = productCounter + 1;
                  }
                  System.out.println("Enter number of product to restock: ");
                  int numberOfProductToRestock = inputGetter.nextInt();
                  inputGetter.nextLine();
                  System.out.println("Enter quantity to restock product by: ");
                  int restockAmount = inputGetter.nextInt();
                  inputGetter.nextLine();
                  vendingMachine.restock(productsToRestock.get(numberOfProductToRestock - 1), restockAmount);
                  System.out.println("Product restocked successfully.");
               }
               else if (operatorInput.equalsIgnoreCase("rm"))
               {
                  Money moneyRemoved = vendingMachine.getBalance();
                  vendingMachine.emptyBalance();
                  System.out.println
                        (
                              "Removed "
                              + moneyRemoved.getCurrency().getSymbol()
                              + moneyRemoved.getNumericValue()
                              + " from vending machine."
                        );
               }
               else if (operatorInput.equalsIgnoreCase("to"))
               {
                  System.out.println("Turning vending machine off...");
                  on = false;
               }
               else
               {
                  validResponse = false;
               }
            }
         }
      }
   }

   /**
    * Displays the products in a vending machine.
    * @param vendingMachine the vending machine whose products to display
    */
   public static void displayProducts(VendingMachine vendingMachine)
   {
      int productCounter = 1;
      for (StockedProduct stockedProduct : vendingMachine.getStock())
      {
         Product product = stockedProduct.getProduct();
         String name = product.getName();
         String price = "" + product.getPrice().getCurrency().getSymbol() + product.getPrice().getNumericValue();
         System.out.println(productCounter + ": " + name + " " + price);
         productCounter = productCounter + 1;
      }
   }
}
