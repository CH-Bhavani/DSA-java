/*
Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.

 

Example 1:

Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
Example 2:

Input: nums = [0,1]
Output: [[0,1],[1,0]]
Example 3:

Input: nums = [1]
Output: [[1]]


*/

class Solution {
    List<List<Integer>> res=new LinkedList<>();
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> dt=new LinkedList<>();
        for(int i:nums)
            dt.add(i);
        dfs(new LinkedList<>(),dt);
        return res;
    }
    public void dfs(List<Integer> perm,List<Integer> dt){
        if(dt.size()==0)
        {
            res.add(perm);
            return ;
        }
        for(Integer num:dt){
            List<Integer> ptemp=new LinkedList<>(perm);
            List<Integer> tdt=new LinkedList<>(dt);
            ptemp.add(num);
            tdt.remove(num);
            dfs(ptemp,tdt);
        }
    }
}
