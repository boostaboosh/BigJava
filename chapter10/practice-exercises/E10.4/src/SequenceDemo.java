public class SequenceDemo
{
   public static void main(String[] args)
   {
      LastDigitDistribution dist1 = new LastDigitDistribution();
      dist1.process(new SquareSequence(), 1000);
      dist1.display();
      System.out.println();

      LastDigitDistribution distPowersOf2 = new LastDigitDistribution();
      distPowersOf2.process(Sequence.powersOf(2), 1000);
      distPowersOf2.display();
      System.out.println();

      LastDigitDistribution dist2 = new LastDigitDistribution();
      dist2.process(new RandomSequence(), 1000);
      dist2.display();
      System.out.println();

      LastDigitDistribution distMultiplesOf5 = new LastDigitDistribution();
      distMultiplesOf5.process(Sequence.multiplesOf(5), 1000);
      distMultiplesOf5.display();
      System.out.println();
   }
}

