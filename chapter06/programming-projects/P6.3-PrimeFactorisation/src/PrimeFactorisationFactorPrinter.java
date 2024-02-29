import java.util.Scanner;

/**
 * The PrimeFactorisationFactorPrinter class executes a program which reads
 * user input, constructs a PrimeFactorisationFactorGenerator object, and
 * prints the factors.
 */
public class PrimeFactorisationFactorPrinter
{
   /**
    * Start the program
    * @param args the program starting arguments
    */
   public static void main(String[] args)
   {
      Scanner scanner = new Scanner(System.in);
      System.out.print("Enter integer to prime factorise: ");

      int integerToFactorise = scanner.nextInt();
      PrimeFactorisationFactorGenerator primeFactorisationFactorGenerator =
            new PrimeFactorisationFactorGenerator(integerToFactorise);
      while (primeFactorisationFactorGenerator.hasNextFactor())
      {
         int nextFactorInPrimeFactorisation = primeFactorisationFactorGenerator.nextFactor();
         System.out.println(nextFactorInPrimeFactorisation);
      }
   }
}
