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
      // TODO: fill implementation
   }

   /**
    * Adds an item to the invoice.
    * @param anItem the item to add to the invoice
    */
   public void add(Item anItem)
   {
      // TODO: fill implementation
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
      // TODO: fill implementation
      return 0;
   }
}
