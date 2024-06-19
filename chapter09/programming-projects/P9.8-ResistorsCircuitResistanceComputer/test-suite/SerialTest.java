import static org.junit.Assert.*;
import org.junit.Test;

public class SerialTest
{
   final double EPSILON = 1E-14;

   @Test public void testGetResistanceTwoResistorsInSerial()
   {
      Serial serialCircuit = new Serial(15, 1);
      Resistor firstResistor = new Resistor(5);
      Resistor secondResistor = new Resistor(10);
      serialCircuit.addCircuit(firstResistor);
      serialCircuit.addCircuit(secondResistor);
      double expectedCombinedResistance = 15;
      assertEquals(expectedCombinedResistance, serialCircuit.getResistance(), EPSILON);
   }
}