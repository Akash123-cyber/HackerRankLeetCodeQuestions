
# Question 1 : Numeric Series

We use the integers **a**, **b**, and **n** to create the following series:

$$
(a + 2^0 \cdot b),\ (a + 2^0 \cdot b + 2^1 \cdot b),\ \ldots,\ (a + 2^0 \cdot b + 2^1 \cdot b + \ldots + 2^{n-1} \cdot b)
$$

You are given **q** queries in the form of **a**, **b**, and **n**.  
For each query, print the series corresponding to the given **a**, **b**, and **n** values as a single line of **n** space-separated integers.

---

## Input Format

The first line contains an integer **q**, denoting the number of queries.

Each line $i$ of the **q** subsequent lines contains three space-separated integers describing the $a_i$, $b_i$, and $n_i$ values for that query.

---

## Constraints

- $0 \le q \le 500$
- $0 \le a, b \le 50$
- $1 \le n \le 15$

---

## Output Format

For each query, print the corresponding series on a new line.  
Each series must be printed in order as a single line of **n** space-separated integers.

---

## Sample Input

``` mathematica
2
0 2 10
5 3 5

```

## Sample Output

``` mathematica
2 6 14 30 62 126 254 510 1022 2046
8 14 26 50 98
```

---

## **Solution**

@import "series.java"

---

# Question 2: Range Of Primitive Types

Java has 8 primitive data types: char, boolean, byte, short, int, long, float, and double. For this exercise, we'll work with the primitives used to hold integer values (byte, short, int, and long):

• A byte is an 8-bit signed integer.  
• A short is a 16-bit signed integer.  
• An int is a 32-bit signed integer.  
• A long is a 64-bit signed integer.  

Given an input integer, you must determine which primitive data types are capable of properly storing that input.

To get you started, a portion of the solution is provided for you in the editor.

Reference: <https://docs.oracle.com/javase/tutorial/java/nutsandbolts/datatypes.html>

## Input Format

The first line contains an integer, T, denoting the number of test cases.

Each test case, T, is comprised of a single line with an integer, n, which can be arbitrarily large or small.

## Output Format

>For each input variable n and appropriate primitive dataType, you must determine if the given primitives are capable of storing it. If yes, then print:

``` mathematica
n can be fitted in:
* dataType
```

>If there is more than one appropriate data type, print each one on its own line and order them by size (i.e.: byte < short < int < long).

**If the number cannot be stored in one of the four aforementioned primitives, print the line:**

``` mathematica
n can't be fitted anywhere.
```

## Sample Input

``` mathematica
5
-150
150000
150000000
213333333333333333333333333333333333
-1000000000000
```

## Sample Output

``` mathematica
-150 can be fitted in:
* short
* int
* long
150000 can be fitted in:
* int
* long
150000000 can be fitted in:
* int
* long
213333333333333333333333333333333333 can't be fitted anywhere.
-1000000000000 can be fitted in:
* long

```

**Explanation**

-150 can be stored in a short, an int, or a long.

213333333333333333333333333333333333 is very large and is outside of the allowable range of values for the primitive data types discussed in this problem.

## Solution

@import "rangeOfPrimitiveTypes.java"

**This Particular code block is quite counter - intuitive**

```java
    long negLong = - ((long) Math.pow(2,63)) - 1;
    long posLong = ((long) Math.pow(2,63));

```

**why would we subtract - 1 from `- ((long)Math.pow(2,32)` which is negative limit of Long ?**

- In other parts of the code we have actually subtacted 1 from the Positive limit of other Primitive Types.
- which is the right way because we know that positive range of numbers in any data types include `0` in it thats why we subtracts 1 from the Max Limit.
- But in case of Long this is different because `Math.pow()` method returns a double not a long and a double has significantly higher range than long.
- when `Math.pow()` returns maximum Numeric Limit of long : `9,223,372,036,854,775,808` but this is maximum Number of negative part of range of `long`.
- So we have explicitly casted `(long)` then **narrowing** happens which converts this `9,223,372,036,854,775,808` double returned by `Math.pow()` into the long. It automatically decreases it by 1 because it is one more than the positive limit of long which is `9,223,372,036,854,775,807` {807 at the end not 808}
- thats why we don't need to subtract `1` from `posLong` because it is already maximum positive limit of `long` : `9,223,372,036,854,775,807` but for the limit of the negative side of range of `long` we need to subtract `1` from it to make it: `-9,223,372,036,854,775,808`

