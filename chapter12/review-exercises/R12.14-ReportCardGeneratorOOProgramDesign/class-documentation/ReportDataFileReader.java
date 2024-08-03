import java.util.Scanner;
import java.io.File;
import java.io.IOException;

/**
 * Reads student report card data from a file.
 */
public class ReportDataFileReader
{
   /*
    * Reads student report card data from a file.
    *
    * The file must have the format:
    * institution name  
    * building number, road, city, state, postal code  
    * student name, student number  
    * semester start date (DD-MM-YY), semester end date (DD-MM-YY), semester short name  
    * subject, grade  
    * subject, grade
    *
    * For example, an input file report-card.dat could look like the following:
    *
    * Sunny Side University  
    * 18, Sandy Beach Avenue, Los Sol, CA, 92383  
    * Gregory Jones, 616382  
    * 10-09-24, 10-01-25, Winter 2024  
    * Java Programming, 4.0  
    * Markdown Writing, 3.0  
    * Meditation 101, 1.0
    *
    * @param filename the name of the file to read from
    * @throws IOException
    */
   public static ReportCard readReportDataFile(String filename) throws IOException
   {
      // todo: fill implementation
   }
}
