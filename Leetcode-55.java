/*
    https://leetcode.com/problems/jump-game/
*/

class Solution {
    /**
     * Time complexity : O(N)
     * Space complexity : O(1)
     */
    public boolean canJump(int[] nums) {
        int farthest = 0, n = nums.length;
        for (int i = 0; i <= Math.min(farthest, n - 1); i++) {
            int farthestJump = i + nums[i];
            farthest = Math.max(farthest, farthestJump);
        }

        return farthest >= n - 1;
    }
}