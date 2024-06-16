import java.util.ArrayList;

/**
 * A bishop is a chess piece which can move and take diagonally
 * by any number of squares as long as pieces aren't on its
 * trajectory.
 */
public class Bishop extends ChessPiece
{
   /**
    * See {@link ChessPiece#ChessPiece()}.
    */
   public Bishop()
   {
      super();
   }

   /**
    * See {@link ChessPiece#ChessPiece(String coordinates)}.
    * @param coordinates
    */
   public Bishop(String coordinates)
   {
      super(coordinates);
   }

   public ArrayList<String> canMoveTo()
   {
      ArrayList<String> validMoves = new ArrayList<>();
      if (super.getSquare().hasValidCoordinates())
      {
         int currentRank = super.getSquare().getRank();
         char currentFile = super.getSquare().getFile();
         ArrayList<Square> validMoveSquares = new ArrayList<>();
         for (int southWestSquareRank = currentRank - 1, southWestSquareFile = currentFile - 1;
              southWestSquareRank != Square.MIN_RANK - 1 && southWestSquareFile != Square.MIN_FILE - 1;
              southWestSquareRank--, southWestSquareFile--)
         {
            validMoveSquares.add(new Square((char) southWestSquareFile, southWestSquareRank));
         }
         for (int northWestSquareRank = currentRank + 1, northWestSquareFile = currentFile - 1;
              northWestSquareRank != Square.MAX_RANK + 1 && northWestSquareFile != Square.MIN_FILE - 1;
              northWestSquareRank++, northWestSquareFile--)
         {
            validMoveSquares.add(new Square((char) northWestSquareFile, northWestSquareRank));
         }
         for (int northEastSquareRank = currentRank + 1, northEastSquareFile = currentFile + 1;
              northEastSquareRank != Square.MAX_RANK + 1 && northEastSquareFile != Square.MAX_FILE + 1;
              northEastSquareRank++, northEastSquareFile++)
         {
            validMoveSquares.add(new Square((char) northEastSquareFile, northEastSquareRank));
         }
         for (int southEastSquareRank = currentRank - 1, southEastSquareFile = currentFile + 1;
              southEastSquareRank != Square.MIN_RANK - 1 && southEastSquareFile != Square.MAX_FILE + 1;
              southEastSquareRank--, southEastSquareFile++)
         {
            validMoveSquares.add(new Square((char) southEastSquareFile, southEastSquareRank));
         }

         for (Square square : validMoveSquares)
         {
            validMoves.add(square.getChessNotation());
         }
      }
      return validMoves;
   }
}
