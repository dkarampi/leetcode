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
	public ListNode swapPairs(ListNode head) {

		if (head == null || head.next == null)
			return head;

		ListNode n0, n1, n2;

		n0 = new ListNode(0);
		n0.next = head;

		n1 = head;
		n2 = n1.next;
		head = n2;

		while (n1 != null && n2 != null) {

			/* swap */
			n0.next = n2;
			n1.next = n2.next;
			n2.next = n1;

			/* Update the references (n1 now is ahead of n2) */
			n0 = n1;
			n1 = n1.next;

			if (n1 == null) /* Make sure we didn't reach the end */
				return head;

			n2 = n1.next;
		}

		return head;
	}
}


/*
 * Nice and short recursive solution - O(n) space.
 * https://oj.leetcode.com/discuss/14045/my-accepted-java-code-used-recursion
 */
public class Solution {
	public ListNode swapPairs(ListNode head) {
		if ((head == null)||(head.next == null))
			return head;
		ListNode n = head.next;
		head.next = swapPairs(head.next.next);
		n.next = head;
		return n;
	}
}
