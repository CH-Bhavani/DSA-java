import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class node{
    int data;
    node left;
    node right;
}

public class BinaryTree<maxlevel> {
    public node createBinaryTree(int val) {
        node a = new node();
        a.data = val;
        a.right = null;
        a.left = null;
        return a;

    }

    public static void main(String[] args) {
        BinaryTree b = new BinaryTree();
        node root = b.createBinaryTree(2);
        root.left = b.createBinaryTree(3);
        root.right = b.createBinaryTree(4);
        root.left.left = b.createBinaryTree(5);
        root.left.right = b.createBinaryTree(6);
        root.left.right.left = b.createBinaryTree(7);
        root.left.right.right = b.createBinaryTree(8);
        root.right.right = b.createBinaryTree(9);
        root.right.right.left = b.createBinaryTree(10);

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
        System.out.println("total number of Nodes " + b.CountNodes(root) + "\nTotal Number of Leaf Nodes   " + b.LeafNodes(root));
        System.out.println("Height of Binary tree  " + b.HeightofBinaryTree(root));
        System.out.println("Print element at level ");
        b.PrintAtAgivenLevel(root, 3);
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
        b.PrintLeftviewofBinarytree(root, 0);
        System.out.println();
        System.out.println(" Print Right view of Binary tree");
        b.PrintRightviewofBinarytree(root, 0);
        System.out.println();
        System.out.println("Inorder tarvaersal without using recursion ");
        b.InorderWithoutRecursion(root);
        System.out.println();
        System.out.println("Preorder tarvaersal without using recursion ");
        b.PreOrderWithoutRecursion(root);
        System.out.println();
        System.out.println("Postorder tarvaersal without using recursion ");
        b.PostOrderWithoutRecursion(root);
        System.out.println();
        System.out.println("Mirror of Binary tree Inorder traversal");
        node Mirror=b.MirrorOfBT(root);
        b.inorder(Mirror);
        //System.out.println();
        //System.out.println("Deleting a BInary Tree");
        //b.deleteBT(root);
        System.out.println();
        System.out.println("check if tow Binary Trees are Identical");
        System.out.println(b.IsIdenticalBT(root,root));
    }

