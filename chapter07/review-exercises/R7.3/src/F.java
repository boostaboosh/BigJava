/**
 * Write code that fills an array values with each set of numbers below.
 * 0 1 0 1 0 1 0 1 0 1
 */
public class F
{
   /**
    * Starts the program
    * @param args
    */
   public static void main(String[] args)
   {
      final int LENGTH = 10;
      int[] zerosAndOnes = new int[LENGTH];

      boolean zeroNext = true;
      for (int index = 0; index < zerosAndOnes.length; index++)
      {
         if (zeroNext == true){
            zerosAndOnes[index] = 0;
            zeroNext = false;
         }
         else
         {
            zerosAndOnes[index] = 1;
            zeroNext = true;
         }
      }

      for (int element : zerosAndOnes)
      {
         System.out.print(element + " ");
      }
   }
}
