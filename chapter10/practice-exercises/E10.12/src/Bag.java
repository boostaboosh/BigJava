import java.util.ArrayList;

public class Bag
{
   private ArrayList<Item> items;

   public Bag()
   {
      this.items = new ArrayList<>();
   }

   /**
    * Adds an item to this bag.
    * @param itemName the item to add
    */
   public void add(String itemName)
   {
      boolean inBag = false;
      int itemIndex = -1;
      boolean done = false;
      for (int index = 0; index < items.size() && !done; index++)
      {
         if (items.get(index).getName().equals(itemName))
         {
            inBag = true;
            itemIndex = index;
            done = true;
         }
      }

      if (inBag)
      {
         items.get(itemIndex).incrementQuantity();
      }
      else
      {
         items.add(new Item(itemName, 1));
      }
   }

   /**
    * Counts the amount of this item in the bag.
    * @param itemName the item to count
    * @return the quantity of this item in the bag
    */
   public int count(String itemName)
   {
      int count = 0;
      for (Item item : items)
      {
         if (item.getName().equals(itemName))
         {
            count = item.getQuantity();
         }
      }
      return count;
   }

   class Item
   {
      private String name;
      private int quantity;

      public Item(String aName, int aQuantity)
      {
         this.name = aName;
         this.quantity = aQuantity;
      }

      public String getName()
      {
         return this.name;
      }

      public int getQuantity()
      {
         return this.quantity;
      }

      public void incrementQuantity()
      {
         this.quantity = this.quantity + 1;
      }
   }
}
