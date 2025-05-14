/**
 * Represents a space in a maze.
 */
public abstract class MazeNode
{
    private final int xCoordinate;
    private final int yCoordinate;

    /**
     * Represents a node of space in a maze.
     * @param xCoordinate the x coordinate of the node relative to the left most column having index zero
     * @param yCoordinate the y coordinate of the node relative to the top most row having index zero
     */
    public MazeNode(int xCoordinate, int yCoordinate)
    {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
    }

    public int getXCoordinate() {
        return xCoordinate;
    }

    public int getYCoordinate() {
        return yCoordinate;
    }

    public boolean equals(Object other)
    {
        if (other == null || other.getClass() != this.getClass())
        {
            return false;
        }
        else
        {
            MazeNode otherNode = (MazeNode) other;
            return this.xCoordinate == otherNode.xCoordinate
                    && this.yCoordinate == otherNode.yCoordinate;
        }
    }
}
