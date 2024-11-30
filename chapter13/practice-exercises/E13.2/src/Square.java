public class Square
{
   private final int sideLength;
   
   public Square(int sideLength)
   {
      this.sideLength = sideLength;
   }
   
   public int getArea()
   {
      if (this.sideLength == 1)
      {
         return 1;
      }
      else
      {
         Square smaller = new Square(sideLength - 1);
         return sideLength * 2 - 1 + smaller.getArea();
      }
   }
}
