/**
   A program that demonstrates the LinkedList class
*/
public class ListDemo
{  
   public static void main(String[] args)
   {  
      LinkedList staff = new LinkedList();
      staff.addFirst("Tom");
      staff.addFirst("Romeo");
      staff.addFirst("Harry");
      staff.addFirst("Diana");
      
      // | in the comments indicates the iterator position

      ListIterator firstIterator = staff.listIterator(); // |DHRT
      firstIterator.next(); // D|HRT
      firstIterator.next(); // DH|RT

      ListIterator secondIterator = staff.listIterator(); // |DHRT
      secondIterator.next(); // D|HRT

      // first iterator current position is H
      // second iterator current position is D

      // Add an element after the second iterator and move past it
      secondIterator.add("Silvio"); // DS|HRT

      // now linked list is D -> S -> H -> R -> T

      // Remove first iterator's last traversed element (This is when the linked list breaks)
      firstIterator.remove(); // This removes node H "Harry" from the linked list but inadvertently removes Silvio too!
      // Silvio is removed too because the first iterator's previous instance variable isn't updated when the "Silvio"
      // node is added. Instead of updating S to point to R when H is removed, the first iterator updates D to point to
      // R when H is removed, because its previous variable still references D. Even after the second iterator added S
      // after node D.

      // Print all elements

      firstIterator = staff.listIterator();
      while (firstIterator.hasNext())
      {
         System.out.print(firstIterator.next() + " ");
      }
      System.out.println();
   }
}

