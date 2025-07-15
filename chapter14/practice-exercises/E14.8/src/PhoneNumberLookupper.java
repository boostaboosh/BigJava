import java.io.IOException;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class PhoneNumberLookupper
{
   public static void main(String[] args) throws IOException
   {
      ContactsFileWriter.writeRandomContactsFile("contacts.txt");
      Contact[] contacts = ContactsFileReader.getContacts("contacts.txt");
      if (contacts == null)
      {
         return;
      }

      Contact[] sortedByNumber = Arrays.copyOf(contacts, contacts.length);
      Arrays.sort(
            sortedByNumber,
            Comparator.comparing(c -> c.phoneNumber)
      );

      Contact[] sortedByName = Arrays.copyOf(contacts, contacts.length);
      Arrays.sort(
            sortedByName,
            (a, b) -> a.getName().compareTo(b.getName())
      );

      // lookup program
      try (Scanner inputReader = new Scanner(System.in))
      {
         boolean done = false;
         while (!done)
         {
            System.out.println("\nEnter \"done\" to quit.");
            System.out.print("Lookup name by phone number, or phone number by name? (nbp/pbn) ");
            String choice = inputReader.nextLine().trim();
            switch (choice) {
               case "nbp":
                  lookupNameUsingNumber(sortedByNumber, inputReader);
                  break;
               case "pbn":
                  lookupPhoneUsingName(sortedByName, inputReader);
                  break;
               case "done":
                  done = true;
                  break;
               default:
                  System.out.println("Invalid option: " + choice + " entered.");
                  break;
            }
         }
      }
   }

   private static void lookupPhoneUsingName(Contact[] sortedByName, Scanner inputReader)
   {
      System.out.println("Enter name to find the number associated with it: ");
      String name = inputReader.nextLine().trim();

      int pos = Arrays.binarySearch(
            sortedByName,
            new Contact(name, null),
            Comparator.comparing(c -> c.name)
      );

      if (pos < 0)
      {
         System.out.println(
               "Number not found, but would be in position: "
               + (-(pos + 1))
         );
      }
      else
      {
         System.out.println(
               "Phone number found for provided name is: "
               + sortedByName[pos].phoneNumber
         );
      }
   }

   private static void lookupNameUsingNumber(Contact[] sortedByNumber, Scanner inputReader)
   {
      System.out.println("Enter number to find the name associated with it: ");

      String number = inputReader.nextLine().trim();
      try {
         new BigInteger(number);
      } catch (NumberFormatException e)
      {
         System.out.println("Invalid input, expected number but got: " + inputReader.nextLine().trim());
         return;
      }

      int pos = Arrays.binarySearch(
            sortedByNumber,
            new Contact(null, number),
            Comparator.comparing(c -> c.phoneNumber)
      );

      if (pos < 0)
      {
         System.out.println(
               "Number not found, but would be in position: "
               + (-(pos + 1))
         );
      }
      else
      {
         System.out.println(
               "Phone number found for contact named: "
               + sortedByNumber[pos].name
         );
      }
   }
}
