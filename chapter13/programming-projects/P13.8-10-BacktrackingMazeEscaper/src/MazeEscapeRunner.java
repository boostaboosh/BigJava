import java.io.FileNotFoundException;

/**
 * Runs a maze escaper on a maze provided in a maze layout text file.
 */
public class MazeEscapeRunner
{
    public static void main(String[] args) throws IllegalArgumentException
    {
        if (args.length != 1)
        {
            throw new IllegalArgumentException("expected 1 command line arg: the maze file name");
        }
        String mazeFileName = args[0];

        MazeFileReader mazeReader = new MazeFileReader();
        try
        {
            mazeReader.readMazeLayout(mazeFileName);
        } catch (FileNotFoundException e) {
            System.out.println("Could not find a file named: " + mazeFileName);
            return;
        } catch (MazeFileFormatException e) {
            System.out.println("Maze layout file " + mazeFileName + " has an incorrect format");
            return;
        }

        Maze maze = mazeReader.getMaze();
        MazeEscaper escaper = new MazeEscaper(maze);
        escaper.findEscapes();
        Path escape = escaper.getShortestEscapePath();
        MazePathPrinter.printPathInMaze(escape, maze);
    }
}
