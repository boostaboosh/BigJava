••• E15.5 
Write a program that reads a Java source file and produces an index of all identifiers
in the file. 
For each identifier, print all lines in which it occurs. 
For simplicity, we will consider each string consisting only of letters, numbers, 
and underscores an identifier. 
Declare a Scanner in for reading from the source file 
and call in.useDelimiter("[^A-Za-z0-9_]+"). 
Then each call to next returns an identifier.
