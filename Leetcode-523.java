class Solution {
    /**
     * Time complexity : O(N)
     * Space complexity : O(min(N, K))
     */
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> remainderIndexMap = new HashMap<>();
        int prefixSum = 0;
        remainderIndexMap.put(0, -1);

        for (int i = 0; i < nums.length; i++) {
            prefixSum+=nums[i];
            prefixSum = prefixSum % k;
            if (remainderIndexMap.containsKey(prefixSum) && i - remainderIndexMap.get(prefixSum) >= 2) 
                return true;
            
            remainderIndexMap.putIfAbsent(prefixSum, i);
        }

        return false;
    }
}