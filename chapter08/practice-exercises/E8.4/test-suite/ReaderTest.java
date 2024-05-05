import org.junit.Assert;
import org.junit.Test;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class ReaderTest
{
   @Test public void checkForMoreElementsInInputStream()
   {
      String input = "This is a test";
      InputStream inputStream = new ByteArrayInputStream(input.getBytes());
      Reader reader = new Reader(inputStream);
      // System.out.println("Enter non-whitespace characters: ");
      boolean expected = true;
      Assert.assertEquals(expected, reader.hasMoreElements());
   }
   
   @Test public void getCurrentElementWithoutConsumingIt()
   {
      String input = "This is a test";
      InputStream inputStream = new ByteArrayInputStream(input.getBytes());
      Reader reader = new Reader(inputStream);
      // System.out.println("Enter non-whitespace characters: ");
      reader.next();
      String expected = "This";
      Assert.assertEquals(expected, reader.getCurrent());
   }
   
   @Test public void consumeTheCurrentElement()
   {
      Reader reader = new Reader(System.in);
      // System.out.println("Enter non-whitespace characters separated by spaces: ");
      reader.next();
      reader.next();
      reader.next();
      String expectedThirdElementInInputStream = "a";
      Assert.assertEquals(expectedThirdElementInInputStream, reader.getCurrent());
   }
}
