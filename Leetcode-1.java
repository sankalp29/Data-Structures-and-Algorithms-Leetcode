/*
    https://leetcode.com/problems/two-sum/
*/

class Solution {
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length == 0) return null;
        
        Map<Integer, Integer> valueToIndex = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (valueToIndex.containsKey(target - nums[i])) {
                return new int[] {valueToIndex.get(target - nums[i]), i};
            }
            valueToIndex.put(nums[i], i);
        }

        return new int[] {-1, -1};
    }
}