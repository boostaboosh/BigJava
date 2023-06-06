/**
 * A month has a name and a number of days.
 */
public class Month
{
   public enum MonthName { JANUARY, FEBRUARY, MARCH, APRIL, MAY, JUNE, JULY, AUGUST, SEPTEMBER, OCTOBER, NOVEMBER,
      DECEMBER };
   private MonthName monthName; // Using an enum type for a variable that can only hold a finite number of values means
   // we avoid the risk of mistakenly assigning said variable a value which it cannot hold. For example, a month named
   // "3" or "Saturn". And this means we avoid the programming logic producing potentially invalid results due to an
   // invalid month name. Also, we use the == operator to test if the relationship between enum type values is equal.

   /**
    * Constructs a month of the given month number.
    * @param monthNumber the month number, i.e., 1 for January, 2 for February, etc.
    */
   public Month(int monthNumber)
   {
      switch (monthNumber)
      {
         case 1: monthName = MonthName.JANUARY; break;
         case 2: monthName = MonthName.FEBRUARY; break;
         case 3: monthName = MonthName.MARCH; break;
         case 4: monthName = MonthName.APRIL; break;
         case 5: monthName = MonthName.MAY; break;
         case 6: monthName = MonthName.JUNE; break;
         case 7: monthName = MonthName.JULY; break;
         case 8: monthName = MonthName.AUGUST; break;
         case 9: monthName = MonthName.SEPTEMBER; break;
         case 10: monthName = MonthName.OCTOBER; break;
         case 11: monthName = MonthName.NOVEMBER; break;
         case 12: monthName = MonthName.DECEMBER; break;
         default: break;
      }
   }

   /**
    * Returns the length of a month in days.
    * @return the number of days in the month
    */
   public int getLength()
   {
      int numberOfDays;
      if (this.monthName == MonthName.JANUARY || this.monthName == MonthName.MARCH || this.monthName == MonthName.MAY
            || this.monthName == MonthName.JULY || this.monthName == MonthName.AUGUST
            || this.monthName == MonthName.OCTOBER || this.monthName == MonthName.DECEMBER)
      {
         numberOfDays = 31;
      }
      else if (this.monthName == MonthName.FEBRUARY)
      {
         numberOfDays = 28;
      }
      else // if (this.monthName == MonthName.APRIL || this.monthName == MonthName.JUNE
         // || this.monthName == MonthName.SEPTEMBER || this.monthName == MonthName.NOVEMBER)
      {
         numberOfDays = 30;
      }

      return numberOfDays;
   }
}
