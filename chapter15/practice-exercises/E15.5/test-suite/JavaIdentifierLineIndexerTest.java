import org.junit.Assert;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static org.junit.Assert.*;

public class JavaIdentifierLineIndexerTest
{
   @Test
   public void GivenAJavaSourceFile_WhenLineIndexingIdentifiers_ThenCorrectLinesAreReturnedForEachIdentifier() throws FileNotFoundException
   {
      Map<String, Set<Integer>> actualIdentifierIndex =
            JavaIdentifierLineIndexer.getIdentifierLineIndexes("test-suite/TestFile.java");

      Map<String, Set<Integer>> expectedIndex = new HashMap<>();
      expectedIndex.put("import", Set.of(1));
      expectedIndex.put("java", Set.of(1));
      expectedIndex.put("util", Set.of(1));
      expectedIndex.put("public", Set.of(4, 6, 14));
      expectedIndex.put("class", Set.of(4));
      expectedIndex.put("TestFile", Set.of(4));
      expectedIndex.put("static", Set.of(6, 14));
      expectedIndex.put("void", Set.of(6));
      expectedIndex.put("main", Set.of(6));
      expectedIndex.put("String", Set.of(6));
      expectedIndex.put("args", Set.of(6));
      expectedIndex.put("for", Set.of(8, 17, 19, 22));
      expectedIndex.put("int", Set.of(8, 14, 17, 19, 22));
      expectedIndex.put("num", Set.of(8, 10, 14, 17, 19, 22));
      expectedIndex.put("new", Set.of(8, 16));
      expectedIndex.put("TreeSet", Set.of(8));
      expectedIndex.put("getPrimes", Set.of(8, 14));
      expectedIndex.put("100", Set.of(8));
      expectedIndex.put("System", Set.of(10));
      expectedIndex.put("out", Set.of(10));
      expectedIndex.put("println", Set.of(10));
      expectedIndex.put("Set", Set.of(14, 16));
      expectedIndex.put("Integer", Set.of(14, 16));
      expectedIndex.put("nums", Set.of(16, 17, 21, 22, 25));
      expectedIndex.put("HashSet", Set.of(16));
      expectedIndex.put("number", Set.of(17));
      expectedIndex.put("2", Set.of(17, 19));
      expectedIndex.put("add", Set.of(17));
      expectedIndex.put("root", Set.of(19, 21, 22));
      expectedIndex.put("if", Set.of(21));
      expectedIndex.put("contains", Set.of(21));
      expectedIndex.put("continue", Set.of(21));
      expectedIndex.put("multiple", Set.of(22));
      expectedIndex.put("remove", Set.of(22));
      expectedIndex.put("return", Set.of(25));

      Assert.assertEquals(expectedIndex, actualIdentifierIndex);
   }
}
