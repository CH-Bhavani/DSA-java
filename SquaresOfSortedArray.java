/*

Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted in non-decreasing order.

 

Example 1:

Input: nums = [-4,-1,0,3,10]
Output: [0,1,9,16,100]
Explanation: After squaring, the array becomes [16,1,0,9,100].
After sorting, it becomes [0,1,9,16,100].
Example 2:

Input: nums = [-7,-3,2,3,11]
Output: [4,9,9,49,121]


*/


// two pointer approach

class Solution {
    public int[] sortedSquares(int[] nums) {
     int st=0,e=nums.length-1,ind=nums.length-1;
        int[] arr=new int[e+1];
        while(st<=e){
            if(Math.abs(nums[st])>Math.abs(nums[e]))
                arr[ind--]=nums[st]*nums[st++];
            else
                arr[ind--]=nums[e]*nums[e--];
                
        }
        return arr;
    }
}
