import static org.junit.Assert.*;
import org.junit.Test;

import java.util.ArrayList;

public class BishopTest
{
   @Test public void testCanMoveToFromNonEdgeSquare()
   {
      Bishop bishop = new Bishop("f3");
      ArrayList<String> expectedSquares = new ArrayList<>();
      expectedSquares.add(new Square("e2").getChessNotation());
      expectedSquares.add("d1");
      expectedSquares.add("e4");
      expectedSquares.add("d5");
      expectedSquares.add("c6");
      expectedSquares.add("b7");
      expectedSquares.add("a8");
      expectedSquares.add("g4");
      expectedSquares.add("h5");
      expectedSquares.add("g2");
      expectedSquares.add("h1");
      assertEquals(expectedSquares, bishop.canMoveTo());
   }

   @Test public void testCanMoveToFromEdgeSquare()
   {
      Bishop bishop = new Bishop("g8");
      ArrayList<String> expectedSquares = new ArrayList<>();
      expectedSquares.add("f7");
      expectedSquares.add("e6");
      expectedSquares.add("d5");
      expectedSquares.add("c4");
      expectedSquares.add("b3");
      expectedSquares.add("a2");
      expectedSquares.add("h7");
   }

   @Test public void testToString()
   {
      Bishop bishop = new Bishop("d2");
      String expected = "Bishop[Square[file=d,rank=2]]";
      assertEquals(expected, bishop.toString());
   }

   @Test public void testEquals()
   {
      Bishop bishop = new Bishop("h7");
      Bishop sameContentsBishop = new Bishop("h7");
      boolean expected = true;
      assertEquals(expected, bishop.equals(sameContentsBishop));
      Bishop differentContentsBishop = new Bishop("h4");
      expected = false;
      assertEquals(expected, bishop.equals(differentContentsBishop));
   }
}