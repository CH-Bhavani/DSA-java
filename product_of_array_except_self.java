/*

Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].

The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

You must write an algorithm that runs in O(n) time and without using the division operation.

 

Example 1:

Input: nums = [1,2,3,4]
Output: [24,12,8,6]
Example 2:

Input: nums = [-1,1,0,-3,3]
Output: [0,0,9,0,0]




*/





class Solution {
    public int[] productExceptSelf(int[] nums) {
        int l = nums.length;
        
        int[] res = new int[l];
        int[] left = new int[l];
        int[] right = new int[l];
//         Left and right extreme elements have no product in their either sides, so keeping their values = 1.
        left[0] = 1;
        right[l-1] = 1;
        
//         Computing the left side of product for every element
        for(int i=1;i<l; i++) {
            left[i] = left[i-1] * nums[i-1];
        }
//         Computing the right side of product for every element
        for(int j=l-2;j>=0; j--) {
            right[j] = right[j+1] * nums[j+1];
        }
//         Computing the values, for any ith index multiply products on it's left side and of it's right side as computed, so we can skip that value
        for(int i=0;i<l;i++) {
            res[i] = left[i] * right[i];
        }
        return res;
    }
}
