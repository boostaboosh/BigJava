import org.junit.Assert;
import org.junit.Test;

public class MedianComputerTest {

    final double EPSILON = 1E-14;

    @Test
    public void GivenEmptyArray_WhenGetMedianCalled_ThrowsException()
    {
        int[] a = new int[] {};
        Assert.assertThrows(IllegalArgumentException.class, () -> MedianComputer.getMedian(a));
    }

    @Test
    public void GivenSinglePositiveElementArray_WhenGetMedianCalled_SingleValueReturned()
    {
        int[] a = new int[] { 5 };
        double median = MedianComputer.getMedian(a);
        double expected = 5.0;
        Assert.assertEquals(expected, median, EPSILON);
    }

    @Test
    public void GivenArrayWithPositiveDuplicates_WhenGetMedianCalled_CorrectValueReturned()
    {
        int[] a = new int[] { 1, 1, 5, 2, 5, 9, 2, 1 };
        double median = MedianComputer.getMedian(a);
        double expected = 2;
        Assert.assertEquals(expected, median, EPSILON);
    }

    @Test
    public void GivenArrayWithAllEqualPositiveValues_WhenGetMedianCalled_CorrectValueReturned()
    {
        int[] a = new int[] { 8, 8, 8, 8, 8 };
        double median = MedianComputer.getMedian(a);
        double expected = 8;
        Assert.assertEquals(expected, median, EPSILON);
    }

    @Test
    public void GivenPositiveValuesArrayWithNoValuesGreaterThanFirstPivotValue_WhenGetMedianCalled_CorrectValueReturned()
    {
        int[] a = new int[] { 7, 4, 2, 7, 0 };
        double median = MedianComputer.getMedian(a);
        double expected = 4;
        Assert.assertEquals(expected, median, EPSILON);
    }

    @Test
    public void GivenArrayWithMixedValues_WhenGetMedianCalled_CorrectValueReturned()
    {
        int[] a = new int[] { -1, 0, 5, -9, 3 };
        double median = MedianComputer.getMedian(a);
        double expected = 0;
        Assert.assertEquals(expected, median, EPSILON);
    }

    @Test
    public void GivenArrayWithEvenNumberOfPositiveValues_WhenGetMedianCalled_CorrectValueReturned()
    {
        int[] a = new int[] { 1, 2, 3, 4 };
        double median = MedianComputer.getMedian(a);
        double expected = 2.5;
        Assert.assertEquals(expected, median, EPSILON);
    }

    @Test
    public void GivenArrayWithEvenNumberOfNegativeValues_WhenGetMedianCalled_CorrectValueReturned()
    {
        int[] a = new int[] { -1, -2, -3, -4 };
        double median = MedianComputer.getMedian(a);
        double expected = -2.5;
        Assert.assertEquals(expected, median, EPSILON);
    }

    @Test
    public void GivenArrayWithOddNumberOfPositiveValues_WhenGetMedianCalled_CorrectValueReturned()
    {
        int[] a = new int[] { 1, 3, 4 };
        double median = MedianComputer.getMedian(a);
        double expected = 3;
        Assert.assertEquals(expected, median, EPSILON);
    }

    @Test
    public void GivenArrayWithOddNumberOfNegativeValues_WhenGetMedianCalled_CorrectValueReturned()
    {
        int[] a = new int[] { -1, -3, -4 };
        double median = MedianComputer.getMedian(a);
        double expected = -3;
        Assert.assertEquals(expected, median, EPSILON);
    }

    @Test
    public void GivenArrayWithOddNumberOfMixedValues_WhenGetMedianCalled_CorrectValueReturned()
    {
        int[] a = new int[] { 1, -3, 4 };
        double median = MedianComputer.getMedian(a);
        double expected = 1;
        Assert.assertEquals(expected, median, EPSILON);
    }

    @Test
    public void GivenArrayWithEvenNumberOfMixedValues_WhenGetMedianCalled_CorrectValueReturned()
    {
        int[] a = new int[] { 1, -3, 4, -20 };
        double median = MedianComputer.getMedian(a);
        double expected = -1;
        Assert.assertEquals(expected, median, EPSILON);
    }

}