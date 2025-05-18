class Solution {
    /**
     * Time complexity : O(N^2 * alpha (N^2))
     * Space complexity : O(N^2) for parent and size arrays
     */
    public int largestIsland(int[][] grid) {
        int n = grid.length;
        DisjointSet ds = new DisjointSet(grid);
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        int maximumIslandSize = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    for (int[] direction : directions) {
                        int newI = i + direction[0];
                        int newJ = j + direction[1];

                        if (isValid(newI, newJ, n) && grid[newI][newJ] == 1) 
                            ds.union(newI*n + newJ, i*n + j);
                    }
                }
            }
        }

        boolean allOnes = true;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    allOnes = false;
                    Set<Integer> parents = new HashSet<>();
                    for (int[] direction : directions) {
                        int nRow = i + direction[0];
                        int nCol = j + direction[1];

                        if (isValid(nRow, nCol, n) && grid[nRow][nCol] == 1) {
                            parents.add(ds.findParent(nRow*n + nCol));
                        }
                    }

                    int islandSize = 0;
                    for (Integer parent : parents) {
                        islandSize+=ds.getIslandSize(parent);
                    }

                    maximumIslandSize = Math.max(maximumIslandSize, islandSize + 1);
                }
            }
        }

        return allOnes ? n*n : maximumIslandSize;
    }

    private boolean isValid(int row, int col, int n) {
        return row >= 0 && row < n && col >= 0 && col < n;
    }

    private static class DisjointSet {
        int[] parent;
        int[] size;

        public DisjointSet(int[][] grid) {
            int n = grid.length;
            parent = new int[n*n];
            size = new int[n*n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    parent[i*n + j] = i*n + j;
                    if (grid[i][j] == 1) size[i*n + j] = 1;
                }
            }
        }

        public void union(int cell1, int cell2) {
            int parent1 = findParent(cell1);
            int parent2 = findParent(cell2);
            if (parent1 == parent2) return;

            if (size[parent1] > size[parent2]) {
                parent[parent2] = parent1;
                size[parent1]+=size[parent2];
            } else {
                parent[parent1] = parent2;
                size[parent2]+=size[parent1];
            }
        }

        public int findParent(int cell) {
            if (parent[cell] == cell) return cell;
            return parent[cell] = findParent(parent[cell]);
        }

        public int getIslandSize(int cell) {
            return size[cell];
        }
    }
}