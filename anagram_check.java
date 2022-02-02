/*


Given two strings s and p, return an array of all the start indices of p's anagrams in s. You may return the answer in any order.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

 

Example 1:

Input: s = "cbaebabacd", p = "abc"
Output: [0,6]
Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".
Example 2:

Input: s = "abab", p = "ab"
Output: [0,1,2]
Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab".

*/



class Solution {
public List<Integer> findAnagrams(String s, String p) {
		//list to hold answer
		List<Integer> list = new ArrayList<>();
		//if length of p is more than entire s. answer is not possible
		if (p.length() > s.length()) {
			return list;
		}
		//map to hold freq of window length
        int[] freq = new int[26];
		//preparefreq map by adding p character count and subtracting s character count
		for (int i = 0; i < p.length(); i++) {
			freq[p.charAt(i) - 'a'] += 1;
			freq[s.charAt(i) - 'a'] -= 1;
		}
		int i = 0;
		for (; i < s.length() - p.length(); i++) {
		//if freq map has all zero it means it is an anagaram
			if (checkAnagram(freq)) {
				list.add(i);
			}
			//now for next index comparison remove ith char and add i +p.length() char to freq map
			freq[s.charAt(i) - 'a'] += 1;
			freq[s.charAt(i + p.length()) - 'a'] -= 1;
		}
       //since last comparison left. check it also
	   if (checkAnagram(freq)) {
			list.add(i);
		}
		//return list
		return list;
	}
	
	private boolean checkAnagram(int[] freq) {
		for (int i = 0; i < freq.length; i++) {
			if (freq[i] != 0) {
				return false;
			}
		}
		return true;
	}    
}
