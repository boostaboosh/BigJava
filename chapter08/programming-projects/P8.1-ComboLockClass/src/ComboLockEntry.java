/**
 * A combo lock entry has a number value and a direction from which it was entered.
 */
public class ComboLockEntry
{
   public enum CombinationEntryDirection { LEFT, RIGHT, NONE }
   
   // instance variables
   private final CombinationEntryDirection entryDirection;
   private final int value;

   // constructors

   /**
    * Creates a new dial lock combination entry.
    * @param entryDirection the direction the lock dial was turned
    * @param value the value to which the dial was turned
    */
   public ComboLockEntry(CombinationEntryDirection entryDirection, int value)
   {
      this.entryDirection = entryDirection;
      this.value = value;
   }
   
   // methods

   /**
    * Gets the direction in which the lock dial was turned to make this combination entry.
    * @return the direction in which the lock dial was turned to make this combination entry
    */
   public CombinationEntryDirection getEntryDirection()
   {
      return this.entryDirection;
   }

   /**
    * Gets the value of this combination lock entry.
    * @return the value of this combination lock entry
    */
   public int getValue()
   {
      return this.value;
   }
}
