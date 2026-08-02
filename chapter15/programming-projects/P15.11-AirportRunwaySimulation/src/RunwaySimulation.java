import java.util.LinkedList;
import java.util.Queue;

public class RunwaySimulation // extends Simulation
{
    private Queue<Flight> takeoffQueue;
    private Queue<Flight> landQueue;
    private double currentTime;

    public RunwaySimulation()
    {
        takeoffQueue = new LinkedList<>();
        landQueue = new LinkedList<>();
        currentTime = 9 * 60; // 9am
    }

    public void next()
    {
        if (!landQueue.isEmpty())
        {
            Flight nextFlight = landQueue.remove();
            System.out.println("land " + nextFlight.flightSymbol + " at " + nextFlight.getTime());
        } else if (!takeoffQueue.isEmpty())
        {
            Flight nextFlight = takeoffQueue.remove();
            System.out.println("takeoff " + nextFlight.flightSymbol + " at " + nextFlight.getTime());
        } else {
            System.out.println("No landings or takeoffs due");
        }
    }

    public void addTakeoff(String flightSymbol)
    {
        currentTime = currentTime + expdist(5.0);
        takeoffQueue.add(new Flight(flightSymbol, currentTime));
    }

    public void addLand(String flightSymbol)
    {
        currentTime = currentTime + expdist(5.0);
        landQueue.add(new Flight(flightSymbol, currentTime));
    }

    public static double expdist(double meanTimeBetweenFlightEvents)
    {
        return -meanTimeBetweenFlightEvents * Math.log(1 - Math.random());
    }
}
