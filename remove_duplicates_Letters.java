/*

Given a string s, remove duplicate letters so that every letter appears once and only once. You must make sure your result is the smallest in lexicographical order among all possible results.

 

Example 1:

Input: s = "bcabc"
Output: "abc"
Example 2:

Input: s = "cbacdcbc"
Output: "acdb"
*/



class Solution {
    public String removeDuplicateLetters(String s) {
        Stack<Character> stk=new Stack<>();
        int n=s.length();
        int[] count= new int[26];
        boolean[] valid =new boolean[26];
        for(char c: s.toCharArray()) count[c-'a']++;
        for(char c:s.toCharArray()){
            count[c-'a']--;
            if(valid[c-'a']) continue;
            while(!stk.isEmpty() &&  stk.peek()>c && count[stk.peek()-'a']>0)
                valid[stk.pop()-'a']=false;
            stk.push(c);
            valid[c-'a']=true;
        }
        StringBuilder sb=new StringBuilder();
        while(!stk.isEmpty())
            sb.append(stk.pop());
        return sb.reverse().toString();
    }
}
