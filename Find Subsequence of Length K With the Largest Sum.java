/*

You are given an integer array nums and an integer k. You want to find a subsequence of nums of length k that has the largest sum.

Return any such subsequence as an integer array of length k.

A subsequence is an array that can be derived from another array by deleting some or no elements without changing the order of the remaining elements.

 

Example 1:

Input: nums = [2,1,3,3], k = 2
Output: [3,3]
Explanation:
The subsequence has the largest sum of 3 + 3 = 6.
Example 2:

Input: nums = [-1,-2,3,4], k = 3
Output: [-1,3,4]
Explanation: 
The subsequence has the largest sum of -1 + 3 + 4 = 6.
Example 3:

Input: nums = [3,4,3,3], k = 2
Output: [3,4]
Explanation:
The subsequence has the largest sum of 3 + 4 = 7. 
Another possible subsequence is [4, 3].


*/




class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        PriorityQueue<node> pq1=new PriorityQueue<>((a,b)->a.val-b.val);
        PriorityQueue<node> pq2=new PriorityQueue<>((a,b)->a.id-b.id);
        for(int i=0;i<nums.length;i++){
            pq1.offer(new node(nums[i],i));
            if(pq1.size()>k)
                pq1.poll();
        }
        while(!pq1.isEmpty()){
            pq2.offer(pq1.poll());
        }
        int[] ans=new int[k];
        int i=0;
        while(!pq2.isEmpty()){
            ans[i++]=pq2.poll().val;
        }
        return ans;
    }
}
class node{
    int val;
    int id;
    node(int val,int id){
        this.val=val;
        this.id=id;
    }
    public String toString(){
        return val+" "+id;
    }
}
