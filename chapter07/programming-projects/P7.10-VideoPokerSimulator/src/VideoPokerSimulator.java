/**
 * This class contains a program which simulates a game of video poker.
 */
public class VideoPokerSimulator
{
   /**
    * Starts the program.
    * @param args the program starting arguments
    */
   public static void main(String[] args)
   {
      VideoPokerGame game = new VideoPokerGame();
      while (game.askForToken())
      {
         game.shuffleDeck();
         game.presentTopFiveCards();
         game.askForCardsToReject();
         game.presentTopFiveCards();
         game.scoreHand();
      }
   }
}
