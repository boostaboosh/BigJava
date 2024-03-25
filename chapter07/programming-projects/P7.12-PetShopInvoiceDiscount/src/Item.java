/**
 * An item models an entry in a pet shop invoice.
 */
public class Item
{
   private double price;
   private boolean isPet;
   private int quantity;
   
   /**
    * Constructs a pet shop invoice item.
    * @param price the price of one item
    * @param isPet true if item is a pet
    * @param quantity the amount of the item in the entry
    */
   public Item(double price, boolean isPet, int quantity)
   {
      this.price = price;
      this.isPet = isPet;
      this.quantity = quantity;
   }

   /**
    * Gets the price of the item
    * @return the price of the item
    */
   public double getPrice()
   {
      return this.price;
   }

   /**
    * Gets the quantity of the item in the entry.
    * @return the quantity of the item in the entry
    */
   public int getQuantity()
   {
      return this.quantity;
   }

   /**
    * Checks if the item is a pet.
    * @return true if the item is a pet
    */
   public boolean isPet()
   {
      return this.isPet;
   }
}
