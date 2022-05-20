/*

Given an integer array nums and an integer k, return true if there are two distinct indices i and j in the array such that nums[i] == nums[j] and abs(i - j) <= k.

 

Example 1:

Input: nums = [1,2,3,1], k = 3
Output: true
Example 2:

Input: nums = [1,0,1,1], k = 1
Output: true
Example 3:

Input: nums = [1,2,3,1,2,3], k = 2
Output: false

*/
class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if(nums.length==1)
            return false;
        int ws=0;
        HashSet<Integer> hs=new HashSet<>();
        for(int we=0;we<nums.length;we++){
            //System.out.println("1"+hs);
            if(hs.contains(nums[we]))
                return true;
            hs.add(nums[we]);
            if(we-ws>=k){
                hs.remove(nums[ws]);
                ws++;}
            //System.out.println("2"+hs);
        }
        return false;
    
    }
}

