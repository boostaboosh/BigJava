package chapter12.projects;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class StockedProductTest
{
   private Product product;
   private StockedProduct stockedProduct;
   private Currency currency;
   private Money money;

   @Before
   public void setUp() {
      currency = new Currency
            ("Mars Dollars", '\u20A9', new ArrayList<>(Arrays.asList(0.01, 0.05, 0.1, 0.25, 0.5)));
      money = new Money(currency, 10.0);
      product = new Product("Mars Bar", money);
      stockedProduct = new StockedProduct(product, 100);
   }

   @Test
   public void testConstructorInitializesFields() {
      // Assert that the product and stock are initialized correctly
      assertEquals(product, stockedProduct.getProduct());
      assertEquals(100, stockedProduct.getStock());
   }

   @Test
   public void testGetProduct() {
      // Assert that the product returned is correct
      assertEquals(product, stockedProduct.getProduct());
   }

   @Test
   public void testGetStock() {
      // Assert that the stock returned is correct
      assertEquals(100, stockedProduct.getStock());
   }

   @Test
   public void testSetStockUpdatesStock() {
      // Act: Update the stock quantity
      stockedProduct.setStock(50);

      // Assert: Verify that the stock was updated
      assertEquals(50, stockedProduct.getStock());
   }

   @Test(expected = IllegalArgumentException.class)
   public void testSetStockThrowsExceptionForNegativeQuantity() {
      // Act: Attempt to set a negative stock quantity
      stockedProduct.setStock(-10);

      // Assert: Exception is thrown, no need to explicitly assert in this case
   }
}