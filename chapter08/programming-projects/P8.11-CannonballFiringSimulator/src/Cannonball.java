import java.awt.geom.Point2D;
import java.util.ArrayList;

/**
 * Models a cannonball that is fired into the air in vacuum with earth's gravity pulling it downwards.
 */
public class Cannonball
{
   private static final double GRAVITATIONAL_ACCELERATION = 9.81;
   private final Point2D.Double position;
   private double xVelocity;
   private double yVelocity;
   
   /**
    * Constructs a cannonball with a given starting x position.
    * @param xPosition a given starting x position
    */
   public Cannonball(double xPosition)
   {
      this.position = new Point2D.Double();
      this.position.setLocation(xPosition, 0);
      this.xVelocity = 0;
      this.yVelocity = 0;
   }

   /**
    * Moves the ball to the next position.
    * @param deltaSeconds the time to move the ball for
    */
   public void move(double deltaSeconds)
   {
      // computing the next ball position on the horizontal axis
      double horizontalMovement = this.xVelocity * deltaSeconds;
      double newHorizontalPosition = this.position.getX() + horizontalMovement;
      
      // computing the next ball position on the vertical axis
      double initialVerticalVelocity = this.yVelocity;
      double changeInVerticalVelocity = GRAVITATIONAL_ACCELERATION * deltaSeconds;
      double finalVerticalVelocity = this.yVelocity - changeInVerticalVelocity; // minus because gravity is in opposite direction to Y
      double averageVerticalVelocity = (initialVerticalVelocity + finalVerticalVelocity) / 2.0;
      double verticalMovement = averageVerticalVelocity * deltaSeconds;
      double newVerticalPosition = this.position.getY() + verticalMovement;
      
      // making zero the lowest vertical position
      final double EPSILON = 1E-14;
      if (newVerticalPosition < EPSILON)
      {
         newVerticalPosition = 0;
         this.yVelocity = 0; // setting yVelocity to zero so that once ball reaches ground it doesn't keep decelerating on additional move calls
      }
      
      // moving the ball to the next position it reaches after the change in time (deltaSeconds)
      Point2D.Double nextPosition = new Point2D.Double(newHorizontalPosition, newVerticalPosition);
      this.setLocation(nextPosition);
      
      // updating the vertical velocity of the ball accounting for gravitational acceleration
      this.yVelocity = finalVerticalVelocity;
   }

   /**
    * Gets the current location of the cannonball.
    * @return the current location 
    */
   public Point2D.Double getLocation()
   {
      return new Point2D.Double(this.position.getX(), this.position.getY());
   }

   /**
    * Shoots a cannonball.
    * @param angleAlpha the shooting angle of the cannonball in degrees
    * @param initialVelocity the initial velocity of the cannonball when fired from the cannon
    * @param deltaSeconds the time interval at which ball positions are recorded
    * @return an array list of cannonball locations for each deltaSec time interval until y is zero
    */
   public ArrayList<Point2D.Double> shoot(double angleAlpha, double initialVelocity, double deltaSeconds)
   {
      double angleAlphaInRadians = angleAlpha * Math.PI / 180.0;
      final double EPSILON = 1E-14;
      this.xVelocity = initialVelocity * Math.cos(angleAlphaInRadians); // initial x velocity
      this.yVelocity = initialVelocity * Math.sin(angleAlphaInRadians); // initial y velocity
      ArrayList<Point2D.Double> ballLocations = new ArrayList<Point2D.Double>();
      do
      {
         this.move(deltaSeconds);
         Point2D.Double ballLocation = new Point2D.Double(this.position.getX(), this.position.getY());
         ballLocations.add(ballLocation); // todo: the same point object is added so all points are same
      }
      while (!(Math.abs(this.position.getY() - 0) < EPSILON));
      return ballLocations;
   }

   /**
    * Sets this cannonball's location.
    * @param location this cannonball's new location
    */
   public void setLocation(Point2D.Double location)
   {
      if (location != null)
      {
         this.position.setLocation(location);
      }
   }

   /**
    * Sets this cannonball's velocity in x and y directions.
    * @param xVelocity velocity in x direction
    * @param yVelocity velocity in y direction
    */
   public void setVelocity(double xVelocity, double yVelocity)
   {
      this.xVelocity = xVelocity;
      this.yVelocity = yVelocity;
   }
}
