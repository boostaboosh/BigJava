import java.util.*;

public class InfixToPostfixNotationConverter
{
    public static void main(String[] args)
    {
        String InfixExpression = getUserExpression();
        String reversePolish = toPostfix(InfixExpression);
        outputConvertedExpression(reversePolish);
    }

    private static String getUserExpression()
    {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter an expression: ");
        return in.nextLine();
    }

    public static String toPostfix(String infixExpression)
    {
        infixExpression = infixExpression.replace(" ", "");

        Stack<String> operandsStack = new Stack<>();
        Stack<Character> operatorsStack = new Stack<>();

        int pos = 0;
        while (pos < infixExpression.length())
        {
            char ch = infixExpression.charAt(pos);
            pos++;
            if (isOperator(ch))
            {
                if (operatorsStack.size() == 0) { operatorsStack.push(ch); }
                else
                {
                    char oldOp = operatorsStack.pop();
                    if (precedence(ch) > precedence(oldOp)) { operatorsStack.push(oldOp); }
                    else
                    {
                        evaluateTop(operandsStack, oldOp);
                    }
                    operatorsStack.push(ch);
                }
            }
            else if (ch == '(')
            {
                operatorsStack.push(ch);
            }
            else if (ch == ')')
            {
                boolean done = false;
                while (!done)
                {
                    if (operatorsStack.size() == 0) { error("No matching ("); }
                    char oldOp = operatorsStack.pop();
                    if (oldOp == '(')
                    {
                        done = true;
                    }
                    else
                    {
                        evaluateTop(operandsStack, oldOp);
                    }
                }
            }
            else if (isDigit(ch))
            {
                int start = pos - 1;
                while (pos < infixExpression.length()
                        && Character.isDigit(infixExpression.charAt(pos)))
                {
                    pos++;
                }
                String num = infixExpression.substring(start, pos);
                operandsStack.push(num);
            }
            else { error ("Number, operator, or parenthesis expected."); }
        }
        while (operatorsStack.size() > 0)
        {
            char oldOp = operatorsStack.pop();
            if (oldOp == '(') { error("No matching )"); }
            else
            {
                evaluateTop(operandsStack, oldOp);
            }
        }
        if (operandsStack.size() == 0) { error("Syntax error"); }
        if (operandsStack.size() > 1) { error("Syntax error"); } // makes sure there aren't extra operands beyond the resulting postfix expression on the stack

        return operandsStack.pop();
    }

    private static boolean isDigit(char ch)
    {
        return ch >= '0' && ch <= '9';
    }

    private static boolean isOperator(char ch)
    {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/'; // || ch == '(' || ch == ')';
    }

    private static int precedence(char operator)
    {
        if (operator == '*' || operator == '/')
        {
            return 2;
        }
        if (operator == '-' || operator == '+')
        {
            return 1;
        }
        if (operator == '(')
        {
            return 0;
        }
        else { error("not an operator"); }
        return 0;
    }

    private static void error(String message)
    {
        System.out.println("ERROR: " + message + ".");
        System.exit(1);
    }

    private static void evaluateTop(Stack<String> operandsStack, char operator)
    {
        if (operandsStack.isEmpty()) { error("Syntax error"); }
        String rightOperand = operandsStack.pop();
        if (operandsStack.isEmpty()) { error("Syntax error"); }
        String leftOperand = operandsStack.pop();
        operandsStack.push(leftOperand + rightOperand + operator);
    }

    private static void outputConvertedExpression(String output)
    {
        System.out.print("Expression converted to postfix, i.e. reverse polish, notation is: " + output);
    }

}
