import java.util.Arrays;

public class MedianComputer
{
    public static double getMedian(int[] a)
    {
        a = Arrays.copyOf(a, a.length);
        boolean isEven = a.length % 2 == 0;
        if (isEven)
        {
            int[] a2 = Arrays.copyOf(a, a.length);
            double first = select(a, (a.length / 2) - 1, 0, a.length);
            double second = select(a2, a2.length / 2, 0, a2.length);
            return (first + second) / 2.0;
        }
        else
        {
            return select(a, a.length / 2, 0, a.length);
        }
    }

    /**
     * Given an unsorted sequence of elements
     * and included (lowerInc) and excluded (upperExc) bounds,
     * this method finds the element that would be in the k-th position (zero based rank, so 1st element is k == 0)
     * if the sequence of values was sorted,
     * using the quickSelect algorithm which works similarly to quicksort:
     * partitions the sequence around a pivot element, and repeats this process until it finds the element at
     * the position we are looking for.
     * @param sequence the unsorted sequence of elements
     * @param posOfSortedToGet the k-th item of the sequence between lowerInc and upperExc bounds
     * @param lowerInc the lowerInc included index bound to use as the start of the sorted sequence
     * @param upperExc the upperExc excluded index bound to use as the end of the sorted sequence
     * @return the k-th item in the sorted sequence of items from the lowerInc bound item to the upperExc bound item
     */
    private static int select(int[] sequence, int posOfSortedToGet, int lowerInc, int upperExc)
    {
        if (upperExc - lowerInc == 1)
        {
            return sequence[lowerInc];
        }
        if (sequence == null || sequence.length == 0)
        {
            throw new IllegalArgumentException("cannot select element in null or empty sequence");
        }
        if (lowerInc < 0 || upperExc > sequence.length)
        {
            throw new IllegalArgumentException("lower included bound cannot be less than zero, and upper excluded bound cannot be greater than sequence length");
        }
        if (posOfSortedToGet < lowerInc || posOfSortedToGet >= upperExc)
        {
            throw new IllegalArgumentException("position of element to get must be >= lower included bound and < upper excluded bound");
        }

        int pivotPosition = lowerInc;

        int[] partitionSizes = partition(sequence, lowerInc, upperExc - 1, pivotPosition);
        int numItemsLessThanPivot = partitionSizes[0];
        int numItemsEqualToPivot = partitionSizes[1];

        if (posOfSortedToGet < lowerInc + numItemsLessThanPivot) // k-th element is in left partition
        {
            // search the left partition
            return select(sequence, posOfSortedToGet, lowerInc, lowerInc + numItemsLessThanPivot);
        }
        else if (posOfSortedToGet >= lowerInc + numItemsLessThanPivot + numItemsEqualToPivot) // k-th element is in right partition
        {
            // search the right partition
            return select(sequence, posOfSortedToGet, lowerInc + numItemsLessThanPivot + numItemsEqualToPivot, upperExc);
        }
        else // k-th element is in middle partition of equal values
        {
            // return the middle partition pivot value from the last iteration
            int startOfEqualPartPos = lowerInc + numItemsLessThanPivot;
            return sequence[startOfEqualPartPos];
        }
    }

    /**
     * Partition a sequence into 3 subsequences:
     * elements < pivot,
     * elements = pivot,
     * elements > pivot.
     * @param sequence the sequence of elements
     * @param lower the first item in the portion of the sequence to partition
     * @param higher the last item in the portion of the sequence to partition
     * @param pivotPos the position of the pivot value
     * @return the size of the first (< p), second (= p), and third (> p) partitions in an array
     */
    private static int[] partition(int[] sequence, int lower, int higher, int pivotPos)
    {
        int pivot = sequence[pivotPos];

        int nextLessThanPivotPos = lower;
        int nextGreaterThanPivotPos = higher;
        int indexCounter = lower;

        int sizeOfFirstPart = 0;
        int sizeOfSecondPart = 0;
        int sizeOfThirdPart = 0;

        while (indexCounter <= nextGreaterThanPivotPos)
        {
            if (sequence[indexCounter] < pivot)
            {
                swap(indexCounter, nextLessThanPivotPos, sequence);
                nextLessThanPivotPos++;
                indexCounter++;
                sizeOfFirstPart++;
            }
            else if (sequence[indexCounter] > pivot)
            {
                swap(indexCounter, nextGreaterThanPivotPos, sequence);
                nextGreaterThanPivotPos--;
                sizeOfThirdPart++;
            }
            else
            {
                indexCounter++;
                sizeOfSecondPart++;
            }
        }

        return new int[] {sizeOfFirstPart, sizeOfSecondPart, sizeOfThirdPart};
    }

    private static void swap(int pos1, int pos2, int[] sequence)
    {
        int temp = sequence[pos1];
        sequence[pos1] = sequence[pos2];
        sequence[pos2] = temp;
    }

}
