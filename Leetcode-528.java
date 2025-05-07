/*
    https://leetcode.com/problems/random-pick-with-weight/
*/


class Solution {
    private int[] prefixSums;
    private Random rand;

    /**
     * Time complexity : O(N)
     * Space complexity : O(N)
     */
    public Solution(int[] w) {
        prefixSums = new int[w.length];
        rand = new Random();
        
        prefixSums[0] = w[0];
        for (int i = 1; i < w.length; i++) {
            prefixSums[i] = prefixSums[i-1] + w[i];
        }
    }

    /**
     * Time complexity : O(logN)
     */
    public int pickIndex() {
        int n = prefixSums.length;
        int totalWeight = prefixSums[n-1];
        int random = rand.nextInt(totalWeight) + 1; // [1, totalWeight]

        // Find which range the random number belongs to.
        // The ranges are defined by the numbers in prefixSums array
        int left = 0, right = n-1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (prefixSums[mid] < random) left = mid + 1;
            else right = mid;
        }

        return left;
    }
}
