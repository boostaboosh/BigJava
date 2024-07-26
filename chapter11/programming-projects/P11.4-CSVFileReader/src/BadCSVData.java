import java.io.IOException;

public class BadCSVData extends IOException
{
   public BadCSVData() {}

   public BadCSVData(String message)
   {
      super(message);
   }
}
