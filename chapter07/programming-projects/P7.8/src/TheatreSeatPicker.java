/**
 * Contains a program which prompts users to pick a seat or a price
 * and tells the user if that seat is available or if a  seat is
 * available for that price.
 */
public class TheatreSeatPicker
{
   /**
    * Starts the program
    * @param args starting arguments
    */
   public static void main(String[] args)
   {
      Theatre theatre = new Theatre();
      theatre.printLayout();

      Scanner scanner = new Scanner(System.in);
      System.out.print("Do you want to pick a seat or a price? (s/p) ");
      String answer = scanner.next();
      scanner.nextLine();
      if (answer.equalsIgnoreCase("s"))
      {
         // I could make this whole thing a method called askUserForSeatLocation
         System.out.println("Enter seat row number (row 1 is the top row): ");
         int rowNumber = scanner.nextInt();
         scanner.nextLine();
         System.out.println("Enter seat column number (column 1 is the left and side row in the layout): ");
         int columnNumber = scanner.nextInt();
         scanner.nextLine();
         boolean seatIsAvailable = theatre.getSeatAvailability(rowNumber, columnNumber);
         String output = "";
         if (seatIsAvailable)
         {
            output = "Your selected seat is available";
         }
         else
         {
            output = "Your selected seat is unavailable";
         }
      }
      else if (answer.equalsIgnoreCase("p"))
      {
         // make a method called askUserForSeatPrice
      }
      else
      {
         System.out.println("Valid answers are \"s\" or \"p\".");
      }
   }
}
