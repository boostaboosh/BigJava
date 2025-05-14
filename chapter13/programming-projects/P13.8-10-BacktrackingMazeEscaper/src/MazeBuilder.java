import java.util.ArrayList;

/**
 * Represents a maze being built as a 2-Dimensional table of maze nodes.
 */
public class MazeBuilder
{
    ArrayList<ArrayList<MazeNode>> mazeGrid;

    /**
     * Constructs a maze builder.
     */
    public MazeBuilder() {
        this.mazeGrid = new ArrayList<>();
    }

    /**
     * Adds a maze node to the right of the last node in this maze builder.
     * If no nodes have been added to this maze builder the node will be
     * added to the top left of the maze.
     */
    public void addMazeNode(MazeNode node)
    {
        if (this.mazeGrid.isEmpty())
        {
            this.mazeGrid.add(new ArrayList<MazeNode>());
        }
        ArrayList<MazeNode> lastRow = mazeGrid.get(mazeGrid.size() - 1);
        lastRow.add(node);
    }

    /**
     * Starts a new row in this maze.
     * The row will be started to the bottom left of the bottom most row in this maze.
     */
    public void startNewRow()
    {
        mazeGrid.add(new ArrayList<MazeNode>());
    }

    /**
     * Gets the maze built by this maze builder.
     * @return the maze built by this maze builder
     */
    public Maze getMaze()
    {
        return new Maze(mazeGrid);
    }
}
