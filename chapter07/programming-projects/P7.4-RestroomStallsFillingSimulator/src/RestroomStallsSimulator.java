import java.util.Arrays;
import java.util.Scanner;

/**
 * This class contains a program which reads the numbers of stalls in a row in a restroom,
 * and prints out diagrams to indicate when stalls have become filled, one at a time.
 */
public class RestroomStallsSimulator
{
   private boolean[] rowOfStalls;

   /**
    * Starts the program.
    * @param args
    */
   public static void main(String[] args)
   {
      RestroomStallsSimulator simulator = new RestroomStallsSimulator();

      System.out.println("Enter number of stalls: ");
      Scanner scanner = new Scanner(System.in);

      final int TOTAL_NUMBER_OF_STALLS = scanner.nextInt();
      scanner.nextLine();
      simulator.rowOfStalls = new boolean[TOTAL_NUMBER_OF_STALLS];

      simulator.printRowOfStallsDiagram("_", "X");

      for (int numberOfStalls = 1; numberOfStalls <= TOTAL_NUMBER_OF_STALLS; numberOfStalls++)
      {
         simulator.fillAStall();
         simulator.printRowOfStallsDiagram("_", "X");
      }
   }

   /**
    * Prints a diagram of a row of stalls.
    * @param emptyStallSymbol the symbol for empty stalls
    * @param fullStallSymbol the symbol for full stalls
    */
   public void printRowOfStallsDiagram(String emptyStallSymbol, String fullStallSymbol)
   {
      for (boolean stallValue : this.rowOfStalls)
      {
         String stallSymbol = emptyStallSymbol;
         if (stallValue)
         {
            stallSymbol = fullStallSymbol;
         }
         System.out.print(stallSymbol);
      }
      System.out.println();
   }

   /**
    * Fills a stall in this restroom's row of stalls.
    */
   public void fillAStall()
   {
      int indexOfStallToFill = getIndexOfValueInMiddleOfLongestFalseSequence(this.rowOfStalls);
      this.rowOfStalls[indexOfStallToFill] = true;
   }

   /**
    * Returns the index of the element in the middle of the longest empty
    * sequence in the array.
    * @param array the array to find to search for the index in.
    * @return middleOfLongestEmptySequenceIndex
    */
   public int getIndexOfValueInMiddleOfLongestFalseSequence(boolean[] array)
   {
      int longestSequenceLength = 0;
      int longestSequenceStartingIndex = 0;
      int sequenceLength = 0;
      int sequenceStartingIndex = 0;
      int position = 0;
      boolean done = false;
      boolean trueValueFound = false;
      while (position < array.length && !done)
      {
         if (!array[position])
         {
            if (sequenceLength == 0)
            {
               sequenceStartingIndex = position;
            }
            sequenceLength = sequenceLength + 1;
            if (position == array.length - 1 && sequenceLength > longestSequenceLength)
            {
               longestSequenceLength = sequenceLength;
               longestSequenceStartingIndex = sequenceStartingIndex;
            }
         }
         else
         {
            trueValueFound = true;
            if (sequenceLength > longestSequenceLength)
            {
               longestSequenceLength = sequenceLength;
               longestSequenceStartingIndex = sequenceStartingIndex;
            }
            sequenceLength = 0;
            if ((array.length - (position + 1)) < longestSequenceLength)
            {
               done = true;
            }
         }
         if (!trueValueFound)
         {
            longestSequenceLength = sequenceLength;
         }
         position = position + 1;
      }

      int indexOfElementInMiddleOfFalseSequence = longestSequenceStartingIndex;
      int middleIndexOfArray = array.length / 2;
      if (longestSequenceLength > 2)
      {
         indexOfElementInMiddleOfFalseSequence =
               longestSequenceStartingIndex + Math.floorDiv(longestSequenceLength, 2);
         if (longestSequenceLength % 2 == 0 && indexOfElementInMiddleOfFalseSequence < middleIndexOfArray)
         {
            indexOfElementInMiddleOfFalseSequence = indexOfElementInMiddleOfFalseSequence - 1;
         }
      }
      else if (longestSequenceLength == 2)
      {
         if (longestSequenceStartingIndex > middleIndexOfArray)
         {
            indexOfElementInMiddleOfFalseSequence = longestSequenceStartingIndex + 1;
         }
      }
      return indexOfElementInMiddleOfFalseSequence;
   }
}
