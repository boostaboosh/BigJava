public class ArgumentsAndReturnTypes
{
    public static void main(String[] args)
    {
        /**
         * R2.10
         * Give an example of a method that has an argument of type int .
         * Give an example of a method that has a return value of type int . Repeat for the type String.
         */
//        A method that has an argument of type int is the overloaded println method of the PrintStream class.
//        For example:
        System.out.println(8);

//        A method that has a return value of type int is the length method of the String class.
//        For example:
        String name = "James";
        int nameLength = name.length();
        System.out.print(nameLength);
        System.out.println("123456789".length());

//        A method that has an argument of type String is the replace method of the String class. It actually has two arguments of type String.
//        The replace method carries out a search and replace operation by constructing a new string that is obtained by replacing all occurrences of a target string in the string object it is invoked on with a replacement string
//        For example:
        String beforeReplacement = "weewee";
        String afterReplacement = beforeReplacement.replace("e", "o");
        System.out.println(afterReplacement);
        System.out.println("Hello".replace("H", "c"));

//        A method that has a return value of type String is the toUpperCase method of the String class.
//        For example:
        String uncapitalisedString = "the lord of the rings!";
        System.out.println(uncapitalisedString.toUpperCase());
        System.out.println("arghhhh".toUpperCase());

    }
}
