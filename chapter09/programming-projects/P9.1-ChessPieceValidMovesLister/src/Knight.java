import java.util.ArrayList;

/**
 * A knight is a chess piece which has an L-shaped movement pattern.
 * It can move 2 squares in forward, back, left, or right directions,
 * and then 1 square left or right from that position.
 * For example, if a black knight is on the E4 square it can legally move
 * to the G5 square by moving left by 2 squares to G4,
 * and then moving one square left to the G5 square.
 * Unlike all other traditional chess pieces,
 * a knight can move over other pieces if they are in the way
 * of its trajectory.
 */
public class Knight extends ChessPiece
{
   /*
   todo
    fill implementation
    be a subclass of ChessPiece
    */

   /**
    * See {@link ChessPiece#ChessPiece()}.
    */
   public Knight()
   {
      super();
   }

   /**
    * See {@link ChessPiece#ChessPiece(String coordinates)}.
    * @param coordinates
    */
   public Knight(String coordinates)
   {
      super(coordinates);
   }

   public ArrayList<String> canMoveTo()
   {
      ArrayList<String> canMoveTo = new ArrayList<>();
      if (super.getSquare().hasValidCoordinates())
      {
         ArrayList<Square> moves = new ArrayList<>();

         char currentFile = super.getSquare().getFile();
         int currentRank = super.getSquare().getRank();

         boolean isTwoOrMoreRanksAboveBottomRank = currentRank - Square.MIN_RANK >= 2;
         boolean notOnBottomRank = currentRank != Square.MIN_RANK;
         boolean isTwoOrMoreFilesRightOfLeftEdge = currentFile - Square.MIN_FILE >= 2;
         boolean notOnLeftEdge = currentFile != Square.MIN_FILE;
         boolean isTwoOrMoreRanksBelowTopRank = currentRank - Square.MAX_RANK <= -2;
         boolean notOnTopRank = currentRank != Square.MAX_RANK;
         boolean isTwoOrMoreFilesLeftOfRightEdge = currentFile - Square.MAX_FILE <= -2;
         boolean notOnRightEdge = currentFile != Square.MAX_FILE;

         if (isTwoOrMoreRanksAboveBottomRank)
         {
            if (notOnLeftEdge)
            {
               moves.add(new Square((char) (currentFile - 1), currentRank - 2));
            }
            if (notOnRightEdge)
            {
               moves.add(new Square((char) (currentFile + 1), currentRank - 2));
            }
         }
         if (notOnBottomRank)
         {
            if (isTwoOrMoreFilesRightOfLeftEdge)
            {
               moves.add(new Square((char) (currentFile - 2), currentRank - 1));
            }
            if (isTwoOrMoreFilesLeftOfRightEdge)
            {
               moves.add(new Square((char) (currentFile + 2), currentRank - 1));
            }
         }
         if (notOnTopRank)
         {
            if (isTwoOrMoreFilesRightOfLeftEdge)
            {
               moves.add(new Square((char) (currentFile - 2), currentRank + 1));
            }
            if (isTwoOrMoreFilesLeftOfRightEdge)
            {
               moves.add(new Square((char) (currentFile + 2), currentRank + 1));
            }
         }
         if (isTwoOrMoreRanksBelowTopRank)
         {
            if (notOnLeftEdge)
            {
               moves.add(new Square((char) (currentFile - 1), currentRank + 2));
            }
            if (notOnRightEdge)
            {
               moves.add(new Square((char) (currentFile + 1), currentRank + 2));
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
