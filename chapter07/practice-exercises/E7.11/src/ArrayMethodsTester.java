import java.util.Arrays;

/**
 * A class for testing the ArrayMethods class.
 */
public class ArrayMethodsTester
{
   /**
    * Starts the program.
    * @param args
    */
   public static void main(String[] args)
   {
      final int LENGTH = 10;
      int[] values = new int[LENGTH];
      for (int index = 0; index < values.length; index++)
      {
         values[index] = index + 1;
      }
      System.out.println(Arrays.toString(values));
      System.out.println("Expected: [1,2,3,4,5,6,7,8,9,10]");

      ArrayMethods array = new ArrayMethods(values);

      // a
      array.swapFirstAndLast();
      array.print();
      System.out.println("A Expected: 10, 2, 3, 4, 5, 6, 7, 8, 9, 1");

      // b
      array.shiftRight();
      array.print();
      System.out.println("B Expected: 1, 10, 2, 3, 4, 5, 6, 7, 8, 9");

      // c
      array.replaceAllEvenWithZero();
      array.print();
      System.out.println("C Expected: 1, 0, 0, 3, 0, 5, 0, 7, 0, 9");

      // d
      array.replaceMiddleWithLargestNeighbour();
      array.print();
      System.out.println("D Expected: 1, 1, 3, 0, 5, 0, 7, 0, 9, 9");

      // e
      array.removeMiddle();
      array.print();
      System.out.println("E Expected: 1, 1, 3, 0, 7, 0, 9, 9");

      // f
      array.moveEvenToFront();
      array.print();
      System.out.println("F Expected: 0, 0, 1, 1, 3, 7, 9, 9");

      // g
      int secondLargest = array.getSecondLargest();
      System.out.println(secondLargest);
      System.out.println("G Expected: 9");

      int[] unsortedWithSecondLargest = {3, 1, 2, 0};
      ArrayMethods unsortedArrayWithSecondLargest =
            new ArrayMethods(unsortedWithSecondLargest);
      int secondLargestSecondTest =
            unsortedArrayWithSecondLargest.getSecondLargest();
      System.out.println(secondLargestSecondTest);
      System.out.println("G Expected: 2");

      // h
      boolean isSorted = array.isSortedIncreasingOrder();
      System.out.println(isSorted);
      System.out.println("H Expected: true");

      boolean isSortedSecondTest = unsortedArrayWithSecondLargest.isSortedIncreasingOrder();
      System.out.println(isSortedSecondTest);
      System.out.println("H Expected: false");

      // i
      boolean hasAdjacentDuplicates = array.hasAdjacentDuplicates();
      System.out.println(hasAdjacentDuplicates);
      System.out.println("I Expected: true");

      boolean hasAdjacentDuplicatesSecondTest =
            unsortedArrayWithSecondLargest.hasAdjacentDuplicates();
      System.out.println(hasAdjacentDuplicatesSecondTest);
      System.out.println("I Expected: false");

      // j
      boolean hasDuplicates = array.hasDuplicates();
      System.out.println(hasDuplicates);
      System.out.println("J Expected: true");

      boolean hasDuplicatesSecondTest =
            unsortedArrayWithSecondLargest.hasDuplicates();
      System.out.println(hasDuplicatesSecondTest);
      System.out.println("J Expected: false");
   }
}
