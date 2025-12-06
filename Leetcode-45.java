/*
    https://leetcode.com/problems/jump-game-ii/
*/

class Solution {
    /**
     * Time complexity : O(N)
     * Space complexity : O(1)
     */
    public int jump(int[] nums) {
        int n = nums.length;
        int steps = 0, farthest = 0, currentEnd = 0;

        for (int i = 0; i < n - 1; i++) {
            farthest = Math.max(farthest, i + nums[i]);
            if (i == currentEnd) {
                steps++;
                currentEnd = farthest;
            }
        }

        return steps;
    }
}