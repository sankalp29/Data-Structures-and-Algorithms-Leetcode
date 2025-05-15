/*
    https://leetcode.com/problems/maximum-enemy-forts-that-can-be-captured/
*/

class Solution {
    /**
     * Time complexity : O(N)
     * Space complexity : O(1)
     */
    public int captureForts(int[] forts) {
        int prevFortValue = -2, maxFortsCaptured = 0, currentFortsCaptured = 0;

        for (int i = 0; i < forts.length; i++) {
            if (forts[i] == 0) currentFortsCaptured++;
            else {
                if (prevFortValue == -forts[i]) 
                    maxFortsCaptured = Math.max(maxFortsCaptured, currentFortsCaptured);
                
                currentFortsCaptured = 0;
                prevFortValue = forts[i];
            }
        }

        return maxFortsCaptured;
    }
}