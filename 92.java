/*
 * I solved the problem in 2 ways. One recursive and one iterative.
 * Another idea is to build a sublist once we hit the n-th
 * element and continue adding nodes until the m-th.
 * Of course every time we need to prepend the list we build
 * by adding the new elements at the head.
 * As a last step, we merge the sublist and the 2 other parts
 * (begin and end) of the main list.
 */
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
	public ListNode reverseBetween(ListNode head, int m, int n) {

		ListNode zero = new ListNode(0);
		ListNode start, end;
		zero.next = head;

		/* start should point one before m */
		for (start = zero; m-1 > 0; m--, start = start.next) ;
		/* end should point at n */
		for (end = zero; n > 0; n--, end = end.next) ;

		/* Corner case. Normally we would return head, but not in this case */
		boolean flag = false;
		if (start.next == head)
			flag = true;

		/* Isolate the end of the list */
		ListNode l = end.next;
		end.next = null;

		start.next = reverseIterative(start.next);

		/* Merge the tail (optimization: reverse*() can return the tail as well) */
		ListNode x;
		for (x = start; x.next != null; x = x.next);
		x.next = l;

		if (flag == true)
			return start.next;

		return head;
	}

	private ListNode reverseRecursive(ListNode head) {

		if (head == null || head.next == null)
			return head;

		/* Hint: the reverse of the second element on followed by the first element. */
		ListNode reverse = reverseRecursive(head.next);
		/*
		 * head.next still points to the last element of reversed sub-list.
		 * So move the head to end.
		 */
		head.next.next = head;
		head.next = null;
		return reverse;
	}

	private ListNode reverseIterative(ListNode head) {

		if (head == null || head.next == null)
			return head;

		ListNode zero = new ListNode(0);
		zero.next = head;
		ListNode prev = zero;
		ListNode curr = head;
		ListNode next = head.next;

		while (next != null) {
			curr.next = prev;
			prev = curr;
			curr = next;
			next = next.next;
		}
		/* Fix the first and last next pointer */
		curr.next = prev;
		head.next = null;

		return curr;
	}
}
