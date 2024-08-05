import java.text.NumberFormat;
import java.util.ArrayList;

/**
   Describes an invoice for a set of purchased products.
*/
public class Invoice
{  
   private Address billingAddress;
   private ArrayList<LineItem> items;

   /**
      Constructs an invoice.
      @param anAddress the billing address
   */
   public Invoice(Address anAddress)
   {  
      items = new ArrayList<LineItem>();
      billingAddress = anAddress;
   }
  
   /**
      Adds a charge for a product to this invoice.
      @param aProduct the product that the customer ordered
      @param quantity the quantity of the product
   */
   public void add(Product aProduct, int quantity)
   {  
      LineItem anItem = new LineItem(aProduct, quantity);
      items.add(anItem);
   }

   /**
      Formats the invoice.
      @param columnWidths the width of the columns in the line items table:
                          the first value is the description column width,
                          the second value is the price column width
                          the third value is the quantity column width
                          the fourth value is the total column width
      @return the formatted invoice
      @throws IllegalArgumentException if columnWidths is not of length 4,
                                       or if any of the column widths provided
                                       are below 5 characters wide
   */
   public String format(int[] columnWidths) throws IllegalArgumentException
   {
      if (columnWidths.length != 4)
      {
         throw new IllegalArgumentException
               (
                     "column widths much provide exactly 4 values for each column, "
                           + "instead columnWidths array provided was: "
                           + columnWidths.toString()
               );
      }
      int lineItemTableWidth = 0;
      for (int value : columnWidths)
      {
         if (value < 5)
         {
            throw new IllegalArgumentException
                  (
                        "The value of the column widths must be at least 5: "
                        + columnWidths.toString()
                  );
         }
         lineItemTableWidth = lineItemTableWidth + value;
      }
      String title = "I N V O I C E";
      int indexTitleStart = getFirstCharIndexToCenterString(title, lineItemTableWidth);
      String titleLine = " ".repeat(indexTitleStart) + title;
      String formatted = String.format("%s%n%n", titleLine);
      formatted = formatted + this.billingAddress.format() + "\n\n";

      // now it's time for the table
      // column headers
      final int DESCRIPTION_COLUMN_WIDTH = columnWidths[0];
      if (DESCRIPTION_COLUMN_WIDTH < "Description".length())
      {
         throw new IllegalArgumentException
               (
                     "Description column must be at least as long as \"Description\" string, "
                     + "i.e. " + "Description".length() + " characters.\nProvided column widths: "
                     + columnWidths.toString()
               );
      }
      final int PRICE_COLUMN_WIDTH = columnWidths[1];
      final int QUANTITY_COLUMN_WIDTH = columnWidths[2];
      final int TOTAL_COLUMN_WIDTH = columnWidths[3];
      int descriptionHeaderStart = getFirstCharIndexToCenterString("Description", DESCRIPTION_COLUMN_WIDTH);
      String descriptionColumnHeader = " ".repeat(descriptionHeaderStart) + "Description";
      int spacesAfterCenteredHeadingInDescriptionColumn = DESCRIPTION_COLUMN_WIDTH - descriptionColumnHeader.length();
      descriptionColumnHeader = descriptionColumnHeader + " ".repeat(spacesAfterCenteredHeadingInDescriptionColumn);
      formatted = formatted
            + descriptionColumnHeader
            + String.format("%" + PRICE_COLUMN_WIDTH + "s", "Price")
            + String.format("%" + QUANTITY_COLUMN_WIDTH + "s", "Qty")
            + String.format("%" + TOTAL_COLUMN_WIDTH + "s%n", "Total");
      // now for the value rows
      for (LineItem lineItem : items)
      {
         formatted = formatted + lineItem.format(columnWidths) + "\n";
      }

      // now for the invoice total
      String formattedTotal = NumberFormat.getCurrencyInstance().format(getAmountDue());
      formatted = formatted + "\n" + "AMOUNT DUE: " + formattedTotal;

      return formatted;
   }

   /**
    * Gets the index of the first character of a string in order for it to be centered.
    * @param stringToCentre the string to center
    * @param lengthOfLongerString the length of the character sequence in which
    *                             to center the string
    * @return the index of the first character in the string in order for it be centered
    * in a string of the provided length
    */
   private int getFirstCharIndexToCenterString(String stringToCentre, int lengthOfLongerString)
   {
      return (lengthOfLongerString / 2) - (stringToCentre.length() / 2);
   }

   /**
      Computes the total amount due.
      @return the amount due
   */
   private double getAmountDue()
   {  
      double amountDue = 0;
      for (LineItem item : items)
      {  
         amountDue = amountDue + item.getTotalPrice();
      }
      return amountDue;
   }
}
