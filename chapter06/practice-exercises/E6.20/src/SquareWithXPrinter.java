import java.util.Scanner;

/**
 * This class contains a program which prints squares of a given side length containing an X using asterisks.
 */
public class SquareWithXPrinter
{
   /**
    * Starts the program
    * @param args the program starting arguments
    */
   public static void main(String[] args)
   {
      Scanner scanner = new Scanner(System.in);
      System.out.print("Enter a side length for the outer square: ");
      int squareSideLength = scanner.nextInt();
      int numberOfRows = squareSideLength;
      int numberOfXRows = squareSideLength - 2;

      int numberOfMiddleStars = 0;
      int firstMiddleRow = (int) Math.round(numberOfXRows / 2.0);
      boolean oddNumberOfXRows = (numberOfXRows % 2) != 0;
      int secondMiddleRow = 0;
      if (oddNumberOfXRows)
      {
         secondMiddleRow = firstMiddleRow;
         numberOfMiddleStars = 1;
      }
      else if (!oddNumberOfXRows)
      {
         secondMiddleRow = firstMiddleRow + 1;
         numberOfMiddleStars = 2;
      }

      String starSymbol = "*";
      String space = " ";

      int numberOfStartAndEndSpaces = 0;
      int xRowWidth = squareSideLength - 2;
      int numberOfMiddleSpaces = xRowWidth - 2;

      for (int rowNumber = 1; rowNumber <= numberOfRows; rowNumber++)
      {
         String row = "";
         boolean xRow = rowNumber != 1 && rowNumber != squareSideLength;
         if (!xRow)
         {
            row = starSymbol.repeat(squareSideLength);
         }
         else if (xRow)
         {
            int xRowNumber = rowNumber - 1;
            boolean middleRow = xRowNumber == firstMiddleRow || xRowNumber == secondMiddleRow;
            if (!middleRow)
            {
               row = starSymbol + space.repeat(numberOfStartAndEndSpaces) + starSymbol
                     + space.repeat(numberOfMiddleSpaces) + starSymbol
                     + space.repeat(numberOfStartAndEndSpaces) + starSymbol;
            }
            else if (middleRow)
            {
               row = starSymbol + space.repeat(numberOfStartAndEndSpaces)
                     + starSymbol.repeat(numberOfMiddleStars) + space.repeat(numberOfStartAndEndSpaces)
                     + starSymbol;
            }

            if (xRowNumber < firstMiddleRow)
            {
               numberOfStartAndEndSpaces = numberOfStartAndEndSpaces + 1;
               numberOfMiddleSpaces = numberOfMiddleSpaces - 2;
            }
            else if (xRowNumber >= secondMiddleRow)
            {
               numberOfStartAndEndSpaces = numberOfStartAndEndSpaces - 1;
               numberOfMiddleSpaces = numberOfMiddleSpaces + 2;
            }
         }
         System.out.println(row);
      }
   }
}
