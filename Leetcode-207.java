class Solution {
    /**
     * N = numCourses, E = prerequisites.length
     * Time complexity : O(N + E) 
     * Space complexity : O(N + E)
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];
        Map<Integer, List<Integer>> dependencies = new HashMap<>();

        for (int[] prerequisite : prerequisites) {
            int first = prerequisite[1];
            int second = prerequisite[0];

            inDegree[second]++;
            dependencies.putIfAbsent(first, new ArrayList<>());
            dependencies.get(first).add(second);
        }

        Queue<Integer> bfsQueue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) bfsQueue.add(i);
        }

        while (!bfsQueue.isEmpty()) {
            int courseNo = bfsQueue.poll();
            numCourses--;

            for (Integer dependency : dependencies.getOrDefault(courseNo, new ArrayList<>())) {
                inDegree[dependency]--;
                if (inDegree[dependency] == 0) bfsQueue.add(dependency);
            }
        }

        return numCourses == 0;
    }
}