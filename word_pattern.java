/*


Given a pattern and a string s, find if s follows the same pattern.

Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in s.

 

Example 1:

Input: pattern = "abba", s = "dog cat cat dog"
Output: true
Example 2:

Input: pattern = "abba", s = "dog cat cat fish"
Output: false
Example 3:

Input: pattern = "aaaa", s = "dog cat cat dog"
Output: false


*/





class Solution {
    public boolean wordPattern(String pattern, String s) {
        Map<Character,String> map = new HashMap<Character,String>();
        String[] words = s.split(" ");
        if(pattern.length() != words.length)
            return false;
        for(int i=0; i <pattern.length(); i++){
            char pt = pattern.charAt(i);
            if(map.containsKey(pt)){
                if(map.get(pt).equals(words[i]))
                    continue;
                else
                    return false;
            }
            else{
                if(!map.containsValue(words[i]))
                    map.put(pt,words[i]);
                else
                    return false;
            }
        }
        return true;
    }
}
