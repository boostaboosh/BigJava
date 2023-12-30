import java.util.Scanner;

/**
 * This class contains a program that converts usd to yen
 * and vice versa using a user inputted price of 1 dollar in yen.
 */
public class USDYENCurrencyConverter
{
   /**
    * Starts the program.
    * @param args the program starting arguments
    */
   public static void main(String[] args)
   {
      final double TINY_NUMBER_EPSILON = 1E-14;

      Scanner scanner = new Scanner(System.in);
      System.out.print("Enter the price of 1 U.S. dollar in Japanese yen: ");
      final double ONE_USD_COST_IN_YEN = scanner.nextDouble();

      System.out.print("Enter US dollar values to convert to Japanese yen (0 to end): ");

      boolean done = false;
      while (!done)
      {
         double nextDouble = scanner.nextDouble();
         if (Math.abs(nextDouble - 0) <= TINY_NUMBER_EPSILON)
         {
            done = true;
         }
         else
         {
            double dollarValue = nextDouble;
            double yenValue = dollarValue * ONE_USD_COST_IN_YEN;
            System.out.printf("$%.3f costs ¥%.3f\n", dollarValue, yenValue);
         }
      }

      System.out.print("End JPN ¥ amounts to convert to USD $ (0 to end): ");

      done = false;
      while (!done) {
         double nextDouble = scanner.nextDouble();
         if (Math.abs(nextDouble - 0) <= TINY_NUMBER_EPSILON) {
            done = true;
         } else {
            double yenValue = nextDouble;
            double dollarValue = yenValue / ONE_USD_COST_IN_YEN;
            System.out.printf("JPN ¥%.3f costs US $%.3f\n", yenValue, dollarValue);
         }
      }
   }
}
