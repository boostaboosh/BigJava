/**
 * A car has a certain fuel efficiency and can drive 
 * using up fuel in its tank.
 */
public class Car 
{
	private double fuelEfficiencyInLitresPerKm;
	private double gasInTank;
	
	/**
	 * Construct a car with the specified fuel efficiency.
	 * @param fuelEfficiencyInLitresPerKm
	 */
	public Car(double fuelEfficiencyInLitresPerKm)
	{
		this.fuelEfficiencyInLitresPerKm = fuelEfficiencyInLitresPerKm;
		this.gasInTank = 0;
	}
	
	/**
	 * Drives a car for the specified distance using up fuel in the tank.
	 * @param distance the distance of the drive
	 */
	public void drive(double distance)
	{	
		double litersOfGasolineUsed = distance * fuelEfficiencyInLitresPerKm;
		gasInTank = gasInTank - litersOfGasolineUsed;
	}
	
	/**
	 * Returns the current amount of gasoline in the fuel tank.
	 * @return the amount of gasoline in the fuel tank
	 */
	public double getGasInTank()
	{
		return gasInTank;
	}
	
	/**
	 * Adds gasoline to the fuel tank.
	 * @param litersOfGas the number of litres of gasoline to add to the fuel tank
	 */
	public void addGas(double litresOfGas)
	{
		gasInTank = gasInTank + litresOfGas;
	}
}
