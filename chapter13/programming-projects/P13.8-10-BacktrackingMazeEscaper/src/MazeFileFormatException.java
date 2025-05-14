import java.io.IOException;

public class MazeFileFormatException extends IOException
{
    public MazeFileFormatException() {
        super();
    }

    public MazeFileFormatException(String message)
    {
        super(message);
    }
}
