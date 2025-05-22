class Solution {
    /**
     * Time complexity : O(N)
     * Space complexity : O(1)
     */
    public int maxPower(String s) {
        int length = 1, maxLength = 1, index = 1;

        while (index < s.length()) {
            if (s.charAt(index) == s.charAt(index-1)) length++;
            else length = 1;

            maxLength = Math.max(maxLength, length);
            index++;
        }

        return maxLength;
    }
}