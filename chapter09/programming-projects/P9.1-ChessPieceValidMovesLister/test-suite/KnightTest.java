import static org.junit.Assert.*;
import org.junit.Test;
import java.util.ArrayList;

public class KnightTest
{
   @Test public void testCanMoveToFromCentralPosition()
   {
      Knight knight = new Knight("c4");
      ArrayList<String> expectedMoves = new ArrayList<>();
      expectedMoves.add("b2");
      expectedMoves.add("d2");
      expectedMoves.add("a3");
      expectedMoves.add("e3");
      expectedMoves.add("a5");
      expectedMoves.add("e5");
      expectedMoves.add("b6");
      expectedMoves.add("d6");
      assertEquals(expectedMoves, knight.canMoveTo());
   }

   @Test public void testCanMoveToFromEdgePosition()
   {
      Knight knightOnTheEdge = new Knight("f8");
      ArrayList<String> expectedMoves = new ArrayList<>();
      expectedMoves.add("e6");
      expectedMoves.add("g6");
      expectedMoves.add("d7");
      expectedMoves.add("h7");
      assertEquals(expectedMoves, knightOnTheEdge.canMoveTo());
   }
}