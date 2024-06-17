import static org.junit.Assert.*;
import org.junit.Test;
import java.util.ArrayList;

public class QueenTest
{
   @Test public void testQueenCanMoveToFromNonEdgeSquare()
   {
      Queen queen = new Queen("d4");
      ArrayList<String> expectedMoves = new ArrayList<>();
      for (int rank = 1; rank <= 8; rank++)
      {
         if (rank != 4)
         {
            expectedMoves.add("d" + rank);
         }
      }
      for (char file = 'a'; file <= 'h'; file++)
      {
         if (file != 'd')
         {
            expectedMoves.add(String.valueOf(file) + 4);
         }
      }
      for (char file = 'a', rank = 7; file <= 'h' && (int) rank >= 1; file++, rank--)
      {
         if (file != 'd' && (int) rank != 4)
         {
            expectedMoves.add(String.valueOf(file) + (int) rank);
         }
      }
      for (char file = 'a', rank = 1; file <= 'h' && (int) rank <= 8; file++, rank++)
      {
         if (file != 'd' && (int) rank != 4)
         {
            expectedMoves.add(String.valueOf(file) + (int) rank);
         }
      }
      assertEquals(expectedMoves, queen.canMoveTo());
   }

   @Test public void testQueenCanMoveToFromEdgeSquare()
   {
      Queen queen = new Queen("a2");
      ArrayList<String> expectedCanMoveTo = new ArrayList<>();
      for (int rank = 1; rank <= 8; rank++)
      {
         if (rank != 2)
         {
            expectedCanMoveTo.add("a" + rank);
         }
      }
      for (char file = 'b'; file <= 'h'; file++)
      {
         expectedCanMoveTo.add(String.valueOf(file) + 2);
      }
      expectedCanMoveTo.add("b1");
      for (char file = 'b', rank = 3; rank <= 8; file++, rank++)
      {
         expectedCanMoveTo.add(String.valueOf(file) + (int) rank);
      }
      assertEquals(expectedCanMoveTo, queen.canMoveTo());
   }
}