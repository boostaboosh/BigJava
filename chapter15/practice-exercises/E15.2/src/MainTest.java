import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;

public class MainTest
{
    private LinkedList<String> list;

    @Before
    public void setup()
    {
        list = new LinkedList<>(Arrays.asList("1", "2", "3", "4"));
    }

    @Test
    public void reverse()
    {
        Main.reverse(list);
        LinkedList<String> expected = new LinkedList<>(Arrays.asList("4", "3", "2", "1"));
        Assert.assertEquals(expected, list);
    }
}