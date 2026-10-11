import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LinkedListTests
{
    private LinkedList list;

    @BeforeClass
    public static void Setup()
    {
        Logger.getGlobal().setLevel(Level.INFO);
    }

    @Before
    public void InitialiseList()
    {
        list = new LinkedList();
    }

    @Test
    public void ReverseListTest()
    {
        list.addFirst("Romolo");
        list.addFirst("Remo");
        list.addFirst("Lupo"); // lupo -> remo -> romolo
        list.reverseList(); // romolo -> remo -> lupo

        ArrayList<String> expected = new ArrayList<>(Arrays.asList("Romolo", "Remo", "Lupo"));

        ListIterator iterator = list.listIterator();
        int indexCounter = 0;
        while (iterator.hasNext() && indexCounter < expected.size())
        {
            Object nextInLinkedList = iterator.next();
            Object nextExpected = expected.get(indexCounter);
            Assert.assertEquals(nextExpected, nextInLinkedList);
            indexCounter++;
        }
        if (indexCounter < expected.size() - 1) Assert.fail("not all expected elements in reversed list");
    }

    @Test
    public void ReverseEmptyListTest()
    {
        list.reverseList();
        Assert.assertThrows(NoSuchElementException.class, () -> list.getFirst());
        ListIterator iterator = list.listIterator();
        if (iterator.hasNext()) Assert.fail("reversed linked list should be empty");
    }

    @Test
    public void ReverseSingleItemListTest()
    {
        list.addFirst("lonely");
        list.reverseList();
        Assert.assertEquals("lonely", list.getFirst());
        list.removeFirst();
        Assert.assertThrows(NoSuchElementException.class, () -> list.removeFirst());
    }
}
