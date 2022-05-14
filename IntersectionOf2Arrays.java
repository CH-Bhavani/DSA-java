/*

Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result must appear as many times as it shows in both arrays and you may return the result in any order.

 

Example 1:

Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2,2]
Example 2:

Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [4,9]
Explanation: [9,4] is also accepted.
*/



class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> hm1=new HashMap<>();
            for(int i:nums1)
            {
                hm1.put(i,hm1.getOrDefault(i,0)+1);
            }
        HashMap<Integer,Integer> hm2=new HashMap<>();
        for(int i:nums2)
            {
                hm2.put(i,hm2.getOrDefault(i,0)+1);
            }
        HashMap<Integer,Integer> hm3=new HashMap<>();
        List<Integer> l=new ArrayList<>();
        for(int c: hm1.keySet()){
            if(hm2.containsKey(c))
                hm3.put(c,Math.min(hm2.get(c),hm1.get(c)));
        }
        for(int j:hm3.keySet() ){
            int k=hm3.get(j);
            for(int i=0;i<k;i++){
                l.add(j);
            }
        }
        int[] o=new int[l.size()];
        for(int i=0;i<l.size();i++)
            o[i]=l.get(i);
        return o;
    }
}
