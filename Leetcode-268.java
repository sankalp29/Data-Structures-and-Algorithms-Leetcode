/*
    https://leetcode.com/problems/missing-number/
*/

class Solution {
    /**
     * Time complexity : O(N)
     * Space complexity : O(1)
     */
    public int missingNumber(int[] nums) {
        int xor = 0;
        for (int i = 0; i < nums.length; i++) {
            xor = xor ^ (i + 1);
            xor = xor ^ nums[i];
        }

        return xor;
    }
}