/*
    https://leetcode.com/problems/robot-room-cleaner/
*/

class Solution {
    int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    Set<String> visited = new HashSet<>();

    /**
     * Time complexity : O(N - M) 
     * N = total cells
     * M = number of obstacle cells
     * Space complexity : O(N - M)
     */
    public void cleanRoom(Robot robot) {
        backtrack(robot, 0, 0, 0);
    }

    private void backtrack(Robot robot, int row, int col, int currentDirection) {
        String position = row + ":" + col;
        if (visited.contains(position)) return;
        visited.add(position);
        robot.clean();

        for (int i = 0; i < 4; i++) {
            int newDirection = (currentDirection + i) % 4;
            int newRow = row + directions[newDirection][0];
            int newCol = col + directions[newDirection][1];

            if (robot.move()) {
                backtrack(robot, newRow, newCol, newDirection);
                goBack(robot);
            }

            robot.turnRight();
        }
    }

    private void goBack(Robot robot) {
        robot.turnRight();
        robot.turnRight();
        robot.move();
        robot.turnRight();
        robot.turnRight();
    }
}