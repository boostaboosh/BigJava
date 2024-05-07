import java.util.ArrayList;
import java.util.Scanner;

public class ScoreAnalyzer
{
   public static void main(String[] args)
   {
      Scanner in = new Scanner(System.in);
      ArrayList<String> students = ScoreAnalyzer.readStudentNames(in);
      double[] finalScores = ScoreAnalyzer.readAndComputeStudentScores(students, in);
      ScoreAnalyzer.printStudentFinalScores(students, finalScores);
   }

   /**
    * Prints students' final scores.
    * @param finalScores the final scores of students
    */
   public static void printStudentFinalScores(ArrayList<String> students, double[] finalScores)
   {
      for (int index = 0; index < students.size(); index++)
      {
         String studentName = students.get(index);
         System.out.println(studentName + "'s final score is: " + finalScores[index]);
      }
   }

   /**
    * Reads in students' scores and computes their final score
    * by dropping their lowest score.
    * @param students the array list of students to read and compute scores for
    * @param in the scanner to read input from
    * @return the final scores of each student
    */
   public static double[] readAndComputeStudentScores(ArrayList<String> students, Scanner in)
   {
      double[] finalScores = new double[students.size()];
      int finalScoresCurrentSize = 0;
      for (String student : students)
      {
         ArrayList<Double> quizScores = new ArrayList<>();
         System.out.println("Enter quiz scores for " + student + ", S to stop:");
         boolean done = false;
         while (!done)
         {
            System.out.println("Enter quiz score for " + student + ": ");
            String input = in.next();
            if (input.equalsIgnoreCase("S"))
            {
               done =true;
            }
            else
            {
               quizScores.add(Double.parseDouble(input));
            }
         }
         ArrayList<Double> removedWorstQuizScores = ScoreAnalyzer.removeLowest(quizScores);
         double finalScore = ScoreAnalyzer.computeAverageScore(removedWorstQuizScores);
         finalScores[finalScoresCurrentSize] = finalScore;
         finalScoresCurrentSize = finalScoresCurrentSize + 1;
      }
      return finalScores;
   }
   
   public static double computeAverageScore(ArrayList<Double> scores)
   {
      double sumOfScores = 0;
      for (double score : scores)
      {
         sumOfScores = sumOfScores + score;
      }
      return sumOfScores / scores.size();
   }

   /**
    * Creates an array list of scores from a given array list of scores,
    * with the lowest score from the original array list of scores removed.
    * @param quizScores the array list of scores to remove the lowest score from
    * @return an array list of scores with the lowest score removed
    */
   public static ArrayList<Double> removeLowest(ArrayList<Double> quizScores)
   {
      double EPSILON = 1E-14;
      ArrayList<Double> quizScoresRemovedLowest = new ArrayList<Double>();
      double lowestQuizScore = quizScores.get(0);
      for (double quizScore : quizScores)
      {
         if (quizScore - lowestQuizScore < -(EPSILON))
         {
            lowestQuizScore = quizScore;
         }
      }
      boolean lowestScoreFound = false;
      for (double quizScore : quizScores)
      {
         if (((Math.abs(quizScore - lowestQuizScore) < EPSILON)) && !lowestScoreFound)
         {
            lowestScoreFound = true;
         } else
         {
            quizScoresRemovedLowest.add(quizScore);
         }
      }
      return quizScoresRemovedLowest;
   }
   
   /**
    * Reads in student names from a scanner object.
    * @param scanner the scanner associated with the input stream to parse inputs from
    */
   public static ArrayList<String> readStudentNames(Scanner scanner)
   {
      ArrayList<String> students = new ArrayList<String>();
      System.out.println("Enter student names one at a time, Q to quit: ");
      boolean done = false;
      while (!done)
      {
         System.out.println("Enter student name: ");
         String input = scanner.nextLine();
         if (input.equalsIgnoreCase("Q"))
         {
            done = true;
         } else
         {
            students.add(input);
         }
      }
      return students;
   }
}
