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
        Map<Integer, List<Integer>> xCoordinateNodes = new HashMap<>();

        Queue<Tuple> queue = new LinkedList<>();
        queue.add(new Tuple(root, 0));
        int lowestXCoordinate = Integer.MAX_VALUE;

        while (!queue.isEmpty()) {
            Tuple tuple = queue.poll();
            TreeNode node = tuple.node;
            int xCoordinate = tuple.xCoordinate;
            lowestXCoordinate = Math.min(lowestXCoordinate, xCoordinate);

            xCoordinateNodes.putIfAbsent(xCoordinate, new ArrayList<>());
            xCoordinateNodes.get(xCoordinate).add(node.val);

            if (node.left != null) queue.add(new Tuple(node.left, xCoordinate - 1));
            if (node.right != null) queue.add(new Tuple(node.right, xCoordinate + 1));
        }

        List<List<Integer>> result = new ArrayList<>();

        for (int i = lowestXCoordinate; xCoordinateNodes.containsKey(i); i++) {
            result.add(xCoordinateNodes.get(i));
        }

        return result;
    }
}

class Tuple {
    public TreeNode node;
    public int xCoordinate;

    public Tuple (TreeNode node, int xCoordinate) {
        this.node = node;
        this.xCoordinate = xCoordinate;
    }
}