import org.junit.Test;
import java.time.LocalTime;
import static org.junit.Assert.*;

public class ClockTest
{
   @Test public void testGetHours()
   {
      Clock clock = new Clock();
      String expected = "" + LocalTime.now().getHour();
      assertEquals(expected, clock.getHours());
   }

   @Test public void testGetMinutes()
   {
      Clock clock = new Clock();
      String expected = "" + LocalTime.now().getMinute();
      assertEquals(expected, clock.getMinutes());
   }

   @Test public void testGetTime()
   {
      Clock clock = new Clock();
      String expected = LocalTime.now().toString().substring(0, 5);
      assertEquals(expected, clock.getTime());
   }
}