import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * A class which tests the 1913 US tax calculator class.
 */
public class NineteenThirteenTaxCalculatorTester
{
   public static void main(String[] args)
   {
      Logger.getGlobal().setLevel(Level.INFO);

      double annualIncomeTest = 175000;
      NineteenThirteenIncomeTaxCalculator taxCalculator = new NineteenThirteenIncomeTaxCalculator(annualIncomeTest);
      double incomeTax = taxCalculator.getIncomeTax();
      Logger.getGlobal().info("income tax on annual income of " + annualIncomeTest + ": " + incomeTax
            + "\nexpected: 4750");

      // tests for every branch of getTax method
      // bracket 1
      double bracketOneIncome = 30_000;
      NineteenThirteenIncomeTaxCalculator b1TaxCalculator = new NineteenThirteenIncomeTaxCalculator(bracketOneIncome);
      Logger.getGlobal().info("income tax on " + bracketOneIncome + ": " + b1TaxCalculator.getIncomeTax()
            + "\nexpected 300");
      // bracket 2
      double bracketTwoIncome = 60_000;
      NineteenThirteenIncomeTaxCalculator b2TaxCalculator = new NineteenThirteenIncomeTaxCalculator(bracketTwoIncome);
      Logger.getGlobal().info("income tax on " + bracketTwoIncome + ": " + b2TaxCalculator.getIncomeTax()
            + "\nexpected 700");
      // bracket 3
      // upper edge case
      double bracketThreeIncome = 100_000;
      NineteenThirteenIncomeTaxCalculator b3TaxCalculator = new NineteenThirteenIncomeTaxCalculator(bracketThreeIncome);
      Logger.getGlobal().info("income tax on " + bracketThreeIncome + ": " + b3TaxCalculator.getIncomeTax()
            + "\nexpected 1750");
      // bracket 4
      double bracketFourIncome = 200_000;
      NineteenThirteenIncomeTaxCalculator b4TaxCalculator = new NineteenThirteenIncomeTaxCalculator(bracketFourIncome);
      Logger.getGlobal().info("income tax on " + bracketFourIncome + ": " + b4TaxCalculator.getIncomeTax()
            + "\nexpected 5750");
      // bracket 5
      double bracketFiveIncome = 350_000;
      NineteenThirteenIncomeTaxCalculator b5TaxCalculator = new NineteenThirteenIncomeTaxCalculator(bracketFiveIncome);
      Logger.getGlobal().info("income tax on " + bracketFiveIncome + ": " + b5TaxCalculator.getIncomeTax()
            + "\n12750");
      // bracket 6
      double bracketSixIncome = 1_000_000;
      NineteenThirteenIncomeTaxCalculator b6TaxCalculator = new NineteenThirteenIncomeTaxCalculator(bracketSixIncome);
      Logger.getGlobal().info("income tax on " + bracketSixIncome + ": " + b6TaxCalculator.getIncomeTax()
            + "\nexpected 50250");

      // edge case tests
      // zero income
      double zeroIncome = 0;
      NineteenThirteenIncomeTaxCalculator zeroIncomeTaxCalculator = new NineteenThirteenIncomeTaxCalculator(zeroIncome);
      Logger.getGlobal().info("income tax on " + zeroIncome + ": " + zeroIncomeTaxCalculator.getIncomeTax()
            + "\nexpected 0");
      // 50k income
      // 49.99k income
      // 50.01k income
      // 75k income
      // 100k income
      // 250k income
      // 500k income
   }
}
