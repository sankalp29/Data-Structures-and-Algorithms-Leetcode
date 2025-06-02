/*
    https://leetcode.com/problems/contains-duplicate-ii/
*/

class Solution {
    /**
     * Time complexity : O(N)
     * Space complexity : O(K)
     */
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> window = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (window.contains(num)) return true;
            window.add(num);
            if (window.size() > k) window.remove(nums[i - k]);
        }
        return false;
    }
}