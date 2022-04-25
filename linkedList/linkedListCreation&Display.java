public class LinkedList {
    Node head;
    static class Node{
        int data;
        Node next;
        Node(int data) {
            this.data = data;
        }
    }
    public static  LinkedList insert(LinkedList list,int data){
        Node new_node=new Node(data);
        new_node.next=null;
        if(list.head==null)
            list.head=new_node;
        else{
            Node last=list.head;
            while(last.next!=null){
                last=last.next;
            }
            last.next=new_node;
        }
        return list;
    }
    public static  void printList(LinkedList list){
        Node curnode=list.head;
        while(curnode!=null){
            System.out.print(curnode.data+" -> ");
            curnode=curnode.next;
        }
    }
    public static void main(String[] args) {
        LinkedList l=new LinkedList();
        l=insert(l ,5);
        l=insert(l ,9);
        l=insert(l ,3);
        l=insert(l ,8);
        l=insert(l ,7);
        l=insert(l ,4);
        printList(l);
    }
}
