import java.util.AbstractSet;
import java.util.Iterator;

public class HashTable extends AbstractSet
{
//    U - U - U - U
//    item -> 1783297458 % bucket.length -> compressed hash code: 0 1 2 3
//    item in bucket with that index (compressed hash code
//        item -> item -> item
//
//            a   c   z   I   y   0   x   1
//    U - U - U - U - U - U - U - U - U - U
//    0 - 1 - 2 - 3 - 4 - 5 - 6 - 7 - 8 - 9 -10 -11
//            h - i - h2- j - i2- h3- j2- i3
//    h == i == j
//    h != h2
    private Object[] hashTable;
    private int size;

    public HashTable()
    {
        hashTable = new Object[10];
        size = 0;
    }

    /**
     * Creates an empty hash table with a backing table with a provided start length.
     * @param startLength the starting length of the backing table
     */
    public HashTable(int startLength)
    {
        hashTable = new Object[startLength];
        size = 0;
    }

    @Override
    public boolean add(Object item)
    {
        // todo
        return false;
    }
    @Override
    public Iterator iterator() {
        // todo
        return null;
    }

    @Override
    public int size() {
        // todo
        return 0;
    }
}
