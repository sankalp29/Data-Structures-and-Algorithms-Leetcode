/*
    https://leetcode.com/problems/design-tic-tac-toe/
*/

/**
 * Optimal solution
 * Time complexity : O(1) for each move() call
 * Space complexity : O(2*N)
 */
class TicTacToe {
    int[] rows, cols;
    int diagonal, antiDiagonal, n;

    public TicTacToe(int n) {
        this.n = n;
        rows = new int[n];
        cols = new int[n]; 
    }

    public int move(int row, int col, int player) {
        int toAdd = (player == 1) ? 1 : -1;
        rows[row]+=toAdd;
        cols[col]+=toAdd;

        if (row == col) diagonal+=toAdd;
        if (row + col == n - 1) antiDiagonal+=toAdd;

        if (Math.abs(rows[row]) == n || Math.abs(cols[col]) == n || Math.abs(diagonal) == n || Math.abs(antiDiagonal) == n) 
            return player;
        
        return 0;
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */




/**
 * Sub-optimal solution
 * Time complexity : O(4*N) for each move() call
 * Space complexity : O(N^2)
 */
 /*
class TicTacToe {
    char[][] grid;

    public TicTacToe(int n) {
        grid = new char[n][n];    
    }
    
    public int move(int row, int col, int player) {
        if (player == 1) { // Play 'X'
            grid[row][col] = 'X';
        } else { // Play 'O'
            grid[row][col] = 'O';
        }

        return getVictor(grid, row, col, player);
    }

    private int getVictor(char[][] grid, int row, int col, int player) {
        if (isRowFilled(grid, row, col, grid[row][col])) return player;
        if (isColFilled(grid, row, col, grid[row][col])) return player;
        if (row == col || row + col == grid.length - 1) {
            if (isLeftRightDiagonalFilled(grid, row, col, grid[row][col])) return player;
            if (isRightLeftDiagonalFilled(grid, row, col, grid[row][col])) return player;
        }

        return 0;
    }

    private boolean isRowFilled(char[][] grid, int row, int col, char move) {
        for (char ch : grid[row]) {
            if (ch != move) return false;
        }
        return true;
    }

    private boolean isColFilled(char[][] grid, int row, int col, char move) {
        for (int i = 0; i < grid.length; i++) {
            if (grid[i][col] != move) return false;
        }
        return true;
    }

    private boolean isLeftRightDiagonalFilled(char[][] grid, int row, int col, char move) {
        for (int i = 0; i < grid.length; i++) {
            if (grid[i][i] != move) return false;
        }

        return true;
    }

    private boolean isRightLeftDiagonalFilled(char[][] grid, int row, int col, char move) {
        for (int i = 0; i < grid.length; i++) {
            if (grid[i][grid.length - i - 1] != move) return false;
        }
        return true;
    }
}
*/

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */