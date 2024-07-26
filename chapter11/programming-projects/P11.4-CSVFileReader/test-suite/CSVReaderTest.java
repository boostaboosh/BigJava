import static org.junit.Assert.*;
import org.junit.Test;

public class CSVReaderTest
{
   @Test public void readingDataFromDataWithSomeBadLines()
   {
      CSVReader reader = new CSVReader("data-with-some-bad-lines.csv");
      reader.printRows();
      String expected = "Brooklyn";
      assertEquals(expected, reader.field(2, 5));
   }
}