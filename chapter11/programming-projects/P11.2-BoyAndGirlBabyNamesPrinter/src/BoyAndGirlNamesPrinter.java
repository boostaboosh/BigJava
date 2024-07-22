import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;

public class BoyAndGirlNamesPrinter
{
   public static void main(String[] args)
   {
      String filename = "babynames.txt";
      File babyNamesFile = new File(filename);
      try (Scanner reader = new Scanner(babyNamesFile))
      {
         ArrayList<String> boyNames = new ArrayList<>();
         ArrayList<String> girlNames = new ArrayList<>();
         while (reader.hasNextLine())
         {
            String[] names = reader.nextLine().split("[^A-Za-z]+"); // yields ["", "boyName", "girlName"]
            boyNames.add(names[1]);
            girlNames.add(names[2]);
         }

         int boyAndGirlNamesCounter = 0;
         for (String boyName : boyNames)
         {
            for (String girlName : girlNames)
            {
               if (boyName.equals(girlName))
               {
                  boyAndGirlNamesCounter = boyAndGirlNamesCounter + 1;
                  System.out.println(boyAndGirlNamesCounter + ": " + boyName);
               }
            }
         }
      } // Scanner reader is autoclosed by try with resources statement
      catch (FileNotFoundException exception)
      {
         System.out.println("Could not find file: " + filename);
      }
   }
}
