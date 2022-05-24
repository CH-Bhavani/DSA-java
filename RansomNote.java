/*


Given two strings ransomNote and magazine, return true if ransomNote can be constructed from magazine and false otherwise.

Each letter in magazine can only be used once in ransomNote.

 

Example 1:

Input: ransomNote = "a", magazine = "b"
Output: false
Example 2:

Input: ransomNote = "aa", magazine = "ab"
Output: false
Example 3:

Input: ransomNote = "aa", magazine = "aab"
Output: true

*/


//sol-1
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        if(magazine.length()<ransomNote.length())
            return false;
        int[] atoz=new int[26];
        for(char c:ransomNote.toCharArray()){
            int index=magazine.indexOf(c,atoz[c-'a']);
            if(index==-1)
                return false;
            atoz[c-'a']=index+1;
        }
        return true;
    }
}



// sol-2


class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        if(magazine.length()<ransomNote.length())
            return false;
        int[] atoz=new int[26];
        for(char c:ransomNote.toCharArray()){
            int index=magazine.indexOf(c,atoz[c-'a']);
            if(index==-1)
                return false;
            atoz[c-'a']=index+1;
        }
        return true;
    }
}
