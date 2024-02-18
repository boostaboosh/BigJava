import java.util.ArrayList;
import java.util.Scanner;

/**
 * BarChartDrawer objects run a program which reads a sequence of input values
 * and displays a bar chart of the values, using asterisks.
 */
public class BarChartDrawer
{
   ArrayList<BarChartValue> inputValues;

   /**
    * Constructs a bar chart drawer object.
    */
   public BarChartDrawer()
   {
      this.inputValues = new ArrayList<BarChartValue>();
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
      barChartDrawer.drawHorizontalBarChartWithCaptions(40, "*");
      barChartDrawer.drawVerticalBarChart(barChartDrawer.inputValues, 20, "*");
   }

   /**
    * Reads input values.
    */
   public void readInputValues()
   {
      this.inputValues.clear(); // empties input values when reading new input values
      Scanner scanner = new Scanner(System.in);

      System.out.print("How many values do you want to input? ");

      if (scanner.hasNextInt())
      {
         int numberOfInputs = scanner.nextInt();
         scanner.nextLine();

         int inputtedValues = 0;
         while (inputtedValues < numberOfInputs)
         {
            System.out.printf("Enter value %d of %d to chart: ", inputtedValues + 1, numberOfInputs);

            if (scanner.hasNextInt())
            {
               int inputValue = scanner.nextInt();
               scanner.nextLine();

               System.out.printf("Enter single word caption for value %d, which is value %d of %d to chart: ",
                     inputValue, inputtedValues + 1, numberOfInputs);
               String caption = scanner.next();
               scanner.nextLine();

               this.inputValues.add(new BarChartValue(inputValue, caption));
               inputtedValues = inputtedValues + 1;
            }
            else
            {
               System.out.println("You must enter an integer value.");
               scanner.nextLine();
            }
         }
      }
      else
      {
         System.out.println("Enter a single integer value.");
         scanner.nextLine();
         System.out.println("How many values do you want to input? ");
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
         int biggestValue = getBiggestValue(this.inputValues);
         final int MAX_BAR_LENGTH = 40;
         double unitValue = 0;
         if (biggestValue > MAX_BAR_LENGTH)
         {
            unitValue = biggestValue / (double) MAX_BAR_LENGTH;
            for (BarChartValue value : this.inputValues)
            {
               int barLength = (int) Math.round(value.getValue() / unitValue);
               System.out.println(unitSymbol.repeat(barLength));
            }
         }
         else
         {
            unitValue = MAX_BAR_LENGTH / (double) biggestValue;
            for (BarChartValue value : this.inputValues)
            {
               int barLength = (int) Math.round(value.getValue() * unitValue);
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
   public void drawVerticalBarChart(ArrayList<BarChartValue> values, int height, String symbol)
   {
      final String barUnitSymbol = symbol;
      final int MAX_BAR_HEIGHT = height;
      ArrayList<BarChartValue> valuesToChart = new ArrayList<BarChartValue>(values);
      ArrayList<BarChartValue> barChartValues =
            makeArrayListProportionalToNewLargestValue(valuesToChart, MAX_BAR_HEIGHT);
      for (int currentRowNumber = MAX_BAR_HEIGHT; currentRowNumber > 0; currentRowNumber--)
      {
         for (int index = 0; index < barChartValues.size(); index++)
         {
            int barChartValue = barChartValues.get(index).getValue();
            if (barChartValue == currentRowNumber)
            {
               System.out.print(barUnitSymbol);
               barChartValues.get(index).setValue(barChartValue - 1);
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
   public int getBiggestValue(ArrayList<BarChartValue> values)
   {
      if (!values.isEmpty())
      {
         int biggestValue = values.get(0).getValue();
         for (BarChartValue value : values)
         {
            if (value.getValue() > biggestValue)
            {
               biggestValue = value.getValue();
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
   public ArrayList<BarChartValue> makeArrayListProportionalToNewLargestValue (ArrayList<BarChartValue> arrayListToTransform, int newLargestValue)
   {
      ArrayList<BarChartValue> newArrayList = new ArrayList<BarChartValue>(arrayListToTransform.size());
      int largestValue = getBiggestValue(arrayListToTransform);
      double proportionalMultiplier = newLargestValue / (double) largestValue;
      boolean newLargestValueIsLargerThanOld = true;
      if (largestValue > newLargestValue)
      {
         proportionalMultiplier = largestValue / (double) newLargestValue;
         newLargestValueIsLargerThanOld = false;
      }
      for (BarChartValue value : arrayListToTransform)
      {
         int proportionalValue = 0;
         if (newLargestValueIsLargerThanOld)
         {
            proportionalValue = (int) Math.round(value.getValue() * proportionalMultiplier);
         }
         else
         {
            proportionalValue = (int) Math.round(value.getValue() / proportionalMultiplier);
         }
         newArrayList.add(new BarChartValue(proportionalValue, value.getCaption()));
      }
      return newArrayList;
   }

   /**
    * Draws a horizontal bar chart with captions based on the input values.
    */
   public void drawHorizontalBarChartWithCaptions(int maximumBarLength, String chartUnitSymbol)
   {
      final int MAX_BAR_LENGTH = maximumBarLength;
      int widthOfWidestCaption = this.getWidthOfWidestCaption(this.inputValues);
      ArrayList<BarChartValue> barChartValues = makeArrayListProportionalToNewLargestValue(this.inputValues, MAX_BAR_LENGTH);

      for (BarChartValue bar : barChartValues)
      {
         System.out.printf("%" + widthOfWidestCaption + "s ", bar.getCaption());
         System.out.println(chartUnitSymbol.repeat(bar.getValue()));
      }
   }

   /**
    * Returns the number of characters in the widest caption in the bar chart values
    * @param barChartValues the bar chart values to search for the one with the widest caption
    * @return the widest caption in the bar chart values
    */
   public int getWidthOfWidestCaption(ArrayList<BarChartValue> barChartValues)
   {
      int widthOfWidestCaption = 0;
      for (BarChartValue value : this.inputValues)
      {
         int captionLength = value.getCaption().length();
         if (captionLength > widthOfWidestCaption)
         {
            widthOfWidestCaption = captionLength;
         }
      }
      return widthOfWidestCaption;
   }
}
