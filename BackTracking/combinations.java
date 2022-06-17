/*


Given two integers n and k, return all possible combinations of k numbers out of the range [1, n].

You may return the answer in any order.

 

Example 1:

Input: n = 4, k = 2
Output:
[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]
Example 2:

Input: n = 1, k = 1
Output: [[1]]




*/



class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res=new LinkedList();
        if(k==0){
            res.add(new LinkedList<>());
            return res;
        }
        backtracking(1,n,k,new LinkedList<>(),res);
        return res;
    }
    public void backtracking(int start,int end,int k,LinkedList<Integer> current,List<List<Integer>> res){
        if(current.size()==k)
            res.add(new LinkedList(current));
        for(int i=start;i<=end && current.size()<=k;i++){
            current.add(i);
            backtracking(i+1,end,k,current,res);
            current.removeLast();
        }
    }
}
