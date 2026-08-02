public class RunwayEvent extends Event
{
    private String flightSymbol;

    public RunwayEvent(double time, String flightSymbol)
    {
        super(time);
        this.flightSymbol = flightSymbol;
    }
}
