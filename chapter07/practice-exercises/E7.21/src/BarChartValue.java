/**
 * BarChartValue objects represent values in a bar chart.
 * They can have captions associated with them.
 */
public class BarChartValue
{
   private int value;
   private String caption;

   /**
    * Constructs a bar chart value object.
    * @param value the value of the bar chart value
    * @param caption the caption which describes the bar chart value
    */
   public BarChartValue (int value, String caption)
   {
      this.value = Math.max(value, 0);
      this.caption = caption;
   }

   /**
    * Returns the value of this bar chart value
    * @return the value of this bar chart value
    */
   public int getValue()
   {
      return this.value;
   }

   /**
    * Returns the caption of this bar chart value
    * @return the caption of this bar chart value
    */
   public String getCaption()
   {
      return this.caption;
   }

   /**
    * Assigns this bar chart value a new value
    * @param value the new value to assign this bar chart value
    */
   public void setValue(int value)
   {
      this.value = value;
   }
}
