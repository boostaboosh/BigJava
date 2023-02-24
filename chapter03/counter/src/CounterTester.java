/**
 * A class to test the Counter class.
 * @param args not used
 */
public class CounterTester 
{
	public static void main (String args[])
	{
		Counter counterOne = new Counter();
		Counter counterTwo = new Counter();
		
		counterOne.click();
		counterOne.click();
		counterOne.click();
		
		counterTwo.click();
		counterTwo.click();
		counterTwo.reset();
		
		
		System.out.println(counterOne.getValue());
		System.out.println("Expected: 3");
		
		System.out.println(counterTwo.getValue());
		System.out.println("Expected: 0");
	}
}
