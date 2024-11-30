public class Rectangle
{
   private int height;
   private int width;
   
   public Rectangle(int height, int width)
   {
      if (height < 0 || width < 0) { 
         throw new IllegalArgumentException(); 
      }
      this.height = height;
      this.width = width;
   }

   /**
    * Gets the area of this rectangle recursively
    * @return the area of this rectangle
    */
   public int getArea()
   {
      if (this.width == 1)
      {
         return this.height;
      } else
      {
         Rectangle smaller = new Rectangle(this.height, this.width - 1);
         return height + smaller.getArea();
      }
   }
}
