/*
    https://leetcode.com/problems/maximum-subarray/
*/

class Solution {
    /**
     * Kadane's algorithm
     * Time complexity : O(N)
     * Space complexity : O(1)
     */
    public int maxSubArray(int[] nums) {
        int currentSum = 0, maxSubarraySum = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            currentSum+=nums[i];
            maxSubarraySum = Math.max(maxSubarraySum, currentSum);

            if (currentSum < 0) currentSum = 0;
        }

        return maxSubarraySum;
        
    }

    /**
     * Time complexity : O(NlogN) (logN levels and iteration over N elements at each level)
     * Space complexity : O(logN) (logN levels -> recursion stack space)
     */
    private int divideAndConquer(int[] nums, int left, int right) {
        if (left == right) return nums[left];

        int mid = left + (right - left) / 2;

        int leftSum = divideAndConquer(nums, left, mid);
        int rightSum = divideAndConquer(nums, mid+1, right);
        int crossSum = getMaxCrossSum(nums, left, mid, right);

        return Math.max(crossSum, Math.max(leftSum, rightSum));
    }

    private int getMaxCrossSum(int[] nums, int left, int mid, int right) {
        int sum = 0, maxLeft = Integer.MIN_VALUE, maxRight = Integer.MIN_VALUE;

        for (int i = mid; i >= left; i--) {
            sum+=nums[i];
            maxLeft = Math.max(maxLeft, sum);
        }

        sum = 0;
        for (int i = mid+1; i <= right; i++) {
            sum+=nums[i];
            maxRight = Math.max(maxRight, sum);
        }

        return maxLeft + maxRight;
    }
}