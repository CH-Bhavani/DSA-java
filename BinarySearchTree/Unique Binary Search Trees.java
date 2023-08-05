/*

Given an integer n, return the number of structurally unique BST's (binary search trees) which has exactly n nodes of unique values from 1 to n.

 

Example 1:


Input: n = 3
Output: 5
Example 2:

Input: n = 1
Output: 1
 

Constraints:

1 <= n <= 19


  */





class Solution {
    public int numTrees(int n) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(0,1);
        map.put(1,1);
        return numTrees(n, map);
    }
    private int numTrees(int n,Map<Integer,Integer> map){
        if(map.containsKey(n)) return map.get(n);
        int sum=0;
        for(int i=1;i<=n;i++){
            sum+=numTrees(i-1,map)*numTrees(n-i,map);

        }
        map.put(n,sum);
        return sum;
    }
}
