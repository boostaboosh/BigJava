/**
 * This class executes a program which prints all positive numbers that are divisible by
 * ten and less than a value n.
 */
public class DivisibleByTenLessThanN
{
   public static void main(String[] args)
   {
      int n = 171;
      for (int nextMultiple = 10; nextMultiple < n; nextMultiple = nextMultiple + 10)
      {
         int thisMultiple = nextMultiple;
         System.out.printf("%d ", thisMultiple);
      }
   }
}
