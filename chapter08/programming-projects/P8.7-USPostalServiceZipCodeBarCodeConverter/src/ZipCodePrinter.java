/**
 * A zip code printed prints zip codes.
 */
public class ZipCodePrinter
{
   /**
    * Constructs a zip code printer.
    */
   public ZipCodePrinter()
   {
   }

   /**
    * Prints the provided zip code.
    * @param zipCode the zip code to print
    */
   public static void printZipCode(ZipCode zipCode)
   {
      for (int counter = 0; counter < ZipCode.ZIP_CODE_LENGTH; counter++)
      {
         System.out.print(zipCode.getDigit(counter));
      }
      System.out.println();
   }
}
