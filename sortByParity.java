/*

Given an array of integers nums, half of the integers in nums are odd, and the other half are even.

Sort the array so that whenever nums[i] is odd, i is odd, and whenever nums[i] is even, i is even.

Return any answer array that satisfies this condition.

 

Example 1:

Input: nums = [4,2,5,7]
Output: [4,5,2,7]
Explanation: [4,7,2,5], [2,5,4,7], [2,7,4,5] would also have been accepted.
Example 2:

Input: nums = [2,3]
Output: [2,3]

*/

class Solution {
    public int[] sortArrayByParityII(int[] arr) {
        int i=0,j=1,n=arr.length;
        while(i<n && j<n){
            while(i<n && arr[i]%2==0)
                i+=2;
            while(j<n && arr[j]%2==1)
                j+=2;
            if(i<n && j<n){
                int temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
                i+=2;
                j+=2;
            }
        }
        return arr;
    }
}

