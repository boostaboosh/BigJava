import java.util.ArrayList;

/**
   This class solves the eight queens problem using backtracking.
*/
public class EightQueens
{
   private static int solutionCounter = 0;
   private static ArrayList<String> seen = new ArrayList<>();

   public static void main(String[] args)
   {
      solve(new PartialSolution(0));
      System.out.println("Should be 12 unique solutions.");
   }

   /**
      Prints all solutions to the problem that can be extended from 
      a given partial solution.
      @param sol the partial solution
   */
   public static void solve(PartialSolution sol)
   {
      int exam = sol.examine();
      if (exam == PartialSolution.ACCEPT) 
      {
         String uniqueStringRepresentation = sol.getUniqueStringRepresentation(); // we'll define this
         if (!seen.contains(uniqueStringRepresentation)) {
            seen.add(uniqueStringRepresentation);
            System.out.printf("%d) %s\n", ++solutionCounter, sol);
         }
      }
      else if (exam == PartialSolution.CONTINUE)
      {
         for (PartialSolution p : sol.extend())
         {
            solve(p);
         }
      }
   }

}
