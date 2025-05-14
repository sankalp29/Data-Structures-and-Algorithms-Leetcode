/*
    https://leetcode.com/problems/max-consecutive-ones/
*/

class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int currentOnes = 0, maxOnes = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) currentOnes++;
            else currentOnes = 0;

            maxOnes = Math.max(maxOnes, currentOnes);
        }

        return maxOnes;
    }
}