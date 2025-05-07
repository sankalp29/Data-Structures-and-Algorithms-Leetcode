/*
    https://leetcode.com/problems/binary-tree-vertical-order-traversal/
*/

class Solution {
    private static class Pair {
        TreeNode node;
        int x;
        public Pair(TreeNode node, int x) {
            this.node = node;
            this.x = x;
        }
    }

    /**
     * Time complexity: O(N)
     * Space complexity: O(N)
     */
    public List<List<Integer>> verticalOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();

        Map<Integer, List<Integer>> columnNodes = new HashMap<>();
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(root, 0));

        int minColumn = 0;
        int maxColumn = 0;

        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            TreeNode node = pair.node;
            int x = pair.x;

            columnNodes.computeIfAbsent(x, k -> new ArrayList<>()).add(node.val);

            minColumn = Math.min(minColumn, x);
            maxColumn = Math.max(maxColumn, x);

            if (node.left != null) queue.add(new Pair(node.left, x - 1));
            if (node.right != null) queue.add(new Pair(node.right, x + 1));
        }

        List<List<Integer>> result = new ArrayList<>();
        for (int i = minColumn; i <= maxColumn; i++) {
            result.add(columnNodes.get(i));
        }

        return result;
    }
}
