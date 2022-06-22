public class PunctuationReplace
{
    public static void main (String[] args)
    {
        String message = "Hello, World!";
        message = message.replace(",", "").replace(" ", "").replace("!", "");
        System.out.println(message);
        message = "Big, Large, Bean Bag!";
        String messageWithoutCommas = message.replace(",", "");
        String messageWithoutExclamationMarks = messageWithoutCommas.replace("!", "");
        String messageWithoutSpaces = messageWithoutExclamationMarks.replace(" ", "");
        message = messageWithoutSpaces;
        System.out.println(message);
    }
}
