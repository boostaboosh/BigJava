import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
   An action listener that prints a message.
*/
public class ClickListener implements ActionListener
{
   private int clickCounter = 0;

   public void actionPerformed(ActionEvent event)
   {
      System.out.println("I was clicked " + clickCounter + " times.");
      clickCounter = clickCounter + 1;
   }            
}

