import java.util.Arrays;
import java.util.Scanner;

public class BarCodeAsker
{
   private char[] enteredBarCode;
   private int enteredBarCodeLength;
   private Scanner scanner;

   /**
    * Constructs a bar code asker.
    */
   public BarCodeAsker()
   {
      this.enteredBarCode = new char[BarCode.BAR_CODE_LENGTH];
      this.enteredBarCodeLength = 0;
      this.scanner = new Scanner(System.in);
   }

   /**
    * Constructs a bar code asker with a given scanner object to read from an input stream.
    * @param inputStreamReader a scanner object to read input from
    */
   public BarCodeAsker(Scanner inputStreamReader)
   {
      this.enteredBarCode = new char[BarCode.BAR_CODE_LENGTH];
      this.enteredBarCodeLength = 0;
      this.scanner = inputStreamReader;
   }

   /**
    * Asks the user to input a USPS bar code.
    */
   public void askForBarCode()
   {
      System.out.println("Enter a USPS zip code bar code one bar at a time.");
      for (int barIndexCounter = 0; barIndexCounter < BarCode.BAR_CODE_LENGTH; barIndexCounter++)
      {
         System.out.println("bar " + (barIndexCounter + 1) + ":");
         this.enteredBarCode[this.enteredBarCodeLength] = this.askForABar();
         this.enteredBarCodeLength = this.enteredBarCodeLength + 1;
      }
   }

   /**
    * Asks the user to input a single bar.
    * @return the entered bar, either | or :
    */
   public char askForABar()
   {
      char bar = '\0'; // null character literal
      boolean enteredValidBar = false;
      while (!enteredValidBar)
      {
         System.out.println("Enter bar:");
         String input = scanner.nextLine().trim();
         if (input.equals("|") || input.equals(":"))
         {
            bar = input.charAt(0);
            enteredValidBar = true;
         }
         else
         {
            System.out.println("A bar code digit bar must be tall '|' or short ':'.");
         }
      }
      return bar;
   }

   /**
    * Gets the bar code asked for from the user.
    * @return the bar code asked for from the suer
    */
   public char[] getBarCodeCharactersAsArray()
   {
      return Arrays.copyOf(this.enteredBarCode, this.enteredBarCodeLength);
   }
}
