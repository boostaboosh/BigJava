import java.util.Scanner;

/**
 * This class contains a test program which tests if the expected discount
 * on a pet shop order matches that actual discount returned by the
 * invoice maker program.
 */
public class InvoiceDiscountTester
{
   /**
    * The program starting point.
    * @param args the program starting arguments
    */
   public static void main(String[] args)
   {
      InvoiceMaker invoiceMaker = new InvoiceMaker();
      invoiceMaker.main(new String[0]);
      Scanner scanner = new Scanner(System.in);
      System.out.println("Expected:");
      System.out.println("Total: " + 231.97);
      System.out.println("Discount: " + 39.80);
      System.out.println("Total after discount: " + 192.17);
   }
}
