/*
    https://leetcode.com/problems/next-greater-element-ii/
*/

class Solution {
    /**
     * Time complexity : O(2*N)
     * Space complexity : O(N)
     */
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] nextGreater = new int[n];
        Arrays.fill(nextGreater, -1);
        Stack<Integer> stack = new Stack<>();

        for (int i = 2*n - 1; i >= 0; i--) {
            int index = i % n;
            while (!stack.isEmpty() && nums[index] >= stack.peek()) stack.pop();

            if (!stack.isEmpty()) nextGreater[index] = stack.peek();
            stack.add(nums[index]);
        }

        return nextGreater;
    }
}