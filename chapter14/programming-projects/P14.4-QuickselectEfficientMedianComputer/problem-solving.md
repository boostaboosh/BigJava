# •• P14.4
The median m of a sequence of n elements is the element that would fall in the
middle if the sequence was sorted. That is, e ≤ m for half the elements, and m ≤ e
for the others. Clearly, one can obtain the median by sorting the sequence, but one
can do quite a bit better with the following algorithm (Quickselect) that finds the kth element of a
sequence between a (inclusive) and b (exclusive). (For the median, use k = n/2, a = 0,
and b = n.)
```
select(k, a, b):
Pick a pivot p in the subsequence between a and b.
Partition the subsequence elements into three subsequences: the elements <p, =p, >p
Let n1, n2, n3 be the sizes of each of these subsequences.
if k < n1 // i.e. the pivot value is after the k-th element
    return select(k, 0, n1).
else if (k >= n1 + n2) // i.e. the pivot value is before the k-th element
    return select(k, n1 + n2, n) // if not iterating over the same indexing I would have to update k to equal k - (n1 + n2) because index zero would now be n1 + n2
else // k >= n1 && k < n1 + n2, i.e. the pivot value is the k-th element
    return p.
```
Implement this algorithm and measure how much faster it is for computing the
median of a random large sequence, when compared to sorting the sequence and
taking the middle element.

note: there is an error in the book's pseudocode.
k is the zero-based index of the element we want in the sorted sequence.
In the branch where the k-th element is positioned after the values equal to the pivot,
the first index of the right side values is n1 + n2, and so the branch much check if k >= n1 + n2, 
not just > n1 + n2. 
Additionally, the books pseudocode recurses over the same sequence 
for every recursive iteration, which is why it does not update k 
when looking for the k-th value on the right side of the pivot 
in the partitioned sequence.
