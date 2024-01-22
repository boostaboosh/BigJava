public class E {
   public static void main(String[] args)
   {
      int LENGTH = 9;
      int[] values = new int[LENGTH];

      for(int index = 0; index < values.length; ++index)
      {
         if (index < 4)
         {
            values[index] = (index + 1) * (index + 1);
         }
         else if (index == 4)
         {
            values[index] = 9;
         }
         else if (index == 5)
         {
            values[index] = 7;
         }
         else if (index < 8)
         {
            int differenceOfPreviousTwoValues = values[index - 2] - values[index - 1];
            values[index] = differenceOfPreviousTwoValues * differenceOfPreviousTwoValues;
         }
         else {
            values[index] = 11;
         }
      }

      for (int element : values)
      {
         System.out.print(element + " ");
      }
   }
}
