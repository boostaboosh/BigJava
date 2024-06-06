/**
 * A bar code printed prints bar codes.
 */
public class BarCodePrinter
{
   /**
    * Prints a USPS bar code.
    * @param barCode the bar code to print
    */
   public static void printBarCode(BarCode barCode)
   {
      if (barCode != null)
      {
         for (char character : barCode.getBarCodeAsArray())
         {
            System.out.print(character);
         }
         System.out.println();
      }
   }
}
