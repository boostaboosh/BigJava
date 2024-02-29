/**
 * Seat objects model seats in a theatre.
 * They have a price and an availability.
 */
public class Seat
{
   private final double price;
   private boolean availability;
   private final int userRowNumber;
   private final int userColumnNumber;

   public Seat(double price, boolean availability, int userRowNumber, int userColumnNumber)
   {
      this.price = price;
      this.availability = availability;
      this.userRowNumber = userRowNumber;
      this.userColumnNumber = userColumnNumber;
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
   public int getUserRowNumber()
   {
      return this.userRowNumber;
   }

   /**
    * Gets this seat's column number.
    * @return this seat's column number
    */
   public int getUserColumnNumber()
   {
      return this.userColumnNumber;
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
      System.out.printf("row %d and column %d", this.userRowNumber, this.userColumnNumber);
   }
}
