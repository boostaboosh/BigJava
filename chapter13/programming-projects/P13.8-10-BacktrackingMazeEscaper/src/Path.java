import java.util.ArrayList;

/**
 * Represents a path in a maze.
 */
public class Path implements Comparable<Path>
{
    private final ArrayList<PathNode> path;

    /**
     * Constructs a maze path.
     */
    public Path()
    {
        this.path = new ArrayList<>();
    }

    /**
     * Constructs a maze path with the same path as the provided maze path.
     * @param path the maze path to copy the path of
     */
    public Path(Path path)
    {
        this.path = new ArrayList<>(path.path);
    }

    /**
     * Checks if a maze node is contained in this path node.
     * @param node the node to check the containment of in this path
     * @return true if the node is contained in this path
     */
    public boolean contains(MazeNode node)
    {
        for (PathNode pathNode : this.path)
        {
            if (pathNode.equals(node))
            {
                return true;
            }
        }
        return false;
    }

    /**
     * Adds a path node to this maze path.
     * @param node the node to add
     */
    public void addPathNode(PathNode node)
    {
        this.path.add(node);
    }

    /**
     * Checks if this path is empty.
     * @return true if this path is empty
     */
    public boolean isEmpty()
    {
        return this.path.isEmpty();
    }

    /**
     * Checks if this maze path contains duplicate nodes.
     * @return true if this maze path contains duplicate nodes
     */
    public boolean containsDuplicateNodes()
    {
        for (int index = 0; index < path.size(); index++)
        {
            PathNode firstNode = this.path.get(index);
            for (int secondIndex = 0; secondIndex < path.size(); secondIndex++)
            {
                if (index != secondIndex)
                {
                    PathNode secondNode = this.path.get(secondIndex);
                    if (firstNode.equals(secondNode))
                    {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * Gets the last node in this path.
     * @return the last node in this path, or null if this path has no nodes
     */
    public PathNode getLastNode()
    {
        if (this.path.isEmpty())
        {
            return null;
        }
        else
        {
            return this.path.get(this.path.size() - 1);
        }
    }

    /**
     * Gets the first node in this path.
     * @return the first node in this path, or null if this path has no nodes
     */
    public PathNode getFirstNode()
    {
        if (this.path.isEmpty())
        {
            return null;
        }
        else
        {
            return this.path.get(0);
        }
    }

    public int compareTo(Path otherPath)
    {
        return this.path.size() - otherPath.path.size();
    }
}
