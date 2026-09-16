import java.util.ConcurrentModificationException;
import java.util.NoSuchElementException;

/**
   An implementation of a doubly linked list.
*/
public class LinkedList
{  
   private Node first;
   private Node last;
   private int mutationsCounter;
   /** 
      Constructs an empty linked list.
   */
   public LinkedList()
   {  
      first = null;
      last = null;
      mutationsCounter = 0;
   }
   
   /**
      Returns the first element in the linked list.
      @return the first element in the linked list
   */
   public Object getFirst()
   {  
      if (first == null) { throw new NoSuchElementException(); }
      return first.data;
   }

   /**
      Removes the first element in the linked list.
      @return the removed element
   */
   public Object removeFirst()
   {
      if (first == null) { throw new NoSuchElementException(); }
      Object element = first.data;
      first = first.next;
      if (first == null) { last = null; } // List is now empty
      else { first.previous = null; }
      mutationsCounter++;
      return element;
   }

   /**
      Adds an element to the front of the linked list.
      @param element the element to add
   */
   public void addFirst(Object element)
   {
      Node newNode = new Node();
      newNode.data = element;
      newNode.next = first;
      newNode.previous = null;
      if (first == null) { last = newNode; }
      else { first.previous = newNode; }
      first = newNode;
      mutationsCounter++;
   }
   
   /**
      Returns the last element in the linked list.
      @return the last element in the linked list
   */
   public Object getLast()
   {  
      if (last == null) { throw new NoSuchElementException(); }
      return last.data;
   }

   /**
      Removes the last element in the linked list.
      @return the removed element
   */
   public Object removeLast()
   {
      if (last == null) { throw new NoSuchElementException(); }
      Object element = last.data;
      last = last.previous;
      if (last == null) { first = null; } // List is now empty
      else { last.next = null; }
      mutationsCounter++;
      return element;
   }

   /**
      Adds an element to the back of the linked list.
      @param element the element to add
   */
   public void addLast(Object element)
   {
      Node newNode = new Node();
      newNode.data = element;
      newNode.next = null;
      newNode.previous = last;
      if (last == null) { first = newNode; }
      else { last.next = newNode; }
      last = newNode;
      mutationsCounter++;
   }
   
   /**
      Returns an iterator for iterating through this list.
      @return an iterator for iterating through this list
   */
   public ListIterator listIterator()
   {  
      return new LinkedListIterator();
   }
   
   class Node
   {  
      public Object data;
      public Node next;
      public Node previous;
   }

   class LinkedListIterator implements ListIterator
   {  
      private Node position;
      private boolean isAfterNext;
      private boolean isAfterPrevious;
      private int mutationsCounter;

      /**
         Constructs an iterator that points to the front
         of the linked list.
      */
      public LinkedListIterator()
      {  
         position = null;
         isAfterNext = false;
         isAfterPrevious = false;
         mutationsCounter = LinkedList.this.mutationsCounter;
      }

      public void checkConcurrentMod() throws ConcurrentModificationException
      {
         if (mutationsCounter != LinkedList.this.mutationsCounter)
         {
            throw new ConcurrentModificationException("concurrent modification");
         }
      }
      
      /**
         Moves the iterator past the next element.
         @return the traversed element
      */
      public Object next()
      {
         checkConcurrentMod();
         if (!hasNext()) { throw new NoSuchElementException(); }
         isAfterNext = true;
         isAfterPrevious = false;

         if (position == null)
         {
            position = first;
         }
         else
         {
            position = position.next;
         }

         return position.data;
      }
      
      /**
         Tests if there is an element after the iterator position.
         @return true if there is an element after the iterator position
      */
      public boolean hasNext()
      {  
         if (position == null)
         {
            return first != null;
         }
         else
         {
            return position.next != null;
         }
      }

      /**
         Moves the iterator before the previous element.
         @return the traversed element
      */
      public Object previous()
      {
         checkConcurrentMod();
         if (!hasPrevious()) { throw new NoSuchElementException(); }
         isAfterNext = false;
         isAfterPrevious = true;

         Object result = position.data;
         position = position.previous;
         return result;
      }
      
      /**
         Tests if there is an element before the iterator position.
         @return true if there is an element before the iterator position
      */
      public boolean hasPrevious()
      {  
         return position != null;
      }
      
      /**
         Adds an element before the iterator position
         and moves the iterator past the inserted element.
         @param element the element to add
      */
      public void add(Object element)
      {
         checkConcurrentMod();
         if (position == null)
         {
            addFirst(element);
            position = first;
         }
         else if (position == last)
         {
            addLast(element);
            position = last;
         }
         else
         {  
            Node newNode = new Node();
            newNode.data = element;
            newNode.next = position.next;
            newNode.next.previous = newNode;
            position.next = newNode;
            newNode.previous = position;
            position = newNode;
         }

         isAfterNext = false;
         isAfterPrevious = false;
         mutationsCounter = LinkedList.this.mutationsCounter;
      }
      
      /**
         Removes the last traversed element. This method may
         only be called after a call to the next() method.
      */
      public void remove()
      {
         checkConcurrentMod();
         Node positionToRemove = lastPosition();

         if (positionToRemove == first)
         {
            removeFirst();
         }
         else if (positionToRemove == last)
         {
            removeLast();
         }
         else
         {
            positionToRemove.previous.next = positionToRemove.next;
            positionToRemove.next.previous = positionToRemove.previous;
         }

         if (isAfterNext) 
         { 
            position = position.previous;
         }

         isAfterNext = false;
         isAfterPrevious = false;
         mutationsCounter = LinkedList.this.mutationsCounter;
      }

      /**
         Sets the last traversed element to a different value. 
         @param element the element to set
      */
      public void set(Object element)
      {
         checkConcurrentMod();
         Node positionToSet = lastPosition();
         positionToSet.data = element;
         mutationsCounter = LinkedList.this.mutationsCounter;
      }

      /**
         Returns the last node traversed by this iterator, or
         throws an IllegalStateException if there wasn't an immediately
         preceding call to next or previous.
         @return the last traversed node
      */
      private Node lastPosition()
      {
         if (isAfterNext) 
         { 
            return position; 
         }
         else if (isAfterPrevious) 
         {
            if (position == null)
            {
               return first;
            }
            else
            {
               return position.next;
            }
         }
         else { throw new IllegalStateException(); }
      }      
   }
}
