import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
   This program displays the growth of an investment. 
*/
public class InvestmentViewer2
{  
   private static final int FRAME_WIDTH = 400;
   private static final int FRAME_HEIGHT = 100;

   private static final double INITIAL_BALANCE = 1000;

   public static void main(String[] args)
   {  
      JFrame frame = new JFrame();

      // The button to trigger the calculation
      JButton button = new JButton("Add Interest");

      // The application adds interest to this bank account
      BankAccount account = new BankAccount(INITIAL_BALANCE);

      // The label for displaying the results
      JLabel label = new JLabel("balance: " + account.getBalance());

      // The panel that holds the user interface components
      JPanel panel = new JPanel();
      panel.add(button);
      panel.add(label);      
      frame.add(panel);

      ActionListener listener = new AddInterestListener(account, label);
      button.addActionListener(listener);

      frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setVisible(true);
   }
}

