public class GetNextGenerationTester
{
   public static void main(String[] args)
   {
      System.out.println("Get next generation test:");

      GameOfLife noAliveEdgeCellsGame = new GameOfLife();
      noAliveEdgeCellsGame.playGame();
      System.out.println("No alive edge cells game.\n"
            + "Expected:\n"
            + "generation 0:\n"
            + "   \n"
            + " o \n"
            + "   \n"
            + "generation 1:\n"
            + "   \n"
            + "   \n"
            + "   \n");
      GameOfLife staticAliveEdgeCellsGame = new GameOfLife();
      staticAliveEdgeCellsGame.playGame();
      System.out.println("Static alive edge cells game.\n"
            + "Expected:\n"
            + "generation 0:\n"
            + "  o\n"
            + " o \n"
            + " o \n"
            + "generation 1:\n"
            + "     \n"
            + "   o \n"
            + "  o  \n"
            + "  o  \n"
            + "     \n");
      GameOfLife dynamicAliveEdgeCellsGame = new GameOfLife();
      dynamicAliveEdgeCellsGame.playGame();
      System.out.println("Dynamic alive edge cells game.\n"
            + "Expected:\n"
            + "generation 0:\n"
            + "  o\n"
            + " oo\n"
            + "ooo\n"
            + "generation 1:\n"
            + "     \n"
            + "  oo \n"
            + " o  o\n"
            + " o o \n"
            + "  o  \n"
            + "generation 2:\n"
            + "       \n"
            + "       \n"
            + "   oo  \n"
            + "  oooo \n"
            + "  ooo  \n"
            + "   o   \n"
            + "       \n");
   }
}
