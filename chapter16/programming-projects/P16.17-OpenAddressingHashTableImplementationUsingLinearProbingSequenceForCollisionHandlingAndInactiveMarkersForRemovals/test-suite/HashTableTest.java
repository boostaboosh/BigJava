import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

import static org.junit.Assert.*;

public class HashTableTest
{
    private HashTable hashTable;

    @org.junit.Before
    public void setUp() throws Exception
    {
        hashTable = new HashTable(5);
    }

    @org.junit.Test
    public void add()
    {
        hashTable.add("Alfie");
        Assert.assertTrue("table doesn't contain added item", hashTable.contains("Alfie"));
        hashTable.add("Bob");
        Assert.assertTrue("table doesn't contain added item", hashTable.contains("Bob"));
    }

    @Test
    public void addToFullTable()
    {
        addMany(hashTable, "Alfie", "Bob", "Carla", "David", "Ester", "Frank", "Greg");
        Assert.assertTrue("table doesn't contain added item", hashTable.containsAll(Set.of("Frank", "Greg")));

        Set set = createSet("Alfie", "Bob", "Carla", "David", "Ester", "Frank", "Greg");
        Assert.assertTrue("expected set contains all of hashTable items", set.containsAll(hashTable));
        Assert.assertTrue("expected hashTable contains all of set items", hashTable.containsAll(set));
        Assert.assertTrue("expected set and hashtable contain different number of items", hashTable.size() == set.size());
    }

    @org.junit.Test
    public void iterator() {
    }

    @org.junit.Test
    public void size() {
    }

    private void addMany(HashTable hashTable, Object... objects)
    {
        hashTable.addAll(Arrays.asList(objects));
    }

    private static Set createSet(Object... objects)
    {
        Set set = new TreeSet();
        for (Object object : objects)
        {
            set.add(object);
        }
        return set;
    }
}