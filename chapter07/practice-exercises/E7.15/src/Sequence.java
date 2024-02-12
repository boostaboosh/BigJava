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

   /**
    * Checks if a sequence is a permutation of another sequence,
    * i.e., if two sequences have the same values in some order,
    * with the same multiplicities.
    * For example,
    * 1, 4, 9, 6, 6
    * is a permutation of 4, 6, 1, 9, 6
    * but 1, 4, 9, 6, 6
    * is not a permutation of 6, 4, 9, 1, 1
    * @param otherSequence the other sequence
    * @return true if this sequence is a permutation of the other
    * sequence
    */
   public boolean isPermutationOf(Sequence otherSequence)
   {
      boolean isPermuationOfOtherSequence = false;
      Sequence firstSequence = new Sequence(this.values);
      Sequence secondSequence = new Sequence(otherSequence.values);
      int index = 0;
      while (index < firstSequence.size())
      {
         int firstSequenceElement = firstSequence.get(index);
         boolean matchNotFound = true;
         int position = 0;
         while (matchNotFound && position < secondSequence.size())
         {
            int secondSequenceElement = secondSequence.get(position);
            if (secondSequenceElement == firstSequenceElement)
            {
               matchNotFound = false;
               firstSequence.remove(index);
               secondSequence.remove(position);
            }
            position = position + 1;
         }
         if (matchNotFound)
         {
            index = index + 1;
         }
      }
      if (firstSequence.size() == 0 && secondSequence.size() == 0)
      {
         isPermuationOfOtherSequence = true;
      }
      return isPermuationOfOtherSequence;
   }

   /**
    * Removes an element at the specified index from the sequence
    * @param index the index of the element to remove
    */
   public void remove(int index)
   {
      int lastElementIndex = this.size() - 1;
      for (int position = index + 1; position < this.size(); position++)
      {
         this.values[position - 1] = this.values[position];
      }
      this.values = Arrays.copyOf(this.values, this.values.length - 1);
   }

   /**
    * Prints elements in this sequence separated by commas.
    */
   public void print()
   {
      for (int index = 0; index < this.size(); index++)
      {
         System.out.print(this.get(index));
         if (index < this.size() - 1)
         {
            System.out.print(", ");
         }
      }
   }

   /**
    * Yields the sum of this sequence and another.
    * If the sequences don't have the same length, it is assumed that missing
    * elements have a value of zero.
    * For example, the sum of
    * 1 4 9 16 9 7 4 9 11
    * and
    * 11 11 7 9 16 4 1
    * is the sequence
    * 12 15 16 25 25 11 5 9 11
    * @param other the other sequence to sum this sequence with
    * @return the sequence resulting from the sum of this sequence's values
    * and the other's
    */
   public Sequence sum(Sequence other)
   {
      Sequence longSequence = other;
      Sequence shortSequence = this;
      boolean thisSequenceIsLonger = this.size() > other.size();
      if (thisSequenceIsLonger)
      {
         longSequence = this;
         shortSequence = other;
      }
      Sequence sumSequence = new Sequence(longSequence.size());

      for (int index = 0; index < longSequence.size(); index++)
      {
         int longerSequenceElement = longSequence.values[index];
         int shorterSequenceElement = 0;
         if (index < shortSequence.size())
         {
            shorterSequenceElement = shortSequence.values[index];
         }
         int elementsSum = longerSequenceElement + shorterSequenceElement;
         sumSequence.values[index] = elementsSum;
      }

      return sumSequence;
   }
}
