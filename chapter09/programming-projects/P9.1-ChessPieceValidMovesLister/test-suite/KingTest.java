import static org.junit.Assert.*;
import org.junit.Test;
import java.util.ArrayList;

public class KingTest
{
   @Test public void testCanMoveToFromNonEdgeSquare()
   {
      King king = new King("g2");
      ArrayList<String> expectedCanMoveTo = new ArrayList<>();
      expectedCanMoveTo.add("g1");
      expectedCanMoveTo.add("f1");
      expectedCanMoveTo.add("f2");
      expectedCanMoveTo.add("f3");
      expectedCanMoveTo.add("g3");
      expectedCanMoveTo.add("h3");
      expectedCanMoveTo.add("h2");
      expectedCanMoveTo.add("h1");
      assertEquals(expectedCanMoveTo, king.canMoveTo());
   }

   @Test public void testCanMoveToFromEdgeSquare()
   {
      King king = new King("e1");
      ArrayList<String> expectedCanMoveTo = new ArrayList<>();
      expectedCanMoveTo.add("d1");
      expectedCanMoveTo.add("d2");
      expectedCanMoveTo.add("e2");
      expectedCanMoveTo.add("f2");
      expectedCanMoveTo.add("f1");
      assertEquals(expectedCanMoveTo, king.canMoveTo());
   }
}