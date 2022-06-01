/*

iven a sorted integer array arr, two integers k and x, return the k closest integers to x in the array. The result should also be sorted in ascending order.

An integer a is closer to x than an integer b if:

|a - x| < |b - x|, or
|a - x| == |b - x| and a < b
 

Example 1:

Input: arr = [1,2,3,4,5], k = 4, x = 3
Output: [1,2,3,4]
Example 2:

Input: arr = [1,2,3,4,5], k = 4, x = -1
Output: [1,2,3,4]


*/



class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int left=0,right=arr.length-k;
        while(left<right){
            int mid=(left+right)/2;
            if((x-arr[mid])>(arr[mid+k]-x))
               left=mid+1;
             else
               right=mid;
        }
        List<Integer> l=new ArrayList<>();
        for(int i=left;i<left+k;i++){
            l.add(arr[i]);
        }
        return l;
    }
}