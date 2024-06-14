/**
 * A rectangle class that has getPerimeter and getArea methods
 */
public class BetterRectangle extends java.awt.Rectangle
{
   /**
    * Constructs a better rectangle.
    * @param xCoordinate the X coordinate of the upper left corner
    * @param yCoordinate the Y coordinate of the upper right corner
    * @param width the width
    * @param height the height
    */
   public BetterRectangle(int xCoordinate, int yCoordinate, int width, int height)
   {
      setLocation(xCoordinate, yCoordinate);
      setSize(width, height);
   }

   /**
    * Gets the perimeter of this rectangle.
    * @return the perimeter of this rectangle
    */
   public int getPerimeter()
   {
      return this.height * 2 + this.width * 2;
   }

   /**
    * Gets the area of this rectangle.
    * @return the area of this rectangle
    */
   public int getArea()
   {
      return this.height * this.width;
   }
}
