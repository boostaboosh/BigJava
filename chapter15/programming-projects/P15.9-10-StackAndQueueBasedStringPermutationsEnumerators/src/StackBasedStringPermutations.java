import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class StackBasedStringPermutations
{
    public static void main(String[] args)
    {
        Scanner inputReader = new Scanner(System.in);
        System.out.println("Enter word to find permutations of: ");
        String word = inputReader.nextLine().replace(" ", "");
        List<String> permutations = getPermutations(word);
        for (String permutation : permutations)
        {
            System.out.println(permutation);
        }
    }

    public static List<String> getPermutations(String word)
    {
        List<String> permutations = new LinkedList<>();
        Stack<String> stack = new Stack<>();
        stack.push("+" + word);
        while (!stack.isEmpty())
        {
            String top = stack.pop();
            if (top.charAt(top.length() - 1) == '+')
            {
                permutations.add(top.substring(0, top.length() - 1));
            } else {
                int plusPos = -1;
                for (int i = 0; i < top.length(); i++)
                {
                    if (top.charAt(i) == '+') plusPos = i;
                    else if (plusPos != -1)
                    {
                        String beforePlus = top.substring(0, plusPos);
                        String afterPlusBeforeChar = top.substring(plusPos + 1, i);
                        String afterChar = top.substring(i + 1);
                        stack.push(beforePlus + top.charAt(i) + '+' + afterPlusBeforeChar + afterChar);
                    }
                }
            }
        }
        return permutations;
    }
}
