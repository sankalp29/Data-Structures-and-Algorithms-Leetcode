/*
    https://leetcode.com/problems/next-greater-element-i/
*/

class Solution {
    /**
     * Time complexity : O(N)
     * Space complexity : O(M + N)
     */
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> valueToIndex = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        int[] nextGreater = new int[nums2.length];
        Arrays.fill(nextGreater, -1);
        for (int i = nums2.length - 1; i >= 0; i--) {
            valueToIndex.put(nums2[i], i);
            while (!stack.isEmpty() && stack.peek() <= nums2[i]) {
                stack.pop();
            }

            if (!stack.isEmpty()) nextGreater[i] = stack.peek();
            stack.add(nums2[i]);
        }

        int[] result = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            int index = valueToIndex.get(nums1[i]);
            result[i] = nextGreater[index];
        }

        return result;
    }
}