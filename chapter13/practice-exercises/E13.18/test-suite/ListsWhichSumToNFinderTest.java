import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ListsWhichSumToNFinderTest {

    @org.junit.Test
    public void GIVEN_anArrayOfIntegers_WHEN_getSublistsWhichSumToNIsCalled_THEN_aListOfSublistsWhichSumToNIsReturned() {
        // given an array of integers
        int[] array = new int[] { 1, 2, 3, 4, 5};
        int n = 8;

        // when get sublists which sum to n is called
        List<List<Integer>> sublistsWhichSumToN = ListsWhichSumToNFinder.getSublistsWhichSumToN(array, n);

        // then a list of sublists which sum to n is returned
        List<List<Integer>> expectedSublistsWhichSumToN = new ArrayList<>(
                List.of(
                        List.of(1, 3, 4),
                        List.of(3, 5),
                        List.of(1, 2, 5)
                )
        );
        List<List<Integer>> actualSublists = sublistsWhichSumToN;

        assertTrue(
                "The expected and actual lists of sublists which sum to N are different.",
                haveSameContents(expectedSublistsWhichSumToN, actualSublists)
        );
    }

    @org.junit.Test
    public void GIVEN_anArrayOfIntegersWithNoSublistsWhichSumToN_WHEN_getSublistsWhichSumToNIsCalled_THEN_anEmptyListIsReturned() {
        // given an array of integers with no sublists which sum to N
        int[] array = new int[] { 1, 2, 3, 4, 5};
        int n = 100;

        // when get sublists which sum to n is called
        List<List<Integer>> sublistsWhichSumToN = ListsWhichSumToNFinder.getSublistsWhichSumToN(array, n);

        // then a list of sublists which sum to n is returned
        List<List<Integer>> expectedSublistsWhichSumToN = new ArrayList<>();
        List<List<Integer>> actualSublists = sublistsWhichSumToN;

        assertTrue(
                "Expected an empty sublist, but actual sublist was " + actualSublists + ".",
                haveSameContents(expectedSublistsWhichSumToN, actualSublists)
        );
    }

    @org.junit.Test
    public void GIVEN_anArrayWhichSumToN_WHEN_getSublistsWhichSumToNIsCalled_THEN_returnedListContainsOriginalArray() {
        // given an array of integers which sum to N
        int[] array = new int[] { 1, 2, 3, 4, 5};
        int n = 15;

        // when get sublists which sum to n is called
        List<List<Integer>> sublistsWhichSumToN = ListsWhichSumToNFinder.getSublistsWhichSumToN(array, n);

        // returned list contains original array
        List<List<Integer>> expectedSublistsWhichSumToN = new ArrayList<>(
                List.of(
                        List.of(1, 2, 3, 4, 5)
                )
        );
        List<List<Integer>> actualSublists = sublistsWhichSumToN;

        assertTrue(
                "Expected actual sublist to contain original sublist but actual sublist was " + actualSublists + ".",
                haveSameContents(expectedSublistsWhichSumToN, actualSublists)
        );
    }

    /**
     * Compares two lists of sublists for equality of contents ignoring ordering
     * @param firstList a list of sublists
     * @param secondList a list of sublists
     * @return true if both lists contain the same elements
     */
    public static <T> boolean haveSameContents(List<List<T>> firstList, List<List<T>> secondList)
    {
        if (firstList == null || secondList == null) return false;
        boolean sameSize = firstList.size() == secondList.size();
        boolean sameContents = true;
        for (List<T> sublist : firstList)
        {
            boolean inOtherList = false;
            int counter = 0;
            while(!inOtherList && counter < secondList.size())
            {
                List<T> otherSublist = secondList.get(counter);
                if (sublist.containsAll(otherSublist) && otherSublist.containsAll(sublist))
                {
                    inOtherList = true;
                }
                counter++;
            }
            if (!inOtherList)
            {
                sameContents = false;
                break;
            }
        }
        return sameSize && sameContents;
    }
}
