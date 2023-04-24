import java.util.Scanner;

/**
 * A class which adds a comma to separate the thousands of an integer input between 1,000 and 999,999.
 */
public class CommaAdder
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        // output message telling user to input an integer between 1000 and 999999
        System.out.println("Input an integer between 1000 and 999999 to which you want to add a comma: ");
        // input = user keyboard input
        String number = input.next();
        // rightOfThousands = string from third last character to last character of input number
        String rightOfThousands = number.substring(number.length() - 3, number.length());
        // LeftOfHundreds = string from first character to fourth last character of input number
        String leftOfHundreds = number.substring(0, number.length() - 3);
        // output leftOfHundreds + , + rightOfThousands
        System.out.println(leftOfHundreds + "," + rightOfThousands);
    }
}
