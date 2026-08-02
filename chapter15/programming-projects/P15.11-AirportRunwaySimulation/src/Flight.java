public class Flight extends Event
{
    public String flightSymbol;

    public Flight(String flightSymbol, double eventTime)
    {
        super(eventTime);
        this.flightSymbol = flightSymbol;
    }
}
