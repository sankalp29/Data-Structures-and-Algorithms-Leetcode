/*
    https://leetcode.com/problems/3sum/
*/

class Solution {
    /**
     * Time complexity : O(N ^ 2 + OlogN)
     * Space complexity : O(1) auxiliary space
     */
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < n - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int start = i + 1, end = n - 1;
            while (start < end) {
                int sum = nums[i] + nums[start] + nums[end];
                if (sum == 0) {
                    result.add(List.of(nums[i], nums[start], nums[end]));
                    int value = nums[start];
                    while (start < end && nums[start] == value) start++;
                    value = nums[end];
                    while (start < end && nums[end] == value) end--;
                } else if (sum < 0) start++;
                else end--;
            }
        }

        return result;
    }
}