public class HasAliveEdgeCellsTester
{
   public static void main(String[] args)
   {
      System.out.println("Has alive edge cells test:");

      GameOfLife noAliveEdgeCellsGame = new GameOfLife();
      System.out.print("No alive edge cells game. Expected false. Result "
            + noAliveEdgeCellsGame.hasAliveEdgeCells());

      GameOfLife aliveEdgeCellsGame = new GameOfLife();
      System.out.print("No alive edge cells game. Expected true. Result "
            + aliveEdgeCellsGame.hasAliveEdgeCells());
   }
}
