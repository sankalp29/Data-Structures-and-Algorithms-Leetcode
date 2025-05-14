/*
    https://leetcode.com/problems/max-consecutive-ones-iii/
*/

class Solution {
    /**
     * Time complexity : O(2*N) => O(N)
     * Space complexity : O(1)
     */
    public int longestOnes(int[] nums, int k) {
        int left = 0, right = 0, zeroes = 0, maxConsecutiveOnes = 0;

        while (right < nums.length) {
            if (nums[right] == 0) zeroes++;

            while (zeroes > k) {
                if (nums[left] == 0) zeroes--;
                left++;
            }

            maxConsecutiveOnes = Math.max(maxConsecutiveOnes, right - left + 1);
            right++;
        }

        return maxConsecutiveOnes;
    }
}