/**
 * This class contains a program that displays, using asterisks, a filled and hollow square.
 */
public class SquareDrawer
{
   /**
    * Starts the program.
    * @param args information for starting the program
    */
   public static void main(String[] args)
   {
      for (int rowNumber = 1; rowNumber <= 5; rowNumber++)
      {
         String rowStart = "***** *";
         String secondSquareSymbol = "";
         if (rowNumber == 1 || rowNumber == 5)
         {
            secondSquareSymbol = "*";
         }
         else
         {
            secondSquareSymbol = " ";
         }
         String rowEnd = secondSquareSymbol.repeat(3).concat("*");
         String row = rowStart.concat(rowEnd);
         System.out.println(row);
      }
   }
}
