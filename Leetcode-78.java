/*
    https://leetcode.com/problems/subsets/
*/

class Solution {
    /**
     * Bitmasking
     * Time complexity : O(N * 2^N)
     * Space complexity : O(N * 2^N)
     */
    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        List<List<Integer>> powerSet = new ArrayList<>();
        int totalSubsets = 1 << n;

        for (int mask = 0; mask < totalSubsets; mask++) { // mask is in a way the subset number
            List<Integer> subset = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) subset.add(nums[i]);
            }

            powerSet.add(subset);
        }

        return powerSet;
    }

    /**
     * Time complexity : O(N * 2^N)
     * Space complexity : O(N * 2^N)
     */
    /*
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> powerSet = new ArrayList<>();
        List<Integer> current = new ArrayList<>();

        generatePowerSet(nums, 0, current, powerSet);

        return powerSet;
    }
    */

    private void generatePowerSet(int[] nums, int index, List<Integer> current, List<List<Integer>> powerSet) {
        if (index == nums.length) {
            powerSet.add(new ArrayList<>(current));
            return;
        }

        // Option 1 : Don't pick
        generatePowerSet(nums, index+1, current, powerSet);

        // Option 2 : Pick
        current.add(nums[index]);
        generatePowerSet(nums, index+1, current, powerSet);
        current.remove(current.size() - 1);
    }
}