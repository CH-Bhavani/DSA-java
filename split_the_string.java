/*


Given a string s, return the number of segments in the string.

A segment is defined to be a contiguous sequence of non-space characters.

 

Example 1:

Input: s = "Hello, my name is John"
Output: 5
Explanation: The five segments are ["Hello,", "my", "name", "is", "John"]
Example 2:

Input: s = "Hello"
Output: 1



*/




sol:1
  
  
  
  
  class Solution {
    public int countSegments(String s) {
        String[] arr=s.trim().split(" ");
        int count=0;
        for(String str:arr){
            if(str.length()!=0)
                count++;
        }
        return count;
            
    }
}







sol:2
  
  
  
  
  class Solution {
    public int countSegments(String s) {
        int l = s.length();
        int count=0;
        int i = 0;
        if(s.length() >0 ){
        while(i<l){
            if(i== l-1 && s.charAt(i) == ' ')
                break;
            if(s.charAt(i) == ' ' && s.charAt(i+1) != ' ')
                count++;
            i++;
        }
        if(s.charAt(0) != ' ')
            count++;
        }
        return count;
    }
}
