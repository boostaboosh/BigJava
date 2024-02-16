import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * BarChartDrawer objects run a program which reads a sequence of input values
 * and displays a bar chart of the values, using asterisks.
 */
public class BarChartDrawer
{
   ArrayList<Integer> inputValues;

   /**
    * Constructs a bar chart drawer object.
    */
   public BarChartDrawer()
   {
      this.inputValues = new ArrayList<Integer>();
   }

   /**
    * Starts the program.
    * @param args the program starting arguments
    */
   public static void main(String[] args)
   {
      BarChartDrawer barChartDrawer = new BarChartDrawer();
      barChartDrawer.readInputValues();
      barChartDrawer.drawHorizontalBarChart();
      barChartDrawer.drawVerticalBarChart(barChartDrawer.inputValues, 20, "*");
   }

   /**
    * Reads input values.
    */
   public void readInputValues()
   {
      this.inputValues.clear();
      Scanner scanner = new Scanner(System.in);
      System.out.print("How many values do you want to input? ");
      int numberOfInputs = scanner.nextInt();
      scanner.nextLine(); // discard the rest of the line including the new line character
            // so future scanner reads don't cause unexpected behaviour due to
            // the leftover characters in the input stream like the new line character
      for (int input = 0; input < numberOfInputs; input++)
      {
         System.out.println("Enter next value in bar chart: ");

         while (!scanner.hasNextInt()) // if there's no input available in the input stream hasNextInt() will block
                  // and wait for input. This waiting happens because hasNextInt() needs to determine whether
                  // the next token in the input stream is an integer, but if there's no input to check,
                  // it waits until there is some input to evaluate.
         {
            System.out.println("You must enter an integer value!");
            scanner.nextLine(); // consume the entire line with the non-integer input token
                  // so that you don't end up in an infinite loop due to the leftover new
                  // line character or other leftover input characters causing hasNextInt()
                  // to return false, thereby making the looping condition always true
            System.out.println("Enter next value in bar chart: ");
         }
         int nextValue = scanner.nextInt();
         scanner.nextLine(); // consumes the remaining input including the leftover new line character
               // to make sure the scanner is ready for the next input
         this.inputValues.add(nextValue);
      }
   }

   /**
    * Draws a horizontal bar chart based on the input values.
    */
   public void drawHorizontalBarChart()
   {
      if (!this.inputValues.isEmpty())
      {
         final String unitSymbol = "*";
         System.out.println(this.inputValues);
         int biggestValue = getBiggestValue(this.inputValues);
         final int MAX_BAR_LENGTH = 40;
         double unitValue = 0;
         if (biggestValue > MAX_BAR_LENGTH)
         {
            unitValue = biggestValue / (double) MAX_BAR_LENGTH;
            for (int value : this.inputValues)
            {
               int barLength = (int) Math.round(value / unitValue);
               System.out.println(unitSymbol.repeat(barLength));
            }
         }
         else
         {
            unitValue = MAX_BAR_LENGTH / (double) biggestValue;
            for (int value : this.inputValues)
            {
               int barLength = (int) Math.round(value * unitValue);
               System.out.println(unitSymbol.repeat(barLength));
            }
         }
      }
      else
      {
         System.out.println("No values to make a bar chart with.");
      }
   }

   /**
    * Draws a vertical bar chart of the specified values of the specified height.
    * @param values the values to represent with bars in the bar chart
    * @param height the height of the tallest bar in the chart which corresponds to the largest value
    */
   public void drawVerticalBarChart(ArrayList<Integer> values, int height, String symbol)
   {
      final String barUnitSymbol = symbol;
      final int MAX_BAR_HEIGHT = height;
      ArrayList<Integer> valuesToChart = new ArrayList<Integer>(values);
      ArrayList<Integer> barChartValues = makeArrayListProportionalToNewLargestValue(valuesToChart, MAX_BAR_HEIGHT);
      for (int currentRowNumber = MAX_BAR_HEIGHT; currentRowNumber > 0; currentRowNumber--)
      {
         for (int index = 0; index < barChartValues.size(); index++)
         {
            int barChartValue = barChartValues.get(index);
            if (barChartValue == currentRowNumber)
            {
               System.out.print(barUnitSymbol);
               barChartValues.set(index, barChartValue - 1);
            }
            else
            {
               System.out.print(" ");
            }
         }
         System.out.println();
      }
   }

   /**
    * Gets the biggest value from the array list
    * @return the biggest value, or zero if empty
    */
   public int getBiggestValue(ArrayList<Integer> values)
   {
      if (!values.isEmpty())
      {
         int biggestValue = values.get(0);
         for (int value : values)
         {
            if (value > biggestValue)
            {
               biggestValue = value;
            }
         }
         return biggestValue;
      }
      return 0;
   }

   /**
    * Creates an array list proportional to a given value by making the
    * largest value in the array list equal to the passed value, and
    * transforming every other value proportionally.
    * For example, the array 1, 2, 3 transform into the array
    * 10, 20, 30 given the value 30 to be proportional to.
    * @param arrayListToTransform the array to transform
    * @param newLargestValue the value of the largest element in the new array
    * @return a new array of the same proportions as the arrayToTransform
    * with the specified largest value
    */
   public ArrayList<Integer> makeArrayListProportionalToNewLargestValue (ArrayList<Integer> arrayListToTransform, int newLargestValue)
   {
      ArrayList<Integer> newArrayList = new ArrayList<Integer>(arrayListToTransform.size());
      int largestValue = getBiggestValue(arrayListToTransform);
      double proportionalMultiplier = newLargestValue / (double) largestValue;
      boolean newLargestValueIsLargerThanOld = true;
      if (largestValue > newLargestValue)
      {
         proportionalMultiplier = largestValue / (double) newLargestValue;
         newLargestValueIsLargerThanOld = false;
      }
      for (int value : arrayListToTransform)
      {
         int proportionalValue = 0;
         if (newLargestValueIsLargerThanOld)
         {
            proportionalValue = (int) Math.round(value * proportionalMultiplier);
         }
         else
         {
            proportionalValue = (int) Math.round(value / proportionalMultiplier);
         }
         newArrayList.add(proportionalValue);
      }
      return newArrayList;
   }
}
