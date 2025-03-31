import java.util.ArrayList;
import java.util.List;

public class ListsWhichSumToNFinder {
    /**
     * Generates all lists of integers of an array whose sum is equal to an integer n recursively.
     * @param a array to find subslists of which sum up to n
     * @param n the number we want the returned lists to sum up to
     * @return a list of lists which sum up to n and are subsists of a. this can include the input array a.
     */
    public static List<List<Integer>> getSublistsWhichSumToN(int[] a, int n)
    {
        List<List<Integer>> allSublists = getAllSubsets(a);
        List<List<Integer>> sublistsWhichSumToN = new ArrayList<>();
        for (List<Integer> sublist : allSublists)
        {
            if (sumOf(sublist) == n) sublistsWhichSumToN.add(sublist);
        }
        return sublistsWhichSumToN;
    }

    /**
     * Gets all subsets of an array recursively.
     * @param a an array of ints
     * @return all sublists of a or null if a is null
     */
    private static List<List<Integer>> getAllSubsets(int[] a)
    {
        List<List<Integer>> allSubsets = new ArrayList<>();
        if (a == null) return null;
        if (a.length == 0)
        {
            ArrayList<Integer> empty = new ArrayList<>();
            allSubsets.add(empty);
        }
        else {
            int[] shorter = new int[a.length - 1];
            for (int i = 0; i < a.length - 1; i++) {
                shorter[i] = a[i];
            }

            int removed = a[a.length - 1];

            List<List<Integer>> allSubsetsOfShorter = getAllSubsets(shorter);

            for (List<Integer> subset : allSubsetsOfShorter)
            {
                allSubsets.add(subset);
                List<Integer> newSubset = new ArrayList<>(subset);
                newSubset.add(removed);
                allSubsets.add(newSubset);
            }
        }
        return allSubsets;
    }

    /**
     * Returns the sum of numbers in a list.
     * @param listOfNumbers a list of integers
     * @return the int sum of ints in the list or -1 if null or empty list provided
     */
    private static int sumOf(List<Integer> listOfNumbers)
    {
        if (listOfNumbers == null || listOfNumbers.isEmpty()) return -1;
        else {
            int total = 0;
            for (int num : listOfNumbers) total += num;
            return total;
        }
    }
}
