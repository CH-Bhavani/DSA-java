/*
Given an array of distinct integers nums and a target integer target, return the number of possible combinations that add up to target.

The test cases are generated so that the answer can fit in a 32-bit integer.
Example 1:

Input: nums = [1,2,3], target = 4
Output: 7
Explanation:
The possible combination ways are:
(1, 1, 1, 1)
(1, 1, 2)
(1, 2, 1)
(1, 3)
(2, 1, 1)
(2, 2)
(3, 1)
Note that different sequences are counted as different combinations.
Example 2:

Input: nums = [9], target = 3
Output: 0
 

Constraints:

1 <= nums.length <= 200
1 <= nums[i] <= 1000
All the elements of nums are unique.
1 <= target <= 1000
 

*/


//Approach 1: 100% Faster Dynamic Programming - Top Down Approach
// Time Complexity: O(n*target) | Space Complexity: O(target)
/*
Runtime: 0 ms, faster than 100.00% of Java online submissions for Combination Sum IV.
Memory Usage: 39.9 MB, less than 87.07% of Java online submissions for Combination Sum IV.
*/
class Solution {
    static int[] dp;
    public int combinationSum4(int[] nums, int target) {
        
        dp = new int[target + 1];
        Arrays.fill(dp, -1);
        dp[0] = 1;
        helper(nums, target);
        return dp[target];
    }
    
    public static int helper(int[] nums, int target){
        if(dp[target]> -1){
            return dp[target];
        }
        int res = 0;
        
        for(int i : nums){
            if(i<=target){
                res += helper(nums, target-i);
            }
        }
        
        dp[target] = res;
        return dp[target];
    }
}
      
//Approach 2: 92% Faster Dynamic Programming -  Bottom Up Approach
// Time Complexity: O(n*target) | Space Complexity: O(target)
class Solution {
    static int[] dp;
    public int combinationSum4(int[] nums, int target) {
        
        dp = new int[target + 1];

        dp[0] = 1;
        for(int i=1; i<=target; i++){
            for(int n : nums){
                if(i>=n){
                    dp[i] += dp[i-n];
                }
            }
        }
        return dp[target];
    }
}
        

//Approach 3:(Recursion) Brute Force --> Works, but TLE in Online Compilers
class Solution {
    public int combinationSum4(int[] nums, int target) {
        
        if(target == 0){
            return 1;
        }
        int res = 0;
        for(int i : nums){
            if(i<=target){
                res += combinationSum4(nums, target-i);
            }
        }
        return res;
    }
}
