import java.io.IOException;

public class InvalidArgumentsException extends IOException
{
   public InvalidArgumentsException()
   {
      super();
   }

   public InvalidArgumentsException(String message)
   {
      super(message);
   }
}
