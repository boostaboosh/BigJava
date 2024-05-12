import java.util.ArrayList;

/**
 * A combo lock works like a US style dial combination lock in a gym locker.
 * The lock is unlocked via a combination entered by turning a dial on the lock face:
 * 3 numbers between 0 and 39.
 * To open a combo lock the user must first turn its dial to the right (clockwise) to the 
 * first number in the combination, 
 * then left (counterclockwise) to the second number in the combination,
 * and then right to the third number in the combination.
 */
public class ComboLock
{
   
   
   
   // instance variables
   
   private final int NUMBER_OF_TICKS_ON_DIAL;
   private final ComboLockEntry[] UNLOCK_SEQUENCE;
   private final ArrayList<ComboLockEntry> currentCombination;
   
   // constructors

   /**
    * Constructs a combo lock with a given unlock combination.
    * @param secret1 the first number in the unlock combination
    * @param secret2 the second number in the unlock combination
    * @param secret3 the third number in the unlock combination
    */
   public ComboLock(int secret1, int secret2, int secret3)
   {
      this.NUMBER_OF_TICKS_ON_DIAL = 40;
      ComboLockEntry firstEntry = new ComboLockEntry(ComboLockEntry.CombinationEntryDirection.RIGHT, secret1);
      ComboLockEntry secondEntry = new ComboLockEntry(ComboLockEntry.CombinationEntryDirection.LEFT, secret2);
      ComboLockEntry thirdEntry = new ComboLockEntry(ComboLockEntry.CombinationEntryDirection.RIGHT, secret3);
      this.UNLOCK_SEQUENCE = new ComboLockEntry[] {firstEntry, secondEntry, thirdEntry};
      this.currentCombination = new ArrayList<ComboLockEntry>();
   }
   
   // methods

   /**
    * Resets the dial so that it points to zero,
    * and the current combination sequence, 
    * so that no number has been entered.
    */
   public void reset()
   {
      this.currentCombination.clear();
   }

   /**
    * Gets the last entry for this lock.
    * @return the last entry for this lock, or null if no entry has been made yet
    */
   private ComboLockEntry getLastCombinationEntry()
   {
      ComboLockEntry lastEntry = new ComboLockEntry(ComboLockEntry.CombinationEntryDirection.NONE, 0);
      if (!this.currentCombination.isEmpty())
      {
         lastEntry = this.currentCombination.get(this.currentCombination.size() - 1);
      }
      return lastEntry;
   }

   /**
    * Turns the dial by a given number of ticks to the left (counterclockwise).
    * @param ticks the ticks to turn the dial to the left (counterclockwise) by
    */
   public void turnLeft(int ticks)
   {
      ComboLockEntry lastEntry = this.getLastCombinationEntry();
      int newEntryValue = (lastEntry.getValue() + ticks) % NUMBER_OF_TICKS_ON_DIAL;
      ComboLockEntry newEntry = new ComboLockEntry(ComboLockEntry.CombinationEntryDirection.LEFT, newEntryValue);
      if (lastEntry.getEntryDirection() == ComboLockEntry.CombinationEntryDirection.LEFT)
      {
         this.currentCombination.set(this.currentCombination.size() - 1, newEntry);
      }
      else // if lastEntry.getEntryDirection() == CombinationEntryDirection.RIGHT || lastEntry.getEntryDirection() == CombinationEntryDirection.NONE
      {
         this.currentCombination.add(newEntry);
      }
   }

   /**
    * Turns the dial by a given number of ticks to the right (clockwise).
    * @param ticks the ticks to turn the dial to the right (clockwise) by
    */
   public void turnRight(int ticks)
   {
      ComboLockEntry lastEntry = this.getLastCombinationEntry();
      int newEntryValue = Math.floorMod((lastEntry.getValue() - ticks), this.NUMBER_OF_TICKS_ON_DIAL);
      ComboLockEntry newEntry = new ComboLockEntry(ComboLockEntry.CombinationEntryDirection.RIGHT, newEntryValue);
      if (lastEntry.getEntryDirection() == ComboLockEntry.CombinationEntryDirection.RIGHT)
      {
         this.currentCombination.set(this.currentCombination.size() - 1, newEntry);
      }
      else // if lastEntry.getEntryDirection() == CombinationEntryDirection.LEFT || lastEntry.getEntryDirection() == CombinationEntryDirection.NONE
      {
         this.currentCombination.add(newEntry);
      }
   }

   /**
    * Attempts to open the lock.
    * The lock only opens if the user has:
    * first turned it to the right to the tick representing the first number in the combination,
    * and then turned it to the left to the tick representing the second number in the combination,
    * and then turned it to the right to the tick representing the third number in the combination.
    * @return true if the lock is opened
    */
   public boolean open()
   {
      boolean combinationsAreEqual = true;
      if (this.currentCombination.size() != this.UNLOCK_SEQUENCE.length)
      {
         combinationsAreEqual = false;
      }
      else
      {
         boolean done = false;
         for (int index = 0; index < this.UNLOCK_SEQUENCE.length && !done; index++)
         {
            ComboLockEntry entry = this.currentCombination.get(index);
            ComboLockEntry unlockSequenceEntry = this.UNLOCK_SEQUENCE[index];
            if (!(unlockSequenceEntry.getValue() == entry.getValue() 
                  && unlockSequenceEntry.getEntryDirection() == entry.getEntryDirection()))
            {
               combinationsAreEqual = false;
               done = true;
            }
         }
      }
      return combinationsAreEqual;
   }

   /**
    * Gets the current selected value on the dial.
    * Made for testing purposes.
    * @return the current selected value on the dial
    */
   public int getSelectedDialValue()
   {
      return this.currentCombination.get(this.currentCombination.size() - 1).getValue();
   }
}
