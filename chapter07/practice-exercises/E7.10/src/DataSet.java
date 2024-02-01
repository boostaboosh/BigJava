import java.util.ArrayList;

/**
 * Dataset objects store a number of values of type double.
 */
public class DataSet
{
   private ArrayList<Double> values;
   private int maximumNumberOfValues;

   /**
    * Constructs a new DataSet object with no values.
    */
   public DataSet(int maximumNumberOfValues)
   {
      this.values = new ArrayList<Double>();
      this.maximumNumberOfValues = maximumNumberOfValues;
   }

   /**
    * Adds a value to the data set, provided there is still room.
    * @param valueToAdd the value to add to the data set
    */
   public void add(double valueToAdd)
   {
      if (this.values.size() < this.maximumNumberOfValues)
      {
         values.add(valueToAdd);
      }
   }

   /**
    * Computes the sum of all elements in the data set.
    * @return the sum of all elements in the data set
    */
   public double getSum()
   {
      double sum = 0;
      for (double value : values)
      {
         sum = sum + value;
      }
      return sum;
   }

   /**
    * Computer the average of all elements in the data set.
    * @return the average of all elements in the data set
    */
   public double getAverage()
   {
      double average = this.getSum() / this.values.size();
      return average;
   }

   /**
    * Gets the highest value in the data set.
    * @return the highest value in the data set.
    */
   public double getMaximum()
   {
      double maximum = this.values.get(0);
      for (double value : values)
      {
         if (value > maximum)
         {
            maximum = value;
         }
      }
      return maximum;
   }

   /**
    * Gets the lowest value in the data set.
    * @return the lowest value in the data set
    */
   public double getMinimum()
   {
      double minimum = this.values.get(0);
      for (double value : values)
      {
         if (value < minimum)
         {
            minimum = value;
         }
      }
      return minimum;
   }
}
