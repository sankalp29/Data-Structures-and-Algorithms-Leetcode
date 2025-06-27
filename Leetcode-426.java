/*
    https://leetcode.com/problems/convert-binary-search-tree-to-sorted-doubly-linked-list/
*/

class Solution {
    /**
     * Time complexity : O(N)
     * Space complexity : O(N)
     */
    public Node treeToDoublyList(Node root) {
        if (root == null) return null;

        Node dummyHead = new Node(-1);
        Node current = dummyHead;
        Node treeNode = root;

        Stack<Node> stack = new Stack<>();
        while (!stack.isEmpty() || treeNode != null) {
            while (treeNode != null) {
                stack.add(treeNode);
                treeNode = treeNode.left;
            }

            treeNode = stack.pop();
            Node newNode = new Node(treeNode.val);
            current.right = newNode;
            newNode.left = current;
            current = newNode;

            treeNode = treeNode.right;
        }

        current.right = dummyHead.right;
        dummyHead.right.left = current;
        return dummyHead.right;
    }
}