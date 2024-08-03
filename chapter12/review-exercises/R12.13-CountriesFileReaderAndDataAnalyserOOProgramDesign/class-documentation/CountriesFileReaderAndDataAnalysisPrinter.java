import java.io.File;
import java.util.ArrayList;

/**
 * This program reads a file containing country data and prints:
 * 1. the country with the largest area
 * 2. the country with the largest population
 * 3. the country with the largest population density
 */
public class CountriesFileReaderAndDataAnalysisPrinter
{
   /**
    * Runs the program.
    */
   public static void main(String[] args)
   {
      // todo: fill implementation
   }
   
   /**
    * Asks user for input file.
    * @return the input file
    */
   public File askUserForFile()
   {
      // todo: fill implementation
   }

   /**
    * Reads country records from input file.
    * @return the ArrayList of countries from the input file
    */
   public ArrayList<Country> readFile(File inputFile)
   {
      // todo: fill implementation
   }

   /**
    * Prints the country with the largest measure to the terminal.
    * @param measurer the country measurer
    * @param countries the countries to measure
    */
   public void printLargestMeasureCountry
         (
               Measurer<Country> measurer,
               ArrayList<Country> countries
         )
   {
      // todo: fill implementation
   }
}
