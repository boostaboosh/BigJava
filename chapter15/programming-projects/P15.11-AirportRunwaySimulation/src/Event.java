public class Event implements Comparable<Event>
{
    private final double processTime;

    public Event(double time)
    {
        this.processTime = time;
    }

    public double getTime()
    {
        return this.processTime;
    }

    public int compareTo(Event otherEvent)
    {
        return Double.compare(this.processTime, otherEvent.processTime);
    }
}
