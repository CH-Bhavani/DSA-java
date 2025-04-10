/**

In a linked list of size n, where n is even, the ith node (0-indexed) of the linked list is known as the twin of the (n-1-i)th node, if 0 <= i <= (n / 2) - 1.

For example, if n = 4, then node 0 is the twin of node 3, and node 1 is the twin of node 2. These are the only nodes with twins for n = 4.
The twin sum is defined as the sum of a node and its twin.

Given the head of a linked list with even length, return the maximum twin sum of the linked list.

 

Example 1:


Input: head = [5,4,2,1]
Output: 6
Explanation:
Nodes 0 and 1 are the twins of nodes 3 and 2, respectively. All have twin sum = 6.
There are no other nodes with twins in the linked list.
Thus, the maximum twin sum of the linked list is 6. 
Example 2:


Input: head = [4,2,2,3]
Output: 7
Explanation:
The nodes with twins present in this linked list are:
- Node 0 is the twin of node 3 having a twin sum of 4 + 3 = 7.
- Node 1 is the twin of node 2 having a twin sum of 2 + 2 = 4.
Thus, the maximum twin sum of the linked list is max(7, 4) = 7. 
Example 3:


Input: head = [1,100000]
Output: 100001
Explanation:
There is only one node with a twin in the linked list having twin sum of 1 + 100000 = 100001.
 

Constraints:

The number of nodes in the list is an even integer in the range [2, 105].
1 <= Node.val <= 105


  **/



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
    public int pairSum(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        Stack<Integer> stack = new Stack<>();
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            stack.push(slow.val);
            slow = slow.next;
        }
        int maxsum = 0;
        while (slow!=null){
            maxsum = Math.max(maxsum, slow.val + stack.pop());
            slow = slow.next;
        }
        return maxsum;

    }
}




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
    public int pairSum(ListNode head) {
        int length = 0;
        ListNode current = head;
        while(current!= null){
            length++;
            current=current.next;
        }
        ListNode first = head;
        ListNode second = head;

        for(int i=0; i< length/2; i++){
            second = second.next;
        }
        ListNode prev = null;
        while(second!=null){
            ListNode next = second.next;
            second.next = prev;
            prev = second;
            second = next;
        }
        ListNode firstHalf = head;
        ListNode secondHalf = prev;
        int maxs=0;
        while(secondHalf!=null){
            maxs = Math.max(maxs,firstHalf.val +secondHalf.val);
            firstHalf=firstHalf.next;
            secondHalf=secondHalf.next;
        }

        return maxs;



    }
}



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
    public int pairSum(ListNode head) {
        ListNode fast=head;
        ListNode slow=head;
        int sum=0;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        fast=head;
        slow=reverse(slow);
        while(slow!=null){
            if ( sum < fast.val + slow.val)
                sum  = fast.val + slow.val;
            fast = fast.next;
            slow = slow.next;
        }
        return sum;
    }
    public ListNode reverse(ListNode head){
        if(head==null || head.next==null)
            return head;
        ListNode next=reverse(head.next);
        head.next.next=head;
        head.next=null;
        return next;
    }
}
