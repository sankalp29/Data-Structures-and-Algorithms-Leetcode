/*
    https://leetcode.com/problems/closest-binary-search-tree-value-ii/
*/

class Solution {
    /**
     * Time complexity : O(N)
     * Space complexity : O(K + N)
     */
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        Deque<Integer> deque = new LinkedList<>();
        dfs(root, target, k, deque);

        return new ArrayList<>(deque);
    }

    private void dfs(TreeNode root, double target, int k, Deque<Integer> deque) {
        if (root == null) return;

        dfs(root.left, target, k, deque);
        deque.add(root.val);

        if (deque.size() > k) {
            if (Math.abs(deque.peekFirst() - target) <= Math.abs(deque.peekLast() - target)) {
                deque.pollLast();
                return;
            }
            deque.pollFirst();
        }

        dfs(root.right, target, k, deque);
    }
}