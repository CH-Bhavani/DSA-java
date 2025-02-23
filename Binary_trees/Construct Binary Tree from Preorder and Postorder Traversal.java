/**

Given two integer arrays, preorder and postorder where preorder is the preorder traversal of a binary tree of distinct values and postorder is the postorder traversal of the same tree, reconstruct and return the binary tree.

If there exist multiple answers, you can return any of them.

 

Example 1:


Input: preorder = [1,2,4,5,3,6,7], postorder = [4,5,2,6,7,3,1]
Output: [1,2,3,4,5,6,7]
Example 2:

Input: preorder = [1], postorder = [1]
Output: [1]
 

Constraints:

1 <= preorder.length <= 30
1 <= preorder[i] <= preorder.length
All the values of preorder are unique.
postorder.length == preorder.length
1 <= postorder[i] <= postorder.length
All the values of postorder are unique.
It is guaranteed that preorder and postorder are the preorder traversal and postorder traversal of the same binary tree.


  **/

class Solution {

    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        int numOfNodes = preorder.length;
        return constructTree(0, numOfNodes - 1, 0, preorder, postorder);
    }

    // Helper function to construct the tree recursively
    private TreeNode constructTree(
        int preStart,
        int preEnd,
        int postStart,
        int[] preorder,
        int[] postorder
    ) {
        // Base case: If there are no nodes to process, return null
        if (preStart > preEnd) return null;

        // Base case: If only one node is left, return that node
        if (preStart == preEnd) {
            return new TreeNode(preorder[preStart]);
        }

        // The left child root in preorder traversal (next element after root)
        int leftRoot = preorder[preStart + 1];

        // Calculate the number of nodes in the left subtree by searching in postorder
        int numOfNodesInLeft = 1;
        while (postorder[postStart + numOfNodesInLeft - 1] != leftRoot) {
            numOfNodesInLeft++;
        }

        TreeNode root = new TreeNode(preorder[preStart]);

        // Recursively construct the left subtree
        root.left = constructTree(
            preStart + 1,
            preStart + numOfNodesInLeft,
            postStart,
            preorder,
            postorder
        );

        // Recursively construct the right subtree
        root.right = constructTree(
            preStart + numOfNodesInLeft + 1,
            preEnd,
            postStart + numOfNodesInLeft,
            preorder,
            postorder
        );

        return root;
    }
}
