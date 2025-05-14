import java.util.ArrayList;

/**
 * Represents a path inside a maze.
 */
public class MazeEscapePathPartialSolution implements PartialSolution, Comparable<MazeEscapePathPartialSolution>
{
    private final Path path;
    private final Maze maze;

    /**
     * Constructs a maze escape path partial solution with a given escape path and maze.
     * @param escapePath the escape path so far
     * @param maze the maze the path escapes from
     */
    public MazeEscapePathPartialSolution(Path escapePath, Maze maze)
    {
        this.path = escapePath;
        this.maze = maze;
    }

    public Result examine()
    {
        /*
        if the first and last node are maze access points and different nodes accept this solution,
        if the last node already exists in the path abandon this solution
        otherwise continue extending this solution
         */
        if (this.path.containsDuplicateNodes())
        {
            return Result.ABANDON;
        }
        else
        {
            if (this.path.isEmpty()) // partial solution is empty, so this is the first run, and it needs to be extended
            {
                return Result.CONTINUE;
            }

            PathNode firstNode = this.path.getFirstNode();
            PathNode lastNode = this.path.getLastNode();
            if (!firstNode.equals(lastNode)
                    && this.maze.isAccessNode(firstNode)
                    && this.maze.isAccessNode(lastNode))
            {
                return Result.ACCEPT;
            }
            else
            {
                return Result.CONTINUE;
            }
        }
    }

    public ArrayList<PartialSolution> extend()
    {
        ArrayList<PartialSolution> extendedSolutions = new ArrayList<>();
        if (this.path.isEmpty())
        {
            /*
            make a partial solution for each maze access point
             */
            for (PathNode accessNode : this.maze.getAccessNodes())
            {
                Path pathWithAccess = new Path();
                pathWithAccess.addPathNode(accessNode);
                extendedSolutions.add(new MazeEscapePathPartialSolution(pathWithAccess, this.maze));
            }
        }
        else
        {
            /*
            extend this maze path by adding each neighbouring node to the last node to the end of a new partial solution
             */
            PathNode lastNode = this.path.getLastNode();
            for (PathNode neighbourPathNode : this.maze.getNeighbouringPathNodes(lastNode))
            {
                Path pathWithNeighbour = new Path(this.path);
                pathWithNeighbour.addPathNode(neighbourPathNode);
                extendedSolutions.add(new MazeEscapePathPartialSolution(pathWithNeighbour, this.maze));
            }
        }
        return extendedSolutions;
    }

    public int compareTo(MazeEscapePathPartialSolution otherSolution)
    {
        return this.path.compareTo(otherSolution.path);
    }

    /**
     * Gets this partial solution's escape path.
     * @return this partial solution's escape path
     */
    public Path getPath()
    {
        return this.path;
    }
}
