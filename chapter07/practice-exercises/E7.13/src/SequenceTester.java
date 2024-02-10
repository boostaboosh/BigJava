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

      System.out.println("sameValues method tests:");

      System.out.print(firstSequence.sameValues(identicalSequence));
      System.out.println(" Expected true");
      System.out.print(firstSequence.sameValues(differentSequence));
      System.out.println(" Expected false");

      int[] longArray = { 1, 4, 9, 16, 9, 7, 4, 9, 11 };
      Sequence longSequence = new Sequence(longArray);
      int[] shortArray = { 11, 11, 7, 9, 16, 4, 1 };
      Sequence shortSequence = new Sequence(shortArray);

      System.out.print(longSequence.sameValues(shortSequence));
      System.out.println(" Expected true");
   }
}
