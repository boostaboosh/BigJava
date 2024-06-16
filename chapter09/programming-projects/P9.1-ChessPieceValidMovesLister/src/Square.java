/**
 * Represents the location of a square on a chess board in chess notation.
 * For example, G7 indicates the square at the intersection of file G and row 7.
 * The first a letter from A to H indicates a file on the chess board.
 * Then a number from 1 to 8 indicates a row on the chess board.
 */
public class Square
{
   public static final int MAX_RANK = 8;
   public static final int MIN_RANK = 1;
   public static final char MAX_FILE = 'h';
   public static final char MIN_FILE = 'a';
   public static final char INVALID_FILE = 'z';
   public static final int INVALID_RANK = -1;
   private char file;
   private int rank;

   /**
    * Constructs a square with a rank (row) and file (column).
    * The file and rank are set to z and -1 respectively if invalid.
    * @param file the file of the square
    * @param rank the rank of the square
    */
   public Square(char file, int rank)
   {
      this.setPosition(file, rank);
   }

   /**
    * Constructs a square with a rank (row) and file (column)
    * from given square coordinates in chess notation.
    * If the provided coordinates are invalid the file and rank
    * are set to z and -1 respectively.
    * @param chessNotation the coordinates of the square
    *                      in chess notation:
    *                      First a letter from A to D indicating a
    *                      file on the chess board.
    *                      Then a number from 1 to 8 indicating a
    *                      row on the chess board.
    *                      For example, G7 indicates the square at
    *                      the intersection of file G and row 7.
    */
   public Square(String chessNotation)
   {
      if (chessNotation != null && chessNotation.length() == 2)
      {
         this.setPosition(chessNotation.charAt(0), Integer.valueOf(String.valueOf(chessNotation.charAt(1))));
      }
      else
      {
         this.setPosition('z', -1);
      }
   }

   /**
    * Sets the location of this square on this chess board.
    * The file and rank are set to z and -1 respectively if invalid.
    * @param file the file (column) of the square from A to H
    * @param rank the  rank (row) of the square from 1 to 8
    */
   public void setPosition(char file, int rank)
   {
      this.setFile(file);
      this.setRank(rank);
   }

   /**
    * Sets the file of this square.
    * The file is set to 'z' is the provided file is invalid.
    * @param file the file of this square from A to H
    */
   public void setFile(char file)
   {
      file = String.valueOf(file).toLowerCase().charAt(0);
      if (file >= MIN_FILE && file <= MAX_FILE)
      {
         this.file = file;
      }
      else
      {
         this.file = 'z';
      }
   }

   /**
    * Sets the rank of this position.
    * The rank is set to -1 if the provided rank is invalid.
    * @param rank the rank of this position from 1 to 8
    */
   public void setRank(int rank)
   {
      if (rank >= MIN_RANK && rank <= MAX_RANK)
      {
         this.rank = rank;
      }
      else
      {
         this.rank = -1;
      }
   }

   /**
    * Gets the file of this square.
    * @return the file of this square from 'a' to 'h', 'z' if invalid
    */
   public char getFile()
   {
      return this.file;
   }

   /**
    * Gets the rank of this square.
    * @return the rank of this square, -1 if invalid
    */
   public int getRank()
   {
      return this.rank;
   }

   /**
    * Gets the validity of this square's coordinates.
    * @return true if square rank and file coordinates are valid
    */
   public boolean hasValidCoordinates()
   {
      return !(this.rank == INVALID_RANK || this.file == INVALID_FILE);
   }

   /**
    * Gets the location of this square on the chess board in chess
    * notation.
    * For example, g7 indicates the square at the intersection of file G
    * and row 7.
    * The first a letter from a to h indicates a file (column)
    * on the chess board.
    * Then a number from 1 to 8 indicates a rank (row) on the chess board.
    * @return the location of this square on the chess board in chess
    * notation
    */
   public String getChessNotation()
   {
      return "" + this.file + this.rank;
   }

   /**
    * Gets the string representation of this square object's state.
    * @return the string representation of this square object's state
    */
   public String toString()
   {
      return this.getClass().getName() + "[file=" + this.file + ",rank=" + this.rank + "]";
   }

   /**
    * Checks if two square objects have the same contents.
    * @param otherObject the object to compare the internal contents of this
    *               object with
    * @return true if this object and the provided object have the
    * same internal contents
    */
   public boolean equals(Object otherObject)
   {
      boolean sameInternalState = false;
      if (this.getClass() == otherObject.getClass() && otherObject != null)
      {
         Square otherSquare = (Square) otherObject;
         if (this.file == otherSquare.file
               && this.rank == otherSquare.rank)
         {
            sameInternalState = true;
         }
      }
      return sameInternalState;
   }
}
