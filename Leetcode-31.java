/*
    https://leetcode.com/problems/next-permutation/
*/

class Solution {
    /**
     * Time complexity : O(N) + O(N) + O(NlogN)
     * Space complexity : O(1)
     */
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length == 0) return;
        int n = nums.length;
        
        if (isDescending(nums)) {
            reverse(nums);
            return;
        }

        for (int i = n-2; i >= 0; i--) {
            // Keep moving left till numbers are increasing
            if (nums[i+1] <= nums[i]) continue;
            int index = i+1;
            // Find index of the smallest number > nums[i]
            while (index < n && nums[index] > nums[i]) index++;
            index--;
            // Swap the smallest number > nums[i] with nums[i]. Doing this gives us a larger permutation.
            swap(nums, i, index);
            // Since we already have a larger permutation, but we need the "NEXT" larger permutation, sort array from (i+1)
            Arrays.sort(nums, i+1, n);
            break;
        }
    }

    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

    private void reverse(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n / 2; i++) {
            swap(nums, i, n - i - 1);
        }
    }

    private boolean isDescending(int[] nums) {
        int n = nums.length;
        for (int i = n-2; i >= 0; i--) {
            if (nums[i+1] > nums[i]) return false;
        }

        return true;
    }
}