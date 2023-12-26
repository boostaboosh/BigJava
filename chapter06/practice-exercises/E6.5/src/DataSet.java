/**
 * A DataSet computes operations on a set of floating point values.
 */
public class DataSet
{
   private double largest;
   private double smallest;
   private double sum;
   private int numberOfValues;

   /**
    * Constructs a DataSet object.
    */
   public DataSet()
   {
      largest = 0;
      smallest = 0;
      sum = 0;
      numberOfValues = 0;
   }

   /**
    * Adds a floating point value to the set of values.
    * @param value the value to add to the set
    */
   public void add(double value)
   {
      this.numberOfValues = this.numberOfValues + 1;
      this.sum = this.sum + value;
      if (this.numberOfValues == 1)
      {
         this.largest = value;
         this.smallest = value;
      }
      else if (this.numberOfValues > 1)
      {
         if (value < this.smallest)
         {
            this.smallest = value;
         }
         else if (value > this.largest)
         {
            this.largest = value;
         }
      }
   }

   /**
    * Returns the average of values in the set.
    * @return the average of values in the set
    */
   public double getAverage()
   {
      double average = this.sum / this.numberOfValues;
      return average;
   }

   /**
    * Returns the smallest value in the set.
    * @return the smallest value
    */
   public double getSmallest()
   {
      return this.smallest;
   }

   /**
    * Returns the largest value in the set.
    * @return the largest value
    */
   public double getLargest()
   {
      return this.largest;
   }

   /**
    * Returns the range of values in the set, i.e., the difference between the largest and smallest values.
    * @return the range of values
    */
   public double getRange()
   {
      double range = this.largest - this.smallest;
      return range;
   }
}
