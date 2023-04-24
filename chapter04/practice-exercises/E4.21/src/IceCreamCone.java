/**
 * An IceCreamCone computes its surface area and its volume given its height and radius.
 */
public class IceCreamCone
{
    // instance variables of IceCreamCone objects:
    private double radius;
    private double height;

    /**
     * Constructs an IceCreamCone with a given height and radius.
     * @param coneHeight the height of the ice cream cone
     * @param coneRadius the radius of the ice cream cone
     */
    public IceCreamCone(double coneHeight, double coneRadius)
    {
        height = coneHeight;
        radius = coneRadius;
    }

    /**
     * Gets the surface area of the ice cream cone not including the opening at the top.
     * @return the surface area of the cone excluding the opening at the top
     */
    public double getSurfaceArea()
    {
        // lateral side length = square root of radius squared + height squared
        double lateralSideLength = Math.sqrt(Math.pow(this.radius, 2) + Math.pow(this.height, 2));
        // curved surface area = pi * radius * lateral side length
        double curvedSurfaceArea = Math.PI * this.radius * lateralSideLength;

        // return curved surface area
        return curvedSurfaceArea;
    }

    /**
     * Gets the volume of the ice cream cone.
     * @return the volume of the ice cream cone
     */
    public double getVolume()
    {
        // cone volume = 1/3 * pi * radius squared * height
        double coneVolume = (Math.PI * Math.pow(this.radius, 2) * this.height) / 3.0;

        // return cone volume
        return coneVolume;
    }
}
