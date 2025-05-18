/*
    https://leetcode.com/problems/squares-of-a-sorted-array/
*/

class Solution {
    /**
     * Time complexity : O(N)
     * Space complexity : O(1)
     */
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int left = 0, right = n-1, index = n-1;
        int[] result = new int[n];

        while (left <= right) {
            if (Math.abs(nums[left]) > Math.abs(nums[right])) {
                result[index] = nums[left] * nums[left];
                left++;
            } else {
                result[index] = nums[right] * nums[right];
                right--;
            }
            index--;
        }

        return result;
    }
}