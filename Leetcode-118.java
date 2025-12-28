/*
    https://leetcode.com/problems/pascals-triangle/
*/

class Solution {
    /**
     * Time complexity : O(N ^ 2)
     * Space complexity : O(N ^ 2) for result list. O(1) auxiliary space
     */
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();

        for (int row = 0; row < numRows; row++) {
            List<Integer> currentRow = new ArrayList<>();
            currentRow.add(1);
            
            for (int j = 1; j <= row - 1; j++) {
                int topLeft = triangle.get(row - 1).get(j - 1);
                int topRight = triangle.get(row - 1).get(j);

                currentRow.add(topLeft + topRight);
            }
            if (row > 0) currentRow.add(1);

            triangle.add(currentRow);
        }

        return triangle;
    }
}