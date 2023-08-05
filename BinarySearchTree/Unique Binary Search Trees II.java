/*


Given an integer n, return all the structurally unique BST's (binary search trees), which has exactly n nodes of unique values from 1 to n. Return the answer in any order.

 

Example 1:


Input: n = 3
Output: [[1,null,2,null,3],[1,null,3,2],[2,1,3],[3,1,null,null,2],[3,2,null,1]]
Example 2:

Input: n = 1
Output: [[1]]
 

Constraints:

1 <= n <= 8


*/



/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<TreeNode> generateTrees(int n) {
        Map<Pair<Integer, Integer>, List<TreeNode>> memo = new HashMap<>();
        return allPossibleBST(1, n, memo);
    }
    public List<TreeNode> allPossibleBST(int start, int end,Map<Pair<Integer, Integer>, List<TreeNode>> memo){
        List<TreeNode> res = new ArrayList<>();
        if(start>end){
            res.add(null);
            return res;
        }
        if(memo.containsKey(new Pair<>(start,end)))
            return memo.get(new Pair(start,end));

        for(int i=start;i<=end;i++){
            List<TreeNode> lst=allPossibleBST(start,i-1,memo);
            List<TreeNode> rst=allPossibleBST(i+1,end,memo);
            for(TreeNode l:lst){
                for(TreeNode r:rst){
                    TreeNode root=new TreeNode(i,l,r);
                    res.add(root);
                }
            }

        }
        memo.put(new Pair<>(start, end), res);
        return res;
        
    }

}
