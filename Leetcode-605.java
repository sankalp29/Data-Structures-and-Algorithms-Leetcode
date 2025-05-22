/*
    https://leetcode.com/problems/can-place-flowers/
*/

class Solution {
    /**
     * Time complexity : O(Length of array)
     * Space complexity : O(1)
     */
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int previousPlot = 0;

        for (int i = 0; i < flowerbed.length && n > 0; i++) {
            if (flowerbed[i] == 1) {
                previousPlot = 1;
                continue;
            }

            int nextPlot = (i == flowerbed.length - 1) ? 0 : flowerbed[i + 1];

            if (previousPlot == 0 && nextPlot == 0) {
                n = n - 1;
                previousPlot = 1;
            } else {
                previousPlot = 0;
            }
        }

        return n == 0;
    }
}
