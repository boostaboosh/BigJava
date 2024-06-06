import java.util.Scanner;

/**
 * A zip code asker asks the user to input a US postal code, also knows as a zip code.
 */
public class ZipCodeAsker
{
   private ZipCode zipCode;
   private Scanner scanner;
   
   /**
    * Constructs a new zip code asker.
    */
   public ZipCodeAsker()
   {
      this.zipCode = new ZipCode();
      this.scanner = new Scanner(System.in);
   }

   /**
    * Constructs a new zip code asker with a given scanner to read from an input stream.
    * @param inputStreamReader a scanner object
    */
   public ZipCodeAsker(Scanner inputStreamReader)
   {
      this.zipCode = new ZipCode();
      this.scanner = inputStreamReader;
   }

   /**
    * Asks the user to input a USPS zip code.
    */
   public void askForZipCode()
   {
      System.out.print("Enter zip code one digit at a time: ");
      for (int digitCounter = 1; digitCounter <= ZipCode.ZIP_CODE_LENGTH; digitCounter++)
      {
         System.out.println("digit " + digitCounter + ": ");
         this.askForDigit();
      }
   }

   /**
    * Asks the user to input a United States Postal Service zip code digit.
    */
   public void askForDigit()
   {
      boolean validDigitInputted = false;
      while (!validDigitInputted)
      {
         System.out.println("Enter USPS zip code digit: ");
         if (!scanner.hasNextInt())
         {
            System.out.println("A USPS zip code digit must be an integer.");
            scanner.nextLine();
         }
         else // if (scanner.hasNextInt())
         {
            int inputInteger = scanner.nextInt();
            scanner.nextLine();
            if (inputInteger < 0 || inputInteger > 9)
            {
               System.out.println("A USPS zip code digit must be between 0 and 9 (bounds included).");
            }
            else // if (inputInteger > 0 && inputInteger < 10)
            {
               validDigitInputted = true;
               this.zipCode.addDigit(inputInteger);
            }
         }
      }
   }

   /**
    * Gets this zip code asked for from the user.
    * @return the zip code asked for from the user
    */
   public ZipCode getZipCode()
   {
      return this.zipCode;
   }
}
