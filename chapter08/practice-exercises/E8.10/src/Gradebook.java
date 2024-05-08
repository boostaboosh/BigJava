import java.util.ArrayList;

/**
 * A grade book contains quiz scores for multiple students.
 */
public class Gradebook
{
   // instance variables
   ArrayList<Student> students;
   
   // constructors

   /**
    * Constructs a grade book.
    */
   public Gradebook ()
   {
      this.students = new ArrayList<Student>();
   }
   
   // methods

   /**
    * Adds a student to a grade book.
    * @param student the student to add
    */
   public void addStudent(Student student)
   {
      this.students.add(student);
   }

   /**
    * Gets all students in a grade book.
    * @return an array list of all students in a grade book
    */
   public ArrayList<Student> getStudents()
   {
      return this.students;
   }
}
