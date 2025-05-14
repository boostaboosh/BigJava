import java.util.ArrayList;

/**
 * Utility class for printing maze paths.
 */
public class MazePathPrinter
{
    private static final char WALL_NODE_SYMBOL = '*';
    private static final char PATH_NODE_SYMBOL = ' ';
    private static final char WALKED_PATH_NODE_SYMBOL = 'O';

    /**
     * Prints a maze path.
     * @param path the maze path to print
     */
    public static void printPathInMaze(Path path, Maze maze)
    {
        for (ArrayList<MazeNode> row : maze.getMazeGrid())
        {
            printPathInMazeRow(path, row);
            System.out.println();
        }
    }

    /**
     * Prints a maze row
     * @param row a maze row
     */
    private static void printPathInMazeRow(Path path, ArrayList<MazeNode> row)
    {
        for (MazeNode node : row)
        {
            if (path.contains(node))
            {
                System.out.print(WALKED_PATH_NODE_SYMBOL);
            }
            else
            {
                printMazeNode(node);
            }
        }
    }

    /**
     * Prints a maze node.
     * @param node the node to print
     */
    private static void printMazeNode(MazeNode node)
    {
        System.out.print(getPrintSymbol(node));
    }

    /**
     * Gets a maze nodes print symbol.
     * @param node the node to get the print symbol of
     * @return the node's print symbol
     */
    private static char getPrintSymbol(MazeNode node)
    {
        char symbol;
        if (node instanceof WallNode)
        {
            symbol = WALL_NODE_SYMBOL;
        }
        else if (node instanceof PathNode)
        {
            symbol = PATH_NODE_SYMBOL;
        }
        else
        {
            throw new IllegalArgumentException("Maze node of type " + node.getClass() + " has no print symbol.");
        }
        return symbol;
    }
}
