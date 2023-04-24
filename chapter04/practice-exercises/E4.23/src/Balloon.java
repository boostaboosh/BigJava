/**
 * A spherical balloon can be inflated by adding air to it.
 */
public class Balloon
{
    // instance variables
    double radius;

    /**
     * Constructs an empty balloon.
     */
    public Balloon()
    {
        this.radius = 0;
    }

    /**
     * Adds air in cubic centimetres to the balloon.
     * @param amount the amount of air in cubic centimetres to add to the balloon
     */
    public void addAir(double amount)
    {
        // oldVolume = (4/3.0) * PI * radius^3
        double oldVolume = 4 / 3.0 * Math.PI * Math.pow(this.radius, 3);
        // newVolume = oldVolume + amountToAdd
        double newVolume = oldVolume + amount;
        // newRadius = cubeRoot((3 * newVolume) / (4 * PI)) // derived from sphere volume formula: (4/3) * PI * r^3
        double newRadius = Math.cbrt((3 * newVolume) / (4 * Math.PI));
        this.radius = newRadius;
    }

    /**
     * Gets the volume of the balloon.
     * @return the volume of the balloon
     */
    public double getVolume()
    {
        // volume = (4/3) * PI * radius^3
        double volume = 4 / 3.0 * Math.PI * Math.pow(this.radius, 3);
        return volume;
    }

    /**
     * Get the surface area of the balloon.
     * @return the surface area of the balloon
     */
    public double getSurfaceArea()
    {
        // surfaceArea = 4 * PI * radius^2
        double surfaceArea = 4 * Math.PI * Math.pow(this.radius, 2);
        return surfaceArea;
    }

    /**
     * Get the radius of the balloon.
     * @return the radius of the balloon
     */
    public double getRadius()
    {
        return this.radius;
    }
}
