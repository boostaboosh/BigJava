import org.junit.Test;
import org.junit.Assert;
import java.awt.geom.Point2D;
import java.util.ArrayList;

public class CannonballTest
{
   private static final double EPSILON = 1E-14;

   @Test public void movingACannonballWithZeroXVelocity()
   {
      Cannonball cannonball = new Cannonball(0);
      cannonball.setLocation(new Point2D.Double(0, 10));
      cannonball.move(1);
      Point2D.Double expectedLocation = new Point2D.Double();
      expectedLocation.setLocation(0, 5.095);
      Assert.assertEquals(expectedLocation.getX(), cannonball.getLocation().getX(), EPSILON);
      Assert.assertEquals(expectedLocation.getY(), cannonball.getLocation().getY(), EPSILON);
   }
   
   @Test public void movingACannonballWithVelocity()
   {
      Cannonball cannonball = new Cannonball(0);
      cannonball.setVelocity(10, 5);
      cannonball.move(1);
      Point2D.Double expectedLocation = new Point2D.Double();
      expectedLocation.setLocation(10, 0.095);
      Assert.assertEquals(expectedLocation.getX(), cannonball.getLocation().getX(), EPSILON);
      Assert.assertEquals(expectedLocation.getY(), cannonball.getLocation().getY(), EPSILON);
   }
   
   @Test public void movingACannonballTwiceSoThatItHitsTheGround()
   {
      Cannonball cannonball = new Cannonball(0);
      cannonball.setVelocity(10, 5);
      cannonball.move(1);
      cannonball.move(1);
      Point2D.Double expectedLocation = new Point2D.Double();
      expectedLocation.setLocation(20, 0);
      Assert.assertEquals(expectedLocation.getX(), cannonball.getLocation().getX(), EPSILON);
      Assert.assertEquals(expectedLocation.getY(), cannonball.getLocation().getY(), EPSILON);
   }
   
   @Test public void gettingACannonballLocation()
   {
      Cannonball cannonball = new Cannonball(0);
      Point2D.Double newLocation = new Point2D.Double();
      newLocation.setLocation(120.29, 75.432);
      cannonball.setLocation(newLocation);
      Point2D.Double expectedLocation = new Point2D.Double();
      expectedLocation.setLocation(120.29, 75.432);
      Assert.assertEquals(expectedLocation.getX(), cannonball.getLocation().getX(), EPSILON);
      Assert.assertEquals(expectedLocation.getY(), cannonball.getLocation().getY(), EPSILON);
   }
   
   @Test public void shootingACannonball()
   {
      final double EPSILON = 1E-2;
      Cannonball cannonball = new Cannonball(0);
      ArrayList<Point2D.Double> cannonballPoints = cannonball.shoot(26.57, 11.18, 1);
      ArrayList<Point2D.Double> expectedCannonballPoints = new ArrayList<>();
      Point2D.Double point1 = new Point2D.Double(10, 0.095);
      expectedCannonballPoints.add(point1);
      Point2D.Double point2 = new Point2D.Double(20, 0);
      expectedCannonballPoints.add(point2);
      for (int pointIndex = 0; pointIndex < expectedCannonballPoints.size(); pointIndex++)
      {
         Point2D.Double expectedPoint = expectedCannonballPoints.get(pointIndex);
         Point2D.Double actualPoint = cannonballPoints.get(pointIndex);
         int pointNumber = pointIndex + 1;
         Assert.assertEquals("X coordinate of point " + pointNumber + " should be the same.",
               expectedPoint.getX(), actualPoint.getX(), EPSILON);
         Assert.assertEquals("Y coordinate of point " + pointNumber + " should be the same.",
               expectedPoint.getY(), actualPoint.getY(), EPSILON);
      }
   }
}