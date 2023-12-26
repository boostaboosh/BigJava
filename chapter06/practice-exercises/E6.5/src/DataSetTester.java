import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This class contains a program which tests the DataSet class.
 */
public class DataSetTester
{
   /**
    * The main method is the starting point of the program
    * @param args the program arguments
    */
   public static void main(String[] args)
   {
      Logger.getGlobal().setLevel(Level.INFO);

      System.out.print("How many floating point values do you want to input? ");
      Scanner inputStream = new Scanner(System.in);
      int numberOfInputs = inputStream.nextInt();
      DataSet set = new DataSet();
      for (int inputCounter = 0; inputCounter < numberOfInputs; inputCounter++)
      {
         System.out.printf("Input value number %d of %d: ", inputCounter + 1, numberOfInputs);
         double nextValue = inputStream.nextDouble();
         set.add(nextValue);
      }
      System.out.printf("average is %.2f, largest is %.2f, smallest is %.2f, range is %.2f\n"
                        , set.getAverage(), set.getLargest(), set.getSmallest(), set.getRange());

      DataSet numberSet = new DataSet();
      numberSet.add(3.23);
      numberSet.add(10);
      double average = numberSet.getAverage();
      double smallest = numberSet.getSmallest();
      double largest = numberSet.getLargest();
      double range = numberSet.getRange();
      System.out.printf("Data set average %5.3f, smallest %5.3f, largest %5.3f, range %5.3f."
                        , average, smallest, largest, range);
      Logger.getGlobal().info("Expected output: Data set average 6.615, smallest 3.230, largest 10.000" +
                              ", range 6.770.");

      DataSet newNumberSet = new DataSet();
      newNumberSet.add(3);
      newNumberSet.add(4);
      newNumberSet.add(5);
      Logger.getGlobal().info("average: " + newNumberSet.getAverage());
      Logger.getGlobal().info("Expected output: average: 4");
      newNumberSet.add(6);
      Logger.getGlobal().info("average: " + newNumberSet.getAverage());
      Logger.getGlobal().info("Expected output: average: 4.5");
   }
}
