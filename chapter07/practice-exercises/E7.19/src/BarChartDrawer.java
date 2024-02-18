import java.util.ArrayList;
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
      barChartDrawer.drawBarChart();
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
      scanner.nextLine();
      for (int input = 0; input < numberOfInputs; input++)
      {
         System.out.println("Enter next value in bar chart: ");

         while (!scanner.hasNextInt())
         {
            System.out.println("You must enter an integer value!");
            scanner.nextLine();
            System.out.println("Enter next value in bar chart: ");
         }

         int nextValue = scanner.nextInt();
         scanner.nextLine();
         this.inputValues.add(nextValue);
      }
   }

   /**
    * Draws a bar chart based on the input values.
    */
   public void drawBarChart()
   {
      if (!this.inputValues.isEmpty())
      {
         final String unitSymbol = "*";
         System.out.println(this.inputValues);
         int biggestValue = this.getBiggestValue();
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
    * Gets the biggest value.
    * @return the biggest value, or zero if empty
    */
   public int getBiggestValue()
   {
      if (!this.inputValues.isEmpty())
      {
         int biggestValue = this.inputValues.get(0);
         for (int value : this.inputValues)
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
}
