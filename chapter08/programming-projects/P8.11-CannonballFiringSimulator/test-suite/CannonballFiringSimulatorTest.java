import org.junit.Test;
import java.io.ByteArrayInputStream;

public class CannonballFiringSimulatorTest
{
   @Test public void runningASimulation()
   {
      String simulatedInput = "wrong format\n"
            + "yes\n" // run simulation
            + "45\n" // starting angle
            + "100.5\n" // initial cannonball velocity
            + "1.5\n" // time intervals to get position of cannonball at
            + "n\n";
      ByteArrayInputStream inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
      System.setIn(inputStream);
      UserInputGetter.initializeScanner();
      CannonballFiringSimulator.main(new String[0]);
   }
}
