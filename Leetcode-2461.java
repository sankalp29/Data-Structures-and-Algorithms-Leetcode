/*
    https://leetcode.com/problems/maximum-sum-of-distinct-subarrays-with-length-k/
*/

class Solution {
    /**
     * Time complexity : O(N)
     * Space complexity : O(N)
     */
    public long maximumSubarraySum(int[] nums, int k) {
        int left = 0, right = 0;
        long maxSum = 0, currentSum = 0;
        Map<Integer, Integer> frequency = new HashMap<>();

        while (right < nums.length) {
            frequency.put(nums[right], frequency.getOrDefault(nums[right], 0) + 1);
            currentSum+=nums[right];

            // Check current subarray length
            if ((right - left + 1) == k) {
                
                // If all elements are distinct in the current window
                if (frequency.size() == k) 
                    maxSum = Math.max(maxSum, currentSum);
                
                currentSum-=nums[left];
                frequency.put(nums[left], frequency.get(nums[left]) - 1);
                if (frequency.get(nums[left]) == 0) frequency.remove(nums[left]);
                left++;
            }

            right++;
        }

        return maxSum;
    }
}