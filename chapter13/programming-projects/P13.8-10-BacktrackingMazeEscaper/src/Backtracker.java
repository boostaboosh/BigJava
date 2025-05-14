import java.util.ArrayList;

public class Backtracker
{
    /**
     * Finds full solutions to a problem by extending a partial solution
     * towards a full solution, backtracking and extending differently
     * when a partial solution is no longer viable.
     * @param partialSolution a partial solution to extend
     * @return the solutions to the problem
     */
    public static ArrayList<PartialSolution> solve(PartialSolution partialSolution)
    {
        ArrayList<PartialSolution> solutions = new ArrayList<>();

        Result examinationResult = partialSolution.examine();
        if (examinationResult == Result.ACCEPT)
        {
            solutions.add(partialSolution);
        }
        else if (examinationResult == Result.CONTINUE)
        {
            ArrayList<PartialSolution> extendedSolutions = partialSolution.extend();
            for (PartialSolution extendedSolution : extendedSolutions)
            {
                solutions.addAll(solve(extendedSolution));
            }
        }

        return solutions;
    }
}
