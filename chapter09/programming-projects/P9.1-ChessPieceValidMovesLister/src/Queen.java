import java.util.ArrayList;

/**
 * A queen is a chess piece which can move and take in any direction
 * by any number of squares as long as other pieces aren't on its
 * movement trajectory.
 * A queen puts together the movement patterns of bishops and rooks.
 * So, a queen can move and take diagonally by any number of squares,
 * or along ranks and files, as long as other pieces aren't on its
 * movement trajectory.
 */
public class Queen extends ChessPiece
{
   /**
    * See {@link ChessPiece#ChessPiece()}.
    */
   public Queen()
   {
      super();
   }

   /**
    * See {@link ChessPiece#ChessPiece(String coordinates)}.
    * @return
    */
   public Queen(String coordinates)
   {
      super(coordinates);
   }

   public ArrayList<String> canMoveTo()
   {
      ArrayList<String> canMoveTo = new ArrayList<>();
      if (super.getSquare().hasValidCoordinates())
      {
         ArrayList<Square> moves = new ArrayList<>();

         final char CURRENT_FILE = super.getSquare().getFile();
         final int CURRENT_RANK = super.getSquare().getRank();

         for (int rank = Square.MIN_RANK; rank <= Square.MAX_RANK; rank++)
         {
            if (rank != CURRENT_RANK)
            {
               moves.add(new Square(CURRENT_FILE, rank));
            }
         }

         for (char file = Square.MIN_FILE; file <= Square.MAX_FILE; file++)
         {
            if (file != CURRENT_FILE)
            {
               moves.add(new Square(file, CURRENT_RANK));
            }
         }

         final int DISTANCE_FROM_TOP_RANK = Square.MAX_RANK - CURRENT_RANK;
         final int DISTANCE_FROM_LEFT_FILE = CURRENT_FILE - Square.MIN_FILE;
         final int DISTANCE_FROM_TOP_AND_LEFT_EDGES = Math.min
               (DISTANCE_FROM_TOP_RANK, DISTANCE_FROM_LEFT_FILE);
         final Square TOP_LEFT_TO_BOTTOM_RIGHT_DIAGONAL_START_SQUARE = new Square
               (
                     (char) (CURRENT_FILE - DISTANCE_FROM_TOP_AND_LEFT_EDGES),
                     CURRENT_RANK + DISTANCE_FROM_TOP_AND_LEFT_EDGES
               );

         char file = TOP_LEFT_TO_BOTTOM_RIGHT_DIAGONAL_START_SQUARE.getFile();
         int rank = TOP_LEFT_TO_BOTTOM_RIGHT_DIAGONAL_START_SQUARE.getRank();
         while (file <= Square.MAX_FILE && rank >= Square.MIN_RANK)
         {
            if (file != CURRENT_FILE && rank != CURRENT_RANK)
            {
               moves.add(new Square(file, rank));
            }
            file = (char) (file + 1);
            rank = rank - 1;
         }

         final int DISTANCE_FROM_BOTTOM_RANK = CURRENT_RANK - Square.MIN_RANK;
         final int DISTANCE_FROM_BOTTOM_AND_LEFT_EDGES =
               Math.min(DISTANCE_FROM_BOTTOM_RANK, DISTANCE_FROM_LEFT_FILE);
         final Square BOTTOM_LEFT_TO_TOP_RIGHT_DIAGONAL_START_SQUARE = new Square
            (
                  (char) (CURRENT_FILE - DISTANCE_FROM_BOTTOM_AND_LEFT_EDGES),
                  CURRENT_RANK - DISTANCE_FROM_BOTTOM_AND_LEFT_EDGES
            );

         file = BOTTOM_LEFT_TO_TOP_RIGHT_DIAGONAL_START_SQUARE.getFile();
         rank = BOTTOM_LEFT_TO_TOP_RIGHT_DIAGONAL_START_SQUARE.getRank();
         while (file <= Square.MAX_FILE && rank <= Square.MAX_RANK)
         {
            if (file != CURRENT_FILE && rank != CURRENT_RANK)
            {
               moves.add(new Square(file, rank));
            }
            file = (char) (file + 1);
            rank = rank + 1;
         }

         for (Square square : moves)
         {
            canMoveTo.add(square.getChessNotation());
         }
      }
      return canMoveTo;
   }
}
