import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class JavaIdentifierLineIndexer
{
   /**
    * Reads a Java source file and produces a line number index
    * of all identifiers in the file.
    * @param filename the name of the file to read the identifiers
    *                 of and index the lines of each one
    * @return a map which associates identifiers in the java source file
    * with the line numbers on which the identifier occurs in the file
    */
   public static Map<String, Set<Integer>> getIdentifierLineIndexes(String filename) throws FileNotFoundException
   {
      Map<String, Set<Integer>> indexedIdentifiers = new HashMap<>();

      Scanner inputReader = new Scanner(new File(filename));

      int lineCounter = 0;
      while (inputReader.hasNextLine())
      {
         lineCounter++;
         int lineNum = lineCounter;
         Set<String> identifiers = getIdentifiers(inputReader.nextLine());
         identifiers.forEach((identifier) ->
         {
//            if (indexedIdentifiers.get(identifier) == null)
//            {
//               indexedIdentifiers.put(identifier, Set.of(finalLineCounter));
//            }
//            else
//            {
//               TreeSet<Integer> newLines = new TreeSet<>(indexedIdentifiers.get(identifier));
//               newLines.add(finalLineCounter);
//               indexedIdentifiers.put(identifier, newLines);
//            }
            // above implementation using merge method:
            indexedIdentifiers.merge(identifier, new TreeSet<>(Set.of(lineNum)), (oldLineNums, newLineNum) ->
            {
               oldLineNums.addAll(newLineNum);
               return oldLineNums;
            });
         });
      }

      return indexedIdentifiers;
   }

   private static Set<String> getIdentifiers(String line)
   {
      Set<String> identifiers = new HashSet<>();
      String[] tokens = line.trim().split("[^A-Za-z0-9_]+");
      for (int index = 0; index < tokens.length; index++)
      {
         if (!tokens[index].isEmpty())
         {
            identifiers.add(tokens[index]);
         }
      }
      return identifiers;
   }
}
