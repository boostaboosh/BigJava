public class Main
{
   // Given two pixels on a computer screen with integer coordinates (x1, y1) and (x2, y2),
   // write conditions to test whether they are
   // a. The same pixel.
   // b. Very close together (with distance < 5).
   public static void main(String[] args)
   {
      int x1 = 5;
      int y1 = 4;

      int x2 = 10;
      int y2 = 8;

      int closeDistance = 5;

      // condition a
      if (x1 == x2 && y1 == y2)
      {
         // they are the same pixel
         System.out.println("They are the same pixel.");
      } else if (Math.abs(x1 - x2) <= closeDistance && Math.abs(y1 - y2) <= closeDistance) // condition b
      {
         //the pixels are very close together (with distance < 5)
         System.out.println("The pixels are very close together.");
      }
   }
}