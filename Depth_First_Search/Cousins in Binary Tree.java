/**

Given the root of a binary tree with unique values and the values of two different nodes of the tree x and y, return true if the nodes corresponding to the values x and y in the tree are cousins, or false otherwise.

Two nodes of a binary tree are cousins if they have the same depth with different parents.

Note that in a binary tree, the root node is at the depth 0, and children of each depth k node are at the depth k + 1.

 

Example 1:


Input: root = [1,2,3,4], x = 4, y = 3
Output: false
Example 2:


Input: root = [1,2,3,null,4,null,5], x = 5, y = 4
Output: true
Example 3:


Input: root = [1,2,3,null,4], x = 2, y = 3
Output: false
 

Constraints:

The number of nodes in the tree is in the range [2, 100].
1 <= Node.val <= 100
Each node has a unique value.
x != y
x and y are exist in the tree.


  **/


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
    TreeNode xp = null, yp = null;
    int xd = -1, yd = -2;
    public boolean isCousins(TreeNode root, int x, int y) {
        dfs(root, null , x, y, 0);
        return xd == yd && xp.val != yp.val;
    }
    public void dfs(TreeNode root, TreeNode parent, int x, int y, int depth){
        if (root == null) return;
        if (root.val == x){
            xp = parent;
            xd = depth;
        }
        if (root.val == y){
            yp = parent;
            yd = depth;
        }
        if (root.left !=null) 
            dfs(root.left, root, x, y, depth+1);
        if (root.right !=null) 
            dfs(root.right, root, x, y, depth+1);
        return;
    }
}
