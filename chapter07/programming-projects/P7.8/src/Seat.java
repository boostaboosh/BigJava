/**
 * Seat objects model seats in a theatre.
 * They have a price and an availability.
 */
public class Seat
{
   private final double price;
   private boolean availability;
   private final int rowNumber;
   private final int columnNumber;

   public Seat(double price, boolean availability, int rowNumber, int columnNumber)
   {
      this.price = price;
      this.availability = availability;
      this.rowNumber = rowNumber;
      this.columnNumber = columnNumber;
   }

   /**
    * Returns the price of this seat.
    * @return the seat's price
    */
   public double getPrice()
   {
      return this.price;
   }

   /**
    * Returns the availability of this seat
    * @return true if this seat is available for booking
    */
   public boolean getAvailability()
   {
      return this.availability;
   }

   /**
    * Gets this seat's row number.
    * @return this seat's row number
    */
   public int getRowNumber()
   {
      return this.rowNumber;
   }

   /**
    * Gets this seat's column number.
    * @return this seat's column number
    */
   public int getColumnNumber()
   {
      return this.columnNumber;
   }

   /**
    * Sets this seats availability for booking
    * @param availability true if this seat is available for booking
    */
   public void setAvailability(boolean availability)
   {
      this.availability = availability;
   }

   /**
    * Prints this seat's price.
    */
   public void printPrice()
   {
      double price = this.price;
      System.out.print(price);
   }

   /**
    * Prints this seat's location.
    */
   public void printLocation()
   {
      System.out.printf("row %d and column %d", this.rowNumber, this.columnNumber);
   }
}
