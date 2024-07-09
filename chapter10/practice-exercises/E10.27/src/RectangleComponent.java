import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import javax.swing.JComponent;

/**
   This component displays a rectangle that can be moved. 
*/
public class RectangleComponent extends JComponent
{  
   private static final int BOX_X = 100;
   private static final int BOX_Y = 100;
   private static final int BOX_WIDTH = 20;
   private static final int BOX_HEIGHT = 30;

   private enum HorizontalDirection { LEFT, RIGHT }
   private enum VerticalDirection { UP, DOWN }

   private HorizontalDirection horizontalDirection;
   private VerticalDirection verticalDirection;
   private Rectangle box;

   public RectangleComponent()
   {
      horizontalDirection = HorizontalDirection.RIGHT;
      verticalDirection = VerticalDirection.DOWN;
      // The rectangle that the paintComponent method draws 
      box = new Rectangle(BOX_X, BOX_Y, BOX_WIDTH, BOX_HEIGHT);
   }

   public void paintComponent(Graphics g)
   {  
      Graphics2D g2 = (Graphics2D) g;
      g2.draw(box);
   }

   /**
      Moves the rectangle by a given amount. 
      @param dx the amount to move in the x-direction 
      @param dy the amount to move in the y-direction 
   */
   public void moveRectangleBy(int dx, int dy)
   {
      int leftEdge = (int) box.getX();
      if (leftEdge <= 0)
      {
         this.horizontalDirection = HorizontalDirection.RIGHT;
      }

      int rightEdge = (int) (box.getX() + box.getWidth());
      if (rightEdge >= this.getWidth() - 1)
      {
         this.horizontalDirection = HorizontalDirection.LEFT;
      }

      int topEdge = (int) box.getY();
      if (topEdge <= 0)
      {
         this.verticalDirection = VerticalDirection.DOWN;
      }

      int bottomEdge = (int) (box.getY() + box.getHeight());
      if (bottomEdge >= this.getHeight() - 1)
      {
         this.verticalDirection = VerticalDirection.UP;
      }

      if (this.horizontalDirection == HorizontalDirection.LEFT)
      {
         dx = -dx;
      }

      if (this.verticalDirection == VerticalDirection.UP)
      {
         dy = -dy;
      }

      box.translate(dx, dy);
      repaint();      
   }
}

