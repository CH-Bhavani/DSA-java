/*
You are given a string s and an integer k. You can choose any character of the string and change it to any other uppercase English character. You can perform this operation at most k times.

Return the length of the longest substring containing the same letter you can get after performing the above operations.

 

Example 1:

Input: s = "ABAB", k = 2
Output: 4
Explanation: Replace the two 'A's with two 'B's or vice versa.
Example 2:

Input: s = "AABABBA", k = 1
Output: 4
Explanation: Replace the one 'A' in the middle with 'B' and form "AABBBBA".
The substring "BBBB" has the longest repeating letters, which is 4.

*/

class Solution {
    public int characterReplacement(String s, int k) {
        int[] table= new int[26];
        int result=0;
        int maxF=0;
        for(int r=0,l=0;r<s.length();r++) {
            table[s.charAt(r)-'A']+=1;
            maxF=Math.max(table[s.charAt(r)-'A'],maxF);
            if((r-l+1)-maxF>k) {
                table[s.charAt(l)-'A']-=1;
                l++;
            }
            result=Math.max(result,r-l+1);
        }
        return result;

    }
}

