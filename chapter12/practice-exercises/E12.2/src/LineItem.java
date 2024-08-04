/**
   Describes a quantity of an article to purchase.
*/
public class LineItem
{
   private Product theProduct;

   /**
      Constructs an item from the product.
      @param aProduct the product
   */
   public LineItem(Product aProduct)
   {
      theProduct = aProduct;
   }
   
   /**
      Computes the total cost of this line item.
      @return the total price
   */
   public double getTotalPrice()
   {
      return theProduct.getPrice();
   }
   
   /**
      Formats this item.
      @return a formatted string of this item
   */
   public String format()
   {  
      return String.format
            (
                  "%-30s%8.2f%5s%8.2f",
                  theProduct.getDescription(),
                  theProduct.getPrice(),
                  "FIX",
                  getTotalPrice()
            );
   }

   /**
    * Gets the product associated with this line item.
    * @return the product associated with this line item
    */
   public Product getProduct()
   {
      return this.theProduct;
   }
}

