import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class HelloWorldWriterAndReader
{
   public static void main(String[] args) throws FileNotFoundException
   {
      // open a file with the name hello.txt
      PrintWriter outputFileWriter = new PrintWriter("hello.txt");
      // store the message "Hello, World!" in the file
      outputFileWriter.print("Hello, World!");
      // close the file
      outputFileWriter.close();
      // open the same file again
      File inputFile = new File("hello.txt");
      // read the message into a string variable and print it
      Scanner inputFileScanner = new Scanner(inputFile);
      String message = inputFileScanner.nextLine();
      System.out.println(message);
   }
}
