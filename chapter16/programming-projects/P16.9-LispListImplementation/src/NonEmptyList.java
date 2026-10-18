public class NonEmptyList implements LispList
{
    private Object head;
    private LispList tail;

    public NonEmptyList(Object head, LispList tail)
    {
        this.head = head;
        this.tail = tail;
    }

    @Override
    public boolean empty() {
        return false;
    }

    @Override
    public Object head() {
        return null;
    }

    @Override
    public LispList tail() {
        return null;
    }

    @Override
    public String toString()
    {
        // return getClass().getName() + "[head=" + head.toString() + ",tail=" + tail.toString() + "]";
        return head.toString() +" " + tail.toString();
    }
}
