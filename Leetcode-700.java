/*
    https://leetcode.com/problems/search-in-a-binary-search-tree/
*/

class Solution {
    /**
     * Time complexity : O(logN) average case, O(N) worst case
     * Space complexity : O(1)
     */
    public TreeNode searchBST(TreeNode root, int val) {
        while (root != null) {
            if (root.val == val) break;
            if (root.val > val) root = root.left;
            else root = root.right;
        }

        return root;
    }
}