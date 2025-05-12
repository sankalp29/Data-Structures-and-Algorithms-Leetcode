/*
    https://leetcode.com/problems/add-two-numbers/
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
     * Time complexity : O(N)
     * Space complexity : O(1)
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode current1 = l1, current2 = l2, dummyHead = new ListNode(-1);
        ListNode answerCurrent = dummyHead;
        while (current1 != null || current2 != null) {
            int digit1 = (current1 != null) ? current1.val : 0;
            int digit2 = (current2 != null) ? current2.val : 0;
            
            int digit = (digit1 + digit2 + carry) % 10;
            carry = (digit1 + digit2 + carry) / 10;

            ListNode node = new ListNode(digit);
            answerCurrent.next = node;
            answerCurrent = answerCurrent.next;

            if (current1 != null) current1 = current1.next;
            if (current2 != null) current2 = current2.next;
        }

        if (carry != 0) {
            ListNode node = new ListNode(carry);
            answerCurrent.next = node;
        }

        return dummyHead.next;
    }
}