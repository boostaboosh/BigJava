/**
 * A labelled point represents a point is two-dimensional space with a text label.
 */
public class LabelledPoint
{
   int x;
   int y;
   String label;

   public LabelledPoint(int x, int y, String label)
   {
      this.x = x;
      this.y = y;
      this.label = label;
   }

   public String toString()
   {
      return this.getClass().getName() + "[x=" + this.x + ",y=" + this.y + ",label=" + this.label + "]";
   }
}
