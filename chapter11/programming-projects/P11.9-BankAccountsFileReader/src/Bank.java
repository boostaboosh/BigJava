import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * A bank contains a number of bank accounts.
 */
public class Bank
{
   private ArrayList<BankAccount> accounts;

   /**
    * Constructs a new bank.
    */
   public Bank()
   {
      accounts = new ArrayList<>();
   }

   /**
    * Gets an array list containing cloned copies of the accounts in
    * this bank.
    * @return an array list containing cloned copies of the accounts
    * in this bank
    */
   public ArrayList<BankAccount> getAccountsCopy()
   {
      ArrayList<BankAccount> accountsCopy = new ArrayList<>();
      for (BankAccount account : accounts)
      {
         accountsCopy.add((BankAccount) account.clone());
      }
      return accountsCopy;
   }

   /**
    * Gets a clone of the bank account with the highest balance in this bank.
    * @return a clone of the bank account with the highest balance in this bank
    */
   public BankAccount getAccountWithHighestBalance()
   {
      BankAccount highestBalanceAccount = null;
      if (!accounts.isEmpty())
      {
         highestBalanceAccount = accounts.get(0);
         for (BankAccount account : accounts)
         {
            if (account.compareTo(highestBalanceAccount) > 0)
            {
               highestBalanceAccount = account;
            }
         }
      }
      return highestBalanceAccount;
   }

   /**
    * Reads in a file with bank account details in the format:
    * accountNumber1 balance1
    * accountNumber2 balance2
    * . . .
    * and creates the described bank accounts in this bank.
    * If the provided filename string has a null value no data
    * is read and no bank accounts are created.
    * @param filename the name of the file containing the bank
    *                accounts information
    * @throws FileNotFoundException if the file cannot be found
    * @throws IncorrectBankDataFileFormat if the format of the data in the file is incorrect
    */
   public void readFile(String filename) throws FileNotFoundException, IncorrectBankDataFileFormat
   {
      File bankDataFile = new File(filename);
      try (Scanner fileReader = new Scanner(bankDataFile))
      {
         ArrayList<BankAccount> accountsFromFile = new ArrayList<>();
         while (fileReader.hasNextLine())
         {
            String dataLine = fileReader.nextLine();
            try
            {
               accountsFromFile.add(BankAccount.readLine(dataLine));
            }
            catch (IncorrectBankDataLineFormat exception)
            {
               throw new IncorrectBankDataFileFormat
                     ("wrongly formatted line of bank account data in file: " + exception.getMessage());
            }
         }
         for (BankAccount account : accountsFromFile)
         {
            accounts.add(account);
         }
      }
   }
}
