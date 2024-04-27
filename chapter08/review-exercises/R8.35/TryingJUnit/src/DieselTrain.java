/**
 * A Car object models a car vehicle.
 */
public class DieselTrain
{
   public enum GasTankLevel { FULL, PARTIALLY_FULL, EMPTY }
   
   private double distanceFromTerminus;

   /**
    * Constructs a DieselTrain at the terminus.
    */
   public DieselTrain()
   {
      this.distanceFromTerminus = 0.0;
   }

   /**
    * Moves the train.
    */
   public void move(double distance)
   {
      this.distanceFromTerminus = this.distanceFromTerminus - distance;
   }
   
   public double getDistanceFromTerminus()
   {
      return this.distanceFromTerminus;
   }
}
