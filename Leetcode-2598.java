class Solution {
    /**
     * Time complexity : O(N + Value)
     * Space complexity : O(Value)
     */
    public int findSmallestInteger(int[] nums, int value) {
        int[] frequency = new int[value];
        for (int num : nums) {
            frequency[(num % value + value) % value]++;
        }

        int minimum = Integer.MAX_VALUE, minValue = 0;
        for (int i = 0; i < value; i++) {
            if (frequency[i] < minimum) {
                minimum = frequency[i];
                minValue = i;
            }
        }

        return minimum * value + minValue;
    }
}