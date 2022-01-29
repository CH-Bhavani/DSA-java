/*

Given two strings s and t, return true if s is a subsequence of t, or false otherwise.

A subsequence of a string is a new string that is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (i.e., "ace" is a subsequence of "abcde" while "aec" is not).

 

Example 1:

Input: s = "abc", t = "ahbgdc"
Output: true
Example 2:

Input: s = "axc", t = "ahbgdc"
Output: false
*/



class Solution {
    public boolean isSubsequence(String s, String t) {
      int k=0;
        if(s.length()==0)return true;
        if(s.length()>t.length())return false;
        if(s.length()==t.length() && !s.equals(t))return false;
      
        for(int i=0;i<=t.length()-1;i++){
            if( k!=s.length() && s.charAt(k)==t.charAt(i) ){
                k++;
            }
        }
        return k==s.length();
    }
}
