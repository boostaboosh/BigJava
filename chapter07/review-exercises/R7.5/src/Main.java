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
      System.out.println("\nexpected: 1, 1, 2, 3, 4, 5, 4, 3, 2, 1, ");
      System.out.print("actual: ");
      for (int element : a)
      {
         System.out.print(element + ", ");
      }

      // d
      a = new int[]{1, 2, 3, 4, 5, 4, 3, 2, 1, 0};
      for (int i = 8; i >= 0; i--)
      {
         a[i] = a[i + 1];
      }
      System.out.println("\nexpected: 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, ");
      System.out.print("actual: ");
      for (int element : a)
      {
         System.out.print(element + ", ");
      }

      // e
      a = new int[]{1, 2, 3, 4, 5, 4, 3, 2, 1, 0};
      for (int i = 1; i < 10; i++)
      {
         a[i] = a[i] + a[i - 1];
      }
      System.out.println("\nexpected: 1, 3, 6, 10, 15, 19, 22, 24, 25, 25, ");
      System.out.print("actual: ");
      for (int element : a)
      {
         System.out.print(element + ", ");
      }

      // f
      int[] array = { 1, 2, 3, 4, 5, 4, 3, 2, 1, 0 };
      for (int i = 1; i < 10; i = i + 2)
      {
         array[i] = 0;
      }
      System.out.println("\nexpected: 1, 0, 3, 0, 5, 0, 3, 0, 1, 0, ");
      System.out.print("actual: ");
      for (int element : array)
      {
         System.out.print(element + ", ");
      }

      // g
      int[] values = { 1, 2, 3, 4, 5, 4, 3, 2, 1, 0 };
      for (int i = 0; i < 5; i++)
      {
         values[i + 5] = values[i];
      }
      System.out.println("\nexpected: 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, ");
      System.out.print("actual: ");
      for (int element : values)
      {
         System.out.print(element + ", ");
      }

      // f
      int[] sequence = { 1, 2, 3, 4, 5, 4, 3, 2, 1, 0 };
      for (int i = 0; i < 5; i++)
      {
         sequence[i + 5] = sequence[i];
      }
      System.out.println("\nexpected: 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, ");
      System.out.print("actual: ");
      for (int integer : sequence)
      {
         System.out.print(integer + ", ");
      }
   }
}