/*


Given an integer array nums of unique elements, return all possible subsets (the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.

 

Example 1:

Input: nums = [1,2,3]
Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
Example 2:

Input: nums = [0]
Output: [[],[0]]

*/


class Solution {
    public List<List<Integer>> subsets(int[] nums) {
       List<List<Integer>> output=new ArrayList();
        output.add(new ArrayList<Integer>());
        for(int num: nums){
            List<List<Integer>> newsub=new ArrayList();
            for(List<Integer> cur: output){
                newsub.add(new ArrayList<Integer>(cur){{add(num);}});
            }
            for(List<Integer> cur:newsub)
                output.add(cur);
    }
         return output;
    }
}
