import static org.junit.Assert.*;
import org.junit.Test;

public class ParallelTest
{
   final double EPSILON = 1E-14;

   @Test public void testGetResistanceThreeResistorsInParallel()
   {
      Parallel parallelCircuit = new Parallel(10, 1);
      Resistor firstResistor = new Resistor(10);
      Resistor secondResistor = firstResistor;
      Resistor thirdResistor = new Resistor(7.5);
      parallelCircuit.addCircuit(firstResistor);
      parallelCircuit.addCircuit(secondResistor);
      parallelCircuit.addCircuit(thirdResistor);
      double expectedCombinedResistance = 1 / (1.0/10 + 1.0/10 + 1/7.5); // 1 / (1/10 + 1/10 + 1/7.5)
      assertEquals(expectedCombinedResistance, parallelCircuit.getResistance(), EPSILON);
   }

   @Test public void testGetResistanceParallelSerialAndResistorCircuit()
   {
      Serial serialCircuit = new Serial(10, 1);
      Resistor firstResistor = new Resistor(5);
      Resistor secondResistor = new Resistor(5);
      serialCircuit.addCircuit(firstResistor);
      serialCircuit.addCircuit(secondResistor);
      Resistor resistor = new Resistor(10);
      Parallel parallelCircuit = new Parallel(10, 1);
      parallelCircuit.addCircuit(serialCircuit);
      parallelCircuit.addCircuit(resistor);
      double expectedCombinedResistance = 1 / (1.0 / 10 + 1.0 / 10); // 1 / (1/10 + 1/10) = 5
      assertEquals(expectedCombinedResistance, parallelCircuit.getResistance(), EPSILON);
   }
}