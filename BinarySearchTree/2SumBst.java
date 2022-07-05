/*



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
    public boolean findTarget(TreeNode root, int k) {
        List<Integer> hs=new LinkedList<>();
        inorder(root,hs);
        int i=0,j=hs.size()-1;
        while(i<j){
            if(hs.get(i)+hs.get(j)==k)
                return true;
            else if(hs.get(i)+hs.get(j)>k)
                j--;
            else if(hs.get(i)+hs.get(j)<k)
                i++;
        }
        return false;
    }
    public void inorder(TreeNode root,List<Integer> hs){
        if(root==null)
            return ;
        inorder(root.left,hs);
        hs.add(root.val);
        inorder(root.right,hs);
    }
}






class Solution {
    public boolean findTarget(TreeNode root, int k) {
        HashSet<Integer> set=new HashSet();
        return findTwoSum(root,k,set);
    }
    private boolean findTwoSum(TreeNode root, int k,HashSet<Integer> set){
        if(root==null)return false;
        if(set.contains(k-root.val))return true;
        else set.add(root.val);
        return findTwoSum(root.left,k,set) || findTwoSum(root.right,k,set);
    }
}
