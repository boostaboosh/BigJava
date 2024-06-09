import java.awt.geom.Point2D;
import java.util.ArrayList;

/**
 * Cannon ball firing simulator
 */
public class CannonballFiringSimulator
{
   /**
    * Starts the program.
    * @param args starting arguments for the program
    */
   public static void main(String[] args)
   {
      CannonballFiringSimulator simulator = new CannonballFiringSimulator();
      simulator.runSimulator();
   }

   /**
    * Runs the cannonball firing simulator.
    */
   public void runSimulator()
   {
      boolean done = false;
      while (!done)
      {
         UserOutputPrinter.printLine("Do you want to simulate a cannonball being fired? (y/n)");
         if (UserInputGetter.getBooleanValue())
         {
            this.runSimulation();
         }
         else
         {
            done = true;
         }
      }
   }

   /**
    * Runs a simulation of a cannonball being fired.
    */
   public void runSimulation()
   {
      UserOutputPrinter.printLine("Running a cannonball firing simulation.");
      UserOutputPrinter.printLine("Enter a starting angle:");
      double startingAngle = UserInputGetter.getDoubleValue();
      UserOutputPrinter.printLine("Enter an initial velocity:");
      double initialVelocity = UserInputGetter.getDoubleValue();
      UserOutputPrinter.printLine("Enter the duration in seconds of the time " 
            + "interval at which to get cannonball locations:");
      double timeInterval = UserInputGetter.getDoubleValue();
      Cannonball cannonball = new Cannonball(0);
      ArrayList<Point2D.Double> cannonballPositions = cannonball.shoot(startingAngle, initialVelocity, timeInterval);
      for (int positionsIndexCounter = 0; positionsIndexCounter < cannonballPositions.size(); positionsIndexCounter++)
      {
         int numberOfIntervals = positionsIndexCounter + 1;
         double timePassed = numberOfIntervals * timeInterval;
         Point2D.Double position = cannonballPositions.get(positionsIndexCounter);
         UserOutputPrinter.printLine("interval " + numberOfIntervals + ":");
         String outputLine = "After " + timePassed + " seconds the cannonball's location is " 
               + "x: " + position.getX() + ", y: " + position.getY() + ".";
         UserOutputPrinter.printLine(outputLine);
      }
   }
}
