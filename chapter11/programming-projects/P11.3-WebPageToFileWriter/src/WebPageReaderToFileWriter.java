import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class WebPageReaderToFileWriter
{
   public static void main(String[] args)
   {
      Scanner inputReader = new Scanner(System.in);
      System.out.print("Enter webpage address: ");
      String address = inputReader.nextLine();
      URL pageLocation = null;
      try
      {
         pageLocation = new URL(address);
      }
      catch (MalformedURLException e)
      {
         System.out.println("Bad webpage address format: " + e.getMessage());
      }

      System.out.println("Enter output file name for webpage contents: ");
      try
            (
                  Scanner pageReader = new Scanner(pageLocation.openStream());
                  PrintWriter fileWriter = new PrintWriter(inputReader.nextLine())
            )
      {
         while (pageReader.hasNextLine())
         {
            fileWriter.println(pageReader.nextLine());
         }
      }
      catch (FileNotFoundException e)
      {
         System.out.println("Could not write to given output file: " + e.getMessage());
      }
      catch (IOException e)
      {
         System.out.println("Error connecting to webpage: " + e.getMessage());
      }
   }
}
