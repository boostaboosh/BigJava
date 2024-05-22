import java.util.ArrayList;
import java.util.Arrays;

/**
 * A table has rows and columns.
 * A row can be added to a table from a line of comma-separated values.
 */
public class Table
{
   private String[][] table;
   private int currentSize;
   
   /**
    * Creates a table.
    */
   public Table()
   {
      this.table = new String[0][0];
      this.currentSize = 0;
   }

   /**
    * Adds a line to this table from a CSV line.
    * @param line the line of comma separated values to create a row from
    */
   public void addLine(String line)
   {
      char[] characters = line.toCharArray();
      ArrayList<String> row = new ArrayList<>();

      String entry = "";
      int quotationsCounter = 0;
      for (int indexCounter = 0; indexCounter < characters.length; indexCounter++)
      {
         char character = characters[indexCounter];
         
         if (character == '"')
         {
            quotationsCounter = quotationsCounter + 1;
         }
         
         boolean isFirstQuotationMark = character == '"' && quotationsCounter == 1;
         if (!isFirstQuotationMark)
         {
            boolean evenNumberOfQuotationMarks = quotationsCounter % 2 == 0;
            if (!(
                  evenNumberOfQuotationMarks 
                  && (character == '"' || character == ',')
            ))
            {
               entry = entry + character;
            }
            if (character == ',' && evenNumberOfQuotationMarks
                  || indexCounter == characters.length - 1)
            {
               row.add(entry);
               entry = "";
               quotationsCounter = 0;
            }
         }
      }

      this.addRow(row);
   }

   /**
    * Adds a row of entries to this table.
    * @param row the row of entries to add to this table
    */
   public void addRow(ArrayList<String> row)
   {
      // increase size of the table if it's full
      if (this.currentSize >= this.table.length)
      {
         int newSize = 0;
         if (this.currentSize == 0)
         {
            newSize = 1;
         }
         else
         {
            newSize = this.currentSize * 2;
         }
         this.table = Arrays.copyOf(this.table, newSize);
      }
      
      // add row to the table
      final int NUMBER_OF_FIELDS = row.size();
      this.table[this.currentSize] = new String[NUMBER_OF_FIELDS];
      this.currentSize = this.currentSize + 1;
      String[] newTableRow = this.table[this.currentSize - 1];
      for (int entryIndex = 0; entryIndex < newTableRow.length; entryIndex++)
      {
         newTableRow[entryIndex] = row.get(entryIndex);
      }
   }

   /**
    * Retrieves an entry from the specified row and column.
    * @param row the row of the entry to retrieve
    * @param column the column of the entry to retrieve
    * @return the value of the entry at the specified row and column
    */
   public String getEntry(int row, int column)
   {
      String entry = null;
      if (this.table.length > row && this.table[row].length > column)
      {
         entry = this.table[row][column];
      }
      return entry;
   }

   /**
    * The number of rows in this table.
    * @return the number of rows in this table
    */
   public int rows()
   {
      return this.currentSize;
   }

   /**
    * Gets the number of columns in this table.
    * @return the number of columns in this table
    */
   public int columns()
   {
      int numberOfColumns = 0;
      if (!(this.table.length == 0))
      {
         numberOfColumns = this.table[0].length;
      }
      return numberOfColumns;
   }
}
