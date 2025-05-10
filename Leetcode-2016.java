/*
    https://leetcode.com/problems/maximum-difference-between-increasing-elements/description/
*/

class Solution {
    /**
     * Time complexity : O(N)
     * Space complexity : O(1)
     */
    public int maximumDifference(int[] nums) {
        if (nums == null || nums.length == 0) return -1;

        int minimum = Integer.MAX_VALUE, maxDifference = 0;

        for (int i = 0; i < nums.length; i++) {
            maxDifference = Math.max(maxDifference, nums[i] - minimum);
            minimum = Math.min(minimum, nums[i]);
        }

        return maxDifference == 0 ? -1 : maxDifference;
    }
}