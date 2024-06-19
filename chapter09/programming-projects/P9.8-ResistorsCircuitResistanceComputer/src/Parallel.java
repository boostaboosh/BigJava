import java.util.ArrayList;

/**
 * A parallel circuit models a set of circuits in parallel,
 * each of which can be a single resistor or another circuit.
 */
public class Parallel extends Circuit
{
   private ArrayList<Circuit> parallelCircuits;

   /**
    * Constructs a parallel circuit of resistors with no resistors.
    * @param voltage the voltage of the circuit
    * @param current the current of the circuit
    */
   public Parallel(double voltage, double current)
   {
      super(voltage, current);
      this.parallelCircuits = new ArrayList<>();
   }

   /**
    * Adds a resistor to this parallel circuit.
    * Null references are not added.
    * @param circuit the resistor to add
    */
   public void addCircuit(Circuit circuit)
   {
      if (circuit != null)
      {
         this.parallelCircuits.add(circuit);
         super.setCurrent(super.getVoltage() / this.getResistance());
      }
   }

   /**
    * Gets the combined resistance of this parallel circuit.
    * @return the resistance of this parrallel circuit
    */
   public double getResistance()
   {
      double oneOverTotalCombinedResistance = 0;
      for (Circuit circuit : parallelCircuits)
      {
         oneOverTotalCombinedResistance = oneOverTotalCombinedResistance + 1 / circuit.getResistance();
      }
      double totalCombinedResistance = 1 / oneOverTotalCombinedResistance;
      return totalCombinedResistance;
   }
}
