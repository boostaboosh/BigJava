package chapter12.projects;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class VendingMachineTest
{
   private VendingMachine machine;
   private Product cola;
   private Currency usd;
   private StockedProduct stockedCola;

   @Before
   public void setUp() {
      // Initialize currency with some coin denominations
      ArrayList<Double> denominations = new ArrayList<>();
      denominations.add(0.25);
      denominations.add(1.0);
      usd = new Currency("USD", '$', denominations);

      // Initialize products and their prices
      cola = new Product("Cola", new Money(usd, 1.25));
      stockedCola = new StockedProduct(cola, 10);

      // ArrayList for Vending Machine initialization
      ArrayList<StockedProduct> products = new ArrayList<>();
      products.add(stockedCola);

      // Set up the Vending Machine with some products
      machine = new VendingMachine(products, usd);
   }

   @Test
   public void testSelectProduct() {
      machine.selectProduct(stockedCola);
      assertEquals("Selected product should be stockedCola", stockedCola, machine.getSelectedStockedProduct());
   }

   @Test(expected = IncorrectStateException.class)
   public void testSelectProductWrongState() {
      machine.selectProduct(stockedCola);
      machine.acceptCoin(new Coin(1.0, usd)); // Changes state to ENTER
      machine.selectProduct(stockedCola); // Should throw IncorrectStateException
   }

   @Test
   public void testAcceptAndDispenseCoins() {
      machine.selectProduct(stockedCola);
      machine.acceptCoin(new Coin(0.25, usd));
      machine.acceptCoin(new Coin(1.0, usd));
      machine.stopReceivingCoins();
      assertEquals("Total entered coins value should be 1.25", 1.25, machine.getEnteredCoinsNumericValue(), 0.0);
   }

   @Test(expected = IncorrectStateException.class)
   public void testAcceptCoinWrongState() {
      machine.acceptCoin(new Coin(1.0, usd)); // Should throw IncorrectStateException because no product selected
   }

   @Test
   public void testDispenseProduct() {
      machine.selectProduct(stockedCola);
      machine.acceptCoin(new Coin(1.0, usd));
      machine.acceptCoin(new Coin(0.25, usd));
      machine.stopReceivingCoins();
      machine.dispenseSelectedProduct();
      assertEquals("Stock after dispensing one cola should be 9", 9, stockedCola.getStock());
   }

   @Test(expected = IllegalArgumentException.class)
   public void testAcceptInvalidCoin() {
      machine.selectProduct(stockedCola);
      machine.acceptCoin(new Coin(2.0, usd)); // 2.0 is not a valid denomination, should throw IllegalArgumentException
   }

   @Test
   public void testGetProductsToRestock() {
      stockedCola.setStock(0); // Set stock to 0 to simulate a sold out product
      ArrayList<Product> productsToRestock = machine.getProductsToRestock();
      assertTrue("Products to restock should include Cola", productsToRestock.contains(cola));
   }
}