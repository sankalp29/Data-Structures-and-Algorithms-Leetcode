/*
    https://leetcode.com/problems/palindrome-linked-list/
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
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;

        ListNode slow = head, fast = head, firstHalfEnd = null;
        while (fast != null && fast.next != null) {
            firstHalfEnd = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        firstHalfEnd.next = null;
        ListNode secondHalfStart = reverseList(slow);
        ListNode ptr1 = head;
        ListNode ptr2 = secondHalfStart;
        boolean isPalind = true;

        while (ptr1 != null && ptr2 != null) {
            if (ptr2.val != ptr1.val) {
                isPalind = false;
                break;
            }
            ptr2 = ptr2.next;
            ptr1 = ptr1.next;
        }

        firstHalfEnd.next = reverseList(secondHalfStart);
        return isPalind;
    }

    private ListNode reverseList(ListNode head) {
        if (head.next == null) return head;
        ListNode prev = null;

        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }

        return prev;
    }
}