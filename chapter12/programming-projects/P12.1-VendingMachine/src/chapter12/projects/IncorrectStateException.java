package chapter12.projects;

public class IncorrectStateException extends RuntimeException
{
   public IncorrectStateException()
   {
      super();
   }

   public IncorrectStateException(String message)
   {
      super(message);
   }
}
