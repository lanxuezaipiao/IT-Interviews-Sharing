## 题目1 : Beautiful String

时间限制:10000ms
单点时限:1000ms
内存限制:256MB

### 描述

We say a string is beautiful if it has the equal amount of 3 or more continuous letters (in increasing order.)

Here are some example of valid beautiful strings: "abc", "cde", "aabbcc", "aaabbbccc".

Here are some example of invalid beautiful strings: "abd", "cba", "aabbc", "zab".

Given a string of alphabets containing only lowercase alphabets (a-z), output "YES" if the string contains a beautiful sub-string, otherwise output "NO".

### 输入

The first line contains an integer number between 1 and 10, indicating how many test cases are followed.

For each test case: First line is the number of letters in the string; Second line is the string. String length is less than 10MB.

### 输出

For each test case, output a single line "YES"/"NO" to tell if the string contains a beautiful sub-string.

### 提示

Huge input. Slow IO method such as Scanner in Java may get TLE.
#### 样例输入
4
3
abc
4
aaab
6
abccde
3
abb

#### 样例输出
YES
NO
YES
NO



## 题目2 : Performance Log

时间限制:8000ms
单点时限:1000ms
内存限制:256MB

### 描述

You are given a txt file, which is performance logs of a single-threaded program.
Each line has three columns as follow:
[Function Name] [TimeStamp] [Action]
[FunctionName] is a string of length between 1~255
[TimeStamp] format is hh:mm:ss
Valid values for "Action" column are START or END, marking the start or end of a function call.
Each function will only be called once.
Output the depth-first traversal result of the call graph with the total time of each function call. However, sometimes the performance log isn't correct and at that time you just need to output "Incorrect performance log".

### 输入

The input only contains 1 case, first line is a positive number N representing the number of logs(1 <= N <= 20000), then there are N lines in next, each line is the log info containing [Function Name] [TimeStamp] [Action], [Function Name] is a string, you can assume the [Function Name] is distinct and the length between 1~255.

### 输出

Output the depth-first traversal result of the call graph with the total time of each function call for the correct performance, or output "Incorrect performance log".

### 提示

A call graph is a directed graph that represents calling relationships between subroutines in a computer program.
Call graph for the sample input is shown as below:

Another sample test case.
|| Sample Input ||	Sample Output ||
||8
FuncA 00:00:01 START
FuncB 00:00:02 START
FuncC 00:00:03 START
FuncA 00:00:04 END
FuncB 00:00:05 END
FuncD 00:00:06 START
FuncD 00:00:07 END
FuncC 00:00:08 END	|| Incorrect performance log ||



#### 样例输入
8
FuncA 00:00:01 START
FuncB 00:00:02 START
FuncC 00:00:03 START
FuncC 00:00:04 END
FuncB 00:00:05 END
FuncD 00:00:06 START
FuncD 00:00:07 END
FuncA 00:00:08 END

#### 样例输出
FuncA 00:00:07
FuncB 00:00:03
FuncC 00:00:01
FuncD 00:00:01



## 题目3 : String Matching Content Length

时间限制:10000ms
单点时限:1000ms
内存限制:256MB

### 描述

We define the matching contents in the strings of strA and strB as common substrings of the two strings. There are two additional restrictions on the common substrings.
The first restriction here is that every common substring's length should not be less than 3.  For example:
strA: abcdefghijklmn
strB: ababceghjklmn
The matching contents in strA and strB are substrings ("abc", "jklmn"). Note that though "e" and "gh" are common substrings of strA and strB, they are not matching content because their lengths are less than 3.
The second restriction is that the start indexes of all common substrings should be monotone increasing. For example:
strA: aaabbbbccc
strB: aaacccbbbb
The matching contents in strA and strB are substrings ("aaa", "bbbb"). Note that though "ccc" is common substring of strA and strB and has length not less than 3, the start indexes of ("aaa", "bbbb", "ccc") in strB are (0, 6, 3), which is not monotone increasing.

### 输入

Two lines. The first line is strA and the second line is strB. Both strA and strB are of length less than 2100.

### 输出


The maximum length of matching contents (the sum of the lengths of the common substrings).
#### 样例输入
abcdefghijklmn
ababceghjklmn

#### 样例输出
8


## 题目4 : Combination Lock

时间限制:10000ms
单点时限:1000ms
内存限制:256MB

### 描述


Finally, you come to the interview room. You know that a Microsoft interviewer is in the room though the door is locked. There is a combination lock on the door. There are N rotators on the lock, each consists of 26 alphabetic characters, namely, 'A'-'Z'. You need to unlock the door to meet the interviewer inside. There is a note besides the lock, which shows the steps to unlock it.
Note: There are M steps totally; each step is one of the four kinds of operations shown below:
Type1: CMD 1 i j X: (i and j are integers, 1 <= i <= j <= N; X is a character, within 'A'-'Z')
This is a sequence operation: turn the ith to the jth rotators to character X (the left most rotator is defined as the 1st rotator)
For example: ABCDEFG => CMD 1 2 3 Z => AZZDEFG
Type2: CMD 2 i j K: (i, j, and K are all integers, 1 <= i <= j <= N)
This is a sequence operation: turn the ith to the jth rotators up K times ( if character A is turned up once, it is B; if Z is turned up once, it is A now. )
For example: ABCDEFG => CMD 2 2 3 1 => ACDDEFG
Type3: CMD 3 K: (K is an integer, 1 <= K <= N)
This is a concatenation operation: move the K leftmost rotators to the rightmost end.
For example: ABCDEFG => CMD 3 3 => DEFGABC
Type4: CMD 4 i j(i, j are integers, 1 <= i <= j <= N):
This is a recursive operation, which means:
If i > j:
	Do Nothing
Else:
	CMD 4 i+1 j
	CMD 2 i j 1
For example: ABCDEFG => CMD 4 2 3 => ACEDEFG

### 输入

1st line:  2 integers, N, M ( 1 <= N <= 50000, 1 <= M <= 50000 )
2nd line: a string of N characters, standing for the original status of the lock.
3rd ~ (3+M-1)th lines: each line contains a string, representing one step.

### 输出

One line of N characters, showing the final status of the lock.

### 提示

Come on! You need to do these operations as fast as possible.

####

 样例输入
7 4
ABCDEFG
CMD 1 2 5 C
CMD 2 3 7 4
CMD 3 3
CMD 4 1 7

#### 样例输出
HIMOFIN