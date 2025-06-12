/*
    https://leetcode.com/problems/largest-color-value-in-a-directed-graph/
*/

class Solution {
    /**
     * Time complexity : O(26 * (V + E)) = O(V + E)
     * Space complexity : O(26*V) + O(E)
     */
    public int largestPathValue(String colors, int[][] edges) {
        int V = colors.length();
        int[] inDegree = new int[V], visited = new int[V];
        int nodesSeen = 0, maxColorValue = -1;
        // Construct adjancency list
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < V; i++) adjList.add(new ArrayList<>());

        for (int[] edge : edges) {
            int from = edge[0], to = edge[1];
            adjList.get(from).add(to);
            inDegree[to]++;
        }

        // Perform Topological Sort
        Queue<Integer> bfsQueue = new LinkedList<>();
        int[][] colorsAtNode = new int[V][26];
        for (int i = 0; i < V; i++) {
            if (inDegree[i] == 0) bfsQueue.add(i);
        }

        while (!bfsQueue.isEmpty()) {
            int node = bfsQueue.poll();
            int color = colors.charAt(node) - 'a';
            colorsAtNode[node][color]++;
            maxColorValue = Math.max(maxColorValue, colorsAtNode[node][color]);
            visited[node] = 1;
            nodesSeen++;

            for (Integer neighbour : adjList.get(node)) {
                inDegree[neighbour]--;
                if (inDegree[neighbour] == 0) {
                    bfsQueue.add(neighbour);
                }
                for (int i = 0; i < 26; i++) {
                    // Pass in the frequency of every color in the current path to the neighbor node
                    colorsAtNode[neighbour][i] = Math.max(colorsAtNode[neighbour][i], colorsAtNode[node][i]);
                }
            }
        }

        return nodesSeen == V ? maxColorValue : -1;
    }
}