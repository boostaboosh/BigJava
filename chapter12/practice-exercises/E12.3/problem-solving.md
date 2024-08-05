# •• E12.3 

The invoice-printing program is somewhat unrealistic because the formatting of the
LineItem objects won’t lead to good visual results when the prices and quantities have
varying numbers of digits. Enhance the format method in two ways: Accept an int[]
array of column widths as an argument. Use the NumberFormat class to format 
the currency values.

# computation problem solving:

task:  
Re-write the Invoice class format method so that it accepts an int[] array of column widths 
as an argument and uses the **NumberFormat** class to format the currency values.
The aim of the re-written format() method is for it to lead to good visual results 
when the prices and quantities of line items have varying numbers of digits.

## step 1) understand the problem

inputs?

1. an int[] of column widths for the columns in the invoice line items table
2. a list of items in an invoice with a description, price, quantity, and total
3. the use of the NumberFormatter class in the method implementation, 
maybe the parameter variables, to format the currency values

desired outputs?

1. a well formatted output string that will lead to good visual results when printed,
even when line items have quantities and prices with different numbers of characters.

## step 2) solve examples of the problem by hand

output string format with current format method:

```plaintext
Description                      Price  Qty   Total  
Toaster                          10.00    1   10.00  
Hair dryer                      100.00   10 1000.00  
Car vacuum                     1000.00  100100000.00  
```

desired:

```plaintext
            Description            Price   Qty       Total  
Toaster                            10.00     1       10.00  
Hair dryer                        100.00    10     1000.00  
Car vacuum                       1000.00   100   100000.00  
```

## step 3) write a pseudocode algorithm for solving generic instances of the problem that I just solved a specific instance of

```plaintext
lineItemTableWidth = sum of widths in column widths
(make method because I do this later too) index of first letter in invoice title centred text = lineItemTableWidth / 2 - (invoice text length / 2)
length of first line with title = index of first letter in invoice title + length of invoice title length
formatted string = left aligned format with length of first line with title containing title and 2 new lines
formatted string = formatted string + formatted billing address + 2 new lines
// now it's time for the table
index of first letter in centred description header = get index of first letter to centre word in length(word to centre, length of string)
first part of description header = " " * index of first letter in centred description header + "Description"
description header = first part + " " * (description width - first part length)
// decide what to do if provided columnWidths is of wrong length, throw IllegalArgException?
description column width = columnWidths[0]
price column width = columnWidths[1]
Quantity column width = columnWidths[2]
total column width = columnWidths[3]
format string = format string 
                + description header 
                + right aligned "Price" string of width price header width
                + right aligned "Qty" string of width quantity header width
                + right aligned "Total" string of width total header width
// now for the line item values inside of the table
for each item in invoice items:
    invoice item string = left aligned product description of width description column width
    create currency number format with 2 decimal places
    price field string = right aligned price with currency using currency instance of nubmer format of max length field width - 1
    quantity = right aligned quanitity with integer of max length field width - 1
    total price = right alinged price with currency instance of number format of max length field width - 1
    invoice item string = invoice item string 
                          + price field string 
                          + quantity field string 
                          + total price field string
    add invoice item string + new line to format string

// table done
formatted string = formatted string + 
```

## result

```plaintext
                                  I N V O I C E

Sam's Small Appliances
100 Main Street
Anytown, CA 98765

                    Description                        Price  Qty          Total
Toaster                                               £10.00    1         £10.00
Hair dryer                                           £100.00   10      £1,000.00
Car vacuum                                         £1,000.00  100    £100,000.00

AMOUNT DUE: £101,010.00
```
