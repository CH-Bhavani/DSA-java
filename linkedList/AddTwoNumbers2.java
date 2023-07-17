/*



You are given two non-empty linked lists representing two non-negative integers. The most significant digit comes first and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

 

Example 1:


Input: l1 = [7,2,4,3], l2 = [5,6,4]
Output: [7,8,0,7]
Example 2:

Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [8,0,7]
Example 3:

Input: l1 = [0], l2 = [0]
Output: [0]
 

Constraints:

The number of nodes in each linked list is in the range [1, 100].
0 <= Node.val <= 9
It is guaranteed that the list represents a number that does not have leading zeros.

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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode r1=reverseLL(l1);
        ListNode r2=reverseLL(l2);
        ListNode ans=new ListNode(0);
        ListNode dummy=ans;
        int carry=0;
        while(r1!=null || r2!=null||carry==1){
            int sum=0;
            if(r1!=null){
                sum+=r1.val;
                r1=r1.next;
            }
            if(r2!=null){
                sum+=r2.val;
                r2=r2.next;
            }
            sum=sum+carry;
            carry=sum/10;
            ListNode newNode =new ListNode(sum%10);
            ans.next=newNode;
            ans=ans.next;
        }
        return reverseLL(dummy.next);

    }
    public ListNode reverseLL(ListNode head){
        if(head==null || head.next==null)
            return head;
        ListNode cur=head,prev=null;
        while(cur!=null ){
            ListNode temp=cur.next;
            cur.next=prev;
            prev=cur;
            cur=temp;
        }
        return prev;

    }

}
