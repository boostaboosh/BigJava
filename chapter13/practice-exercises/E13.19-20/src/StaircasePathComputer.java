import java.util.ArrayList;
import java.util.List;

public class StaircasePathComputer {

    /**
     * Enumerate all paths for walking n number of steps taking k steps at a time.
     *
     * @param numberOfSteps the number of steps
     * @param maxStepSize   maximum number of steps to be taken in one go
     * @return all paths for walking n number of steps
     */
    public static List<List<Integer>> enumeratePaths(int numberOfSteps, int maxStepSize)
    {
        return enumeratePaths(numberOfSteps, maxStepSize, 0);
    }

    /**
     * Enumerate all paths for walking n number of steps taking maxStepSize steps at a time.
     *
     * @param numberOfSteps the number of steps
     * @param maxStepSize maximum number of steps to be taken in one go
     * @param currentStep the current step
     * @return the possible paths
     */
    private static List<List<Integer>> enumeratePaths(int numberOfSteps, int maxStepSize, int currentStep)
    {
        if (numberOfSteps <= 0)
        {
            return List.of(List.of());
        }

        if (currentStep >= numberOfSteps)
        {
            return List.of(List.of());
        }

        List<List<Integer>> paths = new ArrayList<>();

        for (int stepSize = 1; stepSize <= maxStepSize; stepSize++)
        {
            int nextStep = currentStep + stepSize;
            if (nextStep > numberOfSteps)
            {
                break;
            }
            List<List<Integer>> nextPaths = enumeratePaths(numberOfSteps, maxStepSize, nextStep);

            for (List<Integer> nextPath : nextPaths)
            {
                List<Integer> wholePath = new ArrayList<>();
                wholePath.add(nextStep);
                wholePath.addAll(nextPath);
                paths.add(wholePath);
            }
        }

        return paths;
    }
}
