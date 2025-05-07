/*
    https://leetcode.com/problems/binary-tree-vertical-order-traversal/
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
     * Space complexity : O(N) + O(N) => O(N)
     */
    public List<List<Integer>> verticalOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();
        // Map of xCoordinate -> (nodes present on that xCoordinate)
        Map<Integer, List<Integer>> columnNodes = new TreeMap<>();

        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(root, 0));

        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            TreeNode node = pair.node;
            int x = pair.x;

            columnNodes.computeIfAbsent(x, k -> new ArrayList<>()).add(node.val);

            if (node.left != null) queue.add(new Pair(node.left, x - 1));
            if (node.right != null) queue.add(new Pair(node.right, x + 1));
        }

        return new ArrayList<>(columnNodes.values());
    }
}

class Pair {
    public TreeNode node;
    public int x;

    public Pair (TreeNode node, int x) {
        this.node = node;
        this.x = x;
    }
}