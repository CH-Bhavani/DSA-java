/*
Given a string s, you can transform every letter individually to be lowercase or uppercase to create another string.

Return a list of all possible strings we could create. Return the output in any order.

 

Example 1:

Input: s = "a1b2"
Output: ["a1b2","a1B2","A1b2","A1B2"]
Example 2:

Input: s = "3z4"
Output: ["3z4","3Z4"]



*/
class Solution {
    public List<String> letterCasePermutation(String s) {
        List<String> res=new ArrayList<>();
        Permutation(res,s,0);
        return res;
    }
    public void Permutation(List<String> res,String s,int start){
        res.add(s);
        for(int i=start;i<s.length();i++){
            char[] word=s.toCharArray();
            if(Character.isLetter(s.charAt(i))){
                if(Character.isUpperCase(s.charAt(i)))
                {
                    word[i]=Character.toLowerCase(s.charAt(i));
                    Permutation(res,String.valueOf(word),i+1);
                }
                else{
                    word[i]=Character.toUpperCase(s.charAt(i));
                    Permutation(res,String.valueOf(word),i+1);
                }
                
            }
        }
    }
}

