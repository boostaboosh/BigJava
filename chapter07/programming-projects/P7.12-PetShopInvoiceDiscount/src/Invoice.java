import java.util.ArrayList;

/**
 * An invoice models a pet shop invoice.
 * It holds a collection of Item objects.
 */
public class Invoice
{
   ArrayList<Item> invoice;

   /**
    * Constructs an Invoice object.
    */
   public Invoice()
   {
      invoice = new ArrayList<>();
   }

   /**
    * Adds an item to the invoice.
    * @param anItem the item to add to the invoice
    */
   public void add(Item anItem)
   {
      this.invoice.add(anItem);
   }

   /**
    * Computes the pet shop discount on this invoice.
    * A pet shop gives clients a discount if they buy at least 1 pet,
    * and at least 5 other items.
    * The discount is equal to 20% of the price of the other items,
    * but not the pets.
    * @return the amount of discount the customer is due
    */
   public double getDiscount()
   {
      double discount = 0;
      final int DISCOUNT_PERCENTAGE = 20;
      
      boolean invoiceHasPet = false;
      int otherItemsCounter = 0;
      double otherItemsPrice = 0;
      for (Item item : this.invoice)
      {
         if (item.isPet())
         {
            invoiceHasPet = true;
         }
         else
         {
            otherItemsCounter = otherItemsCounter + item.getQuantity();
            otherItemsPrice = otherItemsPrice + item.getPrice() * item.getQuantity();
         }
      }
      
      if (invoiceHasPet && otherItemsCounter >= 5)
      {
         discount = otherItemsPrice / 100 * DISCOUNT_PERCENTAGE; 
      }
      
      return discount;
   }

   /**
    * Computes the total price of all items in this invoice.
    * @return the total price of all items in this invoice
    */
   public double getTotal()
   {
      double total = 0;
      
      for (Item item : this.invoice)
      {
         total = total + item.getPrice() * item.getQuantity();
      }
      
      return total;
   }
}
