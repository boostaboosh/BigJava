package gui;

import ticTacToe.Cell.CellValue;
import javax.swing.*;
import java.awt.*;

public class BoardComponent extends JComponent
{
   private final int NUMBER_OF_COLUMN_CELLS = 3;
   private final int NUMBER_OF_ROW_CELLS = 3;
   private final int BOARD_WIDTH = 1000;
   private final int BOARD_HEIGHT = 1000;
   private Grid grid;
   private Cell[][] cells;

   public BoardComponent()
   {
      this.setPreferredSize(new Dimension(BOARD_WIDTH, BOARD_HEIGHT));

      grid = new Grid(BOARD_WIDTH, BOARD_HEIGHT);

      cells = new Cell[NUMBER_OF_COLUMN_CELLS][NUMBER_OF_ROW_CELLS];
      int cellWidth = BOARD_WIDTH/3;
      int cellHeight = BOARD_HEIGHT/3;
      int topLeftY = 0;
      for (int rowIndex = 0; rowIndex < cells.length; rowIndex++)
      {
         int topLeftX = 0;
         for (int columnIndex = 0; columnIndex < cells[0].length; columnIndex++)
         {
            cells[rowIndex][columnIndex] = new Cell(topLeftX, topLeftY, cellWidth, cellHeight);
            topLeftX = topLeftX + cellWidth;
         }
         topLeftY = topLeftY + cellHeight;
      }
   }

   public void paintComponent(Graphics graphics)
   {
      Graphics2D graphics2D = (Graphics2D) graphics;
      grid.draw(graphics2D);
      for (Cell[] cellRow : cells)
      {
         for (Cell cell : cellRow)
         {
            cell.draw(graphics2D);
         }
      }
   }

   /**
    * Gets the cell where the provided point is located.
    * @param point the point to find the containing cell of
    * @return the cell specified by row from 0 to 2,
    * and column from 0 to 2. For example, "11" is the middle cell.
    * Returns an empty String if the point is not located in a cell.
    */
   public String getCell(Point point)
   {
      String cellString = "";
      for (int rowIndex = 0; rowIndex < cells.length; rowIndex++)
      {
         for (int columnIndex = 0; columnIndex < cells[0].length; columnIndex++)
         {
            if (cells[rowIndex][columnIndex].getCellArea().contains(point))
            {
               cellString = "" + rowIndex + columnIndex;
            }
         }
      }
      return cellString;
   }

   /**
    * Draws the specified symbol in the specified cell on the board.
    * @param symbol the symbol to draw: O or X
    * @param move the cell to draw the symbol in specified by row from 0 to 2,
    *             and column from 0 to 2. For example, "11" is the middle cell
    */
   public void drawSymbol(CellValue symbol, String move)
   {
      int row = Integer.valueOf(move.substring(0, 1));
      int column = Integer.valueOf(move.substring(1, 2));
      Cell cell = cells[row][column];
      cell.setSymbol(symbol);
      repaint();
   }

   /**
    * Resets this board for a new game of tic-tac-toe.
    */
   public void resetBoard()
   {
      for (Cell[] cellRow : cells)
      {
         for (Cell cell : cellRow)
         {
            cell.setSymbol(CellValue.EMPTY);
         }
      }
      repaint();
   }
}