    public void inorder(node root) {
        if (root == null)
            return;
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    public void preorder(node root) {
        if (root == null)
            return;
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    public void postorder(node root) {
        if (root == null)
            return;
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data + " ");
    }

    public int sumOfNodes(node root) {
        if (root == null)
            return 0;
        return root.data + sumOfNodes(root.left) + sumOfNodes(root.right);
    }

    public int getDifferenceOfValuesAtEvenAndOddLevel(node root) {
        if (root == null)
            return 0;
        return root.data - getDifferenceOfValuesAtEvenAndOddLevel(root.left) - getDifferenceOfValuesAtEvenAndOddLevel(root.right);
    }

    public int CountNodes(node root) {
        if (root == null)
            return 0;
        return 1 + CountNodes(root.left) + CountNodes(root.right);
    }

    public int LeafNodes(node root) {
        if (root == null)
            return 0;
        if (root.left == null && root.right == null)
            return 1;
        return LeafNodes(root.left) + LeafNodes(root.right);
    }

    public static int HeightofBinaryTree(node root) {
        if (root == null)
            return 0;
        return Math.max(HeightofBinaryTree(root.left), HeightofBinaryTree(root.right)) + 1;
    }

    public static void PrintAtAgivenLevel(node root, int level) {
        if (root == null)
            return;
        if (level == 1)
            System.out.print(root.data + " ");
        PrintAtAgivenLevel(root.left, level - 1);
        PrintAtAgivenLevel(root.right, level - 1);
    }

    public void levelOrderTraversalWithRecursion(node root) {
        if (root == null)
            return;
        int height = HeightofBinaryTree(root);
        for (int i = 0; i <= height; i++) {
            PrintAtAgivenLevel(root, i + 1);
            System.out.println();
        }
    }

    public void levelOrderTraversalWithoutRecursion(node root) {
        if (root == null)
            return;
        Queue<node> q = new LinkedList<>();
        q.add(root);
        while (q.size() > 0) {
            node top = q.poll();
            System.out.print(top.data + "  ");
            if (top.left != null)
                q.add(top.left);
            if (top.right != null)
                q.add(top.right);
        }
    }

    public void ReverselevelOrderTraversalWithRecursion(node root) {
        if (root == null)
            return;
        int height = HeightofBinaryTree(root);
        for (int i = height; i >= 0; i--) {
            PrintAtAgivenLevel(root, i + 1);
            System.out.println();
        }
    }

    public void ReverselevelOrderTraversalWithoutRecursion(node root) {
        Queue<node> q = new LinkedList<>();
        q.add(root);
        Stack<node> stk = new Stack<>();
        while (q.size() > 0) {
            node temp = q.poll();
            if (temp.right != null) q.add(temp.right);
            if (temp.left != null) q.add(temp.left);
            stk.push(temp);
        }
        while (!stk.isEmpty()) {
            System.out.print(stk.pop().data + "  ");
        }
    }

    public static void LevelOrderTraversalLinebyLineWithoutRecursion(node root) {
        Queue<node> q = new LinkedList<>();
        q.add(root);
        while (true) {
            int count = q.size();
            if (count == 0)
                break;
            while (count > 0) {
                node top = q.poll();
                System.out.print(top.data + "  ");
                if (top.left != null)
                    q.add(top.left);
                if (top.right != null)
                    q.add(top.right);
                count--;
            }
            System.out.println();
        }
    }

    int maxlevel = 0;

    public void PrintLeftviewofBinarytree(node root, int level) {
        if (root == null)
            return;
        if (level >= maxlevel) {
            System.out.print(root.data + "  ");
            maxlevel++;
        }
        PrintLeftviewofBinarytree(root.left, level + 1);
        PrintLeftviewofBinarytree(root.right, level + 1);

    }

    int maximumlevel = 0;

    public void PrintRightviewofBinarytree(node root, int level) {
        if (root == null)
            return;
        if (level >= maximumlevel) {
            System.out.print(root.data + "  ");
            maximumlevel++;
        }
        PrintRightviewofBinarytree(root.right, level + 1);
        PrintRightviewofBinarytree(root.left, level + 1);

    }

    public void InorderWithoutRecursion(node root) {
        if (root == null)
            return;
        Stack<node> stk = new Stack<>();
        while (root != null) {
            stk.push(root);
            root = root.left;
        }
        while (stk.size() > 0) {
            node t = stk.pop();
            System.out.print(t.data + " ");
            if (t.right != null) {
                node temp = t.right;
                while (temp != null) {
                    stk.push(temp);
                    temp = temp.left;
                }
            }
        }
    }

    public void PreOrderWithoutRecursion(node root) {
        if (root == null)
            return;
        Stack<node> stk = new Stack<>();
        stk.push(root);
        while (stk.size() > 0) {
            node t = stk.pop();
            System.out.print(t.data + " ");
            if (t.right != null)
                stk.push(t.right);
            if (t.left != null)
                stk.push(t.left);
        }

    }

    public  void PostOrderWithoutRecursion(node root) {
        if (root == null)
            return;
        Stack<node> stk1 = new Stack<>();
        Stack<node> stk2 = new Stack<>();
        stk1.push(root);
        while (stk1.size() > 0) {
            node t = stk1.pop();
            if (t.left != null)
                stk1.push(t.left);
            if (t.right != null)
                stk1.push(t.right);
            stk2.push(t);
        }
        while (stk2.size()>0)
            System.out.print(stk2.pop().data + " ");
    }

    public node MirrorOfBT(node root){
        if(root==null)
            return null;
        node t=root.left;
        root.left=root.right;
        root.right=t;
        MirrorOfBT(root.left);
        MirrorOfBT(root.right);
        return root;
    }

    public  node  deleteBT(node root){
        if(root==null)
            return null;
        root.left=deleteBT(root.left);
        root.right=deleteBT(root.right);
        System.out.println("deleting "+ root.data);
        root=null;
        return root;

    }

    public boolean IsIdenticalBT(node root1,node root2){

        if(root1==null && root2==null)
            return true;
        if(root1==null || root2==null)
            return false;
        return (root1.data== root2.data) && IsIdenticalBT(root1.left,root2.left) && IsIdenticalBT(root1.right,root2.right);

    }

    

}
