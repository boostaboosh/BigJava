import org.junit.Assert;
import org.junit.Test;

public class TableTest
{
   @Test public void creatingATable()
   {
      Table table = new Table();
   }
   
   @Test public void gettingNumberOfRowsFromEmptyTable()
   {
      Table table = new Table();
      int expected = 0;
      Assert.assertEquals(expected, table.rows());
   }
   
   @Test public void gettingNumberOrColumnsFromEmptyTable()
   {
      Table table = new Table();
      int expected = 0;
      Assert.assertEquals(expected, table.columns());
   }
   
   @Test public void gettingEntryFromEmtpyTable()
   {
      Table table = new Table();
      String expected = null;
      Assert.assertEquals(expected, table.getEntry(0, 0));
   }
   
   @Test public void addOneLineWithSingleEntryWithoutCommasOrQuotationMarks()
   {
      Table table = new Table();
      String entry = "John Doe,";
      table.addLine(entry);
      String expected = "John Doe";
      Assert.assertEquals(expected, table.getEntry(0, 0));
   }
   
   @Test public void addOneLineWithEntriesSeparatedByCommas()
   {
      Table table = new Table();
      String entry = "Jane Doe,2004,2024";
      table.addLine(entry);
      String expected = "2024";
      Assert.assertEquals(expected, table.getEntry(0, 2));
   }
   
   @Test public void addOneLineWithSingleEntryWithComma()
   {
      Table table = new Table();
      String entry = "\"King Henry, III\",";
      table.addLine(entry);
      String expected = "King Henry, III";
      Assert.assertEquals(expected, table.getEntry(0, 0));
   }
   
   @Test public void addOneLineWithEntriesContainingInternalCommas()
   {
      Table table = new Table();
      String entry = "\"King Henry, III\",\"28 Oct, 1216\",\"16 Nov, 1272\"";
      table.addLine(entry);
      String expected = "28 Oct, 1216";
      Assert.assertEquals(expected, table.getEntry(0, 1));
   }
   
   @Test public void addOneLineWithEntryContainingQuotationMarks()
   {
      Table table = new Table();
      String entry = "\"Bonnie \"\"Prince\"\" Billy\",";
      table.addLine(entry);
      String expected = "Bonnie \"Prince\" Billy";
      Assert.assertEquals(expected, table.getEntry(0, 0));
   }
   
   @Test public void addOneLineWithEntriesContainingQuotationMarks()
   {
      Table table = new Table();
      String entry = "\"Jack \"\"the lion killer\"\"\",\"\"\"Jancember\"\" 1928\",\"\"\"Movember\"\" 1938\"";
      table.addLine(entry);
      String expected = "\"Movember\" 1938";
      Assert.assertEquals(expected, table.getEntry(0, 2));
   }
   
   @Test public void addOneLineWithEntryWithEnclosedCommasAndQuotationMarks()
   {
      Table table = new Table();
      String entry = "\"\"\"Iron\"\", Mike Tyson\",";
      table.addLine(entry);
      String expected = "\"Iron\", Mike Tyson";
      Assert.assertEquals(expected, table.getEntry(0, 0));
   }
   
   @Test public void  addOneLineWithEntriesWithEnclosedCommasAndQuotationMarks()
   {
      Table table = new Table();
      String entry = "\"\"\"Iron\"\", Mike Tyson\",\"June 30, 1966, \"\"Brooklyn\"\"\",\"\"\"n\\a\"\"\"";
      table.addLine(entry);
      String expected = "\"n\\a\"";
      Assert.assertEquals(expected, table.getEntry(0, 2));
   }

   @Test public void addLinesWithQuotationMarksAndCommasEnclosed()
   {
      Table table = new Table();
      String entryOne = "John Jacob Astor,1763,1848";
      String entryTwo = "\"William Backhouse Astor, Jr.\",1829,1892";
      String entryThree = "\"John Jacob \"\"Jakey\"\" Astor VI\",1912,1992";
      table.addLine(entryOne);
      table.addLine(entryTwo);
      table.addLine(entryThree);
      String expected = "John Jacob \"Jakey\" Astor VI";
      Assert.assertEquals(expected, table.getEntry(2, 0));
   }

   @Test public void gettingNumberOfRowsFromNonEmptyTableWithoutEnclosedCommasAndQuotations()
   {
      Table table = new Table();
      String entryOne = "John Jacob Astor,1763,1848";
      String entryTwo = "William Backhouse Astor Jr.,1829,1892";
      String entryThree = "John Jacob Jakey Astor VI,1912,1992";
      table.addLine(entryOne);
      table.addLine(entryTwo);
      table.addLine(entryThree);
      int expected = 3;
      Assert.assertEquals(expected, table.rows());
   }

   @Test public void gettingNumberOfColumnsFromNonEmptyTableWithoutEnclosedCommasAndQuotations()
   {
      Table table = new Table();
      String entryOne = "John Jacob Astor,1763,1848";
      String entryTwo = "William Backhouse Astor Jr.,1829,1892";
      String entryThree = "John Jacob Jakey Astor VI,1912,1992";
      table.addLine(entryOne);
      table.addLine(entryTwo);
      table.addLine(entryThree);
      int expected = 3;
      Assert.assertEquals(expected, table.columns());
   }

   @Test public void gettingNumberOfRowsFromNonEmptyTableWithEnclosedCommasAndQuotations()
   {
      Table table = new Table();
      String entryOne = "John Jacob Astor,1763,1848";
      String entryTwo = "\"William Backhouse Astor, Jr.\",1829,1892";
      String entryThree = "\"John Jacob \"\"Jakey\"\" Astor VI\",1912,1992";
      table.addLine(entryOne);
      table.addLine(entryTwo);
      table.addLine(entryThree);
      int expected = 3;
      Assert.assertEquals(expected, table.rows());
   }

   @Test public void gettingNumberOfColumnsFromNonEmptyTableWithEnclosedCommasAndQuotations()
   {
      Table table = new Table();
      String entryOne = "John Jacob Astor,1763,1848";
      String entryTwo = "\"William Backhouse Astor, Jr.\",1829,1892";
      String entryThree = "\"John Jacob \"\"Jakey\"\" Astor VI\",1912,1992";
      table.addLine(entryOne);
      table.addLine(entryTwo);
      table.addLine(entryThree);
      int expected = 3;
      Assert.assertEquals(expected, table.columns());
   }
}