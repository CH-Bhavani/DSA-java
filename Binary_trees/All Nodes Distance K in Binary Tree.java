/*
Given the root of a binary tree, the value of a target node target, and an integer k, return an array of the values of all nodes that have a distance k from the target node.

You can return the answer in any order.

 

Example 1:


Input: root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, k = 2
Output: [7,4,1]
Explanation: The nodes that are a distance 2 from the target node (with value 5) have values 7, 4, and 1.
Example 2:

Input: root = [1], target = 1, k = 3
Output: []
 

Constraints:

The number of nodes in the tree is in the range [1, 500].
0 <= Node.val <= 500
All the values Node.val are unique.
target is the value of one of the nodes in the tree.
0 <= k <= 1000

*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode ,TreeNode> map=new HashMap<>();
        childtoparent(map,root);
        List<Integer> ans=new ArrayList<>();
        List<TreeNode> visited =new ArrayList<>();
        getNodes(target,k,map,visited,ans);
        return ans;
    }
    public static void getNodes(TreeNode target,int k,Map<TreeNode ,TreeNode> mp,List<TreeNode> visited,List<Integer> ans){
        if(target==null) return ;
        if(k==0){
            ans.add(target.val);
            return;
        }
        visited.add(target);
        if(mp.containsKey(target) && !visited.contains(mp.get(target)))
            getNodes(mp.get(target),k-1,mp,visited,ans);
        if(!visited.contains(target.left)) 
            getNodes(target.left,k-1,mp,visited,ans);
        if(!visited.contains(target.right)) 
            getNodes(target.right,k-1,mp,visited,ans);
    }
    public static void childtoparent(Map<TreeNode ,TreeNode> map,TreeNode root){
        if(root==null)
            return ;
        if(root.left!=null) map.put(root.left,root);
        if(root.right!=null) map.put(root.right,root);
        childtoparent(map,root.left);
        childtoparent(map,root.right);
    }
}
