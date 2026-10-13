/**
   A program that demonstrates the LinkedList class
*/
public class ListDemo
{  
   public static void main(String[] args)
   {  
      LinkedList staff = new LinkedList();

      int count = staff.size();
      compare(0, count, "empty list size is zero", "size was not zero");

      staff.addFirst("Tom");

      count = staff.size();
      compare(1, count, "1 item list size is 1", "size of single item list was not 1");

      staff.addFirst("Romeo");
      staff.addFirst("Harry");
      staff.addFirst("Diana");

      count = staff.size();
      compare(4, count, "4 item list size is 4", "expected size 4, actual size " + count);
      
      // | in the comments indicates the iterator position

      ListIterator iterator = staff.listIterator(); // |DHRT
      iterator.next(); // D|HRT
      iterator.next(); // DH|RT

      // Add more elements after second element
      
      iterator.add("Juliet"); // DHJ|RT
      iterator.add("Nina"); // DHJN|RT

      iterator.next(); // DHJNR|T

      // Remove last traversed element 

      iterator.remove(); // DHJN|T
     
      // Print all elements

      iterator = staff.listIterator();
      while (iterator.hasNext())
      {
         System.out.print(iterator.next() + " ");
      }
      System.out.println();
   }

   public static void compare (int expected, int actual, String testName, String errorMessage)
   {
      if (expected == actual)
      {
         System.out.println(testName + " PASSED");
      }
      else {
         System.out.println(testName + " FAILED: " + errorMessage);
      }
   }
}

