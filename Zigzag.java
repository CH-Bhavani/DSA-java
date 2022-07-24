/*

The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"

Write the code that will take a string and make this conversion given a number of rows:

string convert(string s, int numRows);
 

Example 1:

Input: s = "PAYPALISHIRING", numRows = 3
Output: "PAHNAPLSIIGYIR"
Example 2:

Input: s = "PAYPALISHIRING", numRows = 4
Output: "PINALSIGYAHRPI"
Explanation:
P     I    N
A   L S  I G
Y A   H R
P     I
Example 3:

Input: s = "A", numRows = 1
Output: "A"

*/




class Solution {
    public String convert(String s, int numRows) {
        if(numRows==1)
            return s;
        List<StringBuilder> l=new ArrayList<>();
        for(int i=0;i<Math.min(numRows,s.length());i++)
            l.add(new StringBuilder());
        int r=0;
        boolean flag=false;
        for(char c:s.toCharArray()){
            l.get(r).append(c);
            if(r==0 || r==numRows-1)
                flag=!flag;
            r+=flag?1:-1;
            
        }
        StringBuilder res=new StringBuilder();
        for(StringBuilder row:l)
            res.append(row);
        return res.toString();
        
    }
}
