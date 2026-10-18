public interface LispList
{
    LispList NIL = new EmptyList();

    /**
     * Constructs a new list with this list as its tail
     * @param head the element to place at the start of the new list
     * @return the new list
     */
    default LispList cons(Object head)
    {
        return new NonEmptyList(head, this);
    }

    boolean empty();
    Object head();
    LispList tail();
}
