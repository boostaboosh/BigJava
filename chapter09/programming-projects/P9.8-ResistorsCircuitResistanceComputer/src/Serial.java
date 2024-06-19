import java.util.ArrayList;

/**
 * A serial circuit models a series of circuits,
 * each of which can be a single resistor or another circuit.
 */
public class Serial extends Circuit
{
   private ArrayList<Circuit> serialCircuits;

   /**
    * Constructs a serial circuit of resistors with no resistors.
    * @param voltage the voltage of the circuit
    * @param current the current of the circuit
    */
   public Serial(double voltage, double current)
   {
      super(voltage, current);
      this.serialCircuits = new ArrayList<>();
   }

   /**
    * Adds a resistor to this serial circuit.
    * Null references are not added.
    * @param circuit the resistor to add
    */
   public void addCircuit(Circuit circuit)
   {
      if (circuit != null)
      {
         this.serialCircuits.add(circuit);
         super.setCurrent(super.getVoltage() / this.getResistance());
      }
   }

   /**
    * Gets the combined resistance of this serial circuit.
    * @return the resistance of this serial circuit
    */
   public double getResistance()
   {
      double totalCombinedResistance = 0;
      for (Circuit circuit : serialCircuits)
      {
         totalCombinedResistance = totalCombinedResistance + circuit.getResistance();
      }
      return totalCombinedResistance;
   }
}
