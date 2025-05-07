/* 
    https://leetcode.com/problems/buildings-with-an-ocean-view/ 
*/


class Solution {
    /**
     * Time complexity : O(N)
     * Space complexity : (N)
     */
    public int[] findBuildings(int[] heights) {
        if (heights == null || heights.length == 0) return new int[]{};

        int n = heights.length, maxHeightSeen = -1;
        boolean[] hasOceanView = new boolean[n];
        int count = 0;
        for (int i = n-1; i >= 0; i--) {
            if (heights[i] > maxHeightSeen) {
                hasOceanView[i] = true;
                count++; 
            }
            maxHeightSeen = Math.max(maxHeightSeen, heights[i]);
        }

        int[] result = new int[count];
        int resultIndex = 0;
        for (int i = 0; i < n; i++) {
            if (hasOceanView[i]) result[resultIndex++] = i;
        }

        return result;
    }
}