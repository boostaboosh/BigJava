import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;

public class QueueBasedStringPermutationsTest
{
    @Test
    public void QueueBasedPermutationsGetsAllPermutations()
    {
        List<String> actual = QueueBasedStringPermutations.getPermutations("meat");
        List<String> expected = new LinkedList<>(Arrays.asList(
                "meat", "meta", "maet", "mate", "mtae", "mtea",
                "eatm", "eamt", "etam", "etma", "emta", "emat",
                "aetm", "aemt", "atem", "atme", "amte", "amet",
                "team", "tema", "tmea", "tmae", "taem", "tame"

        ));
        assertTrue(actual.containsAll(expected));
        assertTrue(expected.containsAll(actual));
    }
}
