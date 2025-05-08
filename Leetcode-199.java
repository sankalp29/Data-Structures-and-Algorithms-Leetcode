/*
    https://leetcode.com/problems/binary-tree-right-side-view/
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
     * Space complexity : O(N) (In a complete binary tree, the last level will have N/2 nodes)
     */
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<Integer> rightView = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            TreeNode rightMost = null;

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                rightMost = node;

                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            
            rightView.add(rightMost);
        }

        return rightView;
    }
}