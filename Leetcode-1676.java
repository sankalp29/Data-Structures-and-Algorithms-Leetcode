class Solution {
    /**
     * Time complexity : O(N)
     * Space complexity : O(N) (Set + Recursion stack space)
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode[] nodes) {
        if (root == null || nodes.length == 0) return null;
        if (nodes.length == 1) return nodes[0];

        Set<TreeNode> nodeSet = new HashSet<>();
        for (TreeNode node : nodes) nodeSet.add(node);

        return findLCA(root, nodeSet);
    }

    private TreeNode findLCA(TreeNode node, Set<TreeNode> nodeSet) {
        if (node == null) return null;

        if (nodeSet.contains(node)) return node;

        TreeNode left = findLCA(node.left, nodeSet);
        TreeNode right = findLCA(node.right, nodeSet);

        if (left != null && right != null) return node;
        if (left != null) return left;
        return right;
    }
}