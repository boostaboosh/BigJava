import java.awt.*;

/**
 * A labelled point represents a point is two-dimensional space with a text label.
 */
public class LabelledPoint
{
   Point point;
   String label;

   /**
    * Constructs a labelled point.
    * @param x the X coordinate
    * @param y the Y coordinate
    * @param label the text label of the point
    */
   public LabelledPoint(int x, int y, String label)
   {
      this.point = new Point(x, y);
      this.label = label;
   }

   public String toString()
   {
      return this.getClass().getName() + "[" + point.toString() + ",label=" + this.label + "]";
   }
}
