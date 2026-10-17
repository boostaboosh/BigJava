import org.junit.Assert;
import org.junit.Test;

import java.util.ListIterator;
import java.util.NoSuchElementException;

import static org.junit.Assert.assertThrows;

public class LinkedListIteratorTest {

    @Test
    public void previousReturnsPreviousElement()
    {
        LinkedList list = new LinkedList();
        list.addFirst("Rory");
        list.addFirst("John");
        list.addFirst("Kieran");
        list.addFirst("Declan");
        ListIterator iterator = list.listIterator(); // |DKJR
        iterator.next(); // D|KJR
        iterator.next(); // DK|JR
        String previous = (String) iterator.previous(); // D|KJR
        String expected = "Kieran";
        Assert.assertEquals(expected, previous);
        previous = (String) iterator.previous(); // |DKJR
        expected = "Declan";
        Assert.assertEquals(expected, previous);
        assertThrows(NoSuchElementException.class, () -> {
            iterator.previous();
        });
    }

    @Test
    public void hasPreviousReturnsExpectedValue()
    {
        LinkedList list = new LinkedList();
        list.addFirst("Declan");
        list.addFirst("Kieran");
        list.addFirst("John");
        list.addFirst("Rory");
        ListIterator iterator = list.listIterator(); // |RJKD
        iterator.next(); // R|JKD
        iterator.next(); // RJ|KD
        boolean actualHasPrev = iterator.hasPrevious();
        boolean expectedHasPrev = true;
        Assert.assertEquals(expectedHasPrev, actualHasPrev);
        iterator.previous(); // R|JKD
        actualHasPrev = iterator.hasPrevious();
        expectedHasPrev = true;
        Assert.assertEquals(expectedHasPrev, actualHasPrev);
        iterator.previous(); // |RJKD
        actualHasPrev = iterator.hasPrevious();
        expectedHasPrev = false;
        Assert.assertEquals(expectedHasPrev, actualHasPrev);
    }

    @Test
    public void listIteratorWithIndexNextCallReturnsCorrectElement()
    {
        LinkedList list = new LinkedList();
        list.addFirst("Declan");
        list.addFirst("Kieran");
        list.addFirst("John");
        list.addFirst("Rory");
        ListIterator iterator = list.listIterator(3);
        String nextResult = (String) iterator.next();
        String expected = "Declan";
        Assert.assertEquals(expected, nextResult);
    }
}