/*
    https://leetcode.com/problems/missing-ranges/
*/

class Solution {
    /**
     * Time complexity : O(N)
     * Space complexity : O(1)
     */
    public List<List<Integer>> findMissingRanges(int[] nums, int lower, int upper) {
        List<List<Integer>> missingRanges = new ArrayList<>();
        
        if (nums.length == 0) {
            missingRanges.add(List.of(lower, upper));
            return missingRanges;
        }

        int start = lower;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > start) {
                missingRanges.add(List.of(start, nums[i] - 1));
            }
            start = nums[i] + 1;
        }

        if (start <= upper) {
            missingRanges.add(List.of(start, upper));
        }

        return missingRanges;
    }
}