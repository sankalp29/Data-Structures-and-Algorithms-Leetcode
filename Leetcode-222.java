/*
    https://leetcode.com/problems/count-complete-tree-nodes/
*/

class Solution {
    /**
     * Time complexity : O(logN * logN) because at every level we are finding the left & right height
     * Finding the height will take O(logN) time, because height of the tree is logN.
     * So, at every level it takes O(logN) time. 
     * The total number of levels are = the height of the tree
     * Hence, O(logN * logN)
     * 
     * Space complexity : O(logN)
     */
    public int countNodes(TreeNode root) {
        if (root == null) return 0;

        int leftHeight = getLeftHeight(root);
        int rightHeight = getRightHeight(root);

        if (leftHeight == rightHeight) {
            return (1 << leftHeight) - 1;
        }

        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    private int getRightHeight(TreeNode root) {
        if (root == null) return 0;
        int height = 0;
        while (root != null) {
            height++;
            root = root.right;
        }

        return height;
    }

    private int getLeftHeight(TreeNode root) {
        if (root == null) return 0;
        int height = 0;
        while (root != null) {
            height++;
            root = root.left;
        }

        return height;
    }
}