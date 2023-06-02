import java.util.Scanner;

/**
 * A program that reads four integers and prints “two pairs” if the input consists of two matching pairs (in some order)
 * and “not two pairs” otherwise.
 */
public class Main
{
   public static void main(String[] args)
   {
      boolean twoPairs = false;
      int num1;
      int num2;
      int num3;
      int num4;

      Scanner input = new Scanner(System.in);
      System.out.print("Enter first number: ");
      if (input.hasNextInt())
      {
         num1 = input.nextInt();

         System.out.print("Enter second number: ");
         if (input.hasNextInt())
         {
            num2 = input.nextInt();

            System.out.print("Enter third number: ");
            if (input.hasNextInt())
            {
               num3 = input.nextInt();

               System.out.print("Enter fourth number: ");
               if (input.hasNextInt())
               {
                  num4 = input.nextInt();

                  // inputs are valid

                  if (num1 == num2)
                  {
                     if (num3 == num4)
                     {
                        twoPairs = true;
                     }
                  }
                  else if (num1 == num3)
                  {
                     if (num2 == num4)
                     {
                        twoPairs = true;
                     }
                  }
                  else if (num1 == num4)
                  {
                     if (num2 == num3)
                     {
                        twoPairs = true;
                     }
                  }
                  else
                  {
                     twoPairs = false;
                  }

                  // providing output
                  if (twoPairs)
                  {
                     System.out.print("Two pairs.");
                  }
                  else
                  {
                     System.out.print("Not two pairs.");
                  }
               }
               else
               {
                  System.out.print("Invalid input");
               }
            }
            else
            {
               System.out.print("Invalid input");
            }
         }
         else
         {
            System.out.print("Invalid input");
         }
      }
   }
}