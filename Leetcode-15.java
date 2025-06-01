/*
    https://leetcode.com/problems/3sum/
*/

class Solution {
    /**
     * Time complexity : O(N^2)
     * Space complexity : O(1)
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> triplets = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i-1]) continue;
            int left = i + 1, right = nums.length - 1;

            while (left < right) {
                int totalSum = nums[i] + nums[left] + nums[right];
                if (totalSum == 0) {
                    triplets.add(List.of(nums[i], nums[left], nums[right]));
                    left++;
                    right--;
                    while (left < right && nums[left] == nums[left - 1]) left++;
                    while (left < right && nums[right] == nums[right + 1]) right--;
                } else if (totalSum > 0) {
                    right--;
                } else left++;
            }
        }

        return triplets;
    }
}