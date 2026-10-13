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

      count = staff.size();
      compare(6, count, "6 item list size is 6 after 2 additions", "expected size 6 after 2 additions, actual size " + count);

      // Remove last traversed element 

      iterator.remove(); // DHJN|T

      count = staff.size();
      compare(5, count, "5 item list after 1 removal size is 5", "expected size 5 after a removal, actual size " + count);

      // add first element
      staff.addFirst("Darth-Vader");
      count = staff.size();
      compare(6, count, "6 expected after add first", "expected size 6 after first addition, actual size " + count);

      // remove first element
      System.out.println(staff.removeFirst());
      count = staff.size();
      compare(5, count, "5 expected after remove first", "expected size 5 after first removal, actual size " + count);

      // add last element
      staff.addFirst("Anakin-Skywalker");
      count = staff.size();
      compare(6, count, "6 expected after add last", "expected size 6 after last addition, actual size " + count);

      // remove last element
      System.out.println(staff.removeLast());
      count = staff.size();
      compare(5, count, "5 expected after remove last", "expected size 5 after last removal, actual size " + count);

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
         System.out.println("PASSED " + testName);
      }
      else {
         System.out.println("FAILED " + testName + ": " + errorMessage);
      }
   }
}

