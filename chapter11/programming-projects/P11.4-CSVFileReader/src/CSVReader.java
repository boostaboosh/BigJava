import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Reads values from a CSV file.
 */
public class CSVReader
{
   private ArrayList<ArrayList<String>> rows;

   /**
    * Constructs a CSV reader that reads values from a CSV file.
    * @param filename the name of the CSV file
    */
   public CSVReader(String filename)
   {
      File file = new File(filename);
      try (Scanner fileReader = new Scanner(file, "UTF-8"))
      {
         this.rows = new ArrayList<>();
         // read lines from CSV file
         int lineCounter = 0;
         while (fileReader.hasNextLine())
         {
            try
            {
               lineCounter++;
               readCSVLine(fileReader.nextLine());
            }
            catch (BadCSVData exception)
            {
               System.out.println("CSV data error on file line " + lineCounter);
               System.out.println(exception.getMessage());
            }
         }
      } // auto closes scanner on file
      catch (FileNotFoundException exception)
      {
         System.out.println(exception.getMessage());
      }
   }

   /**
    * Reads a line of comma separated values into this CSV reader.
    * @param line the line of comma separated values to add to this CSV reader
    */
   private void readCSVLine(String line) throws BadCSVData
   {
      if (line.equals(""))
      {
         return;
      }

      ArrayList<String> values = new ArrayList<>();
      boolean isFirstCharacterInValue = true;
      String value = "";
      boolean doubleQuotesClosed = false;
      boolean previousCharacterWasFirstOfDoubleQuotes = false;
      boolean commasAndDoubleQuotationMarksAllowed = false;
      Scanner lineReader = new Scanner(line);
      lineReader.useDelimiter(""); // reads each character
      while (lineReader.hasNext())
      {
         char character = lineReader.next().charAt(0);
         if (isFirstCharacterInValue)
         {
            if (Character.isWhitespace(character))
            {
               // skip initial whitespace by doing nothing
            }
            else if (character == '"')
            {
               commasAndDoubleQuotationMarksAllowed = true;
               isFirstCharacterInValue = false;
            }
            else if (character == ',')
            {
               values.add("");
            }
            else
            {
               commasAndDoubleQuotationMarksAllowed = false;
               value = value + character;
               isFirstCharacterInValue = false;
            }
         }
         else // if !isFirstCharacterInValue
         {
            if (character == ',')
            {
               if (commasAndDoubleQuotationMarksAllowed)
               {
                  if (doubleQuotesClosed)
                  {
                     values.add(value);
                     value = "";
                     isFirstCharacterInValue = true;
                     doubleQuotesClosed = false;
                     previousCharacterWasFirstOfDoubleQuotes = false;
                     commasAndDoubleQuotationMarksAllowed = false;
                  }
                  else
                  {
                     value = value + character;
                  }
               }
               else
               {
                  values.add(value.trim());
                  value = "";
                  isFirstCharacterInValue = true;
               }
            }
            else if (character == '"')
            {
               if (commasAndDoubleQuotationMarksAllowed)
               {
                  if (previousCharacterWasFirstOfDoubleQuotes)
                  {
                     value = value + character;
                     doubleQuotesClosed = false;
                     previousCharacterWasFirstOfDoubleQuotes = false;
                  }
                  else
                  {
                     previousCharacterWasFirstOfDoubleQuotes = true;
                     doubleQuotesClosed = true;
                  }
               }
               else // if (!commasAndDoubleQuotationMarksAllowed)
               {
                  throw new BadCSVData
                        (
                              "Double quote in field not enclosed in "
                              + "double quotes:\n"
                              + line
                        );
               }
            }
            else // if character != '"' && character != ','
            {
               if (commasAndDoubleQuotationMarksAllowed)
               {
                  if (!doubleQuotesClosed)
                  {
                     value = value + character;
                  }
                  else if (Character.isWhitespace(character))
                  {
                     // skip white space character after end
                     // of double quotes enclosed value by doing nothing
                  }
                  else
                  {
                     throw new BadCSVData
                           (
                                 "Non white space character found after "
                                 + "double quotes were closed:\n"
                                 + line
                           );
                  }
               }
               else
               {
                  value = value + character;
               }
            }
         }
         if (!lineReader.hasNext()) // character is last in line
         {
            if (character == ',')
            {
               values.add("");
            }
            else if (commasAndDoubleQuotationMarksAllowed)
            {
               if (doubleQuotesClosed)
               {
                  values.add(value.trim());
                  doubleQuotesClosed = false;
                  previousCharacterWasFirstOfDoubleQuotes = false;
                  commasAndDoubleQuotationMarksAllowed = false;
               }
               else
               {
                  throw new BadCSVData
                        (
                              "Unclosed double quotes in last entry "
                              + "of row:\n"
                              + line
                        );
               }
            }
            else
            {
               values.add(value.trim());
            }
         }
      }

      rows.add(values);
   }

   /**
    * Prints the CSV table the CSV reader read in from the file.
    */
   public void printRows()
   {
      System.out.println("CSV table:");
      int rowCounter = 0;
      for (ArrayList<String> row : rows)
      {
         rowCounter++;
         System.out.print("row #" + rowCounter + ": ");
         for (int index = 0; index < row.size(); index++)
         {
            System.out.print(row.get(index));
            if (index != row.size() - 1)
            {
               System.out.print(",");
            }
         }
         System.out.println();
      }
   }

   /**
    * Gets the number of rows from this CSV file reader.
    * @return the number of rows from this CSV file reader
    */
   public int numberOfRows()
   {
      return this.rows.size();
   }

   /**
    * Gets the numbers of fields in this row of this CSV file reader.
    * @param row the row to get the number of fields from (first row is 1)
    * @return the number of fields in the specified row of this CSV file reader
    * @throws IllegalArgumentException if row is less than 1 or greater than
    *                                  number of rows in CSV file
    */
   public int numberOfFields(int row)
   {
      if (row < 1 || row > this.rows.size()) {
         throw new IllegalArgumentException
               ("Row must be between 1 and " + this.rows.size());
      } else
      {
         return this.rows.get(row - 1).size();
      }
   }

   /**
    * Gets this field at the specified row and column from this CSV file reader.
    * @param row the row of the field to get (first row is 1)
    * @param column the column of the field to get (first column is 1)
    * @return the field at the provided row and column of this CSV file reader
    * @throws IllegalArgumentException if row or column number provided are less
    *                                  than 1 or greater than number of rows in
    *                                  the file or the number of columns in that
    *                                  row
    */
   public String field(int row, int column)
   {
      if (row < 1 || row > this.rows.size())
      {
         throw new IllegalArgumentException
               (
                     "Row argument must be at least 1 and at most the same"
                     + " as the number of lines in the CSV file, which is "
                     + this.rows.size()
                     + ".\n"
                     + "Row provided was "
                     + row
                     +".\n"
               );
      }
      final int numberOfColumns = this.rows.get(row - 1).size();
      if (column < 1 || column > numberOfColumns)
      {
         throw new IllegalArgumentException
               (
                     "Column argument must be at least 1 and at most equal to "
                     + "the number of columns in the row you want the "
                     + "field from, which is row "
                     + row
                     + ".\nThe number of columns is "
                     + numberOfColumns
                     + ".\n"
                     + "Column argument provided was "
                     + column
                     + ".\n"
               );
      }
      else
      {
         return this.rows.get(row - 1).get(column - 1);
      }
   }
}
