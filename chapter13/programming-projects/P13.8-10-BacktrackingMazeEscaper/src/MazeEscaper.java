import java.util.ArrayList;
import java.util.Arrays;

/**
 * A maze escaper finds an escape from a maze defined in a maze file.
 */
public class MazeEscaper
{
    Maze maze;
    ArrayList<MazeEscapePathPartialSolution> solutions;
    boolean hasSearchedEscapes;

    /**
     * Constructs a maze escaper.
     * @param maze the maze this escaper finds escapes from
     */
    public MazeEscaper(Maze maze)
    {
        this.maze = maze;
        this.solutions = new ArrayList<>();
        this.hasSearchedEscapes = false;
    }

    /**
     * Finds escapes from this maze escapers maze.
     */
    public void findEscapes()
    {
        MazeEscapePathPartialSolution emptyMazePathSolution = new MazeEscapePathPartialSolution(new Path(), this.maze);
        ArrayList<PartialSolution> solutions = Backtracker.solve(emptyMazePathSolution);
        for (PartialSolution partialSolution : solutions)
        {
            this.solutions.add((MazeEscapePathPartialSolution) partialSolution);
        }
        this.hasSearchedEscapes = true;
    }

    /**
     * Gets the shortest path to escape this maze escaper's maze.
     * @return the shortest escape path from this maze, or an empty path if no escapes were found
     */
    public Path getShortestEscapePath()
    {
        if (this.hasSearchedEscapes)
        {
            MazeEscapePathPartialSolution shortest = getShortest(this.solutions);
            if (shortest == null)
            {
                return new Path();
            }
            else
            {
                return shortest.getPath();
            }
        }
        else
        {
            throw new IllegalStateException("Must find escapes before retrieving shortest one.");
        }
    }

    /**
     * Gets the shortest solution from a collection of solutions.
     * @param solutions the solutions
     * @return the shortest solution from a collection of solutions, or null if the solutions collection is empty
     */
    private static MazeEscapePathPartialSolution getShortest(ArrayList<MazeEscapePathPartialSolution> solutions)
    {
        if (solutions.isEmpty())
        {
            return null;
        }
        MazeEscapePathPartialSolution smallest = solutions.get(0);
        for (MazeEscapePathPartialSolution sol : solutions)
        {
            if (sol.compareTo(smallest) < 0)
            {
                smallest = sol;
            }
        }
        return smallest;
    }
}
