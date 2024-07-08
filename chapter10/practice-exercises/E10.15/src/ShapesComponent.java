import javax.swing.*;
import java.awt.*;
import java.awt.geom.Arc2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.util.Random;

public class ShapesComponent extends JComponent
{
   /**
    * Randomly generates an object that implements the Shape interface
    * in the Java library API.
    * @return a random shape object from the Shape interface in the Java
    * library API
    */
   public Shape randomShape()
   {
      Shape shape = null;
      Random randomNumberGenerator = new Random();
      int xPosition = randomNumberGenerator.nextInt(this.getWidth());
      int yPosition = randomNumberGenerator.nextInt(this.getHeight());
      int shapeWidth = randomNumberGenerator.nextInt(this.getWidth());
      int shapeHeight = randomNumberGenerator.nextInt(this.getHeight());
      int numberBetween1And4 = randomNumberGenerator.nextInt(4) + 1;
      if (numberBetween1And4 == 1)
      {
         // rectangle
         shape = new Rectangle
               (xPosition, yPosition, shapeWidth, shapeHeight);
      }
      else if (numberBetween1And4 == 2)
      {
         // ellipse
         shape = new Ellipse2D.Double
               (xPosition, yPosition, shapeWidth, shapeHeight);
      }
      else if (numberBetween1And4 == 3)
      {
         // line
         shape = new Line2D.Double
               (xPosition, yPosition, shapeWidth, shapeHeight);
      }
      else if (numberBetween1And4 == 4)
      {
         // arc
         shape = new Arc2D.Double
               (
                     xPosition,
                     yPosition,
                     shapeWidth,
                     shapeHeight,
                     45,
                     45,
                     Arc2D.PIE
               );
      }
      return shape;
   }

   public void paintComponent(Graphics g)
   {
      Graphics2D graphics2D = (Graphics2D) g;
      for (int counter = 1; counter <= 10; counter++)
      {
         Shape shape = randomShape();
         graphics2D.draw(shape);
      }
   }
}
