/*
    https://leetcode.com/problems/check-if-all-as-appears-before-all-bs/
*/

class Solution {
    /**
     * Time complexity : O(N)
     * Space complexity : O(1)
     */
    public boolean checkString(String s) {
        boolean bSeen = false;
        for (char ch : s.toCharArray()) {
            if (ch == 'b') bSeen = true;
            if (ch == 'a') {
                if (bSeen) return false;
            }
        }

        return true;
    }
}