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
    public boolean wordPattern(String p, String s) {
        HashMap<String ,Character> hs=new HashMap<>();
        String[] str=s.split(" ");
        if (str.length!=p.length())
            return false;
        for(int i=0;i<str.length;i++){
            if(!hs.containsKey(str[i])){
                if(!hs.containsValue(p.charAt(i)))
                    hs.put(str[i],p.charAt(i));
                else
                    return false;
            }
            else
                if(!hs.get(str[i]).equals(p.charAt(i)))
                    return false;     
                    
        }
        return true;
    }
}
