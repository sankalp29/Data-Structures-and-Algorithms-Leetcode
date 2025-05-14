/*
    https://leetcode.com/problems/closest-binary-search-tree-value/
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
    // int result;
    // double closest;
    
    public int closestValue(TreeNode root, double target) {
        return getClosestValueIterative(root, target);
    }

    /**
     * Time complexity : Average case : O(logN) (height of the tree), O(N) worst case (skewed tree)
     * Space complexity : O(1)
     */
    private int getClosestValueIterative(TreeNode root, double target) {
        int val, closest = root.val;
        while (root != null) {
            val = root.val;
            double minDifference = Math.abs(closest - target);
            double currentDifference = Math.abs(val - target);
            if (currentDifference < minDifference || (currentDifference == minDifference && val < closest)) {
                closest = val;
            }

            if (target > val) root = root.right;
            else root = root.left;
        }

        return closest;
    }

    /**
     * Time complexity : Average case : O(logN) (height of the tree), O(N) worst case (skewed tree)
     * Space complexity : O(logN) (height of the tree)
     */
    private void getClosestValue(TreeNode root, double target) {
        if (root == null) return;

        double difference = Math.abs(root.val - target);
        if (difference < closest || (difference == closest && result > root.val)) {
            closest = difference;
            result = root.val;
        }

        if (root.val > target) {
            getClosestValue(root.left, target);
        } else {
            getClosestValue(root.right, target);
        }
    }
}