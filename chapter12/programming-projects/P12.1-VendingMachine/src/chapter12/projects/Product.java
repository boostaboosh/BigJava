package chapter12.projects;

/**
 * Represents a product in a shop.
 */
public class Product
{
   private String name;
   private Money price;

   /**
    * Constructs a product.
    * @param name the name of the product
    * @param price the price of the product
    */
   public Product(String name, Money price)
   {
      this.name = name;
      this.price = price;
   }

   /**
    * Gets the name of this product.
    * @return the name of this product
    */
   public String getName()
   {
      return this.name;
   }

   /**
    * Gets the price of this product.
    * @return the price of this product
    */
   public Money getPrice()
   {
      return this.price;
   }

   public boolean equals(Object object)
   {
      if (object == null || this.getClass() != object.getClass())
      {
         return false;
      }
      else
      {
         Product otherProduct = (Product) object;
         return name.equals(otherProduct.name) && price.equals(otherProduct.price);
      }
   }
}
