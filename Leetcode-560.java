/*
    https://leetcode.com/problems/subarray-sum-equals-k
*/


class Solution {
    /**
     * Time complexity : O(N)
     * Space complexity : O(N)
     */
    public int subarraySum(int[] nums, int k) {
        int currentSum = 0, answer = 0;
        Map<Integer, Integer> sumsSeen = new HashMap<>();
        sumsSeen.put(0, 1);

        for (int i = 0; i < nums.length; i++) {
            currentSum+=nums[i];
            if (sumsSeen.containsKey(currentSum - k)) answer+=sumsSeen.get(currentSum - k);

            sumsSeen.put(currentSum, sumsSeen.getOrDefault(currentSum, 0) + 1);
        }

        return answer;
    }
}