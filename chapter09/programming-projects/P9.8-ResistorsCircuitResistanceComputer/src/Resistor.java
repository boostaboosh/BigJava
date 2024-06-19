/**
 * Represents a single resistor in an electrical circuit.
 */
public class Resistor extends Circuit
{
   private double resistance;

   /**
    * Constructs a circuit a single resistor.
    * @param resistance the resistance of the resistor in Ohms
    */
   public Resistor(double resistance)
   {
      super(0, 0);
      this.resistance = resistance;
   }

   /**
    * The resistance of this resistor in Ohms.
    * @return the resistance of this resistor in Ohms
    */
   public double getResistance()
   {
      return this.resistance;
   }
}
