import java.io.IOException;

public class IncorrectBankDataFileFormat extends IOException
{
   public IncorrectBankDataFileFormat() {}

   public IncorrectBankDataFileFormat(String message)
   {
      super(message);
   }
}
