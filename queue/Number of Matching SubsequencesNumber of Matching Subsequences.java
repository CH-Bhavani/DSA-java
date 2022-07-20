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
        Map<Character,Queue<String>> hm=new HashMap<>();
        
        for(int i=0;i<s.length();i++)
            hm.putIfAbsent(s.charAt(i),new LinkedList<>());
        
        for(String word:words){
            char f=word.charAt(0);
            if(hm.containsKey(f)){
                hm.get(f).offer(word);
            }
        }
        int ans=0;
        for(int i=0;i<s.length();i++){
            char startchar=s.charAt(i);
            Queue<String> q=hm.get(startchar);
            int size=q.size();
            for(int k=0;k<size;k++){
                String str=q.poll();
                if(str.substring(1).length()==0)
                    ans++;
                else{
                    if(hm.containsKey(str.charAt(1))){
                        hm.get(str.charAt(1)).add(str.substring(1));
                    }
                }
            }
        }
        return ans;
        
    }
}
