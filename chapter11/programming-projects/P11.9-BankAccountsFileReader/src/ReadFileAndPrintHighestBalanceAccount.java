import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Contains a sample program to read in a file with bank accounts,
 * then print the account with the highest balance.
 */
public class ReadFileAndPrintHighestBalanceAccount
{
   /**
    * Runs the sample program which gives the user 2 chances to provide a correctly formatted
    * bank accounts data file, and then prints the account with the highest balance from the
    * file.
    * @param args the program starting arguments are not used
    */
   public static void main(String[] args)
   {
      Bank bank = new Bank();
      Scanner inputReader = new Scanner(System.in);
      String filename = null;
      int incorrectFileFormatCounter = 0;
      final int MAXIMUM_ATTEMPTS = 2;
      boolean finishedAttempts = false;
      while (!finishedAttempts)
      {
         try
         {
            filename = askUserForFileName(inputReader);
            bank.readFile(filename);
            finishedAttempts = true;
         }
         catch (FileNotFoundException e)
         {
            System.out.println("Could not find file");
            finishedAttempts = true;
         }
         catch (IncorrectBankDataFileFormat e)
         {
            System.out.println("Incorrect data format in file " + filename + ": " + e.getMessage());
            incorrectFileFormatCounter = incorrectFileFormatCounter + 1;
            if (incorrectFileFormatCounter >= MAXIMUM_ATTEMPTS)
            {
               finishedAttempts = true;
            }
         }
      }
      System.out.println("Bank account with highest balance from file: " + bank.getAccountWithHighestBalance());
   }

   /**
    * Asks the user for the name of a file.
    * @param inputReader the user input scanner
    * @return the filename entered by the user
    */
   public static String askUserForFileName(Scanner inputReader)
   {
      System.out.print("Enter name of file with bank accounts data: ");
      return inputReader.nextLine();
   }
}
