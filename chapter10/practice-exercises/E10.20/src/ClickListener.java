import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

/**
   An action listener that prints a message.
*/
public class ClickListener implements ActionListener
{
   public void actionPerformed(ActionEvent event)
   {
      // Step 1: Get the timestamp from the event
      long timestamp = event.getWhen();
      // Step 2: Convert the timestamp to an Instant
      Instant instant = Instant.ofEpochMilli(timestamp);
      // Step 3: Convert the Instant to a ZonedDateTime in the system default time zone
      ZonedDateTime zonedDateTime = instant.atZone(ZoneId.systemDefault());
      // Step 4: Format the ZonedDateTime for display
      DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
      String formattedTime = zonedDateTime.format(formatter);

      System.out.println("I was clicked at " + formattedTime + ".");
   }            
}

