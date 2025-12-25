/*
    https://leetcode.com/problems/minimum-deletions-to-make-string-balanced/
*/

class Solution {
    /**
     * Time complexity : O(N)
     * Space complexity : O(1)
     */
    public int minimumDeletions(String s) {
        int bCount = 0, deletions = 0;

        for (char ch : s.toCharArray()) {
            if (ch == 'b') bCount++;
            else {
                deletions = Math.min(bCount, deletions + 1);
            }
        }

        return deletions;
    }
}