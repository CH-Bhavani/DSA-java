/**

Given two integer arrays inorder and postorder where inorder is the inorder traversal of a binary tree and postorder is the postorder traversal of the same tree, construct and return the binary tree.

 

Example 1:


Input: inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
Output: [3,9,20,null,null,15,7]
Example 2:

Input: inorder = [-1], postorder = [-1]
Output: [-1]
 

Constraints:

1 <= inorder.length <= 3000
postorder.length == inorder.length
-3000 <= inorder[i], postorder[i] <= 3000
inorder and postorder consist of unique values.
Each value of postorder also appears in inorder.
inorder is guaranteed to be the inorder traversal of the tree.
postorder is guaranteed to be the postorder traversal of the tree.


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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Deque<Integer> dq = new ArrayDeque<>();
        for(int val : postorder)
            dq.offer(val);
        return build(dq, inorder);
    }

    private TreeNode build(Deque<Integer> po, int []io){
        if (io.length > 0){
            int idx = indexOf(io, po.pollLast());
            TreeNode node = new TreeNode(io[idx]);
            node.right = build(po, Arrays.copyOfRange(io, idx+1, io.length));
            node.left = build(po, Arrays.copyOfRange(io, 0, idx));
            return node;
        }
        return null;
    }

    private int indexOf(int[] arr , int value){
        for(int i=0;i< arr.length; i++){
            if(arr[i]==value)
                return i;
        }
        return -1;
    }
}
