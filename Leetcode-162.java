/*
    https://leetcode.com/problems/find-peak-element/
*/

class Solution {
    /**
     * Time complexity : O(logN)
     * Space complexity : O(1)
     */
    public int findPeakElement(int[] nums) {
        if (nums == null || nums.length == 0) return -1;

        int n = nums.length;
        int left = 0, right = n - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            boolean biggerThanLeft = (mid - 1) < 0 ? true : nums[mid] > nums[mid - 1];
            boolean biggerThanRight = (mid + 1) == n ? true : nums[mid] > nums[mid + 1];
            
            if (biggerThanLeft && biggerThanRight) return mid;

            if (mid - 1 >= 0 && nums[mid - 1] > nums[mid]) right = mid - 1;
            else left = mid + 1;
        }

        return -1;
    }
}
