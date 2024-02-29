import java.util.Scanner;

/**
 * Contains a program which prompts users to pick a seat or a price
 * and tells the user if that seat is available or if a seat is
 * available for that price.
 */
public class TheatreSeatPicker
{
   private final Theatre theatre;

   /**
    * Constructs a theatre seat picker object.
    */
   public TheatreSeatPicker()
   {
      this.theatre = new Theatre();
   }

   /**
    * Starts the program
    * @param args starting arguments
    */
   public static void main(String[] args)
   {
      TheatreSeatPicker seatPicker = new TheatreSeatPicker();
      seatPicker.theatre.printLayout();

      Scanner scanner = new Scanner(System.in);

      boolean done = false;
      while (!done)
      {
         System.out.print("Do you want to pick a seat or a price? (s/p/exit/print) ");

         String answer = scanner.next();
         scanner.nextLine();
         if (answer.equalsIgnoreCase("s"))
         {
            seatPicker.askUserForSeatLocation();
         }
         else if (answer.equalsIgnoreCase("p"))
         {
            seatPicker.askUserForSeatPrice();
         }
         else if (answer.equalsIgnoreCase("exit"))
         {
            done = true;
         }
         else if (answer.equalsIgnoreCase("print"))
         {
            seatPicker.theatre.printLayout();
         }
         else
         {
            System.out.println("Valid answers are \"s\", \"p\", or \"exit\".");
         }
      }
   }

   /**
    * Asks user to enter a seat location and checks if it's available
    */
   public void askUserForSeatLocation()
   {
      System.out.print("Enter seat row number (row 1 is the top row): ");
      Scanner scanner = new Scanner(System.in);

      int userRowNumber = scanner.nextInt();
      scanner.nextLine();

      System.out.print("Enter seat column number (column 1 is the left and side row in the layout): ");

      int userColumnNumber = scanner.nextInt();
      scanner.nextLine();

      boolean seatIsAvailable =
            this.theatre.getSeatAvailabilityByLocation(userRowNumber - 1, userColumnNumber - 1);
      String output = "";
      if (seatIsAvailable)
      {
         this.askUserToBookSeat(userRowNumber - 1, userColumnNumber - 1);
      }
      else
      {
         System.out.println("Your selected seat is unavailable");
      }
   }

   /**
    * Asks user for a seat price and checks if a seat is available for that price.
    */
   public void askUserForSeatPrice()
   {
      System.out.print("Enter a seat price to check if there are seats available at that price: ");
      Scanner scanner = new Scanner(System.in);

      double searchedSeatPrice = scanner.nextDouble();
      scanner.nextLine();

      if (this.theatre.getSeatAvailabilityByPrice(searchedSeatPrice))
      {
         Seat seat = this.theatre.searchForSeatByPrice(searchedSeatPrice);
         seat.printLocation();
         System.out.println();
         this.askUserToBookSeat(seat.getUserRowNumber() - 1, seat.getUserColumnNumber() - 1);
      }
      else
      {
         System.out.println("No seats available for the entered price.");
      }
   }

   /**
    * Books a seat at the specified row and column.
    * @param rowNumber the row of the seat to book
    * @param columnNumber the column of the seat to book
    */
   public void askUserToBookSeat(int rowNumber, int columnNumber)
   {
      Seat bookingSeat = this.theatre.getSeatByLocation(rowNumber, columnNumber);
      System.out.printf("Do you want to book the seat at row %d and column %d? (y/n) ",
            bookingSeat.getUserRowNumber(), bookingSeat.getUserColumnNumber());
      Scanner scanner = new Scanner(System.in);

      String answer = scanner.next();
      scanner.nextLine();

      boolean wantsToBookSeat = false;
      if (answer.equalsIgnoreCase("y"))
      {
         wantsToBookSeat = true;
      }

      if (wantsToBookSeat)
      {
         bookingSeat.setAvailability(false);
         System.out.println("Seat booked.");
      }
      else
      {
         System.out.println("Seat not booked.");
      }
   }
}
