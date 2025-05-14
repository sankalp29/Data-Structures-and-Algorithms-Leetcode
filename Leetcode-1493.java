/*
    https://leetcode.com/problems/longest-subarray-of-1s-after-deleting-one-element/
*/

class Solution {
    /**
     * Time complexity : O(N)
     * Space complexity : O(1)
     */
    public int longestSubarray(int[] nums) {
        int left = 0, right = 0, zeroes = 0, longest = 0;

        while (right < nums.length) {
            if (nums[right] == 0) zeroes++;

            while (zeroes > 1) {
                if (nums[left] == 0) zeroes--;
                left++;
            }

            longest = Math.max(longest, right - left + 1);
            right++;
        }

        return longest - 1;
    }
}