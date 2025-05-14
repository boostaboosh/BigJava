import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * A file reader which reads a maze layout from a text file.
 */
public class MazeFileReader
{
    private Maze maze;
    private boolean hasReadMaze;

    /**
     * Constructs a maze layout file reader.
     */
    public MazeFileReader()
    {
        hasReadMaze = false;
    }

    /**
     * Reads a maze layout from a file.
     */
    public void readMazeLayout(String mazeFileName) throws FileNotFoundException, MazeFileFormatException
    {
        MazeBuilder mazeBuilder = new MazeBuilder();
        File mazeFile = new File(mazeFileName);
        Scanner fileReader = new Scanner(mazeFile, "UTF-8");
        int rowCounter = 0;
        while(fileReader.hasNextLine())
        {
            String line = fileReader.nextLine();
            processMazeFileLine(rowCounter, line, mazeBuilder);
            rowCounter ++;
        }
        fileReader.close();
        this.maze = mazeBuilder.getMaze();
        this.hasReadMaze = true;
    }

    /**
     * Processes a line of maze layout file and adds it to this reader's maze.
     * @param lineIndex the index of this line starting from the top line with index zero
     * @param line the line to process
     * @param mazeBuilder the maze builder to add this maze row to
     * @throws MazeFileFormatException if the format of the line is incorrect,
     * i.e. isn't just asterisks and white spaces
     */
    private void processMazeFileLine(int lineIndex, String line, MazeBuilder mazeBuilder) throws MazeFileFormatException
    {
        mazeBuilder.startNewRow();
        for (int index = 0; index < line.length(); index++)
        {
            if (line.charAt(index) == '*')
            {
                mazeBuilder.addMazeNode(new WallNode(index, lineIndex));
            }
            else if (line.charAt(index) == ' ')
            {
                mazeBuilder.addMazeNode(new PathNode(index, lineIndex));
            }
            else
            {
                throw new MazeFileFormatException("Maze layout files can only contain asterisks or whitespaces, e.g. * **   *");
            }
        }
    }

    /**
     * Gets the last maze read by this maze file reader.
     * @return the last maze read by this maze file reader
     */
    public Maze getMaze()
    {
        if (hasReadMaze)
        {
            return this.maze;
        }
        else
        {
            throw new IllegalMazeReaderStateException("No successful maze read to return.");
        }
    }
}
