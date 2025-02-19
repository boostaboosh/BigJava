import java.util.ArrayList;

public class SublistArrangementsGenerator
{
   /**
    * Generates and returns an array list containing all possible arrangements 
    * of the sequence of elements from the input list into lists of sublists.
    * <p> 
    * For example, the input: (2,8,4)
    * returns the output:
    * ((2,8,4), ((2),(8),(4)), ((2,8),(4)), ((2),(8,4))).
    * @param arrayList the input list
    * @return an array list containing all possible arrangements 
    * of the sequence of elements from the input list into lists of sublists.
    * If the input list is empty this method returns an empty list.
    */
   public static ArrayList<ArrayList<ArrayList<Integer>>> getSublistArrangements(ArrayList<Integer> arrayList)
   {
      ArrayList<ArrayList<ArrayList<Integer>>> sublistArrangements = new ArrayList<>();
      
      if (arrayList.isEmpty()) {
         return sublistArrangements;
      }
      else if (arrayList.size() == 1)
      {
         ArrayList<Integer> singleElementSublist = new ArrayList<>();
         singleElementSublist.add(arrayList.get(0));
         
         ArrayList<ArrayList<Integer>> singleSublistList = new ArrayList<>();
         singleSublistList.add(singleElementSublist);
         sublistArrangements.add(singleSublistList);
         
         return sublistArrangements;
      }
      else
      {
         ArrayList<Integer> simplifiedInputList = new ArrayList<>(arrayList);
         int removedLastElement = simplifiedInputList.remove(arrayList.size() - 1);
         
         /*
         for each list of sublists in solution for the start of the list 
            I want to add the following 2 lists of sublists to the solution for the whole of the list:
            1. a list which is the same with a single element sublist of the last element added to the end
            2. a list which is the same with the removed element added as the last element of the last sublist
          */
         ArrayList<ArrayList<ArrayList<Integer>>> previousArrangements = getSublistArrangements(simplifiedInputList);
         ArrayList<ArrayList<ArrayList<Integer>>> newArrangements = new ArrayList<>();
         
         for (ArrayList<ArrayList<Integer>> arrangement : previousArrangements)
         {
            newArrangements.add(addNewSublist(arrangement, removedLastElement));
            newArrangements.add(extendLastSublist(arrangement, removedLastElement));
         }
         
         return newArrangements;
      }
   }
   
   private static ArrayList<ArrayList<Integer>> addNewSublist(ArrayList<ArrayList<Integer>> arrangement, int elementToAdd)
   {
      ArrayList<Integer> newSublist = new ArrayList<>();
      newSublist.add(elementToAdd);
      
      ArrayList<ArrayList<Integer>> newArrangement = new ArrayList<>(arrangement);
      newArrangement.add(newSublist);
      
      return newArrangement;
   }

   private static ArrayList<ArrayList<Integer>> extendLastSublist(ArrayList<ArrayList<Integer>> arrangement, int elementToAdd)
   {
      ArrayList<Integer> lastSublist = arrangement.get(arrangement.size() - 1);
      
      ArrayList<Integer> extendedSublist = new ArrayList<>(lastSublist);
      extendedSublist.add(elementToAdd);
      
      ArrayList<ArrayList<Integer>> newArrangement = new ArrayList<>(arrangement);
      newArrangement.set(newArrangement.size() - 1, extendedSublist);
      
      return newArrangement;
   }
}
