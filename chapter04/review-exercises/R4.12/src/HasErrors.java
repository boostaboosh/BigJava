/*
public class HasErrors
{
    public static void main();
    {
        System.out.print(Please enter two numbers:)
        x = in.readDouble;
        y = in.readDouble;
        System.out.printline("The sum is " + x + y);
    }
}

- 5 compile time errors:
    1 - There is a semi-colon after the declaration of the main method which should not be there.
            * The lack of String[] args as a main method parameter means that this is a method called main
            but is not the actual main method. This isn't a compile-time error because it is syntactically
            correct. However, you will not be able to run the program without a main method so this isn't
            even a run time error.
    2 - There are no double-quotes around the string argument for the first print statement.
    3 - There is no semi-colon after the first print statement.
4 & 5 - There is no declaration of the x and y variables which defines what types of values they store.
6 & 7 - There is no declaration of a scanner object called in with System.in, i.e, the keyboard,
        as an argument for its constructor so in will be an unrecognised token by the compiler.
    8 - readDouble is not a method of the Scanner class, the actual method name is nextDouble, so the
        compiler will not be able to find this symbol.
    9 - There are no brackets after the readDouble method invocations so these are not method calls and
        the compiler will think these are undeclared variables or properties of the scanner object.
   10 - There is no method called printline in the PrintStream class that the System.out object belongs to.
         So, printline will not be recognised by the compiler.
            * The argument of the last print method is syntactically correct however it will lead to a
              run-time error because it will not do what the programmer expects. Due to the + operator
              having left to right associativity and being used for both string concatenation and addition
              in Java depending on its arguments, in this situation the + operator will perform string
              concatenation starting on the left-hand side of the expression because the left-hand side
              operand is a string. This means that the left operand for the second + operator will also
              be a string and perform concatenation once again. Therefore, x & y will not be summed like
              the programmer expected.
 */

import java.util.Scanner;

public class HasErrors
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.print("Please enter two numbers:");
        double x = in.nextDouble();
        double y = in.nextDouble();
        double sum = x + y;
        System.out.println("The sum is " + sum);
    }
}
