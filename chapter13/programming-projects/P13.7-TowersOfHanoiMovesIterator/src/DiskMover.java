public class DiskMover
{
    private DiskMoverState state;
    private int numberOfDisks;
    private final int from;
    private final int to;
    private final int aux;
    private DiskMover beforeLargestHelper;
    private DiskMover afterLargestHelper;

    /**
     * Constructs a disk mover for moving n number of disks from start peg to target peg.
     * @param numberOfDisks the number of disks on the start peg
     * @param sourcePeg the start peg where the disks are
     * @param targetPeg the target peg where we want the disks to be
     */
    public DiskMover(int numberOfDisks, int sourcePeg, int targetPeg)
    {
        this.numberOfDisks = numberOfDisks;
        this.from = sourcePeg;
        this.to = targetPeg;
        this.aux = 6 - sourcePeg - targetPeg;
        if (numberOfDisks > 1)
        {
            this.state = DiskMoverState.BEFORE_LARGEST;
        }
        else if (numberOfDisks == 1)
        {
            this.state = DiskMoverState.LARGEST;
        }
        else if (numberOfDisks == 0)
        {
            this.state = DiskMoverState.DONE;
        }
    }

    /**
     * Checks if there are more disk moves to be made.
     * @return true if there are moves to be made, false if the game is complete
     */
    public boolean hasMoreMoves()
    {
        return this.state != DiskMoverState.DONE;
    }

    /**
     * Returns the next disk move to play in the towers of hanoi puzzle.
     * @return the next move to play in the towers of hanoi puzzle
     */
    public String nextMove()
    {
        String moveMessage = "";
        boolean moveDone = false;
        if (state == DiskMoverState.BEFORE_LARGEST)
        {
            if (this.beforeLargestHelper == null)
            {
                this.beforeLargestHelper = new DiskMover(this.numberOfDisks - 1, this.from, this.aux);
            }
            if (this.beforeLargestHelper.hasMoreMoves())
            {
                moveMessage = this.beforeLargestHelper.nextMove();
                moveDone = true;
            }
            else
            {
                this.state = DiskMoverState.LARGEST;
            }
        }
        if (!moveDone && state == DiskMoverState.LARGEST)
        {
            moveMessage = "Move disk from peg " + from + " to " + to;
            moveDone = true;
            if (this.numberOfDisks == 1)
            {
                this.state = DiskMoverState.DONE;
            }
            else
            {
                this.state = DiskMoverState.AFTER_LARGEST;
            }
        }
        if (!moveDone && state == DiskMoverState.AFTER_LARGEST)
        {
            if (this.afterLargestHelper == null)
            {
                this.afterLargestHelper = new DiskMover(this.numberOfDisks - 1, this.aux, this.to);
            }
            if (this.afterLargestHelper.hasMoreMoves())
            {
                moveMessage = this.afterLargestHelper.nextMove();
                if (!this.afterLargestHelper.hasMoreMoves())
                {
                    this.state = DiskMoverState.DONE;
                }
            }
        }
        return moveMessage;
    }

}
