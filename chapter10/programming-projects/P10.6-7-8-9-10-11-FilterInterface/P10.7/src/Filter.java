public interface Filter
{
   /**
    * Checks if an object passes through this filter.
    * @param x the object to filter
    * @return true if the object is accepted through the filter
    */
   boolean accept(Object x);
}