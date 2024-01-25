public class Main
{
   public static void main(String[] args)
   {
      int[] a = { 1, 2, 3, 4, 5, 4, 3, 2, 1, 0 };

      // a
      for (int i = 1; i < 10; i++)
      {
         a[i] = a[i - 1];
      }
      System.out.println("expected: 1, 1, 2, 3, 4, 5, 4, 3, 2, 1, Was wrong!");
      System.out.print("actual: ");
      for (int element : a)
      {
         System.out.print(element + ", ");
      }

      // b
      a = new int[]{1, 2, 3, 4, 5, 4, 3, 2, 1, 0};
      for (int i = 9; i > 0; i--)
      {
         a[i] = a[i - 1];
      }
      System.out.println("\nexpected: 1, 1, 2, 3, 4, 5, 4, 3, 2, 1,");
      System.out.print("actual: ");
      for (int element : a)
      {
         System.out.print(element + ", ");
      }

      // c
      a = new int[]{1, 2, 3, 4, 5, 4, 3, 2, 1, 0};
      for (int i = 9; i > 0; i--)
      {
         a[i] = a[i - 1];
      }
      System.out.println("\nexpected: ");
      System.out.print("actual: ");
      for (int element : a)
      {
         System.out.print(element + ", ");
      }
   }
}