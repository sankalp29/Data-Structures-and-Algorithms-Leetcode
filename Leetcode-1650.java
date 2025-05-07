
/*
    https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree-iii/
*/



/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};
*/

class Solution {
    /**
     * Time complexity : O(H = logN) average case, O(N) worst case (skewed tree)
     * Space complexity : O(H = logN), O(N) worst case (skewed tree)
     */
    public Node lowestCommonAncestor(Node p, Node q) {
        Node a = p, b = q;

        while (a != b) {
            a = a.parent;
            b = b.parent;

            if (a == null) a = q;
            if (b == null) b = p;
        }

        return a;
    }

    /**
     * Time complexity : O(H) average case, O(N) worst case (skewed tree)
     * Space complexity : O(H) average case, O(N) worst case (skewed tree)
     */
    private Node approach1(Node p, Node q) {
        Set<Node> ancestors = new HashSet<>();
        while (p != null) {
            ancestors.add(p);
            p = p.parent;
        }   

        while (q != null) {
            if (ancestors.contains(q)) return q;
            q = q.parent;
        }

        return null;
    }
}