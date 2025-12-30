# ••• P15.2 

Reimplement Exercise [•• E15.4](#-e154-) so that the keys of the map 
are objects of class [Student.java](src/Student.java). 
A student should have a first name, a last name, and a unique integer ID. 
For grade changes and removals, lookup should be by ID. 
The printout should be sorted by last name. 
If two students have the same last name, then use the first name as a tie breaker. 
If the first names are also identical, then use the integer ID. 
Hint: Use two maps. 

# •• P15.6 

Supply compatible hashCode and equals methods to the Student class 
described in Exercise [••• P15.2](#-p152-). 
Test the hash code by adding Student objects to a hash set.

## •• E15.4 

Write a program that keeps a map in which both keys 
and values are strings—the names of students and their course grades. 
Prompt the user of the program to add or remove students, to modify grades, 
or to print all grades. 
The printout should be sorted by name and formatted like this:
Carl: B+
Joe: C
Sarah: A

