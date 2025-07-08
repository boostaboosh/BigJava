# Bug Report Page

**Big Java – 7th Edition**  
**Brief Java – 9th Edition**

---

## Section 2.1.1

Change:

> “For example, you saw in Chapter 1 that System.out refers to an object.”

To:

> “For example, the expression `System.out` that you saw in Chapter 1 refers to an object.”

---

## Section 3.5

In the fifth index card, change the `reg2.purchase` entry from **9.25** to **38.75**.  
*(In the source code, you can see that purchase is the sum of all purchases.)*

---

## Section 4.2

At the end of the section, add:

### Common Error 4.3 – Roundoff Errors

Roundoff errors are a fact of life when calculating with floating-point numbers. You probably have encountered that phenomenon yourself with manual calculations. If you calculate 1⁄3 to two decimal places, you get 0.33. Multiplying again by 3, you obtain 0.99, not 1.00.

In the processor hardware, numbers are represented in the binary number system, using only digits 0 and 1. As with decimal numbers, you can get roundoff errors when binary digits are lost. They just may crop up at different places than you might expect.

In the binary system, there is no exact representation for **4.35**, just as there is no exact representation for **1⁄3** in the decimal system. The representation used by the computer is just a little less than 4.35, so 100 times that value is just a little less than 435.

```java
double price = 4.35;
double quantity = 100;
double total = price * quantity; // Should be 100 * 4.35 = 435
System.out.println(total);       // Prints 434.99999999999994
```

You can deal with roundoff errors by rounding to the nearest integer (see Section 4.2.5) or by displaying a fixed number of digits after the decimal separator (see Section 4.3.2).

---

## Section 4.2.5 – Self Check 6

The solution to the fourth row should refer to **Common Error 4.3** (see above).

---

## Chapter 4 – VitalSource Chapter Review Problem 8

Remove:

> "number of groups = integer part of (total width - tile width) / (2 x tile width)"

It should not be part of the solution.

---

## Section 5.3

At the end of the section, change:

```java
if (richter >= 4.5)
{
   "Damage to poorly constructed buildings";
}
```

To:

```java
if (richter >= 4.5)
{
   description = "Damage to poorly constructed buildings";
}
```

---

## Section 7.6.1

Add a missing comma in the declaration:

```java
int[][] counts = 
{ 
   { 0, 3, 0 },
   { 0, 0, 1 }, 
   { 0, 0, 1 }, 
   { 1, 0, 0 }, 
   { 0, 0, 1 }, 
   { 3, 1, 1 },
   { 0, 1, 0 },
   { 1, 0, 1 }
}; 
```

---

## Common Error 8.2

Change:

> “Between class and instance variable names (Math.PI)”

To:

> “Between the names of classes and static variable names (Math.PI)”

---

## Exercise P11.6

Append:

> “This file uses the UTF-8 encoding—see Special Topic 11.3.”

---

## Chapter 13 – Section 5 – VitalSource Self Check 5

Change:

> “whether the portion of an array”

To:

> “whether the portion `a[from]...a[to-1]` of an array `a`”

---

## Exercise R13.3

Change:

```java
public static void sum
```

To:

```java
public static int sum
```

---

## Section 14.6.2

Change the last equation from:

> `T(n) = 1 + log₂(n)`

To:

> `T(n) = T(1) + log₂(n)`

---

## Section 15.2.3

In **Table 3**, rows 2 to 4 should be as follows:

- `iter.hasNext()`  
  Returns false because the iterator is at the end of the collection.

- ```java
  if (iter.hasPrevious())
  {
     s = iter.previous();
  }
  ```
  `hasPrevious` returns true because the iterator is not at the beginning of the list.  
  The call to `previous` returns `"Sally"`, and the iterator is again at the beginning of the list.  
  `previous` and `hasPrevious` are `ListIterator` methods.

- `iter.set("Juliet");`  
  The `set` method updates the last element returned by `next` or `previous`, without changing the iterator position.  
  The list is now `[Juliet]`.

---

## Section 15.6.3

Change:

> “While the top of the stack has a higher precedence than op”

To:

> “While the precedence of the top of the operator stack is at least that of `op`”

---

## Testbank – Chapter 15 – Problem 64

Change:

> `(k, v) -> v + 1`

To:

> `(p, v) -> p + 1` **(4x)**

---

## Testbank – Chapter 15 – Problem 65

Change:

- `(d, s) -> v + 1` → `(p, v) -> p + 1`  
- `(d, s) -> v + sales` → `(p, v) -> p + sales` **(3x)**

---

## Chapter 17 – VitalSource Interactive Review and Practice / Chapter Review Question 7

In the third question and explanation, change:

> “a right child of the root”

To:

> “a left child of the node holding 18”

---

## Page 871 – Programming Tip 19.2

Change:

```java
if (difference != 0) { return 0; }
```

To:

```java
if (difference != 0) { return difference; }
```

---

## Section 23.3 – WebGet.java

Change `
` to `
` **(3x)**

---

## Glossary Entry for "Unicode"

Change to:

> “A standard code that assigns code values to characters used in scripts around the world.”

---

**Thanks to Claire Bono, Hossein Darbandi, Daniel Ford, Stephen Gilbert, Cindy Johnson, Larry Morelli, Waleed Mortaja, Hoang Nguyen, Barry Nichols, Raymond Novak, and (your name might go here) for their bug reports and suggestions.**
