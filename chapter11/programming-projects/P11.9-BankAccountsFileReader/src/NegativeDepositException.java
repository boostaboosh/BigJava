public class NegativeDepositException extends IllegalArgumentException
{
   public NegativeDepositException() {}

   public NegativeDepositException(String message)
   {
      super(message);
   }
}
