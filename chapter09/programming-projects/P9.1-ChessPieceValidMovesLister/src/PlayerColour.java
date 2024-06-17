/**
 * Represents the colour of a player in a game of chess.
 */
public class PlayerColour
{
   private final Colour colour;

   /**
    * Constructs a player colour.
    * @param colour the colour of this player's colour
    */
   public PlayerColour(Colour colour)
   {
      this.colour = colour;
   }

   /**
    * Gets the colour of this player colour.
    * @return the colour of this player colour
    */
   public Colour getColour()
   {
      return this.colour;
   }

   /**
    * Gets the top rank number of this player.
    * @return the top rank number of this player
    */
   public int getTopRank()
   {
      int topRankNumber = Square.MAX_RANK;
      if (this.colour == Colour.BLACK)
      {
         topRankNumber = Square.MIN_RANK;
      }
      return topRankNumber;
   }

   /**
    * Gets the bottom rank number of this player.
    * @return the bottom rank number of this player
    */
   public int getBottomRank()
   {
      int bottomRankNumber = Square.MIN_RANK;
      if (this.colour == Colour.BLACK)
      {
         bottomRankNumber = Square.MAX_RANK;
      }
      return bottomRankNumber;
   }

   /**
    * Gets the multiplier of a rank movement for this player colour.
    * For example, if a black player moves forwards 2 ranks from
    * F5 to F7, their rank movement multiplier is -1,
    * because their rank number decrements by 2 (7 - 5 =2):
    * -1 * 2 = -2;
    * @return the multiplier of a rank movement for this player colour
    */
   public int getRankMovementMultiplier()
   {
      int multiplier = +1;
      if (this.colour == Colour.BLACK)
      {
         multiplier = -1;
      }
      return multiplier;
   }
}