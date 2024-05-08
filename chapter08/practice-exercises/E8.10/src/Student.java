import java.util.ArrayList;

/**
 * A student has multiple quiz scores.
 */
public class Student
{
   // instance variables
   private String name;
   private ArrayList<Double> scores;
   
   // constructors

   /**
    * Constructs a new student object.
    * @param name the name of the student
    */
   public Student(String name)
   {
      this.name = name;
      this.scores = new ArrayList<Double>();
   }
   
   // methods

   /**
    * Adds a score to a student's collection of scores.
    * @param score the score to add
    */
   public void addScore(double score)
   {
      this.scores.add(score);
   }

   /**
    * Computes a students final score with their worst score removed.
    * @return the student's final score
    */
   public double getFinalScore()
   {
      double sum = this.getSumOfScores();
      double lowestScore = this.getLowestScore();
      double sumWithoutLowestScore = sum - lowestScore;
      double averageScoreWithoutLowestScore = sumWithoutLowestScore / (this.scores.size() - 1);
      return averageScoreWithoutLowestScore;
   }

   /**
    * Gets the sum of this student's scores.
    * @return the sum of this student's scores
    */
   public double getSumOfScores()
   {
      double sum = 0;
      for (double score : this.scores)
      {
         sum = sum + score;
      }
      return sum;
   }

   /**
    * Gets this student's lowest score.
    * @return this student's lowest score
    */
   public double getLowestScore()
   {
      final double EPSILON = 1E-14;
      double lowestScore = Double.MAX_VALUE;
      for (double score : this.scores)
      {
         if (score - lowestScore < -EPSILON)
         {
            lowestScore = score;
         }
      }
      return lowestScore;
   }

   /**
    * Gets a student's name.
    * @return the name of the student
    */
   public String getName()
   {
      return this.name;
   }
}
