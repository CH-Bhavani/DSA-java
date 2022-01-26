/*
Given two binary search trees root1 and root2, return a list containing all the integers from both trees sorted in ascending order.

 

Example 1:


Input: root1 = [2,1,4], root2 = [1,0,3]
Output: [0,1,1,2,3,4]
Example 2:


Input: root1 = [1,null,8], root2 = [8,1]
Output: [1,1,8,8]


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
    List<Integer> arr;
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        arr=new ArrayList<>();
        if(root1==null &&  root2==null) return arr;
        traverse(root1);
        traverse(root2);
        Collections.sort(arr);
        return arr;
    }
    public void traverse(TreeNode node){//, List<Integer> l)
        if(node==null) return;
        arr.add(node.val);
        traverse(node.left);
        traverse(node.right);
    }
}
