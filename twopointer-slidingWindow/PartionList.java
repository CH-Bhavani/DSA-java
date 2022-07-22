/*



Given the head of a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.

 

Example 1:


Input: head = [1,4,3,2,5,2], x = 3
Output: [1,2,2,4,3,5]
Example 2:

Input: head = [2,1], x = 2
Output: [1,2]


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
    public ListNode partition(ListNode head, int x) {
        ListNode bhead=new ListNode(0);
        ListNode before =bhead;
        ListNode ahead=new ListNode(0);
        ListNode after =ahead;
        while(head!=null){
            if(head.val<x){
                before.next=head;
                before=before.next;
                
            }
            else{
                after.next=head;
                after=after.next;
            }
            head=head.next;
        }
        
        after.next=null;
        before.next=ahead.next;
        return bhead.next;
        
        
        
        
    }
}
