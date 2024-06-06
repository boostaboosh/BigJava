import java.util.Scanner;

public class ZipAndBarCodeConverterRunner
{
   // storing converted zip and bar codes for testing purposes
   public static ZipCode lastZipCodeConvertedFromBarCode = null;
   public static BarCode lastBarCodeConvertedFromZipCode = null;
   
   /**
    * The program starting point.
    * @param args the program starting arguments
    */
   public static void main(String[] args)
   {
      Scanner inputStreamReader = new Scanner(System.in);
      boolean userWantsToConvert = true;
      while (userWantsToConvert)
      {
         System.out.println("Do you want to convert between a USPS zip and bar code? (y/n)");
         String inputLine = inputStreamReader.nextLine();
         if (inputLine.equals("y"))
         {
            boolean validConversionOptionInputted = false;
            while (!validConversionOptionInputted)
            {
               System.out.println("Do you want to convert a USPS zip to a bar code or vice-versa? (z2b/b2z)");
               inputLine = inputStreamReader.nextLine();
               if (inputLine.equals("z2b") || inputLine.equals("b2z"))
               {
                  validConversionOptionInputted = true;
                  if (inputLine.equals("z2b"))
                  {
                     ZipCodeAsker zipCodeAsker = new ZipCodeAsker(inputStreamReader);
                     zipCodeAsker.askForZipCode();
                     BarCode barCodeFromZipCode = ZipCodeToBarCodeConverter.convertZipCode(zipCodeAsker.getZipCode());
                     System.out.print("The USPS bar code: ");
                     BarCodePrinter.printBarCode(barCodeFromZipCode);
                     lastBarCodeConvertedFromZipCode = barCodeFromZipCode;
                     System.out.print("Corresponds to the entered USPS zip code: ");
                     ZipCodePrinter.printZipCode(zipCodeAsker.getZipCode());
                  }
                  else // if (inputLine.equals("b2z"))
                  {
                     BarCodeAsker barCodeAsker = new BarCodeAsker(inputStreamReader);
                     barCodeAsker.askForBarCode();
                     if (BarCodeChecker.isValid(barCodeAsker.getBarCodeCharactersAsArray()))
                     {
                        BarCode enteredBarCode = new BarCode(barCodeAsker.getBarCodeCharactersAsArray());
                        ZipCode zipCodeFromBarCode = BarCodeToZipCodeConverter.convertBarCode(enteredBarCode);
                        System.out.print("The USPS zip code: ");
                        ZipCodePrinter.printZipCode(zipCodeFromBarCode);
                        lastZipCodeConvertedFromBarCode = zipCodeFromBarCode;
                        System.out.print("Corresponds to the entered USPS bar code: ");
                        BarCodePrinter.printBarCode(enteredBarCode);
                     }
                     else
                     {
                        System.out.println("Entered bar code is of invalid format.");
                     }
                  }
               }
               else
               {
                  System.out.println("Enter z2b or b2z. Other options are invalid.");
               }
            }
         }
         else if (inputLine.equals("n"))
         {
            userWantsToConvert = false;
         }
         else
         {
            System.out.println("Please enter a valid option!");
         }
      }
   }
}
