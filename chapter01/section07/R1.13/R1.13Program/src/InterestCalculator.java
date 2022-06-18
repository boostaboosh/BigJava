public class InterestCalculator
{
    public static void main (String[] args) {
        int startingBalance = 10000;
        double monthlyInterestRate = 0.05;
        int monthlyExpenses = 500;
        float balance = startingBalance;
        int month = 0;

        while (balance > 0) {
            month += 1;
            balance -= monthlyExpenses;
            double monthlyInterest = monthlyInterestRate * balance;
            balance += monthlyInterest;
            System.out.println("After "+month+" months the balance is "+balance);
        }
        System.out.println("Number of months that have passed before balance reached zero: " + month + " balance " + balance);
    }
}
