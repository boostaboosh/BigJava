import java.util.ArrayList;

/**
 * A king is a chess piece that can move and take in any direction 1 square
 * per move.
 * A king can move like a queen but only 1 square at a time.
 * If a king chess piece is eaten or cannot move to a safe square, the player
 * that owns that king loses the game of chess.
 */
public class King extends ChessPiece
{
   /**
    * See {@link ChessPiece#ChessPiece()}.
    */
   public King()
   {
      super();
   }

   /**
    * See {@link ChessPiece#ChessPiece(String coordinates)}.
    * @param coordinates
    */
   public King(String coordinates)
   {
      super(coordinates);
   }

   public ArrayList<String> canMoveTo()
   {
      ArrayList<String> canMoveTo = new ArrayList<>();
      if (super.getSquare().hasValidCoordinates())
      {
         ArrayList<Square> moves = new ArrayList<>();

         final int currentRank = super.getSquare().getRank();
         final char currentFile = super.getSquare().getFile();

         final boolean aboveBottomRank = currentRank > Square.MIN_RANK;
         final boolean belowTopRank = currentRank < Square.MAX_RANK;
         final boolean rightOfLeftEdge = currentFile > Square.MIN_FILE;
         final boolean leftOfRightEdge = currentFile < Square.MAX_FILE;

         if (aboveBottomRank)
         {
            moves.add(new Square(currentFile, currentRank - 1));
         }
         if (aboveBottomRank && rightOfLeftEdge)
         {
            moves.add(new Square((char) (currentFile - 1), currentRank - 1));
         }
         if (rightOfLeftEdge)
         {
            moves.add(new Square((char) (currentFile - 1), currentRank));
         }
         if (belowTopRank && rightOfLeftEdge)
         {
            moves.add(new Square((char) (currentFile - 1), currentRank + 1));
         }
         if (belowTopRank)
         {
            moves.add(new Square(currentFile, currentRank + 1));
         }
         if (belowTopRank && leftOfRightEdge)
         {
            moves.add(new Square((char) (currentFile + 1), currentRank + 1));
         }
         if (leftOfRightEdge)
         {
            moves.add(new Square((char) (currentFile + 1), currentRank));
         }
         if (aboveBottomRank && leftOfRightEdge)
         {
            moves.add(new Square((char) (currentFile + 1), currentRank - 1));
         }

         for (Square square : moves)
         {
            canMoveTo.add(square.getChessNotation());
         }
      }
      return canMoveTo;
   }
}
