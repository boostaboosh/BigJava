package gui;

import java.awt.*;
import java.awt.geom.Line2D;

public class Grid
{
   private int width;
   private int height;

   public Grid(int aWidth, int aHeight)
   {
      this.width = aWidth;
      this.height = aHeight;
   }

   public void draw(Graphics2D graphics2D)
   {
      int verticalLineXPos = 0;
      int horizontalLineYPos = 0;
      for (int lineCounter = 0; lineCounter < 2; lineCounter++)
      {
         verticalLineXPos = verticalLineXPos + Grid.this.width/3;
         graphics2D.draw(new Line2D.Double(verticalLineXPos , 0, verticalLineXPos , this.height));
         horizontalLineYPos = horizontalLineYPos + Grid.this.height/3;
         graphics2D.draw(new Line2D.Double(0, horizontalLineYPos, this.width, horizontalLineYPos));
      }
   }
}
