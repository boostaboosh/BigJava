package chapter12.invoice.exercise1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.FileNotFoundException;

/**
 * A graphical user interface which allows users to make an invoice and print it.
 */
public class InvoiceMakerInterface extends JFrame
{
   private final int FRAME_WIDTH = 700;
   private final int FRAME_HEIGHT = 900;
   private Invoice invoice;
   private Address invoiceAddress;
   private JTextArea invoiceViewer;
   private JTextField invoiceLineItemEntryDisplay;
   private JButton addItemButton;
   private JButton printButton;

   /**
    * Runs a program which starts the invoice maker GUI.
    * @param args The program starting arguments which will be ignored because there are none.
    */
   public static void main(String[] args)
   {
      JFrame invoiceMakerInterface = new InvoiceMakerInterface();
   }

   /**
    * Creates an invoice maker interface.
    */
   public InvoiceMakerInterface()
   {
      this.invoiceAddress = new Address
            (
                  "Bert's big store",
                  "Main Street",
                  "Capital City",
                  "Sunny State",
                  "23430"
            );

      this.invoice = new Invoice(invoiceAddress);

      // set layout of frame
      this.setLayout(new BorderLayout());

      // construct components and add to this frame

      // invoice display
      invoiceViewer = new JTextArea();
      invoiceViewer.setEnabled(false);
      this.add(invoiceViewer, "North");

      // invoice line item entry display
      invoiceLineItemEntryDisplay = new JTextField();
      this.add(invoiceLineItemEntryDisplay, "Center");

      // add item button
      addItemButton = new JButton("Add item");
      addItemButton.addActionListener
            ((ActionEvent event) ->
                  {
                     String enteredText = this.invoiceLineItemEntryDisplay.getText();
                     String[] entries = enteredText.split(",");
                     if (entries.length != 3)
                     {
                        JOptionPane.showMessageDialog
                              (
                                    null,
                                    "Entry format for new invoice line item must be:\n"
                                    + "product-name,price, quantity\n"
                                    + "For example:\n"
                                    + "green eggs, 2.00, 5"
                              );
                        return;
                     }
                     else
                     {
                        String productDescription = entries[0].trim();
                        Double price = null;
                        try
                        {
                           price = Double.parseDouble(entries[1].trim());
                        }
                        catch (NumberFormatException exception)
                        {
                           JOptionPane.showMessageDialog
                                 (
                                       null,
                                       "The price must be a double value.\n"
                                       + "For example 2.84.\n"
                                       + "Entry format for new invoice line item must be 3 values separated by commas:\n"
                                       + "product-name, price, quantity\n"
                                       + "For example:\n"
                                       + "green eggs, 2.00, 5"
                                 );
                           return;
                        }
                        Product product = new Product(productDescription, price);
                        Integer quantity = null;
                        try
                        {
                           quantity = Integer.parseInt(entries[2].trim());
                        }
                        catch (NumberFormatException exception)
                        {
                           JOptionPane.showMessageDialog
                                 (
                                       null,
                                       "The quantity must be an integer value.\n"
                                             + "For example 11.\n"
                                             + "Entry format for new invoice line item must be 3 values separated by commas:\n"
                                             + "product-name, price, quantity\n"
                                             + "For example:\n"
                                             + "green eggs, 2.00, 5"
                                 );
                           return;
                        }
                        addInvoiceItem(product, quantity);
                     }
                     // empty text field if item added
                     this.invoiceLineItemEntryDisplay.setText("");
                     // update invoice viewer to show invoice with the new items added
                     this.invoiceViewer.setText(this.invoice.format());
                     // alert user that item was added successfully
                     JOptionPane.showMessageDialog(null, "Item added to invoice successfully");
                  }
            );
      this.add(addItemButton, "East");

      // print invoice button
      printButton = new JButton("Print Invoice");
      this.add(printButton, "South");
      printButton.addActionListener((ActionEvent event) -> printInvoice());

      // set frame title, size, close operation, and visibility
      this.setTitle("Invoice Maker");
      this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      this.setVisible(true);
   }

   /**
    * Adds an invoice line item to the invoice being made with the interface.
    * @param product the product being bought
    * @param quantity the quantity of the product being bought
    */
   public void addInvoiceItem(Product product, int quantity)
   {
      this.invoice.add(product, quantity);
   }

   /**
    * Prints the invoice made with the user interface.
    */
   public void printInvoice()
   {
      String outputFileName = JOptionPane.showInputDialog("Enter output file name");
      try
      {
         PlainTextFilePrinter.printTextToFile(this.invoice.format(), outputFileName);
      }
      catch (FileNotFoundException exception)
      {
         JOptionPane.showMessageDialog
               (
                     null,
                     "Invalid output file name or read-only file of same name already exists."
               );
      }
   }
}
