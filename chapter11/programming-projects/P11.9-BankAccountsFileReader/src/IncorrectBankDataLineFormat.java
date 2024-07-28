public class IncorrectBankDataLineFormat extends IllegalArgumentException
{
   public IncorrectBankDataLineFormat() {}

   public IncorrectBankDataLineFormat(String message)
   {
      super(message);
   }
}
