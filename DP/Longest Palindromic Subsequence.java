/*


Given a string s, find the longest palindromic subsequence's length in s.

A subsequence is a sequence that can be derived from another sequence by deleting some or no elements without changing the order of the remaining elements.

 

Example 1:

Input: s = "bbbab"
Output: 4
Explanation: One possible longest palindromic subsequence is "bbbb".
Example 2:

Input: s = "cbbd"
Output: 2
Explanation: One possible longest palindromic subsequence is "bb".
 

Constraints:

1 <= s.length <= 1000
s consists only of lowercase English letters.
*/

class Solution {
    public int longestPalindromeSubseq(String s) {
        if(s.length()==0 || s==null)
            return 0;
        int[][] dp=new int[s.length()+1][s.length()+1];
        String rev= new StringBuilder(s).reverse().toString();
        for(int i=0;i<s.length();i++){
            for(int j=0;j<s.length();j++){
                dp[i+1][j+1]=s.charAt(i)==rev.charAt(j)?dp[i][j]+1:Math.max(dp[i+1][j],dp[i][j+1]);
            }
        }
        return dp[s.length()][s.length()];
    }
}
