/*
    https://leetcode.com/problems/merge-k-sorted-lists/
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
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        
        // minHeap always has N elements
        Comparator<ListNode> comparator = (l1, l2) -> l1.val - l2.val;
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(comparator);
        
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) minHeap.add(lists[i]);
        }

        ListNode dummyHead = new ListNode(0);
        ListNode current = dummyHead;

        while (!minHeap.isEmpty()) {
            ListNode min = minHeap.poll();
            current.next = min;
            current = current.next;

            if (min.next != null) minHeap.add(min.next);
        }

        return dummyHead.next;
    }
}