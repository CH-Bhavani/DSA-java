import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class node{
    int data;
    node left;
    node right;
}

public class BinaryTree<maxlevel> {
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
        System.out.println();
        System.out.print("sum OF Nodes ");
        System.out.println(b.sumOfNodes(root));
        System.out.print("difference of values at even and codd levels  ");
        System.out.print(b.getDifferenceOfValuesAtEvenAndOddLevel(root));
        System.out.println();
        System.out.println("total number of Nodes "+b.CountNodes(root)+"\nTotal Number of Leaf Nodes   "+b.LeafNodes(root));
        System.out.println("Height of Binary tree  "+b.HeightofBinaryTree(root));
        System.out.println("Print element at level ");
        b.PrintAtAgivenLevel(root,3);
        System.out.println("Level order Traversal  ");
        b.levelOrderTraversalWithRecursion(root);
        System.out.println();
        System.out.println("levelOrderTraversalWithoutRecursion");
        b.levelOrderTraversalWithoutRecursion(root);
        System.out.println();
        System.out.println("ReverselevelOrderTraversalWithRecursion");
        b.ReverselevelOrderTraversalWithRecursion(root);
        System.out.println();
        System.out.println("ReverselevelOrderTraversalWithoutRecursion");
        b.ReverselevelOrderTraversalWithoutRecursion(root);
        System.out.println();
        System.out.println(" Level Order Traversal Line by Line Without Recursion");
        b.LevelOrderTraversalLinebyLineWithoutRecursion(root);
        System.out.println();
        System.out.println(" Print Leftview of Binary tree");
        b.PrintLeftviewofBinarytree(root,0);
        System.out.println();
        System.out.println(" Print Right view of Binary tree");
        b.PrintRightviewofBinarytree(root,0);
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
    public int sumOfNodes(node root){
        if(root==null)
            return 0;
        return root.data+sumOfNodes(root.left)+sumOfNodes(root.right);
    }
    public int getDifferenceOfValuesAtEvenAndOddLevel(node root){
        if(root==null)
            return 0;
        return root.data-getDifferenceOfValuesAtEvenAndOddLevel(root.left)-getDifferenceOfValuesAtEvenAndOddLevel(root.right);
    }
    public int CountNodes(node root){
        if(root==null)
            return 0;
        return 1+CountNodes(root.left)+CountNodes(root.right);
    }
    public int LeafNodes(node root){
        if(root==null)
            return 0;
        if(root.left==null && root.right==null)
            return 1;
        return LeafNodes(root.left)+LeafNodes(root.right);
    }
    public static int HeightofBinaryTree(node root){
        if(root==null)
            return 0;
        return Math.max(HeightofBinaryTree(root.left),HeightofBinaryTree(root.right))+1;
    }
    public static void PrintAtAgivenLevel(node root,int level){
        if(root==null)
            return;
        if(level==1)
            System.out.print(root.data +" ");
        PrintAtAgivenLevel(root.left,level-1);
        PrintAtAgivenLevel(root.right,level-1);
    }
    public  void  levelOrderTraversalWithRecursion(node root){
        if(root==null)
            return ;
        int height=HeightofBinaryTree(root);
        for(int i=0;i<=height;i++){
            PrintAtAgivenLevel(root,i+1);
            System.out.println();
        }
    }
    public void levelOrderTraversalWithoutRecursion(node root){
        if(root==null)
            return;
        Queue<node>q=new LinkedList<>();
        q.add(root);
        while(q.size()>0){
            node top=q.poll();
            System.out.print(top.data +"  ");
            if(top.left!=null)
                q.add(top.left);
            if(top.right!=null)
                q.add(top.right);
        }
    }
    public void ReverselevelOrderTraversalWithRecursion(node root){
        if(root==null)
            return ;
        int height=HeightofBinaryTree(root);
        for(int i=height;i>=0;i--){
            PrintAtAgivenLevel(root,i+1);
            System.out.println();
        }
    }
    public void ReverselevelOrderTraversalWithoutRecursion(node root){
        Queue<node> q=new LinkedList<>();
        q.add(root);
        Stack<node> stk=new Stack<>();
        while(q.size()>0){
            node temp=q.poll();
            if(temp.right!=null) q.add(temp.right);
            if(temp.left!=null)  q.add(temp.left);
            stk.push(temp);
        }
        while(!stk.isEmpty()){
            System.out.print(stk.pop().data+"  ");
        }
    }
    public static  void  LevelOrderTraversalLinebyLineWithoutRecursion(node root){
        Queue<node> q=new LinkedList<>();
        q.add(root);
        while(true){
            int count=q.size();
            if(count==0)
                break;
            while(count>0){
                node top=q.poll();
                System.out.print(top.data+"  ");
                if(top.left!=null)
                    q.add(top.left);
                if(top.right!=null)
                    q.add(top.right);
                count--;
            }
            System.out.println();
        }
    }
    int maxlevel=0;
    public void PrintLeftviewofBinarytree(node root,int level){
        if(root==null)
            return ;
        if(level>=maxlevel) {
            System.out.print(root.data + "  ");
            maxlevel++;
        }
        PrintLeftviewofBinarytree(root.left,level+1);
        PrintLeftviewofBinarytree(root.right,level+1);

    }
    int maximumlevel=0;
    public void PrintRightviewofBinarytree(node root,int level){
        if(root==null)
            return ;
        if(level>=maximumlevel) {
            System.out.print(root.data + "  ");
            maximumlevel++;
        }
        PrintRightviewofBinarytree(root.right,level+1);
        PrintRightviewofBinarytree(root.left,level+1);

    }

}
