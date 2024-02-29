public class PrimeFactorisationFactorGenerator
{
   private int lastDivisionQuotient;

   public PrimeFactorisationFactorGenerator (int integerToFactorise)
   {
      this.lastDivisionQuotient = integerToFactorise;
   }

   public boolean hasNextFactor ()
   {
      boolean lastDivisionQuotientIsPrime = true;
      for (int integer = 2; integer <= this.lastDivisionQuotient; integer++)
      {
         if (this.lastDivisionQuotient % integer == 0)
         {
            lastDivisionQuotientIsPrime = false;
         }
      }

      if (lastDivisionQuotientIsPrime)
         return false;
      else
         return true;
   }

   public int nextFactor ()
   {
      int divisionDividend = this.lastDivisionQuotient;
      int primeDivisor = 2;
      int divisionRemainder = 0;
      int nextFactorInPrimeFactorisation = 0;
      do {
         divisionRemainder = divisionDividend % primeDivisor;
         if (divisionRemainder == 0) {
            nextFactorInPrimeFactorisation = primeDivisor;
            this.lastDivisionQuotient = divisionDividend / primeDivisor;
         } else if (divisionRemainder != 0) {
            int potentialPrimeNumber = primeDivisor;
            boolean numberIsPrime = false;
            while (!numberIsPrime)
            {
               potentialPrimeNumber = potentialPrimeNumber + 1;
               numberIsPrime = true;
               for (int numberIterator = 2;
                    numberIterator < potentialPrimeNumber; numberIterator++)
               {
                  if (potentialPrimeNumber % numberIterator == 0)
                  {
                     numberIsPrime = false;
                  }
               }
            }
            int primeNumber = potentialPrimeNumber;
            primeDivisor = primeNumber;
         }
      } while (divisionRemainder != 0);

      return nextFactorInPrimeFactorisation;
   }
}
