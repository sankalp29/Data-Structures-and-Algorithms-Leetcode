/*
    https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    /**
     * Time complexity : O(2*N) => O(N)
     * Space complexity : O(3*N) => O(N) for parentMap + O(N) for visited set + O(N) for auxiliary stack space
     */
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        if (root == null) return new ArrayList<>();
        // Step 1 : Assign parents to node
        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        assignParent(root, null, parentMap);

        Queue<TreeNode> queue = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();
        queue.add(target);
        visited.add(target);

        int distance = 0;

        List<Integer> result = new ArrayList<>();

        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                TreeNode current = queue.poll();
                if (distance == k) result.add(current.val);
                else {
                    if (current.left != null && !visited.contains(current.left)) {
                        queue.add(current.left);
                        visited.add(current.left);
                    }
                    if (current.right != null && !visited.contains(current.right)) {
                        queue.add(current.right);
                        visited.add(current.right);
                    }
                    if (parentMap.get(current) != null && !visited.contains(parentMap.get(current))) {
                        queue.add(parentMap.get(current));
                        visited.add(parentMap.get(current));
                    }
                }
            }
            distance++;
        }

        return result;
    }

    private void assignParent(TreeNode root, TreeNode parent, Map<TreeNode, TreeNode> parentMap) {
        if (root == null) return;

        parentMap.put(root, parent);
        assignParent(root.left, root, parentMap);
        assignParent(root.right, root, parentMap);
    }
}