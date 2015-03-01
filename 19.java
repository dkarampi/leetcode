/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        
        ListNode zero = new ListNode(0);
        zero.next = head;
        
        ListNode fast = zero;
        
        for (int i = 0; i < n; i++, fast = fast.next) {
            // this check is optional;
            // description says that n is always valid
            if (fast == null)
                return head;
        }
        
        ListNode slow = zero;
        
        // Move the two pointers towards right until the fast one
        // reaches the last element. Maintain their relative distance.
        for (; fast.next != null; slow = slow.next, fast = fast.next)
            ;
        
        if (slow == zero) // corner case
            return head.next;
        
        slow.next = slow.next.next;
        
        return head;
    }
}