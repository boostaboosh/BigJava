/**
 * The Cell class models a cell in a game of life board.
 */
public class Cell
{
   public enum State { ALIVE, DEAD }
   // instance variables
   State state;

   // constructors
   public Cell(State state)
   {
      this.state = state;
   }

   // methods
   /**
    * Set the state of this cell.
    */
   public void setStatus(State state)
   {
      this.state = state;
   }

   /**
    * Get the state of this cell.
    */
   public State getStatus()
   {
      return this.state;
   }
}
