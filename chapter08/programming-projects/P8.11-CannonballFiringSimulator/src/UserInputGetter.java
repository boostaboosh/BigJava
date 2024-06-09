import java.util.Scanner;

/**
 * Gets inputs from the user.
 */
public class UserInputGetter
{
   private static Scanner inputStreamReader = new Scanner(System.in);
   
   /**
    * Gets a boolean value inputted by the user.
    * True input values are y or yes or true.
    * False input values are n or no or false.
    * @return the boolean value inputted by the user
    */
   public static boolean getBooleanValue()
   {
      Boolean inputValue = null;
      boolean done = false;
      while (!done)
      {
         if (inputStreamReader.hasNextBoolean())
         {
            inputValue = inputStreamReader.nextBoolean();
         }
         else if (inputStreamReader.hasNext("y")
               || inputStreamReader.hasNext("yes"))
         {
            inputValue = true;
         }
         else if (inputStreamReader.hasNext("n") 
               || inputStreamReader.hasNext("no"))
         {
            inputValue = false;
         }
         else
         {
            UserOutputPrinter.printLine("You must enter a single boolean value. " 
                  + "\nEnter y or yes or true for true. " 
                  + "\nEnter n or no or false for false.");
         }
         inputStreamReader.nextLine();
         if (inputValue != null)
         {
            done = true;
         }
      }
      return inputValue;
   }

   /**
    * Gets a double value inputted by the user.
    * @return a double value inputted by the user
    */
   public static double getDoubleValue()
   {
      Double inputValue = null;
      boolean done = false;
      while (!done)
      {
         if (inputStreamReader.hasNextDouble())
         {
            inputValue = inputStreamReader.nextDouble();
            done = true;
         }
         else
         {
            UserOutputPrinter.printLine("You must enter a double value.");
         }
         inputStreamReader.nextLine();
      }
      return inputValue;
   }

   /**
    * Re-initialises the scanner with the current input stream.
    * Ensures the Scanner instance is updated to reflect the 
    * new System.in input stream set by unit tests.
    */
   public static void initializeScanner() {
      inputStreamReader = new Scanner(System.in);
   }
}
