/*
A substring is a contiguous (non-empty) sequence of characters within a string.

A vowel substring is a substring that only consists of vowels ('a', 'e', 'i', 'o', and 'u') and has all five vowels present in it.

Given a string word, return the number of vowel substrings in word.

 

Example 1:

Input: word = "aeiouu"
Output: 2
Explanation: The vowel substrings of word are as follows (underlined):
- "aeiouu"
- "aeiouu"
Example 2:

Input: word = "unicornarihan"
Output: 0
Explanation: Not all 5 vowels are present, so there are no vowel substrings.
Example 3:

Input: word = "cuaieuouac"
Output: 7
Explanation: The vowel substrings of word are as follows (underlined):
- "cuaieuouac"
- "cuaieuouac"
- "cuaieuouac"
- "cuaieuouac"
- "cuaieuouac"
- "cuaieuouac"
- "cuaieuouac"

*/



class Solution {
    public int countVowelSubstrings(String word) {
        int n=word.length(),vowel=0;
        HashSet<Character> hs=new HashSet<>();
        for(int i=0;i<n-4;i++){
            int j=i;
            hs.clear();
            while(j<n){
                char ch=word.charAt(j);
                if(ch=='a' || ch=='e'|| ch=='i'|| ch=='o'|| ch=='u'){
                    hs.add(ch);
                    if(hs.size()==5)
                        vowel++;
                    j++;
                }
                else
                    break;
            }
        }
            return vowel;
        }
    }
