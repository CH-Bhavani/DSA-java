/*Given an integer array nums where every element appears three times except for one, which appears exactly once. Find the single element and return it.

You must implement a solution with a linear runtime complexity and use only constant extra space.

 

Example 1:

Input: nums = [2,2,3,2]
Output: 3
Example 2:

Input: nums = [0,1,0,1,0,1,99]
Output: 99

*/

    public int singleNumber(int[] nums) {
        HashSet hs = new HashSet<>();
        HashSet bs = new HashSet<>();
        for(int i = 0; i < nums.length; ++i){
            if(bs.contains(nums[i])) bs.remove(nums[i]);
            else if(hs.contains(nums[i])) hs.remove(nums[i]);
            else{hs.add(nums[i]); bs.add(nums[i]);}
        }
        Iterator ans = bs.iterator();
        return (int)ans.next();
    }
}
