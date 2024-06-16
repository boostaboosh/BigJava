import java.util.ArrayList;

/**
 * A chess piece has a position on a 8x8 chess board,
 * and squares it can move to based on its movement pattern.
 */
public abstract class ChessPiece
{
   private Square square;

   /**
    * Constructs a new chess piece at an invalid position.
    */
   public ChessPiece()
   {
      this.square = new Square('z', -1);
   }

   /**
    * Constructs a new chess piece on the square specified in chess
    * notation.
    * The file and rank are set to z and -1 respectively if invalid.
    * @param coordinates the coordinates of the square to position
    *                    the piece on in chess notation:
    *                    First a letter from A to D indicating a
    *                    file on the chess board.
    *                    Then a number from 1 to 8 indicating a
    *                    row on the chess board.
    *                    For example, G7 indicates the square at
    *                    the intersection of file G and row 7.
    */
   public ChessPiece(String coordinates)
   {
      this.setSquare(coordinates);
   }

   /**
    * Sets the square of this chess piece on the board.
    * The file and rank are set to z and -1 if invalid coordinates are
    * provided.
    * @param coordinates the coordinates of the square to position
    *                    the piece on in chess notation:
    *                    First a letter from A to D indicating a
    *                    file on the chess board.
    *                    Then a number from 1 to 8 indicating a
    *                    row on the chess board.
    *                    For example, G7 indicates the square at
    *                    the intersection of file G and row 7.
    */
   public void setSquare(String coordinates)
   {
      coordinates = coordinates.trim();
      if (coordinates != null && coordinates.length() == 2)
      {
         this.square = new Square(coordinates.charAt(0), Integer.valueOf(String.valueOf(coordinates.charAt(1))));
      }
      else
      {
         this.square = new Square('z', -1);
      }
   }

   /**
    * Gets this position of this chess piece.
    * @return the position of this chess piece
    */
   public Square getSquare()
   {
      return new Square(this.square.getFile(), this.square.getRank());
   }

   /**
    * Enumerates the positions on the chess board this chess piece
    * can move to based on its movement pattern.
    * @return the positions on the chess board this chess piece can
    * move to based on its movement pattern
    */
   public abstract ArrayList<String> canMoveTo();

   public String toString()
   {
      return this.getClass().getName() + "[" + this.square + "]";
   }

   public boolean equals(Object otherObject)
   {
      boolean hasSameContents = false;
      if (this.getClass() == otherObject.getClass() && otherObject != null)
      {
         ChessPiece otherChessPiece = (ChessPiece) otherObject;
         if (this.square.equals(otherChessPiece.square))
         {
            hasSameContents = true;
         }
      }
      return hasSameContents;
   }
}
