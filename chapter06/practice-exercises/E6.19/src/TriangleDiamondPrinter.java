import java.util.Scanner;

/**
 * This class contains a program which prints a diamond shape with the asterisks in the middle row
 * and column omitted.
 */
public class TriangleDiamondPrinter
{
   /**
    * The start of the program
    * @param args the program starting arguments
    */
   public static void main(String[] args)
   {
      Scanner scanner = new Scanner(System.in);
      System.out.print("Enter triangle side length: ");
      int sideLength = scanner.nextInt();

      int starsNumber = 1;
      int spacesNumber = sideLength - 1;
      for (int rowNumber = 1; rowNumber <= (sideLength * 2) + 1; rowNumber++)
      {
         String spaces = " ".repeat(spacesNumber);
         String stars = "*".repeat(starsNumber);
         String row = spaces.concat(stars).concat(" ").concat(stars);
         if (rowNumber == sideLength + 1)
         {
            row = "";
         }
         System.out.println(row);
         if (rowNumber < sideLength)
         {
            starsNumber = starsNumber + 1;
            spacesNumber = spacesNumber - 1;
         }
         else if (rowNumber > sideLength + 1)
         {
            starsNumber = starsNumber - 1;
            spacesNumber = spacesNumber + 1;
         }
      }
   }
}
