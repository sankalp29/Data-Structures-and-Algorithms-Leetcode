/*
    https://leetcode.com/problems/longest-consecutive-sequence/
*/

class Solution {
    /**
     * Time complexity : O(N)
     * Space complexity : O(N)
     */
    public int longestConsecutive(int[] nums) {
        Set<Integer> numbers = new HashSet<>();

        for (int num : nums) numbers.add(num);

        int longest = 0;

        for (int num : numbers) {
            if (numbers.contains(num - 1)) continue;

            int value = num;
            while (numbers.contains(value)) {
                value++;
            }
            
            int sequenceLength = value - num;
            longest = Math.max(longest, sequenceLength);
        }

        return longest;
    }
}