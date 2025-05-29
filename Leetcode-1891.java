/*
    https://leetcode.com/problems/cutting-ribbons/
*/

class Solution {
    /**
     * Time complexity : O(Nlog(maxElement))
     * Space complexity : O(1)
     */
    public int maxLength(int[] ribbons, int k) {
        int maxRibbon = Integer.MIN_VALUE;

        for (int ribbon : ribbons) maxRibbon = Math.max(maxRibbon, ribbon);

        int left = 1, right = maxRibbon, result = 0;

        while (left <= right) {
            int length = left + (right - left) / 2;
            int pieces = countPieces(ribbons, length);
            if (pieces >= k) {
                result = length;
                left = length + 1;
            } else right = length - 1;
        }

        return result;
    }
    
    /**
     * Count the number of ribbons of length 'targetLength' that can be formed from the input ribbons
     */
    private int countPieces(int[] ribbons, int targetLength) {
        int count = 0;
        for (int ribbon : ribbons) count+=(ribbon / targetLength);

        return count;
    }
}