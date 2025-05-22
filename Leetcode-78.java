/*
    
*/

class Solution {
    /**
     * Time complexity : O(N * 2^N)
     * Space complexity : O(N * 2^N)
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> powerSet = new ArrayList<>();
        List<Integer> current = new ArrayList<>();

        generatePowerSet(nums, 0, current, powerSet);

        return powerSet;
    }

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