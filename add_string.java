/*





Given two non-negative integers, num1 and num2 represented as string, return the sum of num1 and num2 as a string.

You must solve the problem without using any built-in library for handling large integers (such as BigInteger). You must also not convert the inputs to integers directly.

 

Example 1:

Input: num1 = "11", num2 = "123"
Output: "134"
Example 2:

Input: num1 = "456", num2 = "77"
Output: "533"
Example 3:

Input: num1 = "0", num2 = "0"
Output: "0"









*/






class Solution {
    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder(); // this will contain the ans
        int carry=0;
        for(int l=num1.length()-1, r=num2.length()-1;l>=0||r>=0||carry>0;l--,r--){
            int a=0, b=0;
            if(l>=0) // in case num2 is smaller than num1
                a = num1.charAt(l)-'0';
            if(r>=0) // in case num1 is smaller than num2
                b = num2.charAt(r)-'0';
            int res = a+b+carry;
            sb.append((char)(res%10+'0'));
            carry=res/10;
        }
        return sb.reverse().toString();
    }
}
