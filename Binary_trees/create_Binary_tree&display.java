class node{
    int data;
    node left;
    node right;
}

public class BinaryTree {
    public node createBinaryTree(int val){
        node a=new node();
        a.data=val;
        a.right=null;
        a.left=null;
        return a;

    }

    public static void main(String[] args) {
        BinaryTree b=new BinaryTree();
        node root=b.createBinaryTree(2);
        root.left=b.createBinaryTree(3);
        root.right=b.createBinaryTree(4);
        root.left.left=b.createBinaryTree(5);
        root.left.right=b.createBinaryTree(6);
        root.left.right.left=b.createBinaryTree(7);
        root.left.right.right=b.createBinaryTree(8);
        root.right.right=b.createBinaryTree(9);
        root.right.right.left=b.createBinaryTree(10);
        System.out.print("inorder: ");
        b.inorder(root);
        System.out.println();
        System.out.print("preorder ");
        b.preorder(root);
        System.out.println();
        System.out.print("Postorder ");
        b.postorder(root);
    }
    public void inorder(node root){
        if(root==null)
            return;
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }
    public void preorder(node root){
        if(root==null)
            return;
        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);
    }
    public void postorder(node root){
        if(root==null)
            return;
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data+" ");
    }


}
