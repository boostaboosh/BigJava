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
      ArrayList<ArrayList<ArrayList<Integer>>> listsOfSublists = new ArrayList<>();
      addSublistArrangements(new ArrayList<>(arrayList), listsOfSublists);
      return listsOfSublists;
   }

   /**
    * Adds all possible arrangements of the sequence of elements from the input list 
    * into lists of sublists.
    * <p> 
    * For example, the input: (2,8,4) and an empty list ((())))
    * mutates the empty list so that it becomes:
    * ((2,8,4), ((2),(8),(4)), ((2,8),(4)), ((2),(8,4))).
    * @param arrayList the input list
    * @param listsOfSublists an empty list to add sublist arrangements to
    */
   private static void addSublistArrangements(
         ArrayList<Integer> arrayList,
         ArrayList<ArrayList<ArrayList<Integer>>> listsOfSublists
   )
   {
      if (arrayList.isEmpty()) {}
      else if (arrayList.size() == 1)
      {
         ArrayList<Integer> singleElementSublist = new ArrayList<>();
         singleElementSublist.add(arrayList.get(0));
         
         ArrayList<ArrayList<Integer>> singleSublistList = new ArrayList<>();
         singleSublistList.add(singleElementSublist);
         listsOfSublists.add(singleSublistList);
      }
      else
      {
         ArrayList<Integer> simplifiedInputList = new ArrayList<>(arrayList);
         int removedLastElement = simplifiedInputList.get(arrayList.size() - 1);
         simplifiedInputList.remove(arrayList.size() - 1);
         
         ArrayList<ArrayList<ArrayList<Integer>>> solutionForStartOfList = getSublistArrangements(simplifiedInputList);
         
         /*
         for each list of sublists in solutionForStartOfList
            I want to add the following 2 lists of sublists to solutionForWholeList
            1. a list which is the same with a single element sublist of the last element added to the end
            2. a list which is the same with the removed element added as the last element of the last sublist
          */
         ArrayList<ArrayList<ArrayList<Integer>>> solutionForWholeList = new ArrayList<>();
         for (ArrayList<ArrayList<Integer>> listOfSublists : solutionForStartOfList)
         {
            ArrayList<Integer> removedElementSublist = new ArrayList<>();
            removedElementSublist.add(removedLastElement);
            
            ArrayList<ArrayList<Integer>> listOfSublistsWithRemovedLastElementAsLastSublist = new ArrayList<>(listOfSublists);
            listOfSublistsWithRemovedLastElementAsLastSublist.add(removedElementSublist);
            solutionForWholeList.add(listOfSublistsWithRemovedLastElementAsLastSublist);

            ArrayList<Integer> lastSublist = listOfSublists.get(listOfSublists.size() - 1);
            ArrayList<Integer> lastSublistWithRemovedElementAsLastElement = new ArrayList<>(lastSublist);
            lastSublistWithRemovedElementAsLastElement.add(removedLastElement);
            ArrayList<ArrayList<Integer>> listOfSublistsWithRemovedLastElementAddedToLastSublist = new ArrayList<>(listOfSublists);
            listOfSublistsWithRemovedLastElementAddedToLastSublist.set(listOfSublists.size() - 1, lastSublistWithRemovedElementAsLastElement);
            solutionForWholeList.add(listOfSublistsWithRemovedLastElementAddedToLastSublist);
         }
         /* replace contents of the list referenced by listsOfSublists parameter to contain the solution for the whole list
         Writing: 
            listsOfSublists = solutionForWholeList;
         would be a mistake because it does not add sublist arrangements to the list passed to the addSublistArrangements method,
         instead it changes the list referenced by the parameter variable, and has no effect on the list whose reference we
         passed into the addSublistArrangements method.
         This is because Java is pass by value, which means the value of arguments is copied and assigned to parameter variables,
         but the parameter variables are not references to the same variable passed to their methods, which would be a 
         characteristic of a pass by reference language. 
         What this means is that we need to mutate the list whose object reference value 
         was copied into our listsOfSublists parameter variable, like below:
          */
         listsOfSublists.clear();
         listsOfSublists.addAll(solutionForWholeList);
      }
   }
}
