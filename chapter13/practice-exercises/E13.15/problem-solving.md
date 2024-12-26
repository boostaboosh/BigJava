••• E13.15  

Implement a SubstringGenerator that generates all substrings of a string. For example,
the substrings of the string "rum" are the seven strings

"r", "ru", "rum", "u", "um", "m", ""

Hint:  
First enumerate all substrings that start with the first character. There are n of
them if the string has length n. Then enumerate the substrings of the string that you
obtain by removing the first character.

# understand the problem

inputs:  
a string  
e.g. "cat"  
outputs:  
all substrings of cat  
e.g. "cat", "ca", "c", "at", "a", "t", ""

# work out an example by hand

input: "core"  
outputs:  
"c", "co", "cor", "core", "ore", "or", "o", "re", "r", "e", "" 

# solving the problem recursively (with a recurring computation)

## think of ways to simplify the input

the original input: **core**

1. I can remove the first character _c_: _ore_
2. I can remove the first and last char _c_ and _e_: _or_
3. I can cut it in half: _co_ and _re_

## think of ways to combine the removed input with the solution to the remaining input to obtain a solution to the problem with the original input

If I have all the substrings or ore, how can I combine that solution
with the removed input _c_ to get all substrings of core?  
Easy, to obtain all the substrings of core I can just pre-fix 
the letter _c_ to all the substrings of _ore_ that start with the
letter o, and add these strings and the string "c" to the set of 
substrings of _ore_ to obtain all the substrings of _core_.
Wait, this only works if there is one letter _o_.
If the string is coore with 2 letter Os I will get a substring core which I should not.

Scratch all that. 
What I need to do is create all the substrings that start with the first character,
and then generate the substrings of the word without the first character.

## find solutions to the simplest inputs

if a substring is empty the only substring is itself
