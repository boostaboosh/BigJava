/**
 * A year is the orbital period of a planetary body. A calendar year is the approximation of the number of days of the
 * Earth's orbital period as counted in a given calendar.
 * The Gregorian, or modern, calendar presents a year to be a common year of 365 days or a leap year of 366 days.
 */
public class Year
{
   private int yearNumber;

   /**
    * Constructs a year object.
    * @param yearNumber the year number
    */
   public Year(int yearNumber)
   {
      this.yearNumber = yearNumber;
   }

   /**
    * Computes whether this year is a leap year (a year with 366 days) or not.
    * @return true if this year is a leap year, false if it is not
    */
   public boolean isLeapYear()
   {
      boolean isLeapYear = false;

      int yearNumber = this.yearNumber;
      final int BEGINNING_OF_GREGORIAN_CALENDAR = 1582;
      final int LEAP_YEAR_DIVISOR = 4;
      final int NOT_A_LEAP_YEAR_DIVISOR = 100;
      final int ALWAYS_A_LEAP_YEAR_DIVISOR = 400;

      if (yearNumber > BEGINNING_OF_GREGORIAN_CALENDAR && (yearNumber % LEAP_YEAR_DIVISOR == 0 && yearNumber
            % NOT_A_LEAP_YEAR_DIVISOR != 0 || yearNumber % ALWAYS_A_LEAP_YEAR_DIVISOR == 0))
      {
         isLeapYear = true;
      }

      return isLeapYear;
   }
}
