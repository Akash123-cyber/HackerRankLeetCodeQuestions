# Java Number Formatting – Concepts You Must Remember Forever

This guide explains the core concepts of number formatting used in the following idea:

NumberFormat nf;
nf = NumberFormat.getCurrencyInstance(Locale.US);
String us = nf.format(payment);

---

## 1. NumberFormat Is an Abstract Class

- NumberFormat cannot be instantiated using `new`
- It serves as a blueprint for number formatting

Example (invalid):
new NumberFormat();   // not allowed

Example (valid):
NumberFormat nf = NumberFormat.getCurrencyInstance();

Memory rule:
Abstract class = what to do, not how to do it

---

## 2. Factory Method Pattern

NumberFormat.getCurrencyInstance(Locale.US)

- This is a static factory method
- Java decides which concrete subclass to return
- You never worry about the actual implementation

Memory rule:
You ask → Java builds → you use

---

## 3. Locale Defines Cultural Rules

Locale.US  
Locale.CHINA  
Locale.FRANCE  
new Locale("en", "IN")

A Locale controls:
- Currency symbol
- Decimal separator
- Grouping separator
- Number grouping style

Memory rule:
Locale = country’s number-writing rules

---

## 4. Same Number, Different Output

Input:
12324.134

US     → $12,324.13  
India  → ₹12,324.13  
China  → ￥12,324.13  
France → 12 324,13 €

Memory rule:
Number stays the same, culture changes the format

---

## 5. Why India Uses a Custom Locale

new Locale("en", "IN")

- Java has no predefined Locale.INDIA
- Language = English
- Country  = India

Memory rule:
If Java doesn’t know the country, describe it

---

## 6. Reusing the Same NumberFormat Variable Is Safe

nf = NumberFormat.getCurrencyInstance(Locale.US);
nf = NumberFormat.getCurrencyInstance(Locale.CHINA);

- The reference is reused
- The object changes

Memory rule:
Same remote, different channel

---

## 7. format() Is the Core Operation

String result = nf.format(payment);

- Applies rounding
- Adds currency symbol
- Applies locale rules
- Always returns a String

Memory rule:
Number in → formatted String out

---

## 8. Why String.format() Is Wrong Here

String.format("Rs.%f", payment)

Problems:
- Not locale-aware
- Incorrect grouping
- Hardcoded symbol

Memory rule:
String.format() = manual  
NumberFormat = intelligent

---

## Final One-Line Rule

Locale decides HOW, NumberFormat decides WHAT, and format() produces the final String.
