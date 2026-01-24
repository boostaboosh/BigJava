import java.util.Collection;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;

public class StudentsGradeManager
{
   private final Map<Integer, GradedStudent> gradedStudentsById;

   public StudentsGradeManager()
   {
      this.gradedStudentsById = new HashMap<>();
   }

   public StudentsGradeManager(GradedStudent... startingGradedStudents)
   {
      this.gradedStudentsById = new HashMap<>();

      for (GradedStudent gradedStudent : startingGradedStudents)
      {
         addGradedStudent(gradedStudent);
      }
   }

   /**
    * Adds a student and their course grade to this grade manager.
    * @param gradedStudent the graded student to add
    */
   public void addGradedStudent(GradedStudent gradedStudent)
   {
      gradedStudentsById.put(gradedStudent.getStudent().getId(), gradedStudent);
   }

   /**
    * Removes a student from the students grade manager.
    * @param student the student to remove
    */
   public void removeGradedStudent(Student student)
   {
      gradedStudentsById.remove(student.getId());
   }

   /**
    * Changes a student's grade.
    * @param student the student whose grade will be changed
    * @param newGrade the student's new grade
    * @throws NoSuchStudentException if the student doesn't exist in this grade manager
    */
   public void modifyStudentGrade(Student student, String newGrade) throws NoSuchStudentException
   {
      GradedStudent gradedStudent = gradedStudentsById.get(student.getId());
      if (gradedStudent == null)
      {
         throw new NoSuchStudentException("Non existent student: " + student);
      }
      gradedStudent.setGrade(newGrade);
   }

   /**
    * Gets all graded students.
    * @return all graded students in this graded students manager
    */
   public Collection<GradedStudent> getAllGradedStudents()
   {
      return new ArrayList<>(gradedStudentsById.values());
   }

   /**
    * Gets a student by their last name
    * @param lastName the last name of the student
    * @return the student with that last name
    * @throws NoSuchStudentException if no such student exists
    * @throws DuplicateLastNameException if more than 1 student has that last name
    */
   public Student getStudentByLastName(String lastName) throws NoSuchStudentException, DuplicateLastNameException
   {
      GradedStudent match = null;

      for (GradedStudent gradedStudent : this.gradedStudentsById.values())
      {
         if (gradedStudent.getStudent().getLastName().equals(lastName))
         {
            if (match != null) throw new DuplicateLastNameException("more than 1 student has last name: " + lastName);
            match = gradedStudent;
         }
      }

      if (match == null) throw new NoSuchStudentException("No student exists with surname: " + lastName);
      return match.getStudent();
   }

   /**
    * Gets a student by their first and last name
    * @param firstName the first name of the student
    * @param lastName the last name of the student
    * @return the student with the provided first and last name
    * @throws NoSuchStudentException if no such students exists
    * @throws DuplicateFirstAndLastNamesException if more than 1 student have the same first and last name
    */
   public Student getStudentByFirstAndLastName(String firstName, String lastName) throws NoSuchStudentException, DuplicateFirstAndLastNamesException
   {
      GradedStudent match = null;

      for (GradedStudent gradedStudent : this.gradedStudentsById.values())
      {
         Student student = gradedStudent.getStudent();
         if (student.getLastName().equals(lastName) && student.getFirstName().equals(firstName))
         {
            if (match != null) throw new DuplicateFirstAndLastNamesException("more than 1 student has last name: " + lastName + ", and first name: " + firstName);
            match = gradedStudent;
         }
      }

      if (match == null) throw new NoSuchStudentException("No student exists with last name: " + lastName + ", and first name: " + firstName);
      return match.getStudent();
   }

   /**
    * Returns the student with the given ID.
    * @param id the id of the student to return
    * @return the student with the provided id
    * @throws NoSuchStudentException if no student exists with the provided id
    */
   public Student getStudentById(int id) throws NoSuchStudentException
   {
      GradedStudent gradedStudent = gradedStudentsById.get(id);
      if (gradedStudent == null)
      {
         throw new NoSuchStudentException("No student exists in grade manager with id:" + id);
      }
      return gradedStudent.getStudent();
   }

}
