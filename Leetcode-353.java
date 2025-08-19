/**
 * Time complexity : O(1) every move() call
 * Space complexity : O(N*M) (for food & Set and Deque)
 */
class SnakeGame {
    private int rows, cols, curRow, curCol, score, foodIndex;
    Map<String, int[]> change;
    Deque<Coordinate> snake;
    Set<Coordinate> snakeParts;
    int[][] food;
    boolean isGameOver;

    public SnakeGame(int width, int height, int[][] food) {
        rows = height;
        cols = width;
        curRow = 0;
        curCol = 0;
        score = 0;
        foodIndex = 0;
        this.food = food;
        isGameOver = false;
        change = new HashMap<>();
        snake = new ArrayDeque<>();
        snakeParts = new HashSet<>();
        initialiseDirections(change);
    }

    private void initialiseDirections(Map<String, int[]> change) {
        change.put("U", new int[] {-1, 0});
        change.put("D", new int[] {1, 0});
        change.put("L", new int[] {0, -1});
        change.put("R", new int[] {0, 1});
    }
    
    public int move(String direction) {
        if (isGameOver) return -1;

        int newRow = curRow + change.get(direction)[0];
        int newCol = curCol + change.get(direction)[1];
        Coordinate coordinate = new Coordinate(newRow, newCol);
        
        if (!isValid(newRow, newCol)) {
            isGameOver = true;
            return -1;
        }

        if (foodIndex < food.length && food[foodIndex][0] == newRow && food[foodIndex][1] == newCol) {
            score++;
            foodIndex++;
        } else {
            Coordinate tail = snake.pollLast();
            snakeParts.remove(tail);
            if (snakeParts.contains(coordinate)) {
                isGameOver = true;
                return -1;
            }
        }
        snakeParts.add(coordinate);
        snake.offerFirst(coordinate);

        curRow = newRow;
        curCol = newCol;

        return score;
    }

    private boolean isValid(int row, int col) {
        return row >= 0 && row < rows && col >= 0 && col < cols;
    }

    private static class Coordinate {
        int row, col;

        public Coordinate(int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Coordinate that = (Coordinate) o;
            return row == that.row && col == that.col;
        }

        @Override
        public int hashCode() {
            return Objects.hash(row, col);
        }
    }
}