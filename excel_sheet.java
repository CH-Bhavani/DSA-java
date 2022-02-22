/*

Given a string columnTitle that represents the column title as appear in an Excel sheet, return its corresponding column number.

For example:

A -> 1
B -> 2
C -> 3
...
Z -> 26
AA -> 27
AB -> 28 
...
 

Example 1:

Input: columnTitle = "A"
Output: 1
Example 2:

Input: columnTitle = "AB"
Output: 28
Example 3:

Input: columnTitle = "ZY"
Output: 701

*/



class Solution {
    public int titleToNumber(String columnTitle) {
        HashMap<Character,Integer> hash=new HashMap<>();
        int j=0,sum=0;
        for(char c='A';c<='Z';c++){
            hash.put(c,1+j);
            j++;
        }
        for(int i=0;i<columnTitle.length();i++){
            sum=sum*26+hash.get(columnTitle.charAt(i));
        }
        return sum;
        
    }
}
