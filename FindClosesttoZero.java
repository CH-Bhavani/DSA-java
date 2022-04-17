/*



Given an integer array nums of size n, return the number with the value closest to 0 in nums. If there are multiple answers, return the number with the largest value.

 

Example 1:

Input: nums = [-4,-2,1,4,8]
Output: 1
Explanation:
The distance from -4 to 0 is |-4| = 4.
The distance from -2 to 0 is |-2| = 2.
The distance from 1 to 0 is |1| = 1.
The distance from 4 to 0 is |4| = 4.
The distance from 8 to 0 is |8| = 8.
Thus, the closest number to 0 in the array is 1.
Example 2:

Input: nums = [2,-1,1]
Output: 1
Explanation: 1 and -1 are both the closest numbers to 0, so 1 being larger is returned.
 

Constraints:

1 <= n <= 1000
-105 <= nums[i] <= 105


*/



class Solution {
    public int findClosestNumber(int[] nums) {
            int neg = -100001;
            int pos =  100001;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0)
                return 0;
            else if(nums[i]>0)
                pos=Math.min(pos,nums[i]);
            else
                neg=Math.max(neg,nums[i]);
        }
        return  -neg<pos?neg:pos;
    }
}

