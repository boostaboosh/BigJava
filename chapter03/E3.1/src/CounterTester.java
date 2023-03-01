/**
 * A class that tests the Counter class
 */
public class CounterTester
{
    public static void main(String[] args)
    {
        Counter counterOne = new Counter();
        counterOne.click();
        counterOne.click();
        System.out.println(counterOne.getValue());
        System.out.println("Expected: 2");
        counterOne.undo();
        counterOne.undo();
        counterOne.undo();
        System.out.println(counterOne.getValue());
        System.out.println("Expected: 0");
        counterOne.undo();
        counterOne.undo();
        counterOne.click();
        System.out.println(counterOne.getValue());
        System.out.println("Expected: 1");
    }
}
