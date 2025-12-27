import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class FloodFill
{
   public static void fill(int[][] pixels, Pair startPixel)
   {
      Stack<Pair> toFill = new Stack<>();
      toFill.push(startPixel);

      int coloredPixelCounter = 0;
      while (!toFill.empty()) {
         Pair pixel = toFill.pop();
         if (pixels[pixel.getRow()][pixel.getColumn()] == 0)
         {
            coloredPixelCounter++;
            pixels[pixel.getRow()][pixel.getColumn()] = coloredPixelCounter;
            for (Pair neighbor : getUnfilledNeighbors(pixel, pixels))
            {
               toFill.push(neighbor);
            }
         }
      }
   }

   private static Queue<Pair> getUnfilledNeighbors(Pair pixel, int[][] pixels)
   {
      Queue<Pair> neighbors = new LinkedList<>();
      neighbors.add(new Pair(pixel.getRow() - 1, pixel.getColumn()));
      neighbors.add(new Pair(pixel.getRow(), pixel.getColumn() + 1));
      neighbors.add(new Pair(pixel.getRow() + 1, pixel.getColumn()));
      neighbors.add(new Pair(pixel.getRow(), pixel.getColumn() - 1));

      Queue<Pair> validUnfilledNeighbors = new LinkedList<>();
      neighbors.forEach((neighbor) -> {
         if (isValid(neighbor, pixels)
               && pixels[neighbor.getRow()][neighbor.getColumn()] == 0)
         {
            validUnfilledNeighbors.add(neighbor);
         }
      });

      return validUnfilledNeighbors;
   }

   private static boolean isValid(Pair pixel, int[][] pixels)
   {
      int squareHeight = pixels.length;
      int squareWidth = pixels[0].length;

      return pixel.getRow() >= 0
            && pixel.getColumn() >= 0
            && pixel.getRow() < squareHeight
            && pixel.getColumn() < squareWidth;
   }
}
