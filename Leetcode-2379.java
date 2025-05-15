/*
    https://leetcode.com/problems/minimum-recolors-to-get-k-consecutive-black-blocks/
*/

class Solution {
    /**
     * Time complexity : O(N)
     * Space complexity : O(1)
     */
    public int minimumRecolors(String blocks, int k) {
        if (k == 0) return 0;
        if (k > blocks.length()) return -1;

        int left = 0, right = 0, whiteBlocks = 0, minimumChanges = Integer.MAX_VALUE;
        while (right < k-1) {
            if (blocks.charAt(right) == 'W') whiteBlocks++;
            right++;
        }

        for (; right < blocks.length(); right++, left++) {
            if (blocks.charAt(right) == 'W') whiteBlocks++;
            minimumChanges = Math.min(minimumChanges, whiteBlocks);
            if (blocks.charAt(left) == 'W') whiteBlocks--;
        }

        return minimumChanges;
    }
}