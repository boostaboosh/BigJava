/**
 * A circuit represents an electrical circuit where:
 * V is the voltage (potential difference) across the conductor,
 * measured in volts (V);
 * I is the current flowing through the conductor, measured in amperes (A);
 * R is the resistance of the conductor, measured in ohms (Ω);
 * and V=IR.
 */
public class Circuit
{
   private double voltage;
   private double current;

   /**
    * Constructs a circuit with a given voltage and current.
    * @param voltage the voltage of the circuit
    * @param current the current of the circuit
    */
   public Circuit(double voltage, double current)
   {
      this.voltage = voltage;
      this.current = current;
   }

   /**
    * Gets the resistance of this circuit in Ohms.
    * @return the resistance of this circuit in Ohms.
    */
   public double getResistance()
   {
      return voltage / current;
   }

   /**
    * Gets the voltage of this circuit in volts.
    * @return the voltage of this circuit in volts
    */
   public double getVoltage()
   {
      return this.voltage;
   }

   /**
    * Sets the current of this circuit.
    * @param current the current to set this circuit to
    */
   public void setCurrent(double current)
   {
      this.current = current;
   }
}
