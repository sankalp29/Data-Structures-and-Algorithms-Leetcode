/*
    https://leetcode.com/problems/binary-tree-inorder-traversal/
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
     * Space complexity : O(N) worst case, O(logN) average case (height of the tree)
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> st = new Stack<>();
        List<Integer> result = new ArrayList<>();
        TreeNode current = root;

        while (current != null || !st.isEmpty()) {
            
            while (current != null) {
                st.add(current);
                current = current.left;
            }

            current = st.pop();
            result.add(current.val);

            current = current.right;
        }

        return result;
    }
}