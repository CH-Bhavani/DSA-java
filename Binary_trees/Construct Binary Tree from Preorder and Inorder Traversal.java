/*


Given two integer arrays preorder and inorder where preorder is the preorder traversal of a binary tree and inorder is the inorder traversal of the same tree, construct and return the binary tree.

 

Example 1:


Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
Output: [3,9,20,null,null,15,7]
Example 2:

Input: preorder = [-1], inorder = [-1]
Output: [-1]
 
 
 
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
    int pre;
    HashMap<Integer,Integer> hm;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        pre=0;
        hm=new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            hm.put(inorder[i],i);
        }
        return Btree(preorder,0,preorder.length-1);
        
    }
    public TreeNode Btree(int[] preorder,int left,int right){
        if(left>right)
            return null;
        int  value=preorder[pre++];
        TreeNode root=new TreeNode(value);
        
        root.left=Btree(preorder,left,hm.get(value)-1);
        root.right=Btree(preorder,hm.get(value)+1,right);
        
        return root;
    }
}
