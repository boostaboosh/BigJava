public class WorldClock extends Clock
{
   private int offset;

   /**
    * Constructs a world clock.
    * @param timeOffset an hourly time offset. For example,
    *                   if you live in California,
    *                   a new WorldClock(3) should show the
    *                   time in New York, three time zones
    *                   ahead.
    */
   public WorldClock(int timeOffset)
   {
      this.offset = timeOffset;
   }

   public String getHours()
   {
      int hoursWithoutOffset =
            Integer.valueOf(super.getHours());
      /*
       Math.floorMod behaves like the modulus operator
       but makes sure the result of the operation
       has the same sign as the divisor of the modulus
       operation, i.e., second argument (operand).
       So, -2 % 24 = 22.
       */
      int hoursWithOffset = Math.floorMod
            ((hoursWithoutOffset + offset), 24);
      return String.valueOf(hoursWithOffset);
   }
}
