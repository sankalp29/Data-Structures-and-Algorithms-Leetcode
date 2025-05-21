/*
    https://leetcode.com/problems/check-completeness-of-a-binary-tree/
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
    /**
     * Time complexity : O(N)
     * Space complexity : O(N)
     */
    public boolean isCompleteTree(TreeNode root) {
        if (root == null) return true;

        Queue<TreeNode> bfsQueue = new LinkedList<>();
        bfsQueue.add(root);
        boolean nullSeen = false;

        // Once we see a NULL, we should not see a non-NULL henceforth
        while (!bfsQueue.isEmpty()) {
            TreeNode node = bfsQueue.poll();
            if (node == null) nullSeen = true;
            else {
                if (nullSeen) return false;
                bfsQueue.add(node.left);
                bfsQueue.add(node.right);
            }
        }

        return true;
    }
}