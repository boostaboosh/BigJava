/**
 * A class for testing the Car class
 */
public class CarTester 
{
	public static void main(String[] args)
	{
		Car ferrariEnzo = new Car(3.4);
		ferrariEnzo.addGas(50);
		ferrariEnzo.drive(100);
		ferrariEnzo.addGas(55);
		ferrariEnzo.drive(25);
		double gasLeft = ferrariEnzo.getGasInTank();
		System.out.println(gasLeft);
		System.out.println("Expected: 68.2352941176");
	}
}
