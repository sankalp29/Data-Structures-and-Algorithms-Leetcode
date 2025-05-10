/*
    https://leetcode.com/problems/sum-of-beauty-in-the-array/
*/

class Solution {
    /**
     * Time complexity : O(N)
     * Space complexity : O(N)
     */
    public int sumOfBeauties(int[] nums) {
        int n = nums.length;
        int[] prefixMax = new int[n];
        int prefixRunningMax = 0, beauty = 0, postfixMin = nums[n-1];
        
        for (int i = 0; i < n; i++) {
            prefixMax[i] = prefixRunningMax;
            prefixRunningMax = Math.max(prefixRunningMax, nums[i]);
        }
        
        for (int i = n-2; i >= 1; i--) {
            if (prefixMax[i] < nums[i] && nums[i] < postfixMin) beauty+=2;
            else if (nums[i-1] < nums[i] && nums[i] < nums[i+1]) beauty+=1;

            postfixMin = Math.min(postfixMin, nums[i]);
        }

        return beauty;
    }
}