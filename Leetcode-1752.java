/*
    https://leetcode.com/problems/check-if-array-is-sorted-and-rotated/
*/

class Solution {
    /** 
     * Time complexity : O(N)
     * Space complexity : O(1)
    */
    public boolean check(int[] nums) {
        int drops = 0, n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] > nums[i+1]) drops++;
        }

        if (nums[n - 1] > nums[0]) drops++;

        return drops <= 1;
    }
}