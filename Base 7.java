/*
Given an integer num, return a string of its base 7 representation.

 

Example 1:

Input: num = 100
Output: "202"
Example 2:

Input: num = -7
Output: "-10"

*/




class Solution {
    public String convertToBase7(int num) {    
    int multiplier=0;
     int ans=0;
     while(num != 0){ 
     int remainder = num % 7;           
     num = num/ 7;
     ans +=remainder*Math.pow(10,multiplier);       
    multiplier++;
     }
    return Integer.toString(ans);
    }
}
