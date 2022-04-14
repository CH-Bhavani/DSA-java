/*

A string s is nice if, for every letter of the alphabet that s contains, it appears both in uppercase and lowercase. For example, "abABB" is nice because 'A' and 'a' appear, and 'B' and 'b' appear. However, "abA" is not because 'b' appears, but 'B' does not.

Given a string s, return the longest substring of s that is nice. If there are multiple, return the substring of the earliest occurrence. If there are none, return an empty string.

 

Example 1:

Input: s = "YazaAay"
Output: "aAa"
Explanation: "aAa" is a nice string because 'A/a' is the only letter of the alphabet in s, and both 'A' and 'a' appear.
"aAa" is the longest nice substring.
Example 2:

Input: s = "Bb"
Output: "Bb"
Explanation: "Bb" is a nice string because both 'B' and 'b' appear. The whole string is a substring.
Example 3:

Input: s = "c"
Output: ""
Explanation: There are no nice substrings.

*/




class Solution {
    public String longestNiceSubstring(String s) {
        int max=Integer.MIN_VALUE;
        String fin="";
        for(int i=0;i<s.length();i++){
            for(int j=i+1;j<s.length();j++){
                String sub=s.substring(i,j+1);
                boolean v=check(sub);
                if(v){
                    if(sub.length()>max){
                        fin=sub;
                        max=sub.length();   
                }  
            }
        }
    }
        return fin;
    }
    public static boolean check(String sub){
        Set<Character> set=new HashSet<>();
        for(int i=0;i<sub.length();i++){
            set.add(sub.charAt(i));
        }
        Iterator<Character> i=set.iterator();
        while(i.hasNext()){
            Character c=i.next();
            if(Character.isUpperCase(c)){
                if(!set.contains(Character.toLowerCase(c)))
                    return false;
            }
            if(Character.isLowerCase(c)){
                if(!set.contains(Character.toUpperCase(c)))
                    return false;
            }
        }
        return true;
    }
}
