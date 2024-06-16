import static org.junit.Assert.*;
import org.junit.Test;

public class ChessPieceTest
{
   @Test public void settingTheSquareOfAChessPiece()
   {
      ChessPiece piece = new Bishop();
      piece.setSquare("e5");
      Square expectedSquare = new Square('e', 5);
      assertEquals(expectedSquare, piece.getSquare());
   }

   @Test public void gettingTheSquareOfAChessPiece()
   {
      ChessPiece piece = new Bishop();
      Square expectedPosition = new Square('z', -1);
      assertEquals(expectedPosition, piece.getSquare());
      piece.setSquare("d4");
      expectedPosition = new Square('d', 4);
      assertEquals(expectedPosition, piece.getSquare());
   }

}