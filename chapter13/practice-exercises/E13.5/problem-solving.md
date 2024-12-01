# problem solving

problem:
Write a recursive method for computing a string with the binary digits of a number.
If n is even, then the last digit is 0. If n is odd, then the last digit is 1. Recursively
obtain the remaining digits.

I need to find ways of simplifying my input
and combining solutions to the simplified input
with the solution for the part of the input I removed
in order to find a solution to the problem with the
original input.

## working out an example by hand

If I have a number 528.
How can I simplify this input so that it's 
easier to convert it to binary?

i can remove the first digit. so it becomes 28.
now what? 
well say I have the solution to 28 in binary, 
which is 11100. how doo i combine that with the 
5 i removed? well, 5 in binary is 101.
so is 528 in binary equal to 101 11100 ?
let's check: 0 + 0 + 4 + 8 + 16 + 32 + 0 + 128
= 12 + 16 + 32 + 128 = 60 + 128 = 188.
188 is != 528.

okay, how do i convert a number to binary?
I find the biggest power of 2 that fits in a number,
then write down a 1 in that column of the base 2 number
and then subtract that power of 2 from the number
I'm converting and repeat the process until i end up
with a binary number.

wait a second, the problem text says:  
If n is even, then the last digit is 0. If n is odd, then the last digit is 1. Recursively
obtain the remaining digits.

I'm not using that in the solution I'm thinking of 
where I start with the left most digit and find the 
largest power of 2 that fits within its value and 
repeat.

let's try again considering the value of the last
digit is 0 if the number is even and 1 if the 
number is odd.

if I have 528 again. The last digit 8 is odd.
So the base 2 value will end in 0, because
if it ended in 1 then it would be equal to 
a number divisible by 2 + 1, i.e. an odd 
number.

hmm, maybe simplifying the number starting from
the last one is the key.

if I have 52 in binary, then the binary value of
528 is binary 52 followed by binary 8?
Let's check:
52 in binary is 11010 and 8 is 100, so is
528 equal to 11010100?
0 + 0 + 4 + 0 + 16 + 0 + 64 + 128 = 84 + 128 = 212
which is not 528.

okay, nope. that wasn't it.

let's break this down again:
Write a recursive method for computing a string with the binary digits of a number. If n is even, then the last digit is 0. If n is odd, then the last digit is 1. Recursively obtain the remaining digits.

78 % 2 = 0  
0  
78 / 2 = 39  
39 % 2 = 1  
10  
39 / 2 = 19  
19 % 2 = 1  
110  
19 / 2 = 9  
9 % 2 = 1  
1110  
9 / 2 = 4  
4 % 2 = 0  
01110  
4 / 2 = 2  
2 % 2 = 0  
001110  
2 / 2 = 1  
1 % 2 = 1  
1001110 = 0+2+4+8+0+0+64 = 78  
holy shit that worked!  

why does that work? 
Ah, because dividing by 2 is like dividing by 10 in base 10.  
So what I'm doing here is going:
1. what's the last digit, 0 or 1?
2. remove the last digit by dividing by 2 (like dividing by 10)
3. if remaining number is != 0 repeat these steps 1 to 3

that might still seem confusing.
Let me explain what I'm doing in base 10, and 
then you can see that I'm doing the same thing
in base 2, and it's actually not so complicated.

I have a number, say 528, I want to compute
its last digit, so I do 528 modulus 10 to get
8, and then I then 528 / 10 to get 52. 
And then I just repeat that process to get each
individual digit of the number in base 10.

Now, we are doing the exact same thing in binary,
where the value of each digit represents a power 
of 2 instead of a power of 10.  
So if I have 528, this is a quantity represented 
in base 10, and to get the last digit of this quantity
in base 2 I can do 528 % 2, which is 0, and then 
to get rid of the last base 2 digit (0) which I've just computed, 
I can do 528 integer division by 2, which is 264.
And then I can repeat the steps of doing number (264) modulus
2 and then integer division by 2 to obtain the remaining
digits to the left of the first (right most) binary digit of 528
I computed in base 2: XXX0.
