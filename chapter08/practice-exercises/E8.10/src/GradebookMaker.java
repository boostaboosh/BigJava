import java.util.Scanner;

/**
 * A grade book maker prompts the user for input about student quiz scores so that it can make a grade book.
 */
public class GradebookMaker
{
   // instance variables
   // constructor
   // methods

   /**
    * Asks user to input student names and grades in order to create a grade book.
    * @return a grade book containing the user inputted students and grades
    */
   public Gradebook makeGradebook()
   {
      Gradebook gradebook = new Gradebook();
      Scanner inputStreamReader = new Scanner(System.in);
      this.addStudentNamesFromInput(gradebook, inputStreamReader);
      this.addStudentScoresFromInput(gradebook, inputStreamReader);
      return gradebook;
   }

   /**
    * Asks user to input student names.
    * @param gradebook the grade book of students to add student names to
    * @param inputStreamReader the input stream scanner to get input from
    */
   public void addStudentNamesFromInput(Gradebook gradebook, Scanner inputStreamReader)
   {
      System.out.println("Enter student names, S to stop: ");
      boolean done = false;
      while (!done)
      {
         System.out.print("Enter student name, or S to stop: ");
         String nextLine = inputStreamReader.nextLine();
         if (nextLine.equalsIgnoreCase("S"))
         {
            done = true;
         } else
         {
            String studentName = nextLine;
            gradebook.addStudent(new Student(studentName));
         }
      }
   }

   /**
    * Asks user to input quiz scores for each student.
    * @param gradebook the grade book of students to add scores to
    * @param inputStreamReader the input stream scanner to get input from
    */
   public void addStudentScoresFromInput(Gradebook gradebook, Scanner inputStreamReader)
   {
      for (Student student : gradebook.getStudents())
      {
         System.out.println("Enter quiz scores for student " + student.getName() + ", S to stop: ");
         boolean done = false;
         while (!done)
         {
            System.out.print("Enter quiz score, or S to stop: ");
            String nextLine = inputStreamReader.nextLine();
            if (nextLine.equalsIgnoreCase("S"))
            {
               done = true;
            }
            else
            {
               double quizScore = Double.parseDouble(nextLine);
               student.addScore(quizScore);
            }
         }
      }
   }
}
