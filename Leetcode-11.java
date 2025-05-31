/*
    https://leetcode.com/problems/container-with-most-water/
*/

class Solution {
    /**
     * Time complexity : O(N)
     * Space complexity : O(1)
     */
    public int maxArea(int[] height) {
        int mostWaterArea = 0, left = 0, right = height.length - 1;

        while (left < right) {
            int area = Math.min(height[left], height[right]) * (right - left);
            mostWaterArea = Math.max(mostWaterArea, area);

            if (height[left] < height[right]) left++;
            else right--;
        }

        return mostWaterArea;
    }
}