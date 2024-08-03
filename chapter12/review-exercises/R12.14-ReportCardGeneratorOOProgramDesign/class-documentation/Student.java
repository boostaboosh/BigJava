import java.util.ArrayList;

/**
 * Represents a student at an academic institution.
 */
public class Student
{
   /**
    * Creates a student object from a student record.
    *
    * This constructor parses the student record string to extract the student name and student number.
    * The expected format of the student record is: "student name, student number".
    *
    * @param studentRecord a student record with the format:
    *                      "student name, student number"
    * 
    *                      For example:
    *                      "Gregory Jones, 616382"
    */
   public Student(String studentRecord)
   {
      // todo: fill implementation
   }
   
   /**
    * Adds a course grade to this student.
    *
    * @param courseGrade the course grade to add to this student
    */
   public void addCourseGrade(CourseGrade courseGrade)
   {
      // todo: fill implementation
   }
   
   /**
    * Gets a student's course grades for a particular term.
    *
    * @param term the term to get course grades for
    * @return a list of course grades for the specified term
    */
   public ArrayList<CourseGrade> getCourseGradesForTerm(Term term)
   {
      // todo: fill implementation
   }
   
   /**
    * Gets a student's name.
    *
    * @return the student's name
    */
   public String getName()
   {
      // todo: fill implementation
   }
   
   /**
    * Gets a student's student number.
    *
    * @return the student's student number
    */
   public int getStudentNumber()
   {
      // todo: fill implementation
   }
}
