class Solution {
    /**
     * Time complexity : O(N + M)
     * Space complexity : O(min(N, M))
     */
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        int n = firstList.length, m = secondList.length;
        int index1 = 0, index2 = 0;
        List<int[]> intersections = new ArrayList<>();

        while (index1 < n && index2 < m) {
            int start1 = firstList[index1][0], end1 = firstList[index1][1];
            int start2 = secondList[index2][0], end2 = secondList[index2][1];

            if (Math.max(start1, start2) <= Math.min(end1, end2)) {
                intersections.add(new int[] {Math.max(start1, start2), Math.min(end1, end2)});
            }
            if (end1 < end2) index1++;
            else index2++;
        }

        return intersections.toArray(new int[intersections.size()][2]);
    }
}