import java.util.Scanner;

/**
 * A class for solving chap 4 practice exercise 12 Big Java.
 */
public class CommaRemover
{
    public static void main(String[] args)
    {
//        output message to user saying to input number with comma between 1,000 and 999,999
        System.out.println("Enter number between 1,000 and 999,999 with the comma: ");
//        numberWithComma = keyboard input
        Scanner input = new Scanner(System.in);
        String numberWithComma = input.next();
//        position of last letter = numberWithComma.length - 1
        int lastLetterPosition = numberWithComma.length() - 1;
//        position of comma = position of last letter - 3
        int positionOfComma = lastLetterPosition - 3;
//        first half of number = string from position 0 to before comma
        String firstHalfOfNumber = numberWithComma.substring(0, positionOfComma);
//        second half of number = string from after comma to end of string
        String secondHalfOfNumber = numberWithComma.substring(positionOfComma + 1, numberWithComma.length());
//        output first half of number concatenated with second half of number
        System.out.println(firstHalfOfNumber + secondHalfOfNumber);
    }
}
