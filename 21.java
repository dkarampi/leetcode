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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;
            
        ListNode l, tail, dummy;
        l = tail = dummy = new ListNode(0);
        
        while (l1 != null && l2 != null) {
            
            if (l1.val < l2.val) {
                tail.next = l1;
                l1 = l1.next;
            }
            else {
                tail.next = l2;
                l2 = l2.next;
            }
            
            if (l == dummy) // first entry
                l = l.next;

            tail = tail.next;
        }
        
        if (l1 == null)
            tail.next = l2;
        else
            tail.next = l1;
     
        return l;   
    }
}



// 2 more short and clean solutions. The first one requires O(n) extra space

// https://oj.leetcode.com/discuss/8372/a-recursive-solution
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    
        if(l1 == null) return l2;
        if(l2 == null) return l1;
    
        if(l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l2.next, l1);
            return l2;
        }
    }

//https://oj.leetcode.com/discuss/21829/my-solutions-in-3-languages
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode tail = head;
        for (boolean left; l1 != null && l2 != null; tail = tail.next) {
            left = l1.val < l2.val;
            tail.next = left ? l1 : l2;
            l1 = left ? l1.next : l1;
            l2 = left ? l2 : l2.next;
        }
        tail.next = l1 != null ? l1 : l2;
        return head.next;
    }
}