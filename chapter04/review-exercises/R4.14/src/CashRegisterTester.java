/**
   This class tests the CashRegister class.
*/
public class CashRegisterTester
{
   public static void main(String[] args)
   {
      CashRegister register = new CashRegister();

      register.recordPurchase(0.75);
      register.recordPurchase(1.50);
      register.receivePayment(2, 0, 5, 0, 0);
      System.out.print("Change: ");
      System.out.println(register.giveChange());
      System.out.println("Expected: 0.25");

      register.recordPurchase(2.25);
      register.recordPurchase(19.25);
      register.receivePayment(23, 2, 0, 0, 0);
      System.out.print("Change: ");
      System.out.println(register.giveChange());
      System.out.println("Expected: 2.0");

      register = new CashRegister();
      register.recordPurchase(19.93);
      register.receivePayment(20, 0, 0, 0, 0);
      System.out.print("Change: ");
      System.out.println(register.giveChange());
      // The code segment prints the total as 0.07000000000000028. Explain why.
      // Give a recommendation to improve the code so that users will not be confused.
      /*
      This code prints the total as 0.07000000000000028 instead of 0.07 because of the limited
      precision of floating point values.
      Double values have about 15 significant digits, and there are many numbers which cannot be
      accurately represented as double values. When a value cannot be represented exactly it is
      rounded to its nearest match.
      The problem arises because computers represent numbers in the binary number system.
      In the binary number system, there is no exact representation of the fraction 1/10,
      just as there is no exact representation of the fraction 1/3 = 0.33333 in the decimal number system.
      For this reason, the double type is not appropriate for financial calculations. In
      this book, we will continue to use double values for bank balances and other financial
      quantities so that we keep our programs as simple as possible. However, professional
      programs need to use the BigDecimal type for this purpose.
      Unlike the number types such as int or double, big number objects have essentially no limits on their
      size and precision. However, computations with big number objects are much slower than
      those that involve number types. Perhaps more importantly, you can’t use the familiar arithmetic
      operators such as (+ - *) with them.
      Instead, you have to use methods called add, subtract, and multiply.
      The BigDecimal type carries out floating-point computations without round-off errors so this class
      could be used to improve the code of the CashRegister class so that users will not be confused.
      Alternatively this code could be improved by rounding the result of the payment - purchase operation
      in the giveChange method so that the change value only has two significant decimal digits.
       */
   }
}

