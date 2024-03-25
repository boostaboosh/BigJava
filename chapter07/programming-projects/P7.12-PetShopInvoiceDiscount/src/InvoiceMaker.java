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
      System.out.println("Enter invoice items: (-1 to stop)");
      Scanner scanner = new Scanner(System.in);
      boolean done = false;
      while (!done)
      {
         System.out.println("Enter item price:");
         double price = scanner.nextDouble();
         if (price == - 1)
         {
            done = true;
         }
         else
         {
            System.out.println("Enter item quantity:");
            int quantity = scanner.nextInt();
            System.out.println("Is item a pet? (Y/N)");
            boolean isPet = scanner.next().equalsIgnoreCase("Y");
            Item item = new Item(price, isPet, quantity);
            invoice.add(item);
         }
      }
      System.out.println("Invoice total: " + invoice.getTotal());
      System.out.println("Invoice discount: " + invoice.getDiscount());
   }
}
