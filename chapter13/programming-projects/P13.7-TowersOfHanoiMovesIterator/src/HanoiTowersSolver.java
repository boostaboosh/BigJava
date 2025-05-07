public class HanoiTowersSolver
{
    public static void main(String[] args)
    {
        DiskMover mover = new DiskMover(5, 1, 3);
        while (mover.hasMoreMoves())
        {
            System.out.println(mover.nextMove());
        }
    }
}

