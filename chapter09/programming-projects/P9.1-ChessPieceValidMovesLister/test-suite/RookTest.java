import static org.junit.Assert.*;
import org.junit.Test;
import java.util.ArrayList;

public class RookTest
{
   @Test public void testRookCanMoveToFromNonEdgeSquare()
   {
      Rook rook = new Rook("d4");
      ArrayList<String> expectedMoves = new ArrayList<>();
      expectedMoves.add("d8");
      expectedMoves.add("d7");
      expectedMoves.add("d6");
      expectedMoves.add("d5");
      expectedMoves.add("d3");
      expectedMoves.add("d2");
      expectedMoves.add("d1");
      String move = "a4";
      while(move.charAt(0) != 'h' + 1)
      {
         if (move.charAt(0) != 'd')
         {
            expectedMoves.add(move);
         }
         move = String.valueOf((char) (move.charAt(0) + 1)) + move.charAt(1);
      }
      assertEquals(expectedMoves, rook.canMoveTo());
   }

   @Test public void testRookCanMoveToFromEdgeSquare()
   {
      Rook rook = new Rook("h2");
      ArrayList<String> expectedMoves = new ArrayList<>();
      for (int rankCounter = 8; rankCounter >= 1; rankCounter--)
      {
         if (rankCounter != 2)
         {
            expectedMoves.add("h" + rankCounter);
         }
      }
      for (char file = 'a'; file <= 'h'; file++)
      {
         if (file != 'h')
         {
            expectedMoves.add(String.valueOf(file) + 2);
         }
      }
      assertEquals(expectedMoves, rook.canMoveTo());
   }
}