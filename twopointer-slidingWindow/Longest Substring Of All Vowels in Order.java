/*

A string is considered beautiful if it satisfies the following conditions:

Each of the 5 English vowels ('a', 'e', 'i', 'o', 'u') must appear at least once in it.
The letters must be sorted in alphabetical order (i.e. all 'a's before 'e's, all 'e's before 'i's, etc.).
For example, strings "aeiou" and "aaaaaaeiiiioou" are considered beautiful, but "uaeio", "aeoiu", and "aaaeeeooo" are not beautiful.

Given a string word consisting of English vowels, return the length of the longest beautiful substring of word. If no such substring exists, return 0.

A substring is a contiguous sequence of characters in a string.

 

Example 1:

Input: word = "aeiaaioaaaaeiiiiouuuooaauuaeiu"
Output: 13
Explanation: The longest beautiful substring in word is "aaaaeiiiiouuu" of length 13.
Example 2:

Input: word = "aeeeiiiioooauuuaeiou"
Output: 5
Explanation: The longest beautiful substring in word is "aeiou" of length 5.
Example 3:

Input: word = "a"
Output: 0
Explanation: There is no beautiful substring, so return 0.
 

Constraints:

1 <= word.length <= 5 * 105
word consists of characters 'a', 'e', 'i', 'o', and 'u'.



  */


class Solution {
    public int longestBeautifulSubstring(String word) {
        int a =0, e=1,i=2, o = 3, u =5;
        Map<Character, Integer> hm = new HashMap<>();
        int start =0, max =0;
        HashSet<Character> hs = new HashSet<>();
        hs.add(word.charAt(start));
        for(int end =1; end < word.length() ; end ++){
            if(word.charAt(end) < word.charAt(end -1)) {
                hs.clear();
                start = end;
            }
            hs.add(word.charAt(end));
            if(hs.size()==5){
                max = Math.max(max, end-start+1);
            }
            

        }
        return max;

    }
}
