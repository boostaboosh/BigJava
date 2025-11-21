import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;

public class MainTest {

    private LinkedList<String> list;

    @Before
    public void setup()
    {
        list = new LinkedList<>(Arrays.asList("1", "2", "3", "4", "5", "6", "7"));
    }

    @Test
    public void downsizeThird()
    {
        Main.downsize(list, 3);
        LinkedList<String> expected = new LinkedList<>(Arrays.asList("1", "2", "4", "5", "7"));
        Assert.assertEquals(expected, list);
    }

    @Test
    public void downsizeFirst()
    {
        Main.downsize(list, 2);
        LinkedList<String> expected = new LinkedList<>(Arrays.asList("1", "3", "5", "7"));
        Assert.assertEquals(expected, list);
    }

    @Test
    public void downsizeSecond()
    {
        Main.downsize(list, 1);
        LinkedList<String> expected = new LinkedList<>();
        Assert.assertEquals(expected, list);
    }

    @Test
    public void downsizeBiggerN()
    {
        Main.downsize(list, 10);
        LinkedList<String> expected = new LinkedList<>(Arrays.asList("1", "2", "3", "4", "5", "6", "7"));
        Assert.assertEquals(expected, list);
    }
}