/**
 * Theatre objects model a theatre with seating.
 */
public class Theatre
{
   private final Seat[][] seatingChart;

   public Theatre()
   {
      final int NUMBER_OF_ROWS = 9;
      final int NUMBER_OF_SEATS_PER_ROW = 10;
      this.seatingChart = new Seat[NUMBER_OF_ROWS][NUMBER_OF_SEATS_PER_ROW];
      this.fillSeatingChart();
   }

   /**
    * Fills this theatre's rows with seats.
    */
   public void fillSeatingChart()
   {
      final boolean AVAILABLE = true;
      for (int rowNumber = 0; rowNumber < this.seatingChart.length; rowNumber++)
      {
         if (rowNumber < 3)
         {
            final int ROW_PRICE = 10;
            for (int columnNumber = 0; columnNumber < this.seatingChart[rowNumber].length; columnNumber++)
            {
               this.seatingChart[rowNumber][columnNumber] =
                     new Seat(ROW_PRICE, AVAILABLE, rowNumber + 1, columnNumber + 1);
            }
         }
         else if (rowNumber < 6)
         {
            for (int columnNumber = 0; columnNumber < this.seatingChart[rowNumber].length; columnNumber++)
            {
               if (columnNumber < 2 || columnNumber > 7)
               {
                  final int SEAT_PRICE = 10;
                  this.seatingChart[rowNumber][columnNumber] =
                        new Seat(SEAT_PRICE, AVAILABLE, rowNumber + 1, columnNumber + 1);
               }
               else
               {
                  final int SEAT_PRICE = 20;
                  this.seatingChart[rowNumber][columnNumber] =
                        new Seat(SEAT_PRICE, AVAILABLE, rowNumber + 1, columnNumber + 1);
               }
            }
         }
         else if (rowNumber == 6)
         {
            for (int columnNumber = 0; columnNumber < this.seatingChart[rowNumber].length; columnNumber++)
            {
               if (columnNumber < 2 || columnNumber > 7)
               {
                  final int SEAT_PRICE = 20;
                  this.seatingChart[rowNumber][columnNumber] =
                        new Seat(SEAT_PRICE, AVAILABLE, rowNumber + 1, columnNumber + 1);
               }
               else if (columnNumber < 4 || columnNumber > 5)
               {
                  final int SEAT_PRICE = 30;
                  this.seatingChart[rowNumber][columnNumber] =
                        new Seat(SEAT_PRICE, AVAILABLE, rowNumber + 1, columnNumber + 1);
               }
               else
               {
                  final int SEAT_PRICE = 40;
                  this.seatingChart[rowNumber][columnNumber] =
                        new Seat(SEAT_PRICE, AVAILABLE, rowNumber + 1, columnNumber + 1);
               }
            }
         }
         else if (rowNumber == 7)
         {
            for (int columnNumber = 0; columnNumber < this.seatingChart[rowNumber].length; columnNumber++)
            {
               if (columnNumber < 1 || columnNumber > 8)
               {
                  final int SEAT_PRICE = 20;
                  this.seatingChart[rowNumber][columnNumber] =
                        new Seat(SEAT_PRICE, AVAILABLE, rowNumber + 1, columnNumber + 1);
               }
               else if (columnNumber < 3 || columnNumber > 6)
               {
                  final int SEAT_PRICE = 30;
                  this.seatingChart[rowNumber][columnNumber] =
                        new Seat(SEAT_PRICE, AVAILABLE, rowNumber + 1, columnNumber + 1);
               }
               else if (columnNumber < 4 || columnNumber > 5)
               {
                  final int SEAT_PRICE = 40;
                  this.seatingChart[rowNumber][columnNumber] =
                        new Seat(SEAT_PRICE, AVAILABLE, rowNumber + 1, columnNumber + 1);
               }
               else
               {
                  final int SEAT_PRICE = 50;
                  this.seatingChart[rowNumber][columnNumber] =
                        new Seat(SEAT_PRICE, AVAILABLE, rowNumber + 1, columnNumber + 1);
               }
            }
         }
         else if (rowNumber == 8)
         {
            for (int columnNumber = 0; columnNumber < this.seatingChart[rowNumber].length; columnNumber++)
            {
               if (columnNumber < 1 || columnNumber > 8)
               {
                  final int SEAT_PRICE = 30;
                  this.seatingChart[rowNumber][columnNumber] =
                        new Seat(SEAT_PRICE, AVAILABLE, rowNumber + 1, columnNumber + 1);
               }
               else if (columnNumber < 2 || columnNumber > 7)
               {
                  final int SEAT_PRICE = 40;
                  this.seatingChart[rowNumber][columnNumber] =
                        new Seat(SEAT_PRICE, AVAILABLE, rowNumber + 1, columnNumber + 1);
               }
               else
               {
                  final int SEAT_PRICE = 50;
                  this.seatingChart[rowNumber][columnNumber] =
                        new Seat(SEAT_PRICE, AVAILABLE, rowNumber + 1, columnNumber + 1);
               }
            }
         }
      }
   }

   /**
    * Prints the layout of this theatre with the seat prices.
    */
   public void printLayout()
   {
      for (Seat[] seats : this.seatingChart)
      {
         for (Seat seat : seats)
         {
            if (seat.getAvailability())
            {
               seat.printPrice();
            }
            else
            {
               System.out.print("RES.");
            }
            System.out.print(" | ");
         }
         System.out.println();
      }
   }

   /**
    * Gets the availability of this seat.
    * @return true if this seat is available
    */
   public boolean getSeatAvailabilityByLocation(int rowNumber, int columnNumber)
   {
      boolean seatAvailability = this.seatingChart[rowNumber][columnNumber].getAvailability();
      return seatAvailability;
   }

   /**
    * Gets a seat by location.
    * @param rowNumber the row of the seat to get
    * @param columnNumber the column of the seat to get
    * @return a reference to the seat at the specified location
    */
   public Seat getSeatByLocation(int rowNumber, int columnNumber)
   {
      return this.seatingChart[rowNumber][columnNumber];
   }

   /**
    * Gets the availability of a seat for the specified price.
    * @return true if there is a seat available for the specified price
    */
   public boolean getSeatAvailabilityByPrice(double price)
   {
      final double EPSILON = 1E-14;
      boolean seatFound = false;
      for (int rowNumber = 0; rowNumber < this.seatingChart.length && !seatFound; rowNumber++)
      {
         for (int columnNumber = 0; columnNumber < this.seatingChart[rowNumber].length && !seatFound; columnNumber++)
         {
            Seat seat = this.seatingChart[rowNumber][columnNumber];
            if (Math.abs(seat.getPrice() - price) < EPSILON && seat.getAvailability())
            {
               seatFound = true;
            }
         }
      }
      return seatFound;
   }

   /**
    * Returns a seat of the searched price if it exists
    * @param price the price of the seat searched for
    * @return a seat of the specified price in the theatre
    */
   public Seat searchForSeatByPrice(double price)
   {
      final double EPSILON = 1E-14;
      Seat searchedSeat = null;
      boolean seatFound = false;
      for (int rowNumber = 0; rowNumber < this.seatingChart.length && !seatFound; rowNumber++)
      {
         for (int columnNumber = 0; columnNumber < this.seatingChart[rowNumber].length && !seatFound; columnNumber++)
         {
            Seat seat = this.seatingChart[rowNumber][columnNumber];
            if (Math.abs(seat.getPrice() - price) < EPSILON && seat.getAvailability())
            {
               seatFound = true;
               searchedSeat = seat;
            }
         }
      }
      return searchedSeat;
   }
}
