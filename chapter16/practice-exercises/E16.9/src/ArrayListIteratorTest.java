import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.ListIterator;

public class ArrayListIteratorTest
{
    private ArrayList staff;
    private ListIterator iterator;

    @Before
    public void initialiseList()
    {
        staff = new ArrayList();
        staff.add(0, "Adam");
        staff.add(1, "Bob");
        staff.add(2, "Cara");
        staff.add(3, "David");
        iterator = staff.listIterator();
    }

    @Test
    public void whenAddIsCalledItemIsAdded()
    {
        iterator.add("007");
        ArrayList expectedStaff = new ArrayList();
        expectedStaff.add(0, "007");
        expectedStaff.add(1, "Adam");
        expectedStaff.add(2, "Bob");
        expectedStaff.add(3, "Cara");
        expectedStaff.add(4, "David");
        Assert.assertEquals(expectedStaff, staff);
        iterator.add("008");
        expectedStaff = new ArrayList();
        expectedStaff.add(0, "007");
        expectedStaff.add(1, "008");
        expectedStaff.add(2, "Adam");
        expectedStaff.add(3, "Bob");
        expectedStaff.add(4, "Cara");
        expectedStaff.add(5, "David");
        Assert.assertEquals(expectedStaff, staff);
    }

    @Test
    public void whenListIteratorMutatorMethodsAreCalledConcurrentModificationExceptionIsThrownIfListWasModifiedElsewhere()
    {
        iterator.next();
        staff.set(0, "Adele");
        Assert.assertThrows(ConcurrentModificationException.class, () -> {
            iterator.next();
        });
        Assert.assertThrows(ConcurrentModificationException.class, () -> {
            iterator.previous();
        });
        Assert.assertThrows(ConcurrentModificationException.class, () -> {
            iterator.add("Mandela");
        });
        Assert.assertThrows(ConcurrentModificationException.class, () -> {
            iterator.remove();
        });
        Assert.assertThrows(ConcurrentModificationException.class, () -> {
            iterator.set("William");
        });
    }

    @Test
    public void whenHasNextCalledAtStartMiddleAndEndExpectedValueReturned()
    {
        boolean hasNext = iterator.hasNext();
        boolean expected = true;
        Assert.assertEquals(expected, hasNext);
        iterator.next();
        hasNext = iterator.hasNext();
        Assert.assertEquals(expected, hasNext);
        iterator.next();
        iterator.next();
        iterator.next();
        hasNext = iterator.hasNext();
        expected = false;
        Assert.assertEquals(expected, hasNext);
    }

    @Test
    public void whenHasPreviousCalledAtStartMiddleAndEndExpectedValueReturned()
    {
        boolean hasPrevious = iterator.hasPrevious();
        boolean expected = false;
        Assert.assertEquals(expected, hasPrevious);
        iterator.next();
        hasPrevious = iterator.hasPrevious();
        expected = true;
        Assert.assertEquals(expected, hasPrevious);
        iterator.next();
        iterator.next();
        iterator.next();
        hasPrevious = iterator.hasPrevious();
        Assert.assertEquals(expected, hasPrevious);
    }

    @Test
    public void whenSetIsCalledAfterNextOrPreviousValueIsSetCorrectly()
    {
        iterator.next();
        iterator.set("007");
        ArrayList expectedStaff = new ArrayList();
        expectedStaff.add(0, "007");
        expectedStaff.add(1, "Bob");
        expectedStaff.add(2, "Cara");
        expectedStaff.add(3, "David");
        Assert.assertEquals(expectedStaff, staff);
        iterator.previous();
        iterator.set("Adele");
        expectedStaff = new ArrayList();
        expectedStaff.add(0, "Adele");
        expectedStaff.add(1, "Bob");
        expectedStaff.add(2, "Cara");
        expectedStaff.add(3, "David");
        Assert.assertEquals(expectedStaff, staff);
    }

    @Test
    public void whenSetIsCalledWithoutPriorPreviousOrNextCallExceptionIsThrown()
    {
        Assert.assertThrows(IllegalStateException.class, () -> {
            iterator.set("007");
        });
    }

    @Test
    public void whenCallingRemoveWithoutCallingNextOrPreviousFirstAnErrorIsThrown()
    {
        Assert.assertThrows(IllegalStateException.class, () -> {
            iterator.remove();
        });
    }

    @Test
    public void whenCallingRemoveAfterNextElementIsRemoved()
    {
        iterator.next();
        iterator.remove();
        ArrayList expectedStaff = new ArrayList();
        expectedStaff.add(0, "Bob");
        expectedStaff.add(1, "Cara");
        expectedStaff.add(2, "David");
        Assert.assertEquals(expectedStaff, staff);
    }

    @Test
    public void whenCallingRemoveAfterPreviousElementIsRemoved()
    {
        iterator.next();
        iterator.next();
        iterator.previous();
        iterator.remove();
        ArrayList expectedStaff = new ArrayList();
        expectedStaff.add(0, "Adam");
        expectedStaff.add(1, "Cara");
        expectedStaff.add(2, "David");
        Assert.assertEquals(expectedStaff, staff);
    }

    @Test
    public void whenCallingRemoveTwiceInARowConcurrentModificationExceptionIsThrown()
    {
        iterator.next();
        iterator.next();
        iterator.remove();
        Assert.assertThrows(IllegalStateException.class, () -> {
            iterator.remove();
        });
    }
}