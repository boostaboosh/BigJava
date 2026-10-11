1 understand the problem

what are the inputs
a singly linked list e.g. 1 -> 2 -> 3
what are the desired outputs
the same linked list reversed, e.g. 3 -> 2 -> 1

work examples by hand

input: 1
output: 1

input: empty list
output: empty list

input: dan, josh, pinkie
output: pinkie, josh, dan

write pseudocode for computing the answers
// pinkie -> josh -> dan -> mononoke -> null
get first element // pinkie
get second element // josh
assign first.next a value of null // pinkie -> null     josh -> dan -> mononoke -> null
get third element 
assign second element.next a value of first element // josh -> pinkie -> null   dan -> mononoke -> null
get fourth element
assign third element.next a value of second element // dan -> josh -> pinkie -> null    mononoke -> null
get fifth element (which is null)
assign fourth element.next a value of third element // mononoke -> dan -> josh -> pinkie -> null
