package gui;

import java.awt.*;

import ticTacToe.Cell.CellValue;

/**
 * A cell represents part of the tic-tac-toe board GUI
 * which shows either no symbol, a cross, or a circle.
 */
public class Cell
{
   private Rectangle cellArea;
   private CellValue symbol;
   private Font font;

   /**
    * Constructs an empty cell.
    */
   public Cell(int topX, int topY, int width, int height)
   {
      this.cellArea = new Rectangle(topX, topY, width, height);
      this.symbol = CellValue.EMPTY;
      this.font = new Font(Font.MONOSPACED, Font.BOLD, 350);
   }

   /**
    * Constructs a cell with the specified symbol.
    * @param symbol the symbol to set the cell to
    */
   public Cell(int topX, int topY, int width, int height, CellValue symbol)
   {
      this.cellArea = new Rectangle(topX, topY, width, height);
      this.symbol = symbol;
   }

   /**
    * Sets the symbol of this cell.
    * @param symbol the symbol to set this cell to
    */
   public void setSymbol(CellValue symbol)
   {
      this.symbol = symbol;
   }

   /**
    * Gets the rectangular pixel area of this cell.
    * @return the rectangle representing this cell's area
    */
   public Rectangle getCellArea()
   {
      return (Rectangle) this.cellArea.clone();
   }

   public void drawString(Graphics2D graphics2D, String string)
   {
      graphics2D.drawString(string, cellArea.x, Math.round(cellArea.y + cellArea.height * 0.8));
   }

   /**
    * Draws this cell.
    * @param graphics2D the Graphics2D object that renders the cell
    */
   public void draw(Graphics2D graphics2D)
   {
      graphics2D.setFont(this.font);
      switch (this.symbol)
      {
         case CROSS:
            graphics2D.setColor(Color.RED);
            drawString(graphics2D, "X");
            break;
         case CIRCLE:
            graphics2D.setColor(Color.BLUE);
            drawString(graphics2D, "O");
            break;
         case EMPTY:
            drawString(graphics2D, "");
            break;
      }
   }
}
