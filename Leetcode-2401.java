/*
    https://leetcode.com/problems/longest-nice-subarray/
*/

class Solution {
    public int longestNiceSubarray(int[] nums) {
        int left = 0, right = 0, longest = 1, prefixOr = 0;

        while (right < nums.length) {
            // If the bitwse AND gives a non-zero value, that means some bit(s) in nums[right] & also set in prefixOr
            // i.e some element previous has the same bit(s) set. So the bitwise AND != 0
            while (left < right && (prefixOr & nums[right]) != 0) {
                prefixOr = prefixOr ^ nums[left];
                left++;
            }
            
            prefixOr = prefixOr | nums[right];

            longest = Math.max(longest, right - left + 1);
            right++;
        }

        return longest;
    }
}