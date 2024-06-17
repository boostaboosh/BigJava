import java.util.ArrayList;

/**
 * A rook is a chess piece which can move and take forwards and backwards
 * along files or left and right along ranks of the chess board by any
 * number of squares as long as other pieces aren't along its trajectory.
 */
public class Rook extends ChessPiece
{
   /**
    * See {@link ChessPiece#ChessPiece()}.
    */
   public Rook()
   {
      super();
   }

   /**
    * See {@link ChessPiece#ChessPiece(String coordinates)}.
    * @param coordinates
    */
   public Rook(String coordinates)
   {
      super(coordinates);
   }

   public ArrayList<String> canMoveTo()
   {
      ArrayList<String> canMoveTo = new ArrayList<>();
      if (super.getSquare().hasValidCoordinates())
      {
         ArrayList<Square> moves = new ArrayList<>();

         int currentRank = super.getSquare().getRank();
         char currentFile = super.getSquare().getFile();

         for (int rank = Square.MAX_RANK; rank >= Square.MIN_RANK; rank--)
         {
            if (rank != currentRank)
            {
               moves.add(new Square(currentFile, rank));
            }
         }
         for (char file = Square.MIN_FILE; file <= Square.MAX_FILE; file++)
         {
            if (file != currentFile)
            {
                moves.add(new Square(file, currentRank));
            }
         }

         for (Square square : moves)
         {
            canMoveTo.add(square.getChessNotation());
         }
      }
      return canMoveTo;
   }
}
