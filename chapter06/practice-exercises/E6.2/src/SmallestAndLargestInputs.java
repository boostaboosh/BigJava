import java.util.Scanner;

/**
 * This class contains a program which prints the smallest and largest integer inputs
 */
public class SmallestAndLargestInputs
    {
    /**
     * Print the smallest and largest integers inputted by the user
     * @param args
     */
    public static void main(String[] args)
    {
        int inputInteger;
        int biggestInput = Integer.MIN_VALUE;
        int smallestInput = Integer.MAX_VALUE;
        boolean done = false;

        Scanner input = new Scanner(System.in);
        do
        {
            System.out.print("Enter an integer: ");
            inputInteger = input.nextInt();
            if (inputInteger < smallestInput)
            {
                smallestInput = inputInteger;
            }
            else if (inputInteger > biggestInput)
            {
                biggestInput = inputInteger;
            }
            System.out.print("Are you done? (y/n): ");
            if (input.next().equals("y"))
            {
                done = true;
            }
        }
        while (!done);

        System.out.printf("The biggest input was %d.%nThe smallest input was %d.", biggestInput, smallestInput);
    }
}
