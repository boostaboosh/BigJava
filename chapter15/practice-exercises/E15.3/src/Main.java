import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main
{
   public static void main(String[] args)
   {
      for (int num : getPrimes(100))
      {
         System.out.println(num);
      }
   }

   /**
    * Computes prime numbers up to and including n.
    * Uses the sieve of Eratosthenes method which was known
    * to the ancient greeks.
    * @param num the number n to compute primes up to
    * @return the prime numbers from 2 to n
    * (outer bounds of num range included)
    */
   public static LinkedList<Integer> getPrimes(int num)
   {
      LinkedList<Integer> twoToN = new LinkedList<>();
      for (int counter = 2; counter <= num; counter++)
      {
         twoToN.add(counter);
      }

      int squareRootN = (int) Math.sqrt(num);
      Set<Integer> factors = new TreeSet<>();
      for (int counter = 2; counter <= squareRootN; counter++)
      {
         factors.add(counter);
      }

      factors.forEach((factor) -> {
         twoToN.removeIf((number) -> !number.equals(factor) && number % factor == 0);
      });

      return twoToN;
   }
}