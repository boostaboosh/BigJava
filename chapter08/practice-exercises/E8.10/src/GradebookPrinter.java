/**
 * A grade book printer prints the grades of multiple students inside a grade book.
 */
public class GradebookPrinter
{
   /**
    * The program starting point.
    * @param args the string array containing the program starting arguments
    */
   public static void main(String[] args)
   {
      GradebookMaker gradebookMaker = new GradebookMaker();
      Gradebook gradebook = gradebookMaker.makeGradebook();
      GradebookPrinter gradebookPrinter = new GradebookPrinter();
      gradebookPrinter.printFinalGrades(gradebook);
   }

   /**
    * Prints the final score for each student in the grade book.
    * @param gradebook the grade book to print final scores from
    */
   public void printFinalGrades(Gradebook gradebook)
   {
      for (Student student : gradebook.getStudents())
      {
         System.out.println(student.getName() + "'s final score is: " + student.getFinalScore());
      }
   }
}
