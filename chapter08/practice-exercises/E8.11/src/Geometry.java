import java.awt.geom.Ellipse2D;

public class Geometry
{
   /**
    * Computer the perimeter of an ellipse using Ramanujan's first approximation
    * @param e the ellipse
    * @return the approximate perimeter of the ellipse
    */
   public static double perimeter(Ellipse2D.Double e)
   {
      double semiMajorAxis = e.width / 2;
      double semiMinorAxis = e.height / 2;
      return 2 * Math.PI * Math.sqrt( ( Math.pow(semiMajorAxis, 2) + Math.pow(semiMinorAxis, 2) ) / 2 );
   }

   /**
    * Computer the area of an ellipse.
    * @param e the ellipse
    * @return the area of the ellipse
    */
   public static double area(Ellipse2D.Double e)
   {
      double semiMajorAxis = e.width / 2;
      double semiMinorAxis = e.height / 2;
      return Math.PI * semiMajorAxis * semiMinorAxis;
   }
}
