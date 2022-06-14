public class Error2
{
    public static void maiN (String[] args)
    {
        // This is actually a run time error because the compiler does not consider this to be the same as the main method because
        // the Java language is case-sensitive: Upper and lowercase letters are considered to be completely different from each other.
        // The compiler will cheerfully compile the maiN method.
        // But when the Java virtual machine reads the compiled file, it will complain about the missing main method and refuse to run the program.
        System.out.println("The Java language is case sensitive.");
        // compile-time errors are found by the compiler at compile time.
        // They are errors according the rules of the programming language that the compiler translates.
        // For this reason compile time errors are often called syntax errors.
        // Compile-time errors stop your program from being translated to machine code and executed.
    }
}
