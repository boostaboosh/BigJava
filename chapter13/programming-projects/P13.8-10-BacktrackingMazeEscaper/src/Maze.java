import java.util.ArrayList;

/**
 * Represents a 2-Dimensional maze.
 */
public class Maze
{
    private final ArrayList<ArrayList<MazeNode>> mazeGrid;

    /**
     * Constructs a maze from a given
     * @param mazeGrid the maze to construct the maze from
     */
    public Maze (ArrayList<ArrayList<MazeNode>> mazeGrid)
    {
        this.mazeGrid = mazeGrid;
    }

    /**
     * Gets all entry or exit path nodes of this maze
     * @return the access nodes of this maze
     */
    public ArrayList<PathNode> getAccessNodes()
    {
        ArrayList<MazeNode> borders = getBorderNodes();

        ArrayList<PathNode> accessNodes = new ArrayList<>();
        for (MazeNode node : borders)
        {
            if (node instanceof PathNode)
            {
                accessNodes.add((PathNode) node);
            }
        }
        return accessNodes;
    }

    /**
     * Gets the outer border nodes of this maze's grid.
     * @return the outer border nodes of this maze's grid
     */
    private ArrayList<MazeNode> getBorderNodes()
    {
        ArrayList<MazeNode> borders = new ArrayList<>();
        for (ArrayList<MazeNode> row : this.mazeGrid)
        {
            for (MazeNode node : row)
            {
                if (node.getXCoordinate() == 0
                        || node.getXCoordinate() == row.size() - 1
                        || node.getYCoordinate() == 0
                        || node.getYCoordinate() == this.mazeGrid.size() - 1
                ) {
                    borders.add(node);
                }
            }
        }
        return borders;
    }

    /**
     * Checks if a node is an access node,
     * i.e. an entry or exit path node from this maze.
     * @param pathNode the node to check
     * @return true if a node is an access node
     */
    public boolean isAccessNode(PathNode pathNode)
    {
        boolean isAccessNode = false;
        for (PathNode accessNode : getAccessNodes())
        {
            if (accessNode.equals(pathNode)) {
                isAccessNode = true;
                break;
            }
        }
        return isAccessNode;
    }

    /**
     * Gets all neighbouring path nodes of the provided path node.
     * @param node the path node to get the neighbouring path nodes of
     * @return all neighbouring path nodes of the provided path node
     */
    public ArrayList<PathNode> getNeighbouringPathNodes(PathNode node)
    {
        ArrayList<PathNode> neighbouringPathNodes = new ArrayList<>();
        for (int rowIndex = node.getYCoordinate() - 1; rowIndex <= node.getYCoordinate() + 1; rowIndex++)
        {
            if (isValidYCoordinate(rowIndex))
            {
                for (int columnIndex = node.getXCoordinate() - 1; columnIndex <= node.getXCoordinate() + 1; columnIndex++)
                {
                    if (isValidXCoordinate(columnIndex, rowIndex))
                    {
                        MazeNode neighbour = this.mazeGrid.get(rowIndex).get(columnIndex);
                        if (neighbour instanceof PathNode && !neighbour.equals(node))
                        {
                            neighbouringPathNodes.add((PathNode) neighbour);
                        }
                    }
                }
            }
        }
        return neighbouringPathNodes;
    }

    /**
     * Checks if a y coordinate is valid
     * @param y the y coordinate
     * @return true if valid
     */
    private boolean isValidYCoordinate(int y)
    {
        if (this.mazeGrid.isEmpty())
        {
            return false;
        }
        else
        {
            return y >= 0 && y <= this.mazeGrid.size() - 1;
        }
    }

    /**
     * Checks if an x coordinate is valid in a given row
     * @param x the x coordinate
     * @param y the y coordinate of the row to check the validity of the x coordinate for
     * @return true if valid
     */
    private boolean isValidXCoordinate(int x, int y)
    {
        if (isValidYCoordinate(y))
        {
            return x >= 0 && x <= this.mazeGrid.get(x).size() - 1;
        }
        return false;
    }

    /**
     * Gets this maze's maze grid.
     * @return this maze's maze grid
     */
    public ArrayList<ArrayList<MazeNode>> getMazeGrid()
    {
        return this.mazeGrid;
    }
}
