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
    private List<Integer> maxDiameter = new ArrayList<>();
    public int diameterOfBinaryTree(TreeNode root) {
        getHeight(root);
        System.out.println(maxDiameter);
        return maxDiameter.size() - 1;
    }

    private List<Integer> getHeight(TreeNode root) {
        if (root == null) return new ArrayList<>();

        List<Integer> leftHeight = getHeight(root.left);
        List<Integer> rightHeight = getHeight(root.right);

        if (leftHeight.size() + rightHeight.size() > maxDiameter.size() - 1) {
            maxDiameter = new ArrayList<>();
            maxDiameter.addAll(leftHeight);
            maxDiameter.add(root.val);
            Collections.reverse(rightHeight);
            maxDiameter.addAll(rightHeight);
        }

        if (leftHeight.size() > rightHeight.size()) {
            leftHeight.add(root.val);
            return leftHeight;
        }

        rightHeight.add(root.val);
        return rightHeight;
    }
}