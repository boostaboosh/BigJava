import java.util.Arrays;

/**
 * A class which performs operations on sequences of values.
 */
public class Sequence
{
   private int[] values;

   /**
    * Creates a sequence of values of the specified size.
    * @param size the size of the sequence of values
    */
   public Sequence(int size)
   {
      this.values = new int[size];
   }

   /**
    * Creates a sequence of values with the same value and size as
    * a pre-existing array.
    * @param array the array to use as model for the sequence
    */
   public Sequence(int[] array)
   {
      this.values = Arrays.copyOf(array, array.length);
   }

   /**
    * Set the value of an element in the sequence.
    * @param i the index of the element to set the value of
    * @param n the value to set the element to
    */
   public void set(int i, int n)
   {
      values[i] = n;
   }

   /**
    * Returns a value from an element in the array.
    * @param i the index of the element in the array to get the value of
    * @return the value of the element
    */
   public int get(int i)
   {
      return values[i];
   }

   /**
    * Returns the size of the sequence.
    * @return the size of the sequence
    */
   public int size()
   {
      return values.length;
   }

   /**
    * Checks whether two sequences have the same values in the same order.
    * @param other the sequence to compare this sequence to
    * @return true if the two sequences have the same values in the same order
    */
   public boolean equals(Sequence other)
   {
      boolean isEqual = true;
      boolean sizeIsEqual = this.size() == other.size();
      if (sizeIsEqual)
      {
         for (int index = 0; index < this.size(); index++)
         {
            if (this.get(index) != other.get(index))
            {
               isEqual = false;
            }
         }
      }
      else
      {
         isEqual = false;
      }
      return isEqual;
   }

   /**
    * Checks whether two sequences have the same values in some order,
    * ignoring duplicates.
    * For example, the two sequences 1 4 9 16 9 7 4 9 11
    * and 11 11 7 9 16 4 1 would be considered identical.
    * @param other the other sequence to compare this sequence to
    * @return true if the two sequences contain the same values
    */
   public boolean sameValues(Sequence other)
   {
      Sequence longerSequence = this;
      Sequence shorterSequence = other;
      if (other.size() > this.size())
      {
         longerSequence = other;
         shorterSequence = this;
      }
      boolean haveSameValues = true;
      for (int index = 0; index < longerSequence.size(); index++)
      {
         int value = longerSequence.get(index);
         boolean hasSameValue = false;
         for (int position = 0; position < shorterSequence.size(); position++)
         {
            if (value == other.get(position))
            {
               hasSameValue = true;
            }
         }
         if (!hasSameValue)
         {
            haveSameValues = false;
         }
      }
      return haveSameValues;
   }
}
