import java.util.Scanner;

/**
 * A program which reads in a year number and computer whether that year is a leap year
 */
public class YearTester
{
   public static void main(String[] args)
   {
      Scanner input = new Scanner(System.in);
      System.out.println("Enter a year: ");
      if (input.hasNextInt())
      {
         // input is valid
         int yearNumber = input.nextInt();
         Year year = new Year(yearNumber);
         boolean isLeapYear = year.isLeapYear();
         if(isLeapYear) { System.out.print("Is a leap year."); }
         else { System.out.print("Is not a leap year."); }
      }
      else // input is invalid
      {
         System.out.print("Invalid input. Input must be an integer.");
      }
   }
}
