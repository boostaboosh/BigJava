/**
   This program demonstrates the invoice classes by printing
   a sample invoice.
*/
public class InvoicePrinter
{  
   public static void main(String[] args)
   {  
      Address samsAddress 
            = new Address("Sam's Small Appliances",
               "100 Main Street", "Anytown", "CA", "98765");

      Invoice samsInvoice = new Invoice(samsAddress);
      samsInvoice.add(new Product("Toaster", 10), 1);
      samsInvoice.add(new Product("Hair dryer", 100), 10);
      samsInvoice.add(new Product("Car vacuum", 1000), 100);

      System.out.println(samsInvoice.format(new int[]{50, 10, 5, 15}));
   }
}

