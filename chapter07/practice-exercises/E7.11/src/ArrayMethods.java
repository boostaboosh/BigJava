/**
 * ArrayMethods objects complete tasks on an array of integers.
 */
public class ArrayMethods
{
   private int[] values;
   private int currentSize;

   /**
    * Constructs and ArrayMethods object.
    * @param initialValues the initial array of integers on which array methods
    *                      are performed
    */
   public ArrayMethods(int[] initialValues)
   {
      this.values = initialValues;
      this.currentSize = initialValues.length;
   }

   /**
    * Prints the values in the array.
    */
   public void print()
   {
      for (int index = 0; index < this.currentSize; index++)
      {
         int value = this.values[index];
         System.out.print(value + " ");
      }
      System.out.println();
   }

   /**
    * Swaps the first and last elements in the array.
    */
   public void swapFirstAndLast()
   {
      int first = this.values[0];
      int last = this.values[this.currentSize - 1];
      this.values[0] = last;
      this.values[this.currentSize - 1] = first;
   }

   /**
    * Shift all elements to the right by one position, and move the last
    * element into the first position. For example, 1 4 9 16 25 would be
    * transformed into 25 1 4 9 16.
    */
   public void shiftRight()
   {
      int last = this.values[this.currentSize - 1];
      for (int index = this.currentSize - 1; index > 0; index--)
      {
         this.values[index] = this.values[index - 1];
      }
      this.values[0] = last;
   }

   /**
    * Replaces all even elements with zero.
    */
   public void replaceAllEvenWithZero()
   {
      for (int index = 0; index < this.currentSize; index++)
      {
         if (this.values[index] % 2 == 0)
         {
            this.values[index] = 0;
         }
      }
   }

   /**
    * Replace each element except the first and last by the larger of its two
    * neighbours.
    */
   public void replaceMiddleWithLargestNeighbour()
   {
      int[] newArray = new int[this.currentSize];
      for (int index = 0; index < this.currentSize; index++)
      {
         if (index == 0 || index == this.currentSize - 1)
         {
            newArray[index] = this.values[index];
         }
         else
         {
            int leftNeighbour = this.values[index - 1];
            int rightNeighbour = this.values[index + 1];
            int largestNeighbour = Math.max(leftNeighbour, rightNeighbour);
            newArray[index] = largestNeighbour;
         }
      }
      this.values = newArray;
   }

   /**
    * Remove the middle element if the number of elements in the array is odd,
    * or remove the middle two elements if the number of elements in the array
    * is even.
    */
   public void removeMiddle()
   {
      boolean arrayLengthIsEven = this.currentSize % 2 == 0;
      int numberOfElementsToRemove = 1;
      int indexOfNextElementToRemove = this.currentSize / 2;
      if (arrayLengthIsEven)
      {
         numberOfElementsToRemove = 2;
         indexOfNextElementToRemove = indexOfNextElementToRemove - 1;
      }
      for (int removedElements = 0; removedElements < numberOfElementsToRemove; removedElements++)
      {
         for (int index = indexOfNextElementToRemove + 1; index < this.currentSize; index++)
         {
            this.values[index - 1] = this.values[index];
         }
         // indexOfNextElementToRemove = indexOfNextElementToRemove + 1; This is an error because when we remove an
                                                                      // element from an array, the indexes of the other
                                                                      // elements move back by one. So, the index of
                                                                      // the next elements we want to remove is the
                                                                      // same as the index of the element we removed
                                                                      // previously.
         this.currentSize = this.currentSize - 1;
      }
   }

   /**
    * Moves all even elements to the front, otherwise preserving the order of
    * the elements.
    */
   public void moveEvenToFront()
   {
      for (int index = 1; index < this.currentSize; index++)
      {
         int element = this.values[index];
         if (element % 2 == 0)
         {
            for (int evenIndex = index; evenIndex > 0; evenIndex--)
            {
               this.values[evenIndex] = this.values[evenIndex - 1];
            }
            this.values[0] = element;
         }
      }
   }

   /**
    * Returns the second-largest element in the array.
    * @return the second-largest element in the array
    */
   public int getSecondLargest()
   {
      int largest = this.values[0];
      int smallest = this.values[0];
      for (int index = 1; index < this.currentSize; index++)
      {
         if (this.values[index] > largest)
         {
            largest = this.values[index];
         }
         else if (this.values[index] < smallest)
         {
            smallest = this.values[index];
         }
      }

      int secondLargest = smallest;
      for (int index = 0; index < this.currentSize; index++)
      {
         if (this.values[index] < largest && this.values[index] > secondLargest)
         {
            secondLargest = this.values[index];
         }
      }
      return secondLargest;
   }

   /**
    * Returns true if the array is currently sorted in increasing order.
    * @return true if the array is currently sorted in increasing order
    */
   public boolean isSortedIncreasingOrder()
   {
      boolean isSortedIncreasingOrder = true;
      int previousElement = this.values[0];
      for (int index = 1; index < this.currentSize; index++)
      {
         if (this.values[index] < previousElement)
         {
            isSortedIncreasingOrder = false;
         }
      }
      return isSortedIncreasingOrder;
   }

   /**
    * Returns true if the array contains two adjacent duplicate elements.
    * @return true if the array contains two adjacent duplicate elements
    */
   public boolean hasAdjacentDuplicates()
   {
      boolean hasAdjacentDuplciates = false;
      // TODO: implementation filled in later
      return hasAdjacentDuplciates;
   }

   /**
    * Returns true if the array contains duplicate elements (which need not be
    * adjacent).
    * @return true if the array contains duplicate elements
    */
   public boolean hasDuplicates()
   {
      boolean hasDuplicates = false;
      // TODO: implementation filled in later
      return hasDuplicates;
   }
}