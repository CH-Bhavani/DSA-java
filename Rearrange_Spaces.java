/*


You are given a string text of words that are placed among some number of spaces. Each word consists of one or more lowercase English letters and are separated by at least one space. It's guaranteed that text contains at least one word.

Rearrange the spaces so that there is an equal number of spaces between every pair of adjacent words and that number is maximized. If you cannot redistribute all the spaces equally, place the extra spaces at the end, meaning the returned string should be the same length as text.

Return the string after rearranging the spaces.

 

Example 1:

Input: text = "  this   is  a sentence "
Output: "this   is   a   sentence"
Explanation: There are a total of 9 spaces and 4 words. We can evenly divide the 9 spaces between the words: 9 / (4-1) = 3 spaces.
Example 2:

Input: text = " practice   makes   perfect"
Output: "practice   makes   perfect "
Explanation: There are a total of 7 spaces and 3 words. 7 / (3-1) = 3 spaces plus 1 extra space. We place this extra space at the end of the string.



*/




class Solution {
    public String reorderSpaces(String text) {
        int count=0;
        for(char t:text.toCharArray()){
            if(t==' ')
                count++; 
        }
        if(count==0)
            return text;
        String[] arr=text.trim().split("\\s+");
        if(arr.length==1){
            StringBuilder sbb=new StringBuilder();
            sbb.append(arr[0]);
            addSpace(sbb,count);
            return sbb.toString();
        }
        int n=count/(arr.length-1);
        int r=count%(arr.length-1);
        StringBuilder sb1=new StringBuilder();
        StringBuilder sb=new StringBuilder();
        addSpace(sb1,n);
        addSpace(sb,r);
        //System.out.println(count+" "+arr.length+" "+n+" "+r+" "+sb.toString()+"kk");
        StringBuilder sb2=new StringBuilder();
        int k=0;
        for(String a:arr){
            if(k==arr.length-1){
                sb2.append(a);
                sb2.append(sb);
            }
            else
            {
                sb2.append(a);
                sb2.append(sb1);
                k++;
            }
        }

        return sb2.toString();  
    }
    private static void addSpace(StringBuilder sb, int spaceCount){
        for(int j = 0; j < spaceCount; j++) sb.append(" ");
    }
}
