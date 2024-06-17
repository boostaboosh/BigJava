import java.util.ArrayList;

/**
 * A pawn is a chess piece which can move forward
 * if no pieces are in its way,
 * either 1 or 2 squares if it's moving for the first time,
 * or 1 square if it has moved before.
 * A pawn can also move forward and diagonally 1 square if it also takes
 * a piece from the opposite player by moving to that square.
 * A pawn can also take another pawn en-passant by moving forward
 * and diagonally 1 square if it ends up on the square behind a pawn
 * that has moved forwards 2 squares the previous move.
 */
public class Pawn extends ChessPiece
{
   private final PlayerColour playerColour;

   /**
    * Constructs a new pawn chess piece at an invalid position.
    * @param playerColour the colour of this pawn
    */
   public Pawn(PlayerColour playerColour)
   {
      super();
      this.playerColour = playerColour;
   }

   /**
    * Constructs a new chess piece on the square specified
    * in chess notation.
    * The file and rank are set to z and -1 respectively if invalid.
    * @param coordinates the coordinates of the square to position
    *                    the piece on in chess notation:
    *                    First a letter from A to D
    *                    indicating a file on the chess board.
    *                    Then a number from 1 to 8 indicating
    *                    a row on the chess board.
    *                    For example, G7 indicates the square
    *                    at the intersection of file G and row 7.
    * @param playerColour the colour of this pawn
    */
   public Pawn(String coordinates, PlayerColour playerColour)
   {
      super(coordinates);
      this.playerColour = playerColour;
   }

   public ArrayList<String> canMoveTo()
   {
      ArrayList<String> canMoveTo = new ArrayList<>();
      if (super.getSquare().hasValidCoordinates())
      {
         ArrayList<Square> moves = new ArrayList<>();
         char currentFile = super.getSquare().getFile();
         int currentRank = super.getSquare().getRank();

         if (currentRank != playerColour.getTopRank())
         {
            moves.add(new Square(
                  (char) (currentFile),
                  currentRank + 1 * this.playerColour.getRankMovementMultiplier()));
         }
         if (currentRank == this.getPawnStartingRank())
         {
            moves.add(new Square(
                  (char) (currentFile),
                  currentRank + 2 * this.playerColour.getRankMovementMultiplier()));
         }

         for (Square square : moves)
         {
            canMoveTo.add(square.getChessNotation());
         }
      }
      return canMoveTo;
   }

   /**
    * Gets the starting rank number of this pawn.
    * @return the starting rank number of this pawn
    */
   public int getPawnStartingRank()
   {
      int pawnStartingRank = 2;
      if (this.playerColour.getColour() == Colour.BLACK)
      {
         pawnStartingRank = 7;
      }
      return pawnStartingRank;
   }
}
