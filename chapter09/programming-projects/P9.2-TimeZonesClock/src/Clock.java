import java.time.LocalTime;

public class Clock
{
   /**
    * Gets the hours of the current time.
    * @return the current hours
    */
   public String getHours()
   {
      return LocalTime.now().toString().substring(0, 2);
   }

   /**
    * Gets the minutes of the current time.
    * @return the current minutes
    */
   public String getMinutes()
   {
      return LocalTime.now().toString().substring(3, 5);
   }

   /**
    * Gets the current time in hours and minutes
    * @return the current time
    */
   public String getTime()
   {
      return this.getHours() + ":" + this.getMinutes();
   }
}
