/**
 * The measurer interface describes any class whose objects
 * can measure other objects.
 */
public interface Measurer<T>
{
   /**
    * Gets the meaurement of an object.
    * @param anObject the object to get the measurement of
    * @return the measurement of the object
    */
   double getMeasurement(T anObject);
}
