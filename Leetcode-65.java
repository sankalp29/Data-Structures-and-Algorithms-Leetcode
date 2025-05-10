/*
    https://leetcode.com/problems/valid-number/
*/

class Solution {
    public boolean isNumber(String s) {
        if (s == null) return false;
        s = s.trim();
        int n = s.length();
        if (n == 0) return false;

        boolean numSeen = false;
        boolean numAfterE = true;
        boolean dotSeen = false;
        boolean eSeen = false;

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                numSeen = true;
                if (eSeen) numAfterE = true;
            } else if (ch == '+' || ch == '-') {
                if (i != 0 && s.charAt(i - 1) != 'e' && s.charAt(i - 1) != 'E') return false;
            } else if (ch == '.') {
                if (dotSeen || eSeen) return false;
                dotSeen = true;
            } else if (ch == 'e' || ch == 'E') {
                if (eSeen || !numSeen) return false;
                eSeen = true;
                numAfterE = false;
            } else {
                return false;
            }
        }

        return numSeen && numAfterE;
    }
}