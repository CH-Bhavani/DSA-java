/*

Reversing an integer means to reverse all its digits.

For example, reversing 2021 gives 1202. Reversing 12300 gives 321 as the leading zeros are not retained.
Given an integer num, reverse num to get reversed1, then reverse reversed1 to get reversed2. Return true if reversed2 equals num. Otherwise return false.

 

Example 1:

Input: num = 526
Output: true
Explanation: Reverse num to get 625, then reverse 625 to get 526, which equals num.
Example 2:

Input: num = 1800
Output: false
Explanation: Reverse num to get 81, then reverse 81 to get 18, which does not equal num.
Example 3:

Input: num = 0
Output: true
Explanation: Reverse num to get 0, then reverse 0 to get 0, which equals num.



*/





class Solution {
public boolean isSameAfterReversals(int num) {

// Basically if there is non zero digit at end of given number then after double reversing we will get same number

// but when there is zero at end of given number then it will not equal after double reversing so for all case where there is zero at end it will be false

    if(num == 0){ // base condition
        return true;
    }
    if(num % 10 != 0){  // if last digit is non zero automatically it will be true
        return true;
    }
    return false;      // if not then false
}
}
