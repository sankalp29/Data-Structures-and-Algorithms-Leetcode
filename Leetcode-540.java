/*
    https://leetcode.com/problems/single-element-in-a-sorted-array/
*/

class Solution {
    /**
     * Time complexity : O(logN)
     * Space complexity : O(1)
     */
    public int singleNonDuplicate(int[] nums) {
        int n = nums.length;
        int left = 0, right = n - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            mid = mid - (mid % 2);
            
            if (nums[mid] == nums[mid + 1]) {
               left = mid + 2;
            } else {
                right = mid;
            }
        }

        return nums[left];
    }
}