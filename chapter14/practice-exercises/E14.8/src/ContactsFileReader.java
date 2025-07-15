import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class ContactsFileReader
{
   public static Contact[] getContacts(String fileName) throws IllegalArgumentException, IOException
   {
      if (fileName == null || fileName.isBlank())
      {
         throw new IllegalArgumentException("file name cannot be null or blank");
      }

      List<String> lines = Files.readAllLines(Paths.get(fileName));
      Contact[] contacts = new Contact[lines.size()];
      for (int lineCounter = 0; lineCounter < lines.size(); lineCounter++)
      {
         contacts[lineCounter] = parseContact(lines.get(lineCounter));
      }

      return contacts;
   }

   private static Contact parseContact(String fileLine)
   {
      String[] parts = fileLine.split("\\s");
      String name = parts[0];
      String number = parts[1];
      return new Contact(name, number);
   }

}
