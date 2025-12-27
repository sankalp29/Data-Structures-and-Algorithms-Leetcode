/*
    https://leetcode.com/problems/rotate-array/
*/

class Solution {
    /**
     * Time complexity : O(N + K)
     * Space complexity : O(1)
     */
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        reverse(nums, 0, n - k - 1);
        reverse(nums, n - k, n - 1);
        reverse(nums, 0, n - 1);
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }

    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

    /**
     * Time complexity : O(N + K)
     * Space complexity : O(K)
     */
    private void rotateUsingExtraSpace(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        int[] numbers = new int[k];
        int index = 0;
        for (int i = n - k; i < n; i++) {
            numbers[index++] = nums[i];
        }

        for (int i = n - k - 1; i >= 0; i--) {
            nums[i + k] = nums[i];
        }

        for (int i = 0; i < k; i++) {
            nums[i] = numbers[i];
        }
    }
}