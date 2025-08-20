/**
 * Time complexity : O(M*N * (M*N)) (for each of the M*N starting points, we could possibly recurse over the entire board)
 * Space complexity : O(M*N) (visited matrix)
 */
class Solution {
    int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public boolean exist(char[][] board, String word) {
        int rows = board.length, cols = board[0].length;
        int[][] visited = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (dfs(board, word, 0, visited, i, j)) return true;
                }
            }
        }

        return false;
    }

    private boolean dfs(char[][] board, String word, int index, int[][] visited, int row, int col) {
        if (index == word.length() - 1) {
            return board[row][col] == word.charAt(index);
        }
        if (board[row][col] != word.charAt(index)) return false;
        visited[row][col] = 1;

        for (int[] direction : directions) {
            int newRow = row + direction[0];
            int newCol = col + direction[1];

            if (isValid(newRow, newCol, board) && visited[newRow][newCol] == 0) {
                if (dfs(board, word, index+1, visited, newRow, newCol)) return true;
            }
        }

        visited[row][col] = 0;
        return false;
    }

    private boolean isValid(int row, int col, char[][] board) {
        int rows = board.length, cols = board[0].length;

        return row >= 0 && row < rows && col >= 0 && col < cols;
    }
}