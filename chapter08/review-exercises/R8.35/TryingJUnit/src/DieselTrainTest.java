import org.junit.Test;
import org.junit.Assert;

public class DieselTrainTest
{
   @Test public void move()
   {
      DieselTrain train = new DieselTrain();
      train.move(30.67);
      double expected = 30.67;
      final double EPSILON = 1E-14;
      Assert.assertEquals(expected, train.getDistanceFromTerminus(), EPSILON);
   }
   
   @Test public void moveTwice()
   {
      DieselTrain train = new DieselTrain();
      train.move(10);
      train.move(10);
      double expected = 20;
      final double EPSILON = 1E-14;
      Assert.assertEquals(expected, train.getDistanceFromTerminus(), EPSILON);
   }
}
