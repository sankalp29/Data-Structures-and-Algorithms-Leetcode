/*
    https://leetcode.com/problems/range-sum-of-bst/  
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
     * Time complexity : O(N) worst case, O(logN) average case
     * Space complexity : O(N) worst case, O(logN) average case
     */
    public int rangeSumBST(TreeNode root, int low, int high) {
        
        if (root == null) return 0;

        if (root.val < low) return rangeSumBST(root.right, low, high);
        if (root.val > high) return rangeSumBST(root.left, low, high);

        int sumLeft = rangeSumBST(root.left, low, high);
        int sumRight = rangeSumBST(root.right, low, high);

        return sumLeft + sumRight + root.val;
    }

    /* 
     * Iterative approach
     * Time complexity : O(N) worst case, O(logN) average case
     * Space complexity : O(N) worst case, O(logN) average case
    */
    /*
    public int rangeSumBST(TreeNode root, int low, int high) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int sum = 0;

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            
            if (node.val >= low && node.val <= high) {
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
                sum+=node.val;
            } else if (node.val < low && node.right != null) {
                queue.add(node.right);
            } else if (node.val > high && node.left != null) {
                queue.add(node.left);
            }
        }

        return sum;
    }
    */
}