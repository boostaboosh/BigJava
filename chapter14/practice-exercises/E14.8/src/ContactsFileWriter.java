import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Random;

public class ContactsFileWriter
{
   public static final int NUM_CONTACTS = 1000;

   public static void writeRandomContactsFile(String fileName) throws FileNotFoundException
   {
      // make a file
      PrintWriter fileWriter = new PrintWriter(fileName);

      // write contacts to it (names and nums)
      Random randomNumGen = new Random();
      for (int contactsCount = 0; contactsCount < NUM_CONTACTS; contactsCount++)
      {
         fileWriter.println(
               getRandomName(randomNumGen)
               + " "
               + getRandomNumber(randomNumGen)
         );
      }

      // close file writer so all output is written to disk
      fileWriter.close();
   }

   private static String getRandomName(Random randomNumGen)
   {
      String name = "";

      int length = randomNumGen.nextInt(8) + 2;
      for (int charIndex = 0; charIndex < length; charIndex++)
      {
         char nextChar = (char) (randomNumGen.nextInt('z' - 'a') + 'a');
         name += nextChar;
      }

      return name;
   }

   private static String getRandomNumber(Random randomNumGen)
   {
      String number = "";

      int length = 3 + randomNumGen.nextInt(9);
      for (int digitIndex = 0; digitIndex < length; digitIndex++)
      {
         int digit = randomNumGen.nextInt(10);
         number += digit;
      }

      return number;
   }
}
