import java.util.ListIterator;
import java.util.LinkedList;
import java.util.Stack;

public class Main
{
    /**
     * Reverses the entries in a linked list.
     * @param strings the linked list to reverse the entries of
     */
    public static void reverse(LinkedList<String> strings)
    {
        Stack<String> entries = new Stack<>();
        strings.forEach((string) -> entries.push(string));

        ListIterator<String> listIterator = strings.listIterator();
        while(listIterator.hasNext())
        {
            listIterator.next();
            listIterator.set(entries.pop());
        }
    }
}