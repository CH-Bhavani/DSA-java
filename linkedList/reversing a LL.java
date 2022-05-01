//Given pointer to the head node of a linked list, the task is to reverse the linked list. We need to reverse the list by changing the links between nodes.



import java.util.*;
public class test{
    static class ListNode {
        int data;
        ListNode next;

        ListNode(int data) {
            this.data = data;
            this.next = null;
        }
}
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next= new ListNode(5);
        head.next.next.next.next.next= new ListNode(6);
        head.next.next.next.next .next.next= new ListNode(7);
        head.next.next.next.next.next.next.next= new ListNode(8);
        System.out.println("after reversing");
        ListNode l=reverseLL(head);
        printLL(l);
        System.out.println("original List");
        ListNode o=reverseLL(l);
        printLL(o);
    }
    public static ListNode reverseLL(ListNode head){
        ListNode cur=head,prev=null,next=null;
        while(cur!=null){
            next=cur.next;
            cur.next=prev;
            prev=cur;
            cur=next;
        }
        return prev;
    }
    public static  void printLL(ListNode head){
        ListNode temp=head;
        while(temp!=null){
            System.out.print(temp.data+"->");
            temp= temp.next;
        }
        System.out.println();
    }
}
