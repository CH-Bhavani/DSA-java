/*
Given an integer n, return true if it is a power of four. Otherwise, return false.

An integer n is a power of four, if there exists an integer x such that n == 4x.

 

Example 1:

Input: n = 16
Output: true
Example 2:

Input: n = 5
Output: false
Example 3:

Input: n = 1
Output: true
 

Constraints:

-231 <= n <= 231 - 1
*/
class Solution {
    public boolean isPowerOfFour(int n) {
       double res=Math.log(n)/Math.log(4);
        if(Math.round(res)==res)
            return true;
        else
            return false;
            
            
        // or 
        //return res%1==0.0;
     
     
     // or
     
     
     return (Math.log10(n) / Math.log10(4)) % 1 == 0;
    }
}
