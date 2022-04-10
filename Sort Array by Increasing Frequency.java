/*


Given an array of integers nums, sort the array in increasing order based on the frequency of the values. If multiple values have the same frequency, sort them in decreasing order.

Return the sorted array.

 

Example 1:

Input: nums = [1,1,2,2,2,3]
Output: [3,1,1,2,2,2]
Explanation: '3' has a frequency of 1, '1' has a frequency of 2, and '2' has a frequency of 3.
Example 2:

Input: nums = [2,3,1,3,2]
Output: [1,3,3,2,2]
Explanation: '2' and '3' both have a frequency of 2, so they are sorted in decreasing order.
Example 3:

Input: nums = [-1,1,-6,4,5,-6,1,4,1]
Output: [5,-1,4,4,-6,-6,1,1,1]


*/




class Solution {
    public int[] frequencySort(int[] nums) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int n:nums)
            map.put(n,map.getOrDefault(n,0)+1);
        System.out.println(map);
        Queue<Integer> q=new PriorityQueue<>((a,b)->
        map.get(a)==map.get(b)?b-a: map.get(a)-map.get(b));
        for(int n:nums)
            q.offer(n);
        for(int k=0;k<nums.length;k++){
            nums[k]=q.poll();
        }
        return nums;
    }
}



//sol-2



class Solution {
    public int[] frequencySort(int[] nums) {
        ArrayList<Integer> al=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            al.add(nums[i]);
        }
        sortBasedOnFrequency(al);
        int[] res_arr=new int[nums.length];
        for(int i=0;i<res_arr.length;i++){
            res_arr[i]=al.get(i);
        }
        return res_arr;
    }
    public void sortBasedOnFrequency(List<Integer> al){
        HashMap<Integer,Integer> hm=new HashMap<>();
        for(int i=0;i<al.size();i++){
            hm.put(al.get(i),hm.getOrDefault(al.get(i),0)+1);
        }
        Collections.sort(al,(n1,n2)->{
        int freq1=hm.get(n1);
        int freq2=hm.get(n2);
            if(freq1!=freq2){
                return freq1-freq2;
            }
            return n2-n1;
        });
    }
}




//sol-3



import java.util.*;
import java.lang.*;
class Comp implements Comparator<Integer>{
    Map<Integer,Integer>map=Rextester.map;
    public int compare(Integer a,Integer b){
        if(map.get(a)>map.get(b))return 1;
        else if(map.get(b)>map.get(a))return -1;
        else{
            if(a>b)return -1;
            else if(a<b)return 1;
            return 0;
        }
    }
}
class Rextester
{  
    static Map<Integer,Integer>map;
    public static int[] frequencySort(int[] nums)
    {
        map=new HashMap<Integer,Integer>();
        for(int i:nums){
            if(map.containsKey(i)){
                map.put(i,1+map.get(i));
            }else{
                map.put(i,1);
            }
        }
        Integer[]arr=new Integer[nums.length];
        int k=0;
        for(int i:nums){
            arr[k++]=i;
        }
        Arrays.sort(arr,new Comp());
        k=0;
        for(int i:arr){
            nums[k++]=i;
        }
        return nums;
    }
    
    public static void main(String args[])
    {
        int[]nums={1,1,2,2,2,3};
        nums=frequencySort(nums);
        for(int i:nums)
        {
            System.out.print(i+" ");
        }
    }
}
