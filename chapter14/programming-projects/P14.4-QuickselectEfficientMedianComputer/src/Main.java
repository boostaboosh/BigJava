import java.util.*;

public class Main {
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.print("First array length: ");
        int firstLength = in.nextInt();
        System.out.print("Number of arrays: ");
        int numberOfArrays = in.nextInt();

        StopWatch timer = new StopWatch();

        ArrayList<int[]> randomIntArrays = generateArrays(numberOfArrays, firstLength);
        ArrayList<int[]> randomArraysCopy = getDeepCopy(randomIntArrays);

        ArrayList<String> sortThenMidResults = runSortThenMiddleDemo(timer, randomIntArrays);
        ArrayList<String> efficientMidResults = runEfficientMedianComputerDemo(timer, randomArraysCopy);

        System.out.println("-".repeat(16) + "SORT THEN MID" + "-".repeat(16) + "|" + "-".repeat(16) + "QUICKSELECT ALGO" + "_".repeat(14));
        for (int i = 0; i < numberOfArrays; i++)
        {
            System.out.print(sortThenMidResults.get(i) + "|" + efficientMidResults.get(i) + "\n");
        }
    }

    public static ArrayList<int[]> getDeepCopy(ArrayList<int[]> arrays)
    {
        ArrayList<int[]> clone = new ArrayList<>();
        for (int[] array : arrays)
        {
            clone.add(Arrays.copyOf(array, array.length));
        }
        return clone;
    }

    public static ArrayList<int[]> generateArrays(int numberOfArrays, int firstLength)
    {
        ArrayList<int[]> arrays = new ArrayList<>();

        for (int k = 1; k <= numberOfArrays; k++)
        {
            int n = k * firstLength;

            // Construct random array
            int[] a = ArrayUtil.randomIntArray(n, 100);

            arrays.add(a);
        }

        return arrays;
    }

    public static ArrayList<String> runSortThenMiddleDemo(StopWatch timer, ArrayList<int[]> randomArrays)
    {
        ArrayList<String> results = new ArrayList<>();
        for (int[] a : randomArrays)
        {
            // Use stopwatch to time quicksort and median finding
            timer.start();
            Arrays.sort(a);
            double median = getMedianOfSorted(a);
            timer.stop();

            results.add(String.format("Length:%8d Elapsed milliseconds:%8d", a.length, timer.getElapsedTime()));
            timer.reset();
        }
        return results;
    }

    public static ArrayList<String> runEfficientMedianComputerDemo(StopWatch timer, ArrayList<int[]> randomArrays)
    {
        ArrayList<String> results = new ArrayList<>();
        for (int[] a : randomArrays)
        {
            // Use stopwatch to time median algo
            timer.start();
            double median = MedianComputer.getMedian(a);
            timer.stop();

            results.add(String.format("Length:%8d Elapsed milliseconds:%8d", a.length, timer.getElapsedTime()));
            timer.reset();
        }
        return results;
    }

    public static double getMedianOfSorted(int[] a)
    {
        if (a.length % 2 == 0)
        {
            int first = a[(a.length / 2) - 1];
            int second = a[a.length / 2];
            return (first + second) / 2.0;
        }
        return a[a.length / 2];
    }
}