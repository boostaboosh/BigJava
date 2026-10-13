import java.util.NoSuchElementException;

public class LinkedListIterator implements ListIterator
{
    private Node position;
    private Node previous;
    private boolean isAfterNext;
    private final LinkedList linkedList;

    /**
     Constructs an iterator that points to the front
     of the linked list.
     */
    public LinkedListIterator(LinkedList linkedList)
    {
        position = null;
        previous = null;
        isAfterNext = false;
        this.linkedList = linkedList;
    }

    /**
     Moves the iterator past the next element.
     @return the traversed element
     */
    public Object next()
    {
        if (!hasNext()) { throw new NoSuchElementException(); }
        previous = position; // Remember for remove
        isAfterNext = true;

        if (position == null)
        {
            position = linkedList.getFirstNode();
        }
        else
        {
            position = position.next;
        }

        return position.data;
    }

    /**
     Tests if there is an element after the iterator position.
     @return true if there is an element after the iterator position
     */
    public boolean hasNext()
    {
        if (position == null)
        {
            return linkedList.getFirstNode() != null;
        }
        else
        {
            return position.next != null;
        }
    }

    /**
     Adds an element before the iterator position
     and moves the iterator past the inserted element.
     @param element the element to add
     */
    public void add(Object element)
    {
        if (position == null)
        {
            linkedList.addFirst(element);
            position = linkedList.getFirstNode();
        }
        else
        {
            Node newNode = new Node();
            newNode.data = element;
            newNode.next = position.next;
            position.next = newNode;
            position = newNode;
        }

        isAfterNext = false;
    }

    /**
     Removes the last traversed element. This method may
     only be called after a call to the next() method.
     */
    public void remove()
    {
        if (!isAfterNext) { throw new IllegalStateException(); }

        if (position == linkedList.getFirstNode())
        {
            linkedList.removeFirst();
        }
        else
        {
            previous.next = position.next;
        }
        position = previous;
        isAfterNext = false;
    }

    /**
     Sets the last traversed element to a different value.
     @param element the element to set
     */
    public void set(Object element)
    {
        if (!isAfterNext) { throw new IllegalStateException(); }
        position.data = element;
    }
}
