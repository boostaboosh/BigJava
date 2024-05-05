import java.io.InputStream;
import java.util.Scanner;

public class Reader
{
   private Scanner scanner;
   private String currentElement;
   
   /**
    * A Reader object reads from an InputStream object like
    * System.in and provides an accessor method for accessing
    * the next value in the input stream and a mutator method
    * for consuming it.
    * @param inputStream an input stream object like System.in
    */
   public Reader(InputStream inputStream)
   {
      this.scanner = new Scanner(inputStream);
      this.currentElement = "";
   }

   /**
    * Checks whether there is another element.
    * @return true if there is another element
    */
   public boolean hasMoreElements()
   {
      return this.scanner.hasNext();
   }

   /**
    * Yields the current element without consuming it.
    * @return the current element
    */
   public String getCurrent()
   {
      return this.currentElement;
   }

   /**
    * Consumes the current element.
    */
   public void next()
   {
      this.currentElement = this.scanner.next();
   }
}
