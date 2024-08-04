public class CountableItem extends LineItem
{
   private int theQuantity;

   /**
    Constructs an item from the product and quantity.
    @param aProduct the product
    @param aQuantity the item quantity
    */
   public CountableItem(Product aProduct, int aQuantity)
   {
      super(aProduct);
      theQuantity = aQuantity;
   }

   public double getTotalPrice()
   {
      return super.getTotalPrice() * theQuantity;
   }

   public String format()
   {
      return String.format
            (
                  "%-30s%8.2f%5d%8.2f",
                  super.getProduct().getDescription(),
                  super.getProduct().getPrice(),
                  theQuantity,
                  getTotalPrice()
            );
   }
}
