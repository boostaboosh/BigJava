/**
 * This class contains a program which contains a bounds error.
 * A bounds error is a run time error which occurs when you try
 * to access a non-existent array element by using an invalid index
 * which is outside the range of array indexes.
 * The Java compiler does not catch bounds errors so watch out,
 * because there is no compiler error message. Instead, the
 * program will generate an exception at run-time.
 */
public class BoundsError
{
   public static void main(String[] args)
   {
      int[] numbers = {1, 2, 3, 4};
      int number = numbers[4];
   }
}