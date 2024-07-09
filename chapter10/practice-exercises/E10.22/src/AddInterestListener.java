import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class AddInterestListener implements ActionListener
{
   private static final double INTEREST_RATE = 10;

   private BankAccount account;
   private JLabel label;

   public AddInterestListener(BankAccount anAccount, JLabel aLabel)
   {
      this.account = anAccount;
      this.label = aLabel;
   }

   public void actionPerformed(ActionEvent event)
   {
      double interest = account.getBalance() * INTEREST_RATE / 100;
      account.deposit(interest);
      label.setText("balance: " + account.getBalance());
   }
}
