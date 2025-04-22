import java.util.ArrayList;
import java.util.Arrays;

/**
   A partial solution to the eight queens puzzle.
*/
public class PartialSolution
{
   private Queen[] queens;
   private static final int NQUEENS = 8;

   public static final int ACCEPT = 1;
   public static final int ABANDON = 2;
   public static final int CONTINUE = 3;
   
   /**
      Constructs a partial solution of a given size.
      @param size the size
   */
   public PartialSolution(int size)
   {
      queens = new Queen[size];
   }

   /**
      Examines a partial solution.
      @return one of ACCEPT, ABANDON, CONTINUE
   */
   public int examine()
   {
      for (int i = 0; i < queens.length; i++)
      {
         for (int j = i + 1; j < queens.length; j++)
         {
            if (queens[i].attacks(queens[j])) { return ABANDON; }
         }
      }
      if (queens.length == NQUEENS) { return ACCEPT; }
      else { return CONTINUE; }
   }

   /**
      Yields all extensions of this partial solution.
      @return an array of partial solutions that extend this solution.
   */
   public PartialSolution[] extend()
   {
      // Generate a new solution for each column
      PartialSolution[] result = new PartialSolution[NQUEENS];
      for (int i = 0; i < result.length; i++)
      {
         int size = queens.length;

         // The new solution has one more row than this one
         result[i] = new PartialSolution(size + 1);

         // Copy this solution into the new one
         for (int j = 0; j < size; j++)
         {
            result[i].queens[j] = queens[j];
         }

         // Append the new queen into the ith column
         result[i].queens[size] = new Queen(size, i);
      }
      return result;
   }

   /**
    * Converts a board position of 8 queens to the lexicographically smallest string that represents the board
    * and any of its rotated/mirrored versions.
    * i.e. the same string for mirrored or rotated board positions.
    * This string serves as an identifier for the board position representing the multiple equivalent versions
    * of the board.
    * An 8 queens board position ban be represented in 8 different ways due to rotation and reflection, but all 8 are
    * functionally equivalent solutions. So we want to treat them as duplicates, and store just 1 version as
    * representative of them all.
    * If you have a tray of ice cubes, and you shuffle them around, the ice is still the same,
    * just in a different arrangement. But what if you needed to store one “identity” of the tray in a database?
    * You would want to always record the same version, even if it was flipped or rotated, so you invent a unique way
    * of storing it, like "left to right, or top to bottom".
    * An 8 queens board position is converted to a text string, which is then transformed into all
    * mirrors and rotations of the board, and then one string is chosen for that board duplicated
    * position.
    * @return the canonical string representation of the board (queen positions)
    */
   public String getUniqueStringRepresentation()
   {
      int[] cols = new int[queens.length];
      for (int i = 0; i < queens.length; i++) {
         cols[queens[i].getRow()] = queens[i].getColumn();
      }

      ArrayList<String> forms = new ArrayList<>();
      forms.add(toBoardString(cols));                    // original
      forms.add(toBoardString(rotate90(cols)));
      forms.add(toBoardString(rotate180(cols)));
      forms.add(toBoardString(rotate270(cols)));
      forms.add(toBoardString(mirrorVertical(cols)));
      forms.add(toBoardString(mirrorHorizontal(cols)));
      forms.add(toBoardString(mirrorDiagonal(cols)));
      forms.add(toBoardString(mirrorAntiDiagonal(cols)));

      return getLexicographicallySmallest(forms);
   }

   /**
    * Gets the lexicographically smallest string
    * @param forms the strings to filter
    * @return the lexicographically smallest string
    */
   private String getLexicographicallySmallest(ArrayList<String> forms) {
      if (forms.isEmpty()) return null;
      String smallest = forms.get(0);
      for (String form : forms)
      {
         if (form.compareTo(smallest) < 0)
         {
            smallest = form;
         }
      }
      return smallest;
   }

   /**
    * The index of the number in the string is the row of the queen, and the value of the number
    * is the column of the queen: e.g. "1234578" is 0,1 - 1,2 - 2,3 - etc.
    * @param cols the int array representation of this board position where
    *             index is the queen row, and value is the queen column
    * @return the string representation of this board position of 8 queens
    */
   private String toBoardString(int[] cols) {
      StringBuilder string = new StringBuilder();
      for (int col : cols)
      {
         string.append(col);
      }
      return string.toString();
   }

   private int[] rotate90(int[] cols) {
      int n = cols.length;
      int[] result = new int[n];
      for (int row = 0; row < n; row++) {
         int col = cols[row];
         result[col] = n - 1 - row;
      }
      return result;
   }

   private int[] rotate180(int[] cols) {
      int n = cols.length;
      int[] result = new int[n];
      for (int row = 0; row < n; row++) {
         result[n - 1 - row] = n - 1 - cols[row];
      }
      return result;
   }

   private int[] rotate270(int[] cols) {
      int n = cols.length;
      int[] result = new int[n];
      for (int row = 0; row < n; row++) {
         int col = cols[row];
         result[n - 1 - col] = row;
      }
      return result;
   }

   private int[] mirrorHorizontal(int[] cols) {
      int n = cols.length;
      int[] result = new int[n];
      for (int row = 0; row < n; row++) {
         result[n - 1 - row] = cols[row];
      }
      return result;
   }

   private int[] mirrorVertical(int[] cols) {
      int n = cols.length;
      int[] result = new int[n];
      for (int row = 0; row < n; row++) {
         result[row] = n - 1 - cols[row];
      }
      return result;
   }

   private int[] mirrorDiagonal(int[] cols) {
      int n = cols.length;
      int[] result = new int[n];
      for (int row = 0; row < n; row++) {
         result[cols[row]] = row;
      }
      return result;
   }

   /**
    * flips top right to bottom left
    * @param cols the input board pos
    * @return the board position flipped over the anti-diagonal
    */
   private int[] mirrorAntiDiagonal(int[] cols) {
      int n = cols.length;
      int[] result = new int[n];
      for (int row = 0; row < n; row++) {
         result[n - 1 - cols[row]] = n - 1 - row;
      }
      return result;
   }

   public String toString() { return Arrays.toString(queens); }

}
