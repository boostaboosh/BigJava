public enum DiskMoverState
{
    BEFORE_LARGEST, // a helper mover moves the smaller pile to the other peg
    LARGEST, // move the largest disk from the source to the destination
    AFTER_LARGEST, // the helper mover moves the smaller pile from the other peg to the target
    DONE, // all moves are done
}
