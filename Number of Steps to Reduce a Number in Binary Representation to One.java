/*


Given the binary representation of an integer as a string s, return the number of steps to reduce it to 1 under the following rules:

If the current number is even, you have to divide it by 2.

If the current number is odd, you have to add 1 to it.

It is guaranteed that you can always reach one for all test cases.

 

Example 1:

Input: s = "1101"
Output: 6
Explanation: "1101" corressponds to number 13 in their decimal representation.
Step 1) 13 is odd, add 1 and obtain 14. 
Step 2) 14 is even, divide by 2 and obtain 7.
Step 3) 7 is odd, add 1 and obtain 8.
Step 4) 8 is even, divide by 2 and obtain 4.  
Step 5) 4 is even, divide by 2 and obtain 2. 
Step 6) 2 is even, divide by 2 and obtain 1.  
Example 2:

Input: s = "10"
Output: 1
Explanation: "10" corressponds to number 2 in their decimal representation.
Step 1) 2 is even, divide by 2 and obtain 1.  
Example 3:

Input: s = "1"
Output: 0





*/





/* explanation


Approach:
**NOTE : **

Binary representation of any even no. ends with 0.
Eg: 10 ---> 1010
Binary represention of any odd no. ends with 1.
Eg : 13 ----> 1101
With this information we move on with the solution.
According to the question,

If we have an odd decimal no. , say 13, we have to add 1 to it.
If we have an even decimal no. , say 12 , we have to divide it by 2.
Following these rules we have to find out the no. of steps required to reach 1.
Whenever we have a odd no. we have to do 2 operations :-
1.Add 1 : Carry becomes 1
2.Divide by 2
Whenever we have even no. we have to do 1 operation:-
Divide by 2.
Algorithm:
Intialize carry = 0, ans = 0
We iterate character of binary string from the end to the beginning, i = [n-1..1], except the first digit
If s[i] + carry == 1 -> It's an odd number, we need 2 operations: Add 1 and Divide by two, ans += 2
Else if s[i] + carry == 0 -> It's an even number, we need 1 operation: Divide by two, ans += 1
Then finally, if carry = 1 then total = s[0] + carry = 2, need one additional operation divide by 2 to become one, else if carry = 0 then total = s[0] + carry = 1, no need any additional operation.
So the result is ans + carry
Code: [ T.C-O(N) ]




*/




class Solution 
{
    public int numSteps(String s)
    {
        int countSteps = 0;
        int carry = 0;
        for(int i = s.length()-1;i>=1;i--)
        {
            int rightMostBit = s.charAt(i)-'0';
            if((rightMostBit+carry) == 1)
            {
                carry=1;
                countSteps += 2;
            }
            else
            {
                countSteps++;
            }
        }
        return countSteps+carry;
    }
} 
