/**
 * A DatsSetTester tests the methods of the DataSet class
 * by using a DataSet object and outputting its expected
 * behaviour and its actual behaviour. This way we can
 * see if objects behave as expected.
 */
public class DataSetTester
{
   public static void main(String[] args)
   {
      DataSet dataset = new DataSet(3);
      dataset.add(3.5);
      dataset.add(2);
      dataset.add(-10.501);
      dataset.add(1);
      double sum = dataset.getSum();
      System.out.println("Expected sum is -5.01, actual is " + sum);
      double average = dataset.getAverage();
      System.out.println("Expected average is -1.669, actual is " + average);
      double maximum = dataset.getMaximum();
      System.out.println("Expected max is 3.5, actual is " + maximum);
      double minimum = dataset.getMinimum();
      System.out.println("Expected min is -10.501, actual is " + minimum);
   }
}
