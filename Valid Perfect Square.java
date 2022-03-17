/*
Given a positive integer num, write a function which returns True if num is a perfect square else False.

Follow up: Do not use any built-in library function such as sqrt.

 

Example 1:

Input: num = 16
Output: true
Example 2:

Input: num = 14
Output: false
*/



// method-1


class Solution {
    public boolean isPerfectSquare(int num) {
        return Math.ceil(Math.sqrt(num))==Math.floor(Math.sqrt(num));
    }
}





// method-2


class Solution {
    public boolean isPerfectSquare(int num) {
        int low=1; int high=num;long mid=-1;
        while(low<=high){
            mid = low +(high-low)/2;
            if(mid*mid==num){
                return true;
            }
            else if(mid*mid>num){
                high=(int)mid-1;
            }
            else{
                low=(int)mid+1;
            }
        }
        return false;
    }
}


