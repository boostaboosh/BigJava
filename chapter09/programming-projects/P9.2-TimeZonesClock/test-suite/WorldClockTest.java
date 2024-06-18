import org.junit.Test;
import java.time.LocalTime;
import static org.junit.Assert.*;

public class WorldClockTest
{
   @Test
   public void testGetHours()
   {
      WorldClock clock = new WorldClock(3);
      String expected = ""
            + Math.floorMod((LocalTime.now().getHour() + 3), 24);
      assertEquals(expected, clock.getHours());
   }
}