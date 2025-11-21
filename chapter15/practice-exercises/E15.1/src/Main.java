import java.util.LinkedList;
import java.util.ListIterator;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main
{
    public static void main(String[] args)
    {

    }

    /**
     * Removes every nth employee from a linked list.
     * @param employeeNames the linked list
     * @param n the position of the first name to remove,
     *          and the names to remove relative to the last removed name,
     *          with the first element in the linked list being at n equals 1
     */
    public static void downsize(LinkedList<String> employeeNames, int n)
    {
        if (n < 0) throw new IllegalArgumentException();

        int iterPos = 0;
        ListIterator<String> iterator = employeeNames.listIterator();
        while (iterator.hasNext())
        {
            iterator.next();
            iterPos = iterPos + 1;
            if (iterPos == n)
            {
                iterator.remove();
                iterPos = 0;
            }
        }
    }
}