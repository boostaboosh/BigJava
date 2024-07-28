import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

public class MultiLevelWebPageHyperLinkPrinter
{
   public static void main(String[] args)
   {
      String webPageAddress;
      boolean multiLevelSearch;

      try
      {
         if (args.length == 1)
         {
            multiLevelSearch = false;
            webPageAddress = args[0];
         }
         else if (args.length == 2)
         {
            String option = args[0];
            if (option.equals("-m"))
            {
               multiLevelSearch = true;
            }
            else
            {
               throw new IOException("First of 2 arguments must be multilevel search option: -m");
            }
            webPageAddress = args[1];
         }
         else
         {
            throw new IOException("Expected 1 (web address) or 2 (multilevel search flag -m and web address) arguments.");
         }
      }
      catch(IOException e)
      {
         System.out.println(e.getMessage());
         return;
      }

      searchAndPrintLinks(webPageAddress, multiLevelSearch);
   }

   /**
    * Reads the contents of the provided webpage and searches for hyperlinks
    * which it prints.
    * If multi level search is active this method is also called on the webpages
    * linked to from the provided webpage.
    * @param address the address of the web page to search for links
    * @param multiLevelSearch if true the pages linked to from the provided webpage
    *                         will have this method invoked on themselves so
    *                         that the links in them will be searched and printed
    *                         recursively.
    */
   public static void searchAndPrintLinks(String address, boolean multiLevelSearch)
   {
      ArrayList<String> links = new ArrayList<>();
      searchLinks(links, address);
      printLinksAtAddress(links, address);
      if (multiLevelSearch)
      {
         for (String link : links)
         {
            searchAndPrintLinks(link, true);
         }
      }
   }

   /**
    * Searches a webpage for links and adds the hyperlinks to an arraylist.
    * @param links the arraylist to add the found links to
    * @param address the address of the webpage to serach for links
    */
   public static void searchLinks(ArrayList<String> links, String address)
   {
      try
      {
         URL pageLocation = new URL(address);
         try (Scanner pageReader = new Scanner(pageLocation.openStream()))
         {
            pageReader.useDelimiter("");
            String lastCharacters = "";
            while (pageReader.hasNext())
            {
               lastCharacters = lastCharacters + pageReader.next();
               boolean cannotBeLinkOrLinkFound = false;
               if
               (
                     lastCharacters.matches
                           ("<a\\s+[^>]*?href\\s*=\\s*\"[^\"]+\"[^>]*?>[\\s\\S]+?</a>")
                     || lastCharacters.matches
                           ("<a\\s+[^>]*?href\\s*=\\s*'[^']+'[^>]*?>[\\s\\S]+?</a>")
               )
               {
                  links.add(extractLinkFromTag(lastCharacters));
                  cannotBeLinkOrLinkFound = true;
               }
               else if
               (
                     lastCharacters.matches("\\s+")
                     || lastCharacters.matches("<[^a].*?>") // non link opening tag
                     || lastCharacters.matches("[\\s\\S]*?</.+?>") // element contents followed by closing tag
                     || lastCharacters.matches("<.+?>[\\s\\S]*?</.+?>") // any element with opening and closing tags
               )
               {
                  cannotBeLinkOrLinkFound = true;
               }
               if (cannotBeLinkOrLinkFound)
               {
                  lastCharacters = "";
               }
            }
         }
         catch (IOException e)
         {
            System.out.println("Error reading from webpage " + pageLocation + ": " + e.getMessage());
         }
      }
      catch (MalformedURLException e)
      {
         System.out.println("Bad URL format for address " + address + ": " + e.getMessage());
      }
   }

   public static void printLinksAtAddress(ArrayList<String> links, String address)
   {
      if (!links.isEmpty())
      {
         System.out.println("Hyperlinks found at " + address + ":");
         int linkPrintCounter = 1;
         for (String link : links)
         {
            System.out.println("#" + linkPrintCounter + ": " + link);
            linkPrintCounter++;
         }
      }
      else
      {
         System.out.println("No hyperlinks found at " + address + ".");
      }
   }

   /**
    * Extracts a hyperlink reference from an HTML hyperlink tag.
    * @param htmlTag an HTML hyperlink tag such as <a href="link">link text</a>
    * @return the hyperlink reference from the tag, i.e., the part between double
    * quotes after the href attribute in the HTML hyperlink tag
    */
   public static String extractLinkFromTag(String htmlTag)
   {
      String link = "";
      String sequence = "";
      boolean firstPartBeforeLinkRemoved = false;
      boolean extractionDone = false;
      for (int charIndex = 0; charIndex < htmlTag.length() && !extractionDone; charIndex++)
      {
         sequence = sequence + htmlTag.charAt(charIndex);
         if (sequence.matches("<a[^>]*?href\\s*?=\\s*?(\"|')"))
         {
            sequence = ""; // removes first part of tag before link
            firstPartBeforeLinkRemoved = true;
         }
         if (firstPartBeforeLinkRemoved && sequence.matches(".+?(\"|')"))
         {
            link = sequence.substring(0, sequence.length() - 1);
            extractionDone = true;
         }
      }
      return link;
   }
}
