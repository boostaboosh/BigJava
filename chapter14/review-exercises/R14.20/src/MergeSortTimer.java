import java.util.Arrays;
import java.util.Scanner;

/**
   This program measures how long it takes to sort an
   array of a user-specified size with the merge
   sort algorithm.
*/
public class MergeSortTimer
{  
   public static void main(String[] args)
   {  
      Scanner in = new Scanner(System.in);
      System.out.print("First array length: ");
      int firstLength = in.nextInt();
      System.out.print("Number of arrays: ");
      int numberOfArrays = in.nextInt();

      StopWatch timer = new StopWatch();

      for (int k = 1; k <= numberOfArrays; k++)
      {
         int n = k * firstLength;

         boolean printIt = n < 100;

         // Construct random array
   
         int[] a = ArrayUtil.randomIntArrayWithDuplicates(n, 100);
         int[] aCopy = Arrays.copyOf(a, a.length);

         int[] aUneditedCopy = null;

         if (printIt) {
            aUneditedCopy = Arrays.copyOf(a, a.length);
         }

         // Use stopwatch to time merge sort
         
         timer.start();
         MergeSorter.sort(a);
         timer.stop();
         
         System.out.printf("Length:%8d Elapsed milliseconds merge keep duplicates:%8d", n, timer.getElapsedTime());
         timer.reset();

         timer.start();
         int usedSize = MergeSorter.sortAndRemoveDuplicates(aCopy);
         aCopy = Arrays.copyOf(aCopy, usedSize);
         timer.stop();

         System.out.printf(", Elapsed milliseconds merge remove duplicates:%8d%n", timer.getElapsedTime());
         timer.reset();

         if (printIt)
         {
            System.out.println("unsorted:\n" + Arrays.toString(aUneditedCopy));
            System.out.println("merge sorted:\n" + Arrays.toString(a));
            System.out.println("merge and remove duplicates sorted:\n" + Arrays.toString(aCopy) + "\n");
         }
      }
   }
}

   

