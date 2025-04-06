import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

class StaircasePathComputerTest {

    @Test
    @DisplayName("correct paths are returned for n = 5")
    void GIVEN_thatNEquals5_WHEN_pathsAreEnumerated_THEN_allPathsAreReturned()
    {
        int n = 5;
        int k = 2;
        List<List<Integer>> actualPaths = StaircasePathComputer.enumeratePaths(n, k);
        List<List<Integer>> expectedPaths = List.of(
                List.of(1,2,3,4,5),
                List.of(2,3,4,5),
                List.of(1,3,4,5),
                List.of(1,2,4,5),
                List.of(1,2,3,5),
                List.of(1,3,5),
                List.of(2,3,5),
                List.of(2,4,5)
        );
        assertTrue(haveSameContents(expectedPaths, actualPaths), "lists have different contents for n = 5\nexpected: " + expectedPaths + "\nactual: " + actualPaths);
    }

    @ParameterizedTest(name = "n = {0}")
    @ValueSource( ints = { 0 } )
    void GIVEN_invalidInputs_WHEN_pathsAreEnumerated_THEN_expectedPathsAreReturned(int n)
    {
        int k = 2;
        List<List<Integer>> actualPaths = StaircasePathComputer.enumeratePaths(n, k);
        List<List<Integer>> expectedPaths = List.of(List.of());
        assertTrue(haveSameContents(expectedPaths, actualPaths), "expected an empty list, actual was: " + actualPaths);
    }

    /**
     * Check if 2 lists contain the same elements regardless of ordering
     * @param firstList a list
     * @param secondList a list
     * @return true if the contents are the same
     */
    static <T> boolean haveSameContents(List<T> firstList, List<T> secondList)
    {
        boolean haveSameContents = false;
        if (
                containedInUniquely(firstList, secondList)
                && containedInUniquely(secondList, firstList)
                && firstList.size() == secondList.size()
        )
        {
            haveSameContents = true;
        }
        return haveSameContents;
    }

    /**
     * Check if all elements of first list are contained in second list as unique, i.e. separate, elements.
     * @param firstList a list
     * @param secondList another list
     * @return true if all elements of first list are contained in second list as unique elements,
     * e.g. [1,1] and [1] returns false, but [1,1] and [1,1] returns true.
     */
    static <T> boolean containedInUniquely(List<T> firstList, List<T> secondList)
    {
        List<T> unmatchedItemsInSecondList = new ArrayList<>(secondList);
        for (T element : firstList) {
            boolean inSecondList = false;
            for (int index = 0; index < unmatchedItemsInSecondList.size(); index++) {
                T secondElement = unmatchedItemsInSecondList.get(index);
                if (element instanceof List && secondElement instanceof List) {
                    List list1 = (List) element;
                    List list2 = (List) secondElement;
                    if (haveSameContents(list1, list2)) {
                        inSecondList = true;
                    }
                } else {
                    if (element.equals(secondElement)) {
                        inSecondList = true;
                    }
                }
                if (inSecondList) {
                    unmatchedItemsInSecondList.remove(secondElement);
                    break;
                }
            }
            if (!inSecondList) {
                return false;
            }
        }
        return true;
    }
}
