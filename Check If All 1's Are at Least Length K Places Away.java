/*


iven an binary array nums and an integer k, return true if all 1's are at least k places away from each other, otherwise return false.

 

Example 1:


Input: nums = [1,0,0,0,1,0,0,1], k = 2
Output: true
Explanation: Each of the 1s are at least 2 places away from each other.
Example 2:


Input: nums = [1,0,0,1,0,1], k = 2
Output: false
Explanation: The second 1 and third 1 are only one apart from each other.


*/



class Solution {
    public boolean kLengthApart(int[] nums, int k) {
        int first=-1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==1 && first==-1)
                first=i;
            else if(nums[i]==1)
            {
                if(i-first-1<k) return false;
                first=i;
            }
        }
        return true;
    }
}





//sol2

class Solution {
    public boolean kLengthApart(int[] nums, int k) {
        // initialize the counter of zeros to k
        // to pass the first 1 in nums
        int count = k;
        
        for (int num : nums) {
            // if the current integer is 1
            if (num == 1) {
                // check that number of zeros in-between 1s
                // is greater than or equal to k
                if (count < k) {
                    return false;    
                }
                // reinitialize counter
                count = 0;
                
            // if the current integer is 0
            } else {
                // increase the counter
                ++count;    
            } 
        }        
        return true;
    }
}





//sol3




