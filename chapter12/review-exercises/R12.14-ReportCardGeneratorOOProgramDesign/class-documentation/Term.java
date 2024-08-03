/**
 * Represents a term or semester at an academic institution.
 * For example:
 * the Winter 2024 Term from 10th September 2024 to 10th January 2025.
 */
public class Term
{
   /**
    * Creates a term object from a term dates record.
    *
    * @param termDatesRecord a term dates record with the format:
    * 			     "semester start date (DD-MM-YY), semester end date (DD-MM-YY), semester short name"
    * 
    * 			     For example:
    * 			     "10-09-24, 10-01-25, Winter 2024"
    */ 
   public Term(String termDatesRecord)
   {
      // todo: fill implementation
   }
   
   public boolean equals(Object anotherObject)
   {
      // todo: fill implementation
   }
   
   /**
    * Gets this semester's name.
    *
    * @return the semester's name
    */
   public String getName()
   {
      // todo: fill implementation
   }
   
   /**
    * Gets this semester's start date.
    *
    * @return the semester's start date
    */
   public Date getStartDate()
   {
      // todo: fill implementation
   }
   
   /**
    * Gets this semester's end date.
    *
    * @return the semester's end date
    */
   public Date getEndDate()
   {
      // todo: fill implementation
   }
}
