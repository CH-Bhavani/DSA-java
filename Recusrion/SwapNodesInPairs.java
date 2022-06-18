/*


Given a linked list, swap every two adjacent nodes and return its head. You must solve the problem without modifying the values in the list's nodes (i.e., only nodes themselves may be changed.)

 

Example 1:


Input: head = [1,2,3,4]
Output: [2,1,4,3]
Example 2:

Input: head = []
Output: []
Example 3:

Input: head = [1]
Output: [1]

*/

class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        
        ListNode temp = head.next.next;  //saving reference of head next 1->2->"3"
        ListNode newHead = head.next;  // assigning newHead 1->"2" (2 is going to be head)
        head.next = temp; //current head it mapped to next head "1"->"3"
        newHead.next = head; // (newHead)"2"->(currentHead)"1"
        head = newHead; // making newHead as a actual head, now list look like (head)"2"->1->3.... 
        
        head.next.next = swapPairs(head.next.next); //passing next head to recursion func eg: (head)"3"->4->5->6.... 
        
        return head;
        
    }
}
