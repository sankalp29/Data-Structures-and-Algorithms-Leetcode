/*
    https://leetcode.com/problems/max-consecutive-ones-ii/
*/

class Solution {
    /**
     * Time complexity : O(N) (Single-pass on the array)
     * Space complexity : O(1)
     */
    public int findMaxConsecutiveOnes(int[] nums) {
        // We flip a 0 to 1, and we try to find the maximum subarray which now has all 1s.
        // This is the same as finding the maximum subarray with at most one 0.

        int left = 0, right = 0, zero = 0;
        int maxLength = 0;
        while (right < nums.length) {
            if (nums[right] == 0) zero++;

            while (zero > 1) {
                if (nums[left] == 0) zero--;
                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);
            right++;
        }

        return maxLength;
    }

    /**
     * Time complexity : O(N)
     * Space complexity : O(N)
     */
     /*
    public int findMaxConsecutiveOnes(int[] nums) {
        int n = nums.length;
        int[] prefix = new int[n], postfix = new int[n];
        int maxConsecutive = 0;

        // Initialize prefix ones
        int ones = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) ones++;
            else ones = 0;

            prefix[i] = ones;
        }

        // Initialize postfix ones
        ones = 0;
        for (int i = n-1; i >= 0; i--) {
            if (nums[i] == 1) ones++;
            else ones = 0;

            postfix[i] = ones; 
        }

        // For every 0, check the consective ones to it's left and it's right & add them
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                int left = (i == 0) ? 0 : prefix[i-1];
                int right = (i == n-1) ? 0 : postfix[i+1];
                maxConsecutive = Math.max(maxConsecutive, left + right + 1);
            } else {
                maxConsecutive = Math.max(maxConsecutive, prefix[i]);
            }
        }

        return maxConsecutive;
    }
    */
}
