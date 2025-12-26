import java.util.*;


public class TestFile
{
   public static void main(String[] args)
   {
      for (int num : new TreeSet<>(getPrimes(100)))
      {
         System.out.println(num);
      }
   }

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