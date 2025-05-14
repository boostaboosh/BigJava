import java.util.ArrayList;

/**
 * Describes a partial solution to a problem which can be extended towards a full solution.
 */
public interface PartialSolution
{
    /**
     * Examines this partial solution.
     * @return the result of examining this partial solution.
     * The result is to continue to extend the partial solution if it is valid so far but incomplete,
     * abandon the partial solution if it is invalid and backtrack,
     * accept the partial solution if it is valid and complete.
     */
    Result examine();

    /**
     * Extends this partial solution.
     * @return the extensions of this partial solution
     */
    ArrayList<PartialSolution> extend();
}
