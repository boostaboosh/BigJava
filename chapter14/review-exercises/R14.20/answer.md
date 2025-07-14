what is the efficiency of the merge sort algorithm which also removes duplicates at the merge step?

Merge sort has efficiency O(n log(n)) relative to input size
and I have added a constant number of operations and array accesses per iteration,
such as comparing a value against the previous value in the array before adding it,
and I have added an array copy operation at the end of the algorithm to make a shorter copy without duplicates.

Seeing as removing duplicates involved me adding operations which take the same amount of time regardless of 
how many elements there are in the array.
Specifically, comparing against the previous value before adding a value to the sorted part
of the merged array: `if (val!= array[j - 1])`.

So the efficiency of the merge sort algorithm which also removes duplicates at the merge step I have made is
O(n log(n) + n) which is still O(n log(n)) efficiency after removing the smaller and keeping the biggest term of the
number of operations calculation.

If we compare two different input sizes (say n and 5n), 
the number of additional operations (e.g., duplicate checks) scales linearly with the size of the array.
This means that the ratio of how many more operations this merge sort algorithm executes for a larger input size n,
does not change, because however many operations I complete for each input, say n * 3 or n 10, doesn't change
the ratio of operations for a larger n and a smaller n, because 5n * 3 / 1n * 3 is the same as 5n * 10 / 1n * 10.
That is, we’re adding at most a fixed number of steps per element.
So while the constant factor increases, the growth rate relative to n does not. 
Which is exactly what Big-O captures. That’s why the dominant term remains O(n log n).
