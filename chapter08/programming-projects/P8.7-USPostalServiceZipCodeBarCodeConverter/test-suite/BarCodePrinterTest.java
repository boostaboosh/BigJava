import org.junit.Test;
import org.junit.Assert;

public class BarCodePrinterTest
{
   @Test public void printingABarCode()
   {
      BarCode barCode = new BarCode(new char[] {
            '|',
            '|', ':', '|', ':', ':', // 9
            ':', '|', ':', '|', ':', // 5
            '|', '|', ':', ':', ':', // 0
            ':', ':', ':', '|', '|', // 1
            ':', '|', ':', ':', '|', // 4
            ':', ':', ':', '|', '|', // 1 check sum digit
            '|' }
      );
      BarCodePrinter.printBarCode(barCode);
   }
}