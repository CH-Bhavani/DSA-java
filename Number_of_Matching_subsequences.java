/*


Given a string s and an array of strings words, return the number of words[i] that is a subsequence of s.

A subsequence of a string is a new string generated from the original string with some characters (can be none) deleted without changing the relative order of the remaining characters.

For example, "ace" is a subsequence of "abcde".
 

Example 1:

Input: s = "abcde", words = ["a","bb","acd","ace"]
Output: 3
Explanation: There are three strings in words that are a subsequence of s: "a", "acd", "ace".
Example 2:

Input: s = "dsahjpjauf", words = ["ahjpjau","ja","ahbwzgqnuk","tnmlanowax"]
Output: 2


*/




class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        int count=0;
            for(String word:words)
            {
                if(issub(word,s)) count+=1;
            }
        return count;
    }
    private boolean issub(String w,String s){
        int prev=0,ind;
        for(char ch:w.toCharArray()){
            ind= s.indexOf(ch,prev);
            if(ind==-1) return false;
            else
                prev=ind+1;
        }
        return true;
    }
}
