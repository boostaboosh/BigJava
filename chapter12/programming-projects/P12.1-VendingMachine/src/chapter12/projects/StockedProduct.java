package chapter12.projects;

/**
 * Represents a quantity of a product stocked in a shop.
 */
public class StockedProduct
{
   private Product theProduct;
   private int stock;

   /**
    * Creates a stocked product.
    * @param product the product to be stocked
    * @param stock the quantity of the product in stock
    */
   public StockedProduct(Product product, int stock)
   {
      this.theProduct = product;
      this.stock = stock;
   }

   /**
    * Gets the product.
    * @return the product
    */
   public Product getProduct()
   {
      return theProduct;
   }

   /**
    * Gets the stock of this stocked product.
    * @return the stock
    */
   public int getStock()
   {
      return stock;
   }

   /**
    * Checks if the stocked product is out of stock.
    * @return true if out of stock, i.e. quantity in stock is zero
    */
   public boolean isOutOfStock()
   {
      return getStock() == 0;
   }

   /**
    * Sets the quantity of this product in stock.
    * @param quantity the quantity of this stocked product
    */
   public void setStock(int quantity)
   {
      if (quantity < 0)
      {
         throw new IllegalArgumentException("Quantity of stock cannot be less than zero.");
      }
      stock = quantity;
   }

   /**
    * Increments the quantity of this product in stock by the specified amount.
    * @param quantity the amount to increment the stock of the product by
    */
   public void restock(int quantity)
   {
      if (quantity < 0)
      {
         throw new IllegalArgumentException("Cannot restock by negative amount.");
      }
      stock = stock + quantity;
   }
}
