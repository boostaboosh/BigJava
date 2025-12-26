import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main
{
   public static void main(String[] args)
   {
      for (int num : new TreeSet<>(getPrimes(100)))
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
   public static Set<Integer> getPrimes(int num)
   {
      Set<Integer> nums = new HashSet<>();
      for (int number = 2; number <= num; number++) nums.add(number);

      for (int root = 2; root * root <= num; root++)
      {
         if (!nums.contains(root)) continue;
         for (int multiple = root * root; multiple <= num; multiple += root) nums.remove(multiple);
      }

      return nums;
   }
}