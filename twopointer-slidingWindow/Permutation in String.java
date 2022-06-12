/*


\Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.

In other words, return true if one of s1's permutations is the substring of s2.

 

Example 1:

Input: s1 = "ab", s2 = "eidbaooo"
Output: true
Explanation: s2 contains one permutation of s1 ("ba").
Example 2:

Input: s1 = "ab", s2 = "eidboaoo"
Output: false



*/


class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int ws=0,matched=0;
        Map<Character,Integer> hm=new HashMap<>();
        for(char ch:s1.toCharArray())
            hm.put(ch,hm.getOrDefault(ch,0)+1);
        for(int we=0;we<s2.length();we++){
            char c=s2.charAt(we);
            if(hm.containsKey(c)){
                hm.put(c,hm.get(c)-1);
                if(hm.get(c)==0)
                    matched++;
            }
            if(matched==hm.size())
                return true;
            if(we>=s1.length()-1){
                char leftch=s2.charAt(ws++);
                if(hm.containsKey(leftch)){
                    if(hm.get(leftch)==0)
                        matched--;
                    hm.put(leftch,hm.get(leftch)+1);
                }
            }   
        }
        return false;
        
    }
}
