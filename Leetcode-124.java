/*
    https://leetcode.com/problems/binary-tree-maximum-path-sum/
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int maxSum = Integer.MIN_VALUE;
    /**
     * Time complexity : O(N)
     * Space complexity : O(N) (Recursion stack space)
     */
    public int maxPathSum(TreeNode root) {
        findMaxPathSum(root);
        return maxSum;
    }

    private int findMaxPathSum(TreeNode root) {
        if (root == null) return 0;

        int leftSum = Math.max(findMaxPathSum(root.left), 0);
        int rightSum = Math.max(findMaxPathSum(root.right), 0);

        maxSum = Math.max(maxSum, leftSum + rightSum + root.val);

        return root.val + Math.max(leftSum, rightSum);
    }
}