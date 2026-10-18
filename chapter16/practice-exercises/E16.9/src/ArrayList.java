import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

/**
   This is a simplified implementation of an array list.
*/
public class ArrayList implements Iterable
{
   private Object[] elements;
   private int currentSize;
   private int modifications;

   /**
      Constructs an empty array list.
   */
   public ArrayList() 
   {
      final int INITIAL_SIZE = 10;
      elements = new Object[INITIAL_SIZE];
      currentSize = 0;
   }

   @Override
   public boolean equals(Object otherObject)
   {
      if (otherObject != null && otherObject.getClass().getName().equals(this.getClass().getName()) && otherObject instanceof ArrayList)
      {
         ArrayList otherArrayList = (ArrayList) otherObject;
         if (otherArrayList.currentSize == this.currentSize)
         {
            for (int i = 0; i < currentSize; i++)
            {
               if (!elements[i].equals(otherArrayList.elements[i])) return false;
            }
            return true;
         }
      }
      return false;
   }

   /**
      Gets the size of this array list.
      @return the size
   */
   public int size() { return currentSize; }

   /**
      Throws an IndexOutOfBoundsException if the checked index is out of bounds
      @param n the index to check
   */
   private void checkBounds(int n)
   {
      if (n < 0 || n >= currentSize) 
      {
         throw new IndexOutOfBoundsException();
      }
   }

   /**
      Gets the element at a given position.
      @param pos the position
      @return the element at pos
   */
   public Object get(int pos)
   {
      checkBounds(pos);
      return elements[pos];
   }

   /**
      Sets the element at a given position.
      @param pos the position
      @param element the new value
   */
   public void set(int pos, Object element)
   {
      checkBounds(pos);
      elements[pos] = element;
      modifications++;
   }

   /**
      Removes the element at a given position.
      @param pos the position
      @return the removed element
   */
   public Object remove(int pos)
   {      
      checkBounds(pos);

      Object removed = elements[pos];

      for (int i = pos + 1; i < currentSize; i++)
      {
         elements[i - 1] = elements[i];
      }

      currentSize--;
      modifications++;

      return removed;
   }

   /**
      Adds an element after a given position.
      @param pos the position
      @param newElement the element to add
   */
   public boolean add(int pos, Object newElement)
   {
      growIfNecessary();
      currentSize++;

      checkBounds(pos);

      for (int i = currentSize - 1; i > pos; i--)
      {
         elements[i] = elements[i - 1];
      }

      elements[pos] = newElement;
      modifications++;
      return true;
   }

   /**
      Adds an element after the end of the array list
      @param newElement the element to add
   */
   public boolean addLast(Object newElement)
   {
      growIfNecessary();
      currentSize++;
      
      elements[currentSize - 1] = newElement;
      modifications++;
      return true;
   }

   public Iterator iterator()
   {
      return listIterator();
   }

   public ListIterator listIterator()
   {
      return new ArrayListIterator();
   }

   private class ArrayListIterator implements ListIterator
   {
      private int nextItemIndex;
      private int modifications;
      private boolean isAfterPrevious;
      private boolean isAfterNext;

      public ArrayListIterator()
      {
         nextItemIndex = 0;
         modifications = ArrayList.this.modifications;
         isAfterPrevious = false;
         isAfterNext = false;
      }

      private boolean isModifiedOutsideOfIterator()
      {
         return modifications != ArrayList.this.modifications;
      }

      public void add(Object e) throws ConcurrentModificationException
      {
         if (isModifiedOutsideOfIterator()) throw new ConcurrentModificationException();
         ArrayList.this.add(nextItemIndex, e);
         nextItemIndex++;
         modifications = ArrayList.this.modifications;
      }

      public boolean hasNext()
      {
         return nextItemIndex < ArrayList.this.size();
      }

      public boolean hasPrevious()
      {
         return nextItemIndex > 0;
      }

      public Object next() throws ConcurrentModificationException, NoSuchElementException
      {
         if (isModifiedOutsideOfIterator()) throw new ConcurrentModificationException();
         if (!hasNext()) throw new NoSuchElementException();
         Object nextItem = ArrayList.this.get(nextItemIndex);
         nextItemIndex++;
         isAfterNext = true;
         isAfterPrevious = false;
         return nextItem;
      }

      public int nextIndex()
      {
         return nextItemIndex;
      }

      public Object previous() throws ConcurrentModificationException, NoSuchElementException
      {
         if (isModifiedOutsideOfIterator()) throw new ConcurrentModificationException();
         if (!hasPrevious()) throw new NoSuchElementException();
         isAfterPrevious = true;
         isAfterNext = false;
         return ArrayList.this.get(--nextItemIndex);
      }

      public int previousIndex()
      {
         return nextItemIndex - 1;
      }

      public void remove() throws ConcurrentModificationException, IllegalStateException
      {
         if (isModifiedOutsideOfIterator()) throw new ConcurrentModificationException();
         if (!isAfterNext && !isAfterPrevious) throw new IllegalStateException("remove called without calling next or previous first");
         if (isAfterNext)
         {
            ArrayList.this.remove(nextItemIndex - 1);
            nextItemIndex--;
         } else if (isAfterPrevious) {
            ArrayList.this.remove(nextItemIndex);
         }
         modifications = ArrayList.this.modifications;
         isAfterPrevious = false;
         isAfterNext = false;
      }

      public void set(Object e) throws ConcurrentModificationException, IllegalStateException
      {
         if (isModifiedOutsideOfIterator()) throw new ConcurrentModificationException();
         if (!isAfterNext && !isAfterPrevious) throw new IllegalStateException("remove called without calling next or previous first");
         if (isAfterNext)
         {
            ArrayList.this.set(nextItemIndex - 1, e);
         } else if (isAfterPrevious) {
            ArrayList.this.set(nextItemIndex, e);
         }
         modifications = ArrayList.this.modifications;
         isAfterPrevious = false;
         isAfterNext = false;
      }
   }

   /**
      Grows the elements array if the current size equals the capacity.
   */
   private void growIfNecessary()
   {
      if (currentSize == elements.length)
      {
         Object[] newElements = new Object[2 * elements.length];
         for (int i = 0; i < elements.length; i++) 
         { 
            newElements[i] = elements[i]; 
         }      
         elements = newElements;
      }
   }
}

