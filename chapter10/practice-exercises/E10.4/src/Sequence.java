public interface Sequence
{
   int next();

   static Sequence multiplesOf(int n)
   {
      class MultiplesOfN implements Sequence
      {
         private int multiplier = 0;

         public int next()
         {
            this.multiplier = this.multiplier + 1;
            return this.multiplier * n;
         }
      }

      return new MultiplesOfN();
   }

   static Sequence powersOf(int n)
   {
      class PowersOfN implements Sequence
      {
         private int number = n;

         public int next()
         {
            this.number = this.number + 1;
            return number * number;
         }
      }

      return new PowersOfN();
   }
}

