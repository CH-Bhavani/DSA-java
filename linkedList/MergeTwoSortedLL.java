/*

You are given the heads of two sorted linked lists list1 and list2.

Merge the two lists in a one sorted list. The list should be made by splicing together the nodes of the first two lists.

Return the head of the merged linked list.

 

Example 1:


Input: list1 = [1,2,4], list2 = [1,3,4]
Output: [1,1,2,3,4,4]
Example 2:

Input: list1 = [], list2 = []
Output: []
Example 3:

Input: list1 = [], list2 = [0]
Output: [0]


*/



/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null) return l2;
        if(l2==null) return l1;
        ListNode head;
        if(l1.val>l2.val){
            head=l2;
            l2=l2.next;
        }
        else{
            head=l1;
            l1=l1.next;
        }
        ListNode p=head;
        while(l1!=null && l2!=null){
            if(l1.val<l2.val)
            {
                p.next=l1;
                l1=l1.next;
            }
            else
            {
                p.next=l2;
                l2=l2.next;
            }
            p=p.next;
        }
        if(l1!=null)
            p.next=l1;
        else
            p.next=l2;
        return head;
        
}
}






//sol-2




/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy =new ListNode(0);
        ListNode p=dummy;
        while(l1!=null || l2!=null){
            if(l1==null){
                p.next=l2;
                break;}
            if(l2==null){
                p.next=l1;
                break;}
            if(l1.val<l2.val){
                p.next=l1;
                l1=l1.next;
            }
            else{
                p.next=l2;
                l2=l2.next;
            }
            p=p.next;
        }
        return dummy.next;
    }
}



//sol-3


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null) return l2;
        if(l2==null) return l1;
        if(l1.val<l2.val){
            l1.next=mergeTwoLists(l1.next,l2);
            return l1;
            }
        else{
            l2.next=mergeTwoLists(l2.next,l1);
            return l2;
            }
    }
}
