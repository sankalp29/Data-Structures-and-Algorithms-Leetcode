/*
    https://leetcode.com/problems/jump-game-iv/
*/

class Solution {
    /**
     * Time complexity : O(N)
     * Space complexity : O(N)
     */
    public int minJumps(int[] arr) {
        int n = arr.length;
        Map<Integer, List<Integer>> indexes = new HashMap<>();

        for (int i = 0; i < n; i++) {
            if (!indexes.containsKey(arr[i])) indexes.put(arr[i], new ArrayList<>());
            indexes.get(arr[i]).add(i);
        }

        int distance = 0;
        boolean[] visited = new boolean[n];
        Queue<Integer> bfsQueue = new ArrayDeque<>();
        bfsQueue.add(0);
        visited[0] = true;

        while (!bfsQueue.isEmpty()) {
            int size = bfsQueue.size();
            while (size-- > 0) {
                Integer index = bfsQueue.poll();
                if (index == n - 1) return distance;

                if (index - 1 >= 0 && !visited[index - 1]) {
                    bfsQueue.add(index - 1);
                    visited[index - 1] = true;
                }
                if (index + 1 < n && !visited[index + 1]) {
                    bfsQueue.add(index + 1);
                    visited[index + 1] = true;
                }

                for (Integer otherIndex : indexes.getOrDefault(arr[index], new ArrayList<>())) {
                    if (!visited[otherIndex]) {
                        bfsQueue.add(otherIndex);
                        visited[otherIndex] = true;
                    }
                }
                indexes.remove(arr[index]);
            }

            distance++;
        }

        return distance;
    }
}