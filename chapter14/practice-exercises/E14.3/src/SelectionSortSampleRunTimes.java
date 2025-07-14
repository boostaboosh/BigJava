import java.util.Scanner;

public class SelectionSortSampleRunTimes
{
   /**
    * Write a program that automatically generates the table of sample run times for the
    * selection sort algorithm. The program should ask for the smallest and largest value
    * of n and the number of measurements and then make all sample runs.
    * @param args
    */
   public static void main(String[] args)
   {
      Scanner inputReader = new Scanner(System.in);

      System.out.println("Enter smallest value of input size n: ");
      int smallestN = Integer.parseInt(inputReader.next());

      System.out.println("Enter largest value of input size n: ");
      int largestN = Integer.parseInt(inputReader.next());

      System.out.println("Enter number of measurements to make: ");
      int numMeasurements = Integer.parseInt(inputReader.next());
      double measGap = (largestN - smallestN) / (double) (numMeasurements - 1);

      StopWatch stopWatch = new StopWatch();
      int currentN = smallestN;
      for (int measurementCounter = 0; measurementCounter < numMeasurements; measurementCounter++)
      {
         int[] arr = ArrayUtil.randomIntArray(currentN, 100);

         stopWatch.start();
         SelectionSortDescending.selectionSortDescending(arr);
         long elapsedTime = stopWatch.getElapsedTime();

         System.out.println(String.format("%d) input size n: %-,10d, selection sort time: %-+,10d", measurementCounter + 1, currentN, elapsedTime));

         currentN = smallestN + (int) Math.round((measurementCounter + 1) * measGap);
      }
   }

}
