public class NegativeAmountWithdrawalException extends IllegalArgumentException
{
   public NegativeAmountWithdrawalException() {}

   public NegativeAmountWithdrawalException(String message)
   {
      super(message);
   }
}
