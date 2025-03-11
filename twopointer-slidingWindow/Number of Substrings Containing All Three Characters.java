/*

Given a string s consisting only of characters a, b and c.

Return the number of substrings containing at least one occurrence of all these characters a, b and c.

 

Example 1:

Input: s = "abcabc"
Output: 10
Explanation: The substrings containing at least one occurrence of the characters a, b and c are "abc", "abca", "abcab", "abcabc", "bca", "bcab", "bcabc", "cab", "cabc" and "abc" (again). 
Example 2:

Input: s = "aaacb"
Output: 3
Explanation: The substrings containing at least one occurrence of the characters a, b and c are "aaacb", "aacb" and "acb". 
Example 3:

Input: s = "abc"
Output: 1
 

Constraints:

3 <= s.length <= 5 x 10^4
s only consists of a, b or c characters.

  */

class Solution {
    public int numberOfSubstrings(String s) {
        
        int start = 0,count =0;
        int[] charCount = new int[3];
        for(int end = 0; end< s.length() ; end++){
            charCount[s.charAt(end) - 'a']++;
            while(charCount[0] > 0 && charCount[1] > 0 && charCount[2] > 0)
                {
                    count += s.length() - end;
                    charCount[s.charAt(start) - 'a']--;
                    start ++;
                }

        }
        return count ;
    }
}

// a b c a b c
// 0 1 2 3 4 5 

//  b c  6- 2 = 4;
//  c a 6 -3 = 3
//  c a b 6-4 = 2
// b c 6-5 =1









