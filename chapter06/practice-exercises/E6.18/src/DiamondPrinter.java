/**
 * This class contains a program which print an asterisk diamond.
 */
public class DiamondPrinter
{
   /**
    * The main method is the program start point
    * @param args the program arguments
    */
   public static void main(String[] args)
   {
      String space = " ";
      String star = "*";

      int spaces = 3;
      int stars = 1;

      for (int row = 1; row <= 7; row++)
      {
         System.out.println(space.repeat(spaces).concat(star.repeat(stars)));
         if (row < 4)
         {
            spaces = spaces - 1;
            stars = stars + 2;
         }
         else if (row >= 4)
         {
            spaces = spaces + 1;
            stars = stars - 2;
         }
      }
   }
}
