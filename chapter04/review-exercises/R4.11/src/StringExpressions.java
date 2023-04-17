public class StringExpressions
{
    public static void main(String[] args)
    {
        // Given a string s, write expressions for:
        String string = "string";

        // • The string consisting of the first letter
        String firstLetter = string.substring(0, 1);
        System.out.println(firstLetter);

        // • The string consisting of the first and last letter
        String firstAndLast = string.substring(0, 1).concat(string.substring(string.length() - 1));
        System.out.println(firstAndLast);

        // • The string consisting of all but the first and last letter
        String allButFirstAndLast = string.substring(1, string.length() - 1);
        System.out.println(allButFirstAndLast);

        // • The first half of the string (discarding the middle letter if the string has odd
        // length)
        String firstHalf = string.substring(0, string.length() / 2);
        System.out.println(firstHalf);

        // • The second half of the string (discarding the middle letter if the string has odd
        // length)
        String secondHalf = string.substring((int) Math.round(string.length() / 2.0));
        System.out.println(secondHalf);

        // • The string consisting of the middle letter if the string has odd length, or the
        // middle two letters otherwise
        String middle = string.substring((int) Math.round(string.length() / 2.0) - 1, string.length() / 2 + 1);
        System.out.println(middle);
    }
}
