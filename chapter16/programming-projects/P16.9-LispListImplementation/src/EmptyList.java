public class EmptyList implements LispList
{

    @Override
    public boolean empty() {
        return true;
    }

    @Override
    public Object head() {
        throw new UnsupportedOperationException();
    }

    @Override
    public LispList tail() {
        throw new UnsupportedOperationException();
    }

    @Override
    public String toString()
    {
        // return getClass().getName()+"[]";
        return "";
    }
}
