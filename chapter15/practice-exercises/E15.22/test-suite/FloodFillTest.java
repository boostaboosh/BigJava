import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class FloodFillTest
{
   @Test
   public void FloodFillTest()
   {
      final int sideLength = 10;
      int[][] square = new int[sideLength][sideLength];
      FloodFill.fill(square, new Pair(3, 4));

      int[][] expected = {
            {100, 99, 98, 97, 96, 95, 94, 93, 92, 91},
            { 81, 82, 83, 84, 85, 86, 87, 88, 89, 90},
            { 80, 79, 78, 77, 76, 75, 74, 73, 72, 71},
            {  5,  4,  3,  2,  1, 66, 67, 68, 69, 70},
            {  6, 65, 64, 63, 62, 61, 60, 59, 58, 57},
            {  7, 48, 49, 50, 51, 52, 53, 54, 55, 56},
            {  8, 47, 46, 45, 44, 43, 42, 41, 40, 39},
            {  9, 30, 31, 32, 33, 34, 35, 36, 37, 38},
            { 10, 29, 28, 27, 26, 25, 24, 23, 22, 21},
            { 11, 12, 13, 14, 15, 16, 17, 18, 19, 20}
      };

      Assert.assertArrayEquals("Square should be full", expected, square);
   }
}