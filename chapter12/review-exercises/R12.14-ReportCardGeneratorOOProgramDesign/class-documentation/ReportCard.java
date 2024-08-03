import java.util.ArrayList;

/**
 * Represents a report card.
 *
 * A student report card lists all classes, grades, and the GPA (Grade Point Average) for a semester.
 * And the report belongs to 1 student.
 * A report card contains the following information:
 * - the institution that released the report card
 * - the address of the institution that released the report card
 * - the student that the report referes to
 * - the term (semester) dates that the report refers to
 * - the subjects (classes) taken by the student during that term
 * - the grade obtained by the student in each subject (class)
 * - the average of the grades for all of the classes the student took that semester
 */
public class ReportCard
{
   /**
    * Creates a report card object from an institution, a term, and a student.
    * 
    * @param anInstitution the institution that releases the report card
    * @param aTerm the term, also knows as semester, during which the report class courses took place
    * @param aStudent the student to which the report card courses and grades apply
    */
   public ReportCard(Institution anInstitution, Term aTerm, Student aStudent)
   {
      // todo: fill implementation
   }
   
   /**
    * Gets the course-grades on this report card.
    *
    * @return the list of course-grade pairings on this report card
    */
   public ArrayList<CourseGrade> getCourseGrades()
   {
      // todo: fill implementation
   }
   
   /**
    * Gets the overall Grade Point Average (GPA), i.e. the average, of all grades on this report card.
    *
    * @return the average of the grades for all the courses on this report card
    */
   public Grade getGPA()
   {
      // todo: fill implementation
   }
   
   /**
    * Gets the institution which releases this report card.
    *
    * @return the institution which releases this report card
    */
   public Institution getInsitution()
   {
      // todo: fill implementation
   }
   
   /**
    * Gets the student whose grades are describes by this report card.
    *
    * @return the student whose grades are describes by this report card
    */
   public Student getStudent()
   {
      // todo: fill implementation
   }
   
   /**
    * Gets the term during which the courses on this report card took place.
    * 
    * @return the term during which the courses on this report card took place
    */
   public Term getTerm()
   {
      // todo: fill implementation
   }
}
