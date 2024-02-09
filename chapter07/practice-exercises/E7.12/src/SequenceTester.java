/**
 * A class for testing the Sequence class.
 */
public class SequenceTester
{
   /**
    * Starts the program.
    * @param args the program starting arguments
    */
   public static void main(String[] args)
   {
      Sequence firstSequence = new Sequence(4);
      firstSequence.set(0, 3);
      firstSequence.set(1, 2);
      firstSequence.set(2, 1);
      firstSequence.set(3, 0);
      System.out.print(firstSequence.size());
      System.out.println(" Expected: 4");
      System.out.print(firstSequence.get(3));
      System.out.println(" Expected: 0");

      int[] identicalArray = {3, 2, 1, 0};
      Sequence identicalSequence = new Sequence(identicalArray);
      int[] differentArray = {3, 2, 1, 0, 4};
      Sequence differentSequence = new Sequence(differentArray);

      System.out.print(firstSequence.equals(identicalSequence));
      System.out.println(" Expected true");
      System.out.print(firstSequence.equals(differentSequence));
      System.out.println(" Expected false");
   }
}
