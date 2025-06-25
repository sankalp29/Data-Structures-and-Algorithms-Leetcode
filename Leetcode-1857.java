/*
    https://leetcode.com/problems/largest-color-value-in-a-directed-graph/
*/

class Solution {
    /**
     * Time complexity : O(V + E)
     * Space complexity : O(V + E)
     */
    public int largestPathValue(String colors, int[][] edges) {
        int n = colors.length();
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        int[] inDegree = new int[n];
        int maxColorValue = -1;

        for (int[] edge : edges) {
            int from = edge[0], to = edge[1];
            adjList.putIfAbsent(from, new ArrayList<>());
            adjList.get(from).add(to);

            inDegree[to]++;
        }

        int[][] colorFrequency = new int[n][26];
        Queue<Integer> topoSortQ = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) topoSortQ.add(i);
        }
        
        int nodesVisited = 0;
        while (!topoSortQ.isEmpty()) {
            Integer node = topoSortQ.poll();
            nodesVisited++;
            int color = colors.charAt(node) - 'a';
            colorFrequency[node][color]++;
            maxColorValue = Math.max(maxColorValue, colorFrequency[node][color]);

            for (Integer neighbour : adjList.getOrDefault(node, new ArrayList<>())) {
                for (int col = 0; col < 26; col++) {
                    colorFrequency[neighbour][col] = Math.max(colorFrequency[neighbour][col], colorFrequency[node][col]);
                }

                inDegree[neighbour]--;
                if (inDegree[neighbour] == 0) topoSortQ.add(neighbour);
            }
        }

        return nodesVisited == n ? maxColorValue : -1;
    }
}