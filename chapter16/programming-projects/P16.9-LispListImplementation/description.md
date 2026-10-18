•• P16.9

The LISP language, created in 1960, implements linked lists in a very elegant way.
You will explore a Java analog in this set of exercises. Conceptually, the tail of a list—
that is, the list with its head node removed—is also a list. The tail of that list is again a
list, and so on, until you reach the empty list. Here is a Java interface for such a list:

public interface LispList
{
    boolean empty();
    Object head();
    LispList tail();
    . . .
}

There are two kinds of lists, empty lists and nonempty lists:

    public class EmptyList implements LispList { ... }
    public class NonEmptyList implements LispList { ... }

These classes are quite trivial. The EmptyList class has no instance variables. Its head
and tail methods sim ply throw an UnsupportedOperationException, and its empty method
returns true. The NonEmptyList class has instance variables for the head and tail.

Here is one way of making a LISP list with three elements:

LispList list = new NonEmptyList("A", new NonEmptyList("B", new NonEmptyList("C", new EmptyList())));

This is a bit tedious, and it is a good idea to supply a convenience method cons that
calls the constructor, as well as a static variable NIL that is an instance of an empty list.

Then our list construction becomes

    LispList list = LispList.NIL.cons("C").cons("B").cons("A");

Note that you need to build up the list starting from the (empty) tail.

To see the elegance of this approach, consider the implementation of a toString
method that produces a string containing all list elements. The method must be
implemented by both classes:

public class EmptyList implements LispList
{
    . . .
    public String toString() { return ""; }
}

public class NonEmptyList implements LispList
{
    . . .
    public String toString() { return head() + " " + tail().toString(); }
}

Note that no if statement is required. A list is either empty or nonempty, and the
correct toString method is invoked due to polymorphism.

In this exercise, complete the LispList interface and the EmptyList and NonEmptyList
classes. Write a test program that constructs a list and prints it.
