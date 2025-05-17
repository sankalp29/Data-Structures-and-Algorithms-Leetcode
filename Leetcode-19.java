/*
    https://leetcode.com/problems/remove-nth-node-from-end-of-list/
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
    /**
     * Time complexity : O(N) Single pass on linked list
     * Space complexity : O(1)
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || head.next == null) return null;
        
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode slow = head, fast = head, prev = dummyHead;
        int stepsAhead = n-1;
        while (stepsAhead-- > 0) fast = fast.next;
        
        while (fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next;
        }

        prev.next = slow.next;

        return dummyHead.next;
    }
}