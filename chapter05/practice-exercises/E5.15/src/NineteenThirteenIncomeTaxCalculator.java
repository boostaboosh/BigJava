/**
 * A 1913 tax calculator computes United States income tax for a given income according to the original 1913 tax rates.
 */
public class NineteenThirteenIncomeTaxCalculator
{
   private double annualIncome;

   /**
    * Constructs a 1913 income tax calculator for a given annual income.
    * @param annualIncome the annual income to calculate the income tax on
    */
   public NineteenThirteenIncomeTaxCalculator(double annualIncome)
   {
      this.annualIncome = annualIncome;
   }

   /**
    * Computes the income tax due
    * @return the income tax to pe paid
    */
   public double getIncomeTax()
   {
      final double BRACKET_ONE_LOWER_LIMIT = 0;
      final double BRACKET_ONE_UPPER_AND_TWO_LOWER_LIMIT = 50_000;
      final double BRACKET_TWO_UPPER_AND_THREE_LOWER_LIMIT = 75_000;
      final double BRACKET_THREE_UPPER_AND_FOUR_LOWER_LIMIT = 100_000;
      final double BRACKET_FOUR_UPPER_AND_FIVE_LOWER_LIMIT = 250_000;
      final double BRACKET_FIVE_UPPER_AND_SIX_LOWER_LIMIT = 500_000;

      final double BRACKET_ONE_TAX_RATE = 0.01;
      final double BRACKET_TWO_TAX_RATE = 0.02;
      final double BRACKET_THREE_TAX_RATE = 0.03;
      final double BRACKET_FOUR_TAX_RATE = 0.04;
      final double BRACKET_FIVE_TAX_RATE = 0.05;
      final double BRACKET_SIX_TAX_RATE = 0.06;

      double annualIncome = this.annualIncome;
      double tax = 0;

      if (annualIncome > BRACKET_ONE_LOWER_LIMIT) // bracket 1
      {
         double bracketOneIncome = Math.min(BRACKET_ONE_UPPER_AND_TWO_LOWER_LIMIT, annualIncome);
         tax = tax + bracketOneIncome * BRACKET_ONE_TAX_RATE;
      }
      if (annualIncome > BRACKET_ONE_UPPER_AND_TWO_LOWER_LIMIT) // bracket 2
      {
         double bracketTwoIncome = Math.min(BRACKET_TWO_UPPER_AND_THREE_LOWER_LIMIT, annualIncome)
               - BRACKET_ONE_UPPER_AND_TWO_LOWER_LIMIT;
         tax = tax + bracketTwoIncome * BRACKET_TWO_TAX_RATE;
      }
      if (annualIncome > BRACKET_TWO_UPPER_AND_THREE_LOWER_LIMIT) // bracket 3
      {
         double bracketThreeIncome = Math.min(BRACKET_THREE_UPPER_AND_FOUR_LOWER_LIMIT, annualIncome)
               - BRACKET_TWO_UPPER_AND_THREE_LOWER_LIMIT;
         tax = tax + bracketThreeIncome * BRACKET_THREE_TAX_RATE;
      }
      if (annualIncome > BRACKET_THREE_UPPER_AND_FOUR_LOWER_LIMIT) // bracket 4
      {
         double bracketFourIncome = Math.min(BRACKET_FOUR_UPPER_AND_FIVE_LOWER_LIMIT, annualIncome)
               - BRACKET_THREE_UPPER_AND_FOUR_LOWER_LIMIT;
         tax = tax + bracketFourIncome * BRACKET_FOUR_TAX_RATE;
      }
      if (annualIncome > BRACKET_FOUR_UPPER_AND_FIVE_LOWER_LIMIT) // bracket 5
      {
         double bracketFiveIncome = Math.min(BRACKET_FIVE_UPPER_AND_SIX_LOWER_LIMIT, annualIncome)
               - BRACKET_FOUR_UPPER_AND_FIVE_LOWER_LIMIT;
         tax = tax + bracketFiveIncome * BRACKET_FIVE_TAX_RATE;
      }
      if (annualIncome > BRACKET_FIVE_UPPER_AND_SIX_LOWER_LIMIT) // bracket 6
      {
         double bracketSixIncome = annualIncome - BRACKET_FIVE_UPPER_AND_SIX_LOWER_LIMIT;
         tax = tax + bracketSixIncome * BRACKET_SIX_TAX_RATE;
      }

      return tax;
   }
}