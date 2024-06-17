import static org.junit.Assert.*;
import org.junit.Test;
import java.util.ArrayList;

public class PawnTest
{
   @Test public void testCanMoveToWhenMovingForTheFirstTimeAsWhite()
   {
      Pawn pawn = new Pawn("a2", new PlayerColour(Colour.WHITE));
      ArrayList<String> expectedCanMoveTo = new ArrayList<>();
      expectedCanMoveTo.add("a3");
      expectedCanMoveTo.add("a4");
      assertEquals(expectedCanMoveTo, pawn.canMoveTo());
   }

   @Test public void testCanMoveToWhenMovingForTheFirstTimeAsBlack()
   {
      Pawn pawn = new Pawn("c7", new PlayerColour(Colour.BLACK));
      ArrayList<String> expectedCanMoveTo = new ArrayList<>();
      expectedCanMoveTo.add("c6");
      expectedCanMoveTo.add("c5");
      assertEquals(expectedCanMoveTo, pawn.canMoveTo());
   }

   @Test public void testCanMoveToWhenNotMovingForTheFirstTimeAsWhite()
   {
      Pawn pawn = new Pawn("a5", new PlayerColour(Colour.WHITE));
      ArrayList<String> expectedCanMoveTo = new ArrayList<>();
      expectedCanMoveTo.add("a6");
      assertEquals(expectedCanMoveTo, pawn.canMoveTo());
   }

   @Test public void testCanMoveToWhenNotMovingForTheFirstTimeAsBlack()
   {
      Pawn pawn = new Pawn("f4", new PlayerColour(Colour.BLACK));
      ArrayList<String> expectedCanMoveTo = new ArrayList<>();
      expectedCanMoveTo.add("f3");
      assertEquals(expectedCanMoveTo, pawn.canMoveTo());
   }
}