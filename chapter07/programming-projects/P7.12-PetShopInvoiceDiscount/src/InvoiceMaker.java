import java.util.Scanner;

/**
 * Contains a program which prompts a cashier to enter each price and quantity,
 * and then a Y (yes) for a pet or N (no) for another item.
 * Uses -1 as a sentinel value,
 * and then displays the discount a customer is due.
 */
public class InvoiceMaker
{
   /**
    * The program starting point.
    * @param args the program starting arguments
    */
   public static void main(String[] args)
   {
      Invoice invoice = new Invoice();
      System.out.println("Enter invoice items:");
      Scanner scanner = new Scanner(System.in);
      boolean done = false;
      while (!done)
      {
         System.out.println("Enter item price:");
         if (scanner.nextDouble() == -1)
         {
            done = true;
         }
         else
         {
            double price = scanner.nextDouble();
            System.out.println("Enter item quantity:");
            int quantity = scanner.nextInt();
            System.out.println("Is item a pet? (Y/N)");
            boolean isPet = scanner.nextBoolean();
            Item item = new Item(price, isPet, quantity);
            invoice.add(item);
         }
      }
      System.out.println("Invoice discount: " + invoice.getDiscount());
   }
}
