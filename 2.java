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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        ListNode head = new ListNode(0);
        ListNode l = head;
        int carry = 0;
        
        for (; l1 != null && l2 != null; l1 = l1.next, l2 = l2.next, l = l.next) {
            int sum = l1.val + l2.val + carry;
            l.next = new ListNode(sum % 10);
            carry = sum / 10;
        }
        
        for (; l1 != null; l1 = l1.next, l = l.next) {
            int sum = l1.val + carry;
            l.next = new ListNode(sum % 10);
            carry = sum / 10;
        }
        
        for (; l2 != null; l2 = l2.next, l = l.next) {
            int sum = l2.val + carry;
            l.next = new ListNode(sum % 10);
            carry = sum / 10;
        }
        
        if (carry > 0)
            l.next = new ListNode(carry);
        
        return head.next;
    }
}