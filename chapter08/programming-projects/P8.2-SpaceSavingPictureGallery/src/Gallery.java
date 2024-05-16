import java.awt.Rectangle;
import java.util.ArrayList;

public class Gallery
{
   public static void main(String[] args)
   {
      ArrayList<Rectangle> rectangles = new ArrayList<>();
      
      final int MAX_WIDTH = 720;
      final int GAP = 10;
      final int PICTURES = 20;
      
      for (int i = 1; i <= PICTURES; i++)
      {
         Picture picture = new Picture();
         picture.load("picture" + i + ".jpg");
         boolean foundAPlaceThatFits = false;
         int topLeftY = 0;
         int topLeftX = 0;
         while (!foundAPlaceThatFits)
         {
            Rectangle newPictureRectangle = new Rectangle(topLeftX, topLeftY, picture.getWidth(), picture.getHeight() + GAP);
            if (intersects(newPictureRectangle, rectangles))
            {
               Rectangle intersectedRectangle = getIntersectedRectangleWithLowestYAndXCoordinates(
                     newPictureRectangle, 
                     rectangles);
               topLeftX = topLeftX + intersectedRectangle.width + GAP;
            }
            else if (newPictureRectangle.x + newPictureRectangle.getWidth() > MAX_WIDTH)
            {
               Rectangle nextLowestBottomEdgeRectangle = 
                     getLowestBottomEdgeRectangleWithBottomEdgeGreaterThanSpecifiedValue(topLeftY, rectangles);
               topLeftY = nextLowestBottomEdgeRectangle.y + nextLowestBottomEdgeRectangle.height;
               topLeftX = 0;
            }
            else
            {
               foundAPlaceThatFits = true;
               rectangles.add(newPictureRectangle);
            }
         }
         picture.move(topLeftX, topLeftY);
      }
   }

   private static Rectangle getLowestBottomEdgeRectangleWithBottomEdgeGreaterThanSpecifiedValue(
         int value, 
         ArrayList<Rectangle> rectangles)
   {
      Rectangle rectangleWithBottomEdgeWithLowestYValue = rectangles.get(0);
      
      for (Rectangle rectangle : rectangles)
      {
         int YValueOfBottomEdgeWithLowestYValue = 
               rectangleWithBottomEdgeWithLowestYValue.y + rectangleWithBottomEdgeWithLowestYValue.height;
         int rectangleBottomEdgeYCoordinate = rectangle.y + rectangle.height;
         if (rectangleBottomEdgeYCoordinate > value)
         {
            if (YValueOfBottomEdgeWithLowestYValue <= value)
            {
               rectangleWithBottomEdgeWithLowestYValue = rectangle;
            }
            else if (rectangleBottomEdgeYCoordinate < YValueOfBottomEdgeWithLowestYValue)
            {
               rectangleWithBottomEdgeWithLowestYValue = rectangle;
            }
         }
      }
      return rectangleWithBottomEdgeWithLowestYValue;
   }

   private static Rectangle getIntersectedRectangleWithLowestYAndXCoordinates(
         Rectangle newPictureRectangle,
         ArrayList<Rectangle> rectangles)
   {
      ArrayList<Rectangle> intersectedRectangles = new ArrayList<>();
      for (Rectangle rectangle : rectangles)
      {
         if (rectangle.intersects(newPictureRectangle))
         {
            intersectedRectangles.add(rectangle);
         }
      }
      
      Rectangle lowestXAndYRectangle = intersectedRectangles.get(0);
      for (Rectangle rectangle : intersectedRectangles)
      {
         int lowestXAndYRectangleSum = lowestXAndYRectangle.x + lowestXAndYRectangle.y;
         int y = rectangle.y;
         int x = rectangle.x;
         int xAndYSum = x + y;
         if (xAndYSum < lowestXAndYRectangleSum)
         {
            lowestXAndYRectangle = rectangle;
         }
      }
      
      return lowestXAndYRectangle;
   }

   public static boolean intersects(Rectangle r, ArrayList<Rectangle> rectangles)
   {
      boolean intersects = false;
      for (Rectangle rectangle : rectangles)
      {
         if (rectangle.intersects(r))
         {
            intersects = true;
         }
      }
      return intersects;
   }
}

