/*
    https://leetcode.com/problems/missing-element-in-sorted-array/
*/

class Solution {
    /**
     * Time complexity : O(logN)
     * Space complexity : O(1)
     */
    public int missingElement(int[] nums, int k) {
        int offset = nums[0] - 1;
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int missingElements = nums[mid] - (mid + 1) - offset;
            if (missingElements >= k) right = mid - 1;
            else left = mid + 1;
        }
        
        int missing = nums[right] - (right + 1) - offset;
        int remaining = k - missing; // = k - (nums[right] - (right + 1) - offset)
        // return nums[right] + remaining => k  + (right + 1) + offset
        return k  + (right + 1) + offset;
    }

    private int linearSearch(int[] nums, int k) {
        k = nums[0] + k;
        for (int i = 1; i < nums.length; i++) {
            if (k >= nums[i]) k++;
            if (k < nums[i]) return k;

        }

        return k;
    }
}