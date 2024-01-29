/**
 * This class contains a program which performs tasks on a 2D array.
 */
public class Main
{
   /**
    * Starts the program.
    * @param args
    */
   public static void main(String[] args)
   {
      final int ROWS = 5;
      final int COLUMNS = 7;
      int[][] values = new int[ROWS][COLUMNS];

      // fill all entries with 0
      for (int rowIndex = 0; rowIndex < values.length; rowIndex++)
      {
         for (int columnIndex = 0; columnIndex < values[0].length; columnIndex++)
         {
            values[rowIndex][columnIndex] = 0;
         }
      }

      // fill elements alternately with 0s and 1s
      boolean zeroColumn = true;
      for (int rowIndex = 0; rowIndex < values.length; rowIndex++)
      {
         for (int columnIndex = 0; columnIndex < values[0].length; columnIndex++)
         {
            if (zeroColumn)
            {
               values[rowIndex][columnIndex] = 0;
               zeroColumn = false;
            }
            else
            {
               values[rowIndex][columnIndex] = 1;
               zeroColumn = true;
            }
         }
      }

      // fill only the elements in the top and bottom rows with zeroes
      for (int rowIndex = 0; rowIndex < values.length; rowIndex++)
      {
         if (rowIndex == 0 || rowIndex == values.length - 1)
         {
            for (int columnIndex = 0; columnIndex < values[0].length;
                 columnIndex++)
            {
               values[rowIndex][columnIndex] = 0;
            }
         }
      }

      // compute the sum of all elements
      int sum = 0;
      for (int rowIndex = 0; rowIndex < values.length; rowIndex++)
      {
         for (int columnIndex = 0; columnIndex < values[0].length;
              columnIndex++)
         {
            sum = sum + values[rowIndex][columnIndex];
         }
      }
      System.out.println("sum of all elements is " + sum);

      // print the array in tabular form
      for (int rowIndex = 0; rowIndex < values.length; rowIndex++)
      {
         for (int columnValue : values[rowIndex])
         {
            System.out.print(columnValue + " ");
         }
         System.out.println();
      }
   }
}