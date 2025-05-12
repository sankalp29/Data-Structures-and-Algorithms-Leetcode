class Solution {

    /**
     * Solution 1
     * Time complexity : O(KlogN)
     * Space complexity : O(N)
     */
     /*
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        PriorityQueue<Tuple> minHeap = new PriorityQueue<>((t1, t2) -> (t1.value - t2.value));

        for (int i = 0; i < n; i++) minHeap.add(new Tuple(0, i, matrix[0][i]));

        while (!minHeap.isEmpty()) {
            Tuple tuple = minHeap.poll();
            int row = tuple.row;
            int col = tuple.col;
            int value = tuple.value;
            k--;
            if (k == 0) return value;

            if (row < n-1) minHeap.add(new Tuple(row+1, col, matrix[row+1][col]));
        }

        return -1;
    }

    private static class Tuple {
        int row;
        int col;
        int value;

        public Tuple(int row, int col, int value) {
            this.row = row;
            this.col = col;
            this.value = value;
        }
    }
    */


    /**
     * Solution 2 : Optimal
     * Time complexity : O(Nlog(maxElement - minElement))
     * Space complexity : O(1)
     */

    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int low = matrix[0][0], high = matrix[n-1][n-1];

        while (low < high) {
            int mid = low + (high - low) / 2;
            int count = countLessThanEqual(matrix, mid);

            if (count < k) low = mid + 1;
            else high = mid;
        }

        // Return anything (low or high). Both are same
        return low;
    }

    // Count number of cells having values <= target
    private int countLessThanEqual(int[][] matrix, int target) {
        int n = matrix.length;
        int row = n-1, col = 0;
        int count = 0;

        while (row >= 0 && col < n) {
            if (matrix[row][col] <= target) {
                count+=(row + 1);
                col++;
            } else {
                row--;
            }
        }

        return count;
    }
}