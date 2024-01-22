public class C {
   public static void main(String[] args)
   {
      int LENGTH = 10;
      int[] squares = new int[LENGTH];

      for(int index = 0; index < squares.length; index++)
      {
         squares[index] = (index + 1) * (index + 1);
      }

      for (int element : squares)
      {
         System.out.print(element + " ");
      }
   }
}
