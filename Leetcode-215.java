/*
    https://leetcode.com/problems/kth-largest-element-in-an-array/
*/

class Solution {
    /**
     * Time complexity ; O(NlogK)
     * Space complexity : O(K)
     */
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0) return -1;

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int num : nums) {
            minHeap.add(num);
            if (minHeap.size() > k) pq.poll();
        }

        return minHeap.peek();
    }
}