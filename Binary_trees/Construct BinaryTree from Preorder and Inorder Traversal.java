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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Deque<Integer> dq = new ArrayDeque<>();
        for(int val : preorder)
            dq.offer(val);
        return build(dq, inorder);
    }

    private TreeNode build(Deque<Integer> po, int []io){
        if (io.length > 0){
            int idx = indexOf(io, po.poll());
            TreeNode node = new TreeNode(io[idx]);
            node.left = build(po, Arrays.copyOfRange(io, 0, idx));
            node.right = build(po, Arrays.copyOfRange(io, idx+1, io.length));
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
