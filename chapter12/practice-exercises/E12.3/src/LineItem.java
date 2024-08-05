import java.text.NumberFormat;

/**
   Describes a quantity of an article to purchase.
*/
public class LineItem
{  
   private int quantity;
   private Product theProduct;

   /**
      Constructs an item from the product and quantity.
      @param aProduct the product
      @param aQuantity the item quantity
   */
   public LineItem(Product aProduct, int aQuantity)
   {  
      theProduct = aProduct;
      quantity = aQuantity;
   }
   
   /**
      Computes the total cost of this line item.
      @return the total price
   */
   public double getTotalPrice()
   {  
      return theProduct.getPrice() * quantity;
   }
   
   /**
      Formats this item.
      @param columnWidths the width of the columns in the line items table:
                          the first value is the description column width,
                          the second value is the price column width
                          the third value is the quantity column width
                          the fourth value is the total column width
      @return a formatted string of this item
      @throws IllegalArgumentException if columnWidths is not of length 4,
                                       or if any of the column widths provided
                                       are below 5 characters wide
   */
   public String format(int[] columnWidths)
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
      for (int value : columnWidths)
      {
         if (value < 5) {
            throw new IllegalArgumentException
                  (
                        "The value of the column widths must be at least 5: "
                        + columnWidths.toString()
                  );
         }
      }
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

      String descriptionField = String.format
            (
                  "%-" + DESCRIPTION_COLUMN_WIDTH + "s",
                  trimToSize(theProduct.getDescription(), DESCRIPTION_COLUMN_WIDTH - 1)
            );
      NumberFormat currencyNumberFormatter = NumberFormat.getCurrencyInstance();
      String priceField = String.format
            (
                  "%" + PRICE_COLUMN_WIDTH + "s",
                  currencyNumberFormatter.format(theProduct.getPrice())
            );
      String quantityField = String.format
            (
                  "%" + QUANTITY_COLUMN_WIDTH + "d",
                  quantity
            );
      String totalField = String.format
            (
                  "%" + TOTAL_COLUMN_WIDTH + "s",
                  currencyNumberFormatter.format(getTotalPrice())
            );
      String line = descriptionField + priceField + quantityField + totalField;
      return line;
   }

   private String trimToSize(String string, int maxSize)
   {
      return string.substring(0, Math.min(string.length(), maxSize));
   }
}
