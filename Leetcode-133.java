/*
    https://leetcode.com/problems/clone-graph/
*/

/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) return null;

        Map<Node, Node> origToReplicaMap = new HashMap<>();
        Set<Node> visited = new HashSet<>();

        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        visited.add(node);

        // Perform BFS to create replica nodes and map them against original nodes
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            Node replica = new Node(current.val);

            origToReplicaMap.put(current, replica);

            for (Node neighbour : current.neighbors) {
                if (!visited.contains(neighbour)) {
                    queue.add(neighbour);
                    visited.add(neighbour);
                }
            }
        }

        // Step 2 : Perform BFS again, and set the neighbours for the replica graph nodes
        visited.clear();
        queue.add(node);
        visited.add(node);

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            Node replica = origToReplicaMap.get(current);

            for (Node neighbour : current.neighbors) {
                Node replicaNeighbour = origToReplicaMap.get(neighbour);
                replica.neighbors.add(replicaNeighbour);

                if (!visited.contains(neighbour)) {
                    queue.add(neighbour);
                    visited.add(neighbour);
                }
            }
        }

        return origToReplicaMap.get(node);
    }
}