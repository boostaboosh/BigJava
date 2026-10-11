import java.util.NoSuchElementException;

public class ListTest
{
    public static void main(String[] args)
    {
        LinkedList staff = new LinkedList();
        staff.addFirst("Tom");
        staff.addFirst("Romeo"); // Romeo -> Tom -> null
        staff.removeFirst(); // Tom -> null
        String first = (String) staff.getFirst();
        if (first.equals("Romeo")) System.out.println("Error: first should not equal Romeo who was removed!");
    }
}
