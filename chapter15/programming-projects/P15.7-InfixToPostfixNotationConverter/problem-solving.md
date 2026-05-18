# P15.7-InfixToPostfixNotationConverter

••• P15.7 Modify the expression calculator of Section 15.6.3 to convert an expression into
reverse Polish notation. Hint: Instead of evaluating the top and pushing the result,
append the instructions to a string.

## understand the problem

input: 
3 * (4 + 2)
output:
342+* OR 42+3*

input:
3 * 4 + 2
output:
234*+ OR 34*2+

input
3 * 4 + 2 * (1 + 1 / 2)
output
34*2112/+*+

input 
1 - 1 + 3 * 2 / (1 * 1 + 2)
output
11-3211*2+/*+

1 * 1 + 2
211*+
or
11*2+

1 * 1 + 2 * 3 + 1
11*23*+1+

1 * 1 + 2 * 3 + 1
nums 
ops 

hmmmm. I realised now that the order of computation 
is the order in which the operators are in postfix notation.

Seeing as I am converting from infix to postfix notation, 
and I have an infix notation expression computer, I can 
just take that and when that algorithm would evaluate the top
of the stacks and puts the result back on the operand stack,
I know the top operator and operands are the result of the 
previously translated part of the postfix expression, and 
the next operator and operand.

## solve the problem by hand

input:
3 + 5
output:
35+

I've got an expression here with a single operation. I've got the first operand and the second operand and the operator
in the middle. I keep the order of the operands the same in postfix notation but I move the operator symbol to the right
of the operands.

input:
(4 + 2) - 3
output:

input:
3 - (4 + 2)
output:


## pseudocode for solving general instances of the problem using the method I solved a specific instance of the problem

### the path to the working algo

I've written the code and tests that work now. 
I started with tests for different conversions. Simple tests first, then progressively more complicated ones.
I started with 2 stacks like the calculator uses, a num and op stack, and a list of string for the postfix expression.

I got stuck on the tests with parentheses groups, e.g. 3 - (4 + 2) and (4 + 2) - 3, because I was trying to keep 
track of what side of the next expression the postfix expression between the parentheses should be via a global 
variable to keep track of this state called PreviousResultSide which was an enum of NONE, or LEFT, or RIGHT.
Inside evaluateTop i'd addFirst or addLast to a LinkedList<String> postfixExpression depending on the enum value. 
But there's a bug in the way I track this so the position isn't accurately defined, e.g. i assign Right when 
the parentheses group was on the left side.
The parentheses groups didn't know what side of the next operation they would be on, so
I would be assigning LEFT or RIGHT to previousParenthesesGroup side without being able to determine
whether that side was correct.

Then I moved to using (on paper while hand tracing) a third stack, where I put operands while i read them in 
and popped them for operations, and I also put postfix conversions of part of the infix expression there. 
Basically I was taking the hint to "append the instructions to a string" literally, but on a stack instead.
I was having the same problem as before, of not knowing the order of postfix operations, 
because the stack contained the postfix conversions of each part of the infix expression, but I still didn't know
if 3- was meant to happen after 42+, i.e. 3-42+, or before, i.e. 42+3-, because I just had a stack with "42+" and "3-"
on top. 

I realised though that I was almost there now, and that the original operand stack where I was reading operands into
kept operands that were in operations left of the current postfix operations on the stack. So I realised that I could
treat converted parts of the infix expression, e.g. 42+, as operands themselves, as put them back on the operands stack
after obtaining them, thereby obtaining an ordered stack of operands in the order they are meant to be executed per the
expression. So I made the operandsStack of type String and implemented a two stack (operands and operators) solution and
it worked for all of my tests.
