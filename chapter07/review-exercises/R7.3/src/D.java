public class D {
   public static void main(String[] args)
   {
      int LENGTH = 10;
      int[] zeros = new int[LENGTH];

      // int array is initialised with zeros so no need to initialise manually
      for (int element : zeros)
      {
         System.out.print(element + " ");
      }

      // redundant int array of zeros initialisation
      for(int index = 0; index < zeros.length; ++index)
      {
         zeros[index] = 0;
      }

      System.out.println();
      for (int element : zeros)
      {
         System.out.print(element + " ");
      }
   }
}