#### **Ideal Solution:**

@import "rangeOfPrimitiveTypesIdealSoln.java"

**What does this statement with in the catch block does?**

```java
    catch(Exception e){
        System.out.println(sc.next()+"can't be fitted anywhere.")
    }
```

- This is actually the most critical part of the logic
- When `sc.nextLong()` throws an exception, it does not consume the input. The invalid input (the massive number or text) remains sitting in the Scanner's buffer because the Scanner failed to "digest" it as a number.

- If we tried to print `x` in the catch block, it wouldn't work because `x` was never assigned a value.

- `sc.next()` is used here to:
  - **Read the invalid token as a plain String (since it couldn't be read as a long).**

  - **Clear the buffer so the Scanner is ready for the next iteration of the loop.**

  - **Return the value so it can be concatenated into the print statement.**

---

# Question 3 : Input Till The End Of File

## Problem Statement

The challenge here is to read **n** lines of input until you reach **EOF**, then number and print all **n** lines of content.

**Hint:** Java’s `Scanner.hasNext()` method is helpful for this problem.

---

## Input Format

Read some unknown **n** lines of input from `stdin` (`System.in`) until you reach **EOF**.  
Each line of input contains a **non-empty String**.

---

## Output Format

For each line, print the **line number**, followed by a **single space**, and then the **line content** received as input.

---

## Sample Input

``` text
Hello world
I am a file
Read me until end-of-file.
```

---

## Sample Output

```text
1 Hello world
2 I am a file
3 Read me until end-of-file.
```

## Solution

@import "HasNext.java"

---
# Question4: Day of the Week

You are given a date. You need to write a method `findDay` which returns the **day of the week** for that date.

To simplify your task, a portion of the code is already provided in the editor (as per HackerRank standard).  
You only need to **complete the method logic**.

---

### Function Description

Complete the `findDay` function.

**Parameters:**
- `int month` — the month of the date  
- `int day` — the day of the month  
- `int year` — the year  

**Returns:**
- `String` — the day of the week in **capital letters**  
  (e.g., `MONDAY`, `TUESDAY`, etc.)

---

### Input Format

A single line of input containing **three space-separated integers**: 08 05 2015

### Important Note 🌟

`Calendar.getInstance()` uses a factory method to return a concrete subclass object (like GregorianCalendar) re referenced by an abstract class variable.

- **✅ This is called POLYMORPHIC OBJECT CREATION
(also commonly described as Factory Method Pattern usage)**

### **Solution**

@import "Calendarcall.java"


# Java Calendar – Common Fields & Methods (Quick Reference)

## Setup
```java
Calendar cal = Calendar.getInstance();
```

## 📅 Date Fields

YEAR
```java
int year = cal.get(Calendar.YEAR);
```

MONTH (0-based)
```java
int month = cal.get(Calendar.MONTH) + 1;
```

DATE / DAY_OF_MONTH
```java
int date = cal.get(Calendar.DATE);
```

DAY_OF_WEEK (1–7)
```java
int dow = cal.get(Calendar.DAY_OF_WEEK);
```

DAY_OF_YEAR
```java
int doy = cal.get(Calendar.DAY_OF_YEAR);
```

WEEK_OF_YEAR
```java
int woy = cal.get(Calendar.WEEK_OF_YEAR);
```

WEEK_OF_MONTH
```java
int wom = cal.get(Calendar.WEEK_OF_MONTH);
```
## ⏰ Time Fields

HOUR (12-hour)
```java
int hour = cal.get(Calendar.HOUR);
```

HOUR_OF_DAY (24-hour)
```java
int hour24 = cal.get(Calendar.HOUR_OF_DAY);
```

MINUTE
```java
int min = cal.get(Calendar.MINUTE);
```

SECOND
```java
int sec = cal.get(Calendar.SECOND);
```

MILLISECOND
```java
int ms = cal.get(Calendar.MILLISECOND);
```

AM_PM
```java
int ap = cal.get(Calendar.AM_PM);
```
## 🧠 State / Property Fields

ERA (BC / AD)
```java
int era = cal.get(Calendar.ERA);
```

ZONE_OFFSET
```java
int zone = cal.get(Calendar.ZONE_OFFSET);
```

DST_OFFSET
```java
int dst = cal.get(Calendar.DST_OFFSET);
```
## 🛠️ Utility Methods

add()
```java
cal.add(Calendar.DATE, 5);
```

roll()
```java
cal.roll(Calendar.DATE, 5);
```

getActualMaximum()
```java
int max = cal.getActualMaximum(Calendar.DATE);
```

getActualMinimum()
```java
int min = cal.getActualMinimum(Calendar.DATE);
```
## 📝 Notes

Month is 0-based

DAY_OF_WEEK is 1-based


HOUR ≠ HOUR_OF_DAY

---
## Question 5 : Java Currency Formatter

Given a double-precision number `payment`, denoting an amount of money, use the `NumberFormat` class’s  
`getCurrencyInstance` method to convert `payment` into the **US, Indian, Chinese, and French** currency formats.

Then print the formatted values exactly as shown below:

US: formattedPayment
India: formattedPayment
China: formattedPayment
France: formattedPayment


Here, `formattedPayment` is `payment` formatted according to the appropriate `Locale`’s currency.

---

### Note
- India does **not** have a built-in `Locale`.
- You must construct the Indian locale manually using:
  - language = `en` (English)
  - country = `IN`

---

### Input Format

A single double-precision number denoting `payment`.

---

### Constraints

- `0 ≤ payment ≤ 10^9`

---

### Output Format

- On the first line, print `US: u` where `u` is `payment` formatted as US currency.
- On the second line, print `India: i` where `i` is `payment` formatted as Indian currency.
- On the third line, print `China: c` where `c` is `payment` formatted as Chinese currency.
- On the fourth line, print `France: f` where `f` is `payment` formatted as French currency.

---
### Sample Input

12324.134


---
### Sample Output

US: $12,324.13
India: Rs.12,324.13
China: ￥12,324.13
France: 12 324,13 €


---
### Explanation

Each line contains the value of `payment` formatted according to the respective country’s currency rules.

---
### Solution

@import "NumberFormatterCurrencyFormatter.java"

### 🧠 Go To Number Formatting:

[Java Number Formatting](JavaNumberFormatting.md)

---

# Question 6: Longest Substring Without Repeating Characters

**Statement :** you need to find the length of the longest substring without repeating characters

**Input /Output Examplex :** 
1. str : "abcabacbb
   result = 3; "abc"

2. str : "abcabacd"
   result = 4; "abcd"

3. str : "dvdf"
   output = 3, "vdf"

**Solution:**

@import "LeetCode3LongestSubstringWithoutRepeatingCharacters.java"

**Little Bit More Optimal Solution:**

@import "SubstringWithoutRepeatingCharacters.java"

---

# Question 7: LeetCode 395 Longest Substring with atleast K characters

**Statement :** you need to find the length of the longest substring having frequency of all the characters atleast k

**Example 1:**

**Input**: s = "aaabb", k = 3
**Output**: 3
**Explanation**: The longest substring is "aaa", as 'a' is repeated 3 times.

**Example 2:**
**Input**: s = "ababbc", k = 2
**Output**: 5
**Explanation**: The longest substring is "ababb", as 'a' is repeated 2 times and 'b' is repeated 3 times.

**Solution :**

@import "LeetCode395LongestSubstringWithAtleastKRepeatingCharacters.java"

**More Optimised Solution :**

```java
class Solution {
    public int longestSubstring(String s, int k) {
        
        if(s==null || s.length() < k) return 0;
        return DCHelper(s,0, s.length(),k);
    }

    static int DCHelper(String s, int start, int end, int k){
        //base condition of my recursion
        if(end - start < k) return  0;

        //step1: counting frequencies of the characters in substring
        int[] freq = new int[26];

        for(int i = start; i < end; i++){
            freq[s.charAt(i) - 'a']++;
        }

        //step2: checking validity of the substring if not having invalid characters then return the length of the substring
        //else split the substring around the invalid character

        boolean hasInvalid = false;
        int segmentStart = start;
        int maxLen = 0;

        for(int i = start; i < end; i++){
            if(freq[s.charAt(i) - 'a'] < k){
                hasInvalid = true;

                //left segment 
                maxLen = Math.max(maxLen, DCHelper(s,segmentStart, i, k));
                segmentStart = i + 1;
            }
        }

        if(!hasInvalid){
            return end - start;
        }

        //right segment
        maxLen = Math.max(maxLen, DCHelper(s,segmentStart, end, k));

        return maxLen;
    }
}
```
---

# Question 8: Leetcode 2958. Length of Longest Subarray With at Most K Frequency

**Statement :** You are given an integer array nums and an integer k.

- The frequency of an element x is the number of times it occurs in an array.

- An array is called good if the frequency of each element in this array is less than or equal to k.

- Return the length of the longest good subarray of nums.

- A subarray is a contiguous non-empty sequence of elements within an array.

 

**Example 1:**

**Input:** nums = [1,2,3,1,2,3,1,2], k = 2
**Output:** 6
**Explanation:** The longest possible good subarray is [1,2,3,1,2,3] since the values 1, 2, and 3 occur at most twice in this subarray. Note that the subarrays [2,3,1,2,3,1] and [3,1,2,3,1,2] are also good.
It can be shown that there are no good subarrays with length more than 6.

**Example 2:**

**Input:** nums = [1,2,1,2,1,2,1,2], k = 1
**Output:** 2
**Explanation:** The longest possible good subarray is [1,2] since the values 1 and 2 occur at most once in this subarray. Note that the subarray [2,1] is also good.
It can be shown that there are no good subarrays with length more than 2.

**Solution: Sliding window approach:**

@import "LeetCode2958LengthOfLongestSubarrayWithAtMostKFrequency.java"

**Solution: Slightly more Optimized**

```java
class Solution {
    public int maxSubarrayLength(int[] nums, int k) {

        if(nums.length == k){
            return nums.length;
        }

        HashMap<Integer, Integer> map = new HashMap<>();

        int i = 0, j = 0, maxLen = 0;

        while(j < nums.length){
            map.put(nums[j], map.getOrDefault(nums[j],0)+1);
            if(map.get(nums[j]) > k){
                while(map.get(nums[j]) > k){
                    map.put(nums[i], map.get(nums[i]) - 1);
                    
                    i++;
                }
            }
            //we always need to check the maxLen when we have a proper valid window
            //of elements having freq <= k that's why we are checking the maxLen at the end after
            //checking for any element having freq > k
            maxLen = Math.max(maxLen, j - i + 1);
            j++;
        }
        
        return maxLen;
    }
}
```
---

# Question 9: LeetCode 560. Subarray Sum Equals K

**Statement :** Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.

> A subarray is a contiguous non-empty sequence of elements within an array.

 
**Example 1:**

**Input:** nums = [1,1,1], k = 2
**Output:** 2

**Example 2:**

**Input:** nums = [1,2,3], k = 3
**Output:** 2
 

**Constraints:**
```Mathematica
1 <= nums.length <= 2 * 104
-1000 <= nums[i] <= 1000
-107 <= k <= 107
```

**Solution :**

@import "LeetCode560SubarraySumEqualsK.java"

---

# Question 10: Divide Array in 2 Subarray with equal sum

**Statement :** divide array into two subarrays having equal sum

**Solution :**
@import "SubarrayWithEqualSum.java"



# Question 11: Max Difference between 2 elements of Array

**Statement :** find the max difference between two element of the Array 
assume that the maximum for the current element exists on the right subArray only;

**Example :** arr : {9, 5, 8, 12, 2, 3, 7, 4}
**Output:** 7 {12 - 5 = 7}

**Solution :**
@import "MaxDifferenceBetweenTwoElementsOfArray.java"

# Question 12: LeetCode 46. LRU Cache  

**Topics:** Design, HashMap, Doubly Linked List  

---

### 📌 Problem Statement

Design a data structure that follows the constraints of a **Least Recently Used (LRU) cache**.

Implement the `LRUCache` class:

- `LRUCache(int capacity)`  
  Initializes the LRU cache with a positive size `capacity`.

- `int get(int key)`  
  Returns the value of the key if it exists, otherwise returns `-1`.

- `void put(int key, int value)`  
  Updates the value of the key if it exists. Otherwise, adds the key-value pair to the cache.  
  If the number of keys exceeds the capacity, evict the **least recently used** key.

---

### ⚡ Time Complexity Requirement

Both `get()` and `put()` must run in:

- **O(1)** average time complexity

---

## Example 1

### Input

```text
["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
[[2], [1,1], [2,2], [1], [3,3], [2], [4,4], [1], [3], [4]]
```

### Output:

```
[null, null, null, 1, null, -1, null, -1, 3, 4]
```

### Explanation: 

```

LRUCache lRUCache = new LRUCache(2);

lRUCache.put(1, 1); // cache is {1=1}
lRUCache.put(2, 2); // cache is {1=1, 2=2}

lRUCache.get(1);    // returns 1

lRUCache.put(3, 3); // LRU key was 2, evicts key 2
                    // cache is {1=1, 3=3}

lRUCache.get(2);    // returns -1 (not found)

lRUCache.put(4, 4); // LRU key was 1, evicts key 1
                    // cache is {4=4, 3=3}

lRUCache.get(1);    // returns -1 (not found)
lRUCache.get(3);    // returns 3
lRUCache.get(4);    // returns 4

```

**Constraints**

```text

1 <= capacity <= 3000

0 <= key <= 10^4

0 <= value <= 10^5

At most 2 * 10^5 calls will be made to get and put
```
## Solution

@import "LeetCode46LRUcacheUsingDLLAndHashMap.java"


---

# Question 13: ## 225. Implement Stack using Queues  
**Difficulty:** Easy  

---

### 📌 Problem

Implement a **LIFO Stack** using only **two queues**.

Design the `MyStack` class:

- `void push(int x)` → Push element `x` onto stack  
- `int pop()` → Removes and returns the top element  
- `int top()` → Returns the top element  
- `boolean empty()` → Returns `true` if stack is empty  

---

### Notes

- Only standard queue operations are allowed:  
  `push to back`, `pop/peek from front`, `size`, `isEmpty`

---

### Example

**Input**
```text
["MyStack", "push", "push", "top", "pop", "empty"]
[[], [1], [2], [], [], []]

```

**Output**
```text
[null, null, null, 2, 2, false]
```

**Explanation :**

``` text
MyStack myStack = new MyStack();
myStack.push(1);
myStack.push(2);
myStack.top();   // 2
myStack.pop();   // 2
myStack.empty(); // false
```

**Constraints**

``` text
1 <= x <= 9
At most 100 operations
pop and top are always valid
```

## Solution: 

@import "LeetCode225ImplementStackUsingQueues.java"

---

# Question 14: LeetCode 2095. Delete the Middle Node of a Linked List  
**Difficulty:** Medium  

---

### 📌 Problem

You are given the `head` of a linked list.  
Delete the **middle node**, and return the head of the modified list.

The middle node of a list of size `n` is the:

- ⌊n / 2⌋th node (0-based indexing)

For example:

- n = 1 → middle = 0  
- n = 2 → middle = 1  
- n = 3 → middle = 1  
- n = 4 → middle = 2  
- n = 5 → middle = 2  

---

### Example 1

**Input**
```text
head = [1,3,4,7,1,2,6]
```

**Output**

[1,3,4,1,2,6]


**Explanation**:
```text
n = 7 → middle index = 3 → node value = 7 is removed.
```

### Example 2


**Input :** head = [1,2,3,4]

**Output :** [1,2,4]

**Explanation**:
```text
n = 4 → middle index = 2 → node value = 3 is removed.
```
### Example 3

**Input :** head = [2,1]

**Output :** [2]

**Explanation**:
```text
n = 2 → middle index = 1 → node value = 1 is removed.
```

**Constraints**
```text
Number of nodes: [1, 10^5]

1 <= Node.val <= 10^5
```

## Solution: 

@import "LeetCode2095DeletetheMiddleNodeofLinkedList.java"

---

# Question 15: LeetCode74. Search a 2D Matrix  
**Difficulty:** Medium  

---

### 📌 Problem

You are given an `m x n` integer matrix with the following properties:

- Each row is sorted in **non-decreasing order**
- The first element of each row is **greater than** the last element of the previous row

Given an integer `target`, return:

- `true` if `target` exists in the matrix  
- `false` otherwise  

---

### Requirement

You must solve it in:

- **O(log(m * n))** time complexity

---

### Example 1

**Input**
```text
matrix = [[1,3,5,7],
          [10,11,16,20],
          [23,30,34,60]]
target = 3
```

**Output :** true

### Example 2

**Input**
```text
matrix = [[1,3,5,7],
          [10,11,16,20],
          [23,30,34,60]]
target = 13
```

**Output :** false

**Constraints**

```text
m == matrix.length

n == matrix[i].length

1 <= m, n <= 100

-10^4 <= matrix[i][j], target <= 10^4
```

## Solution:

@import "LeetCode74BinarySearch2DMatrix.java"