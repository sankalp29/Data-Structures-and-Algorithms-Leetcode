/*
    https://leetcode.com/problems/merge-intervals/
*/

class Solution {
    /**
     * Time complexity : O(NlogN) + O(N) + O(N) => O(NlogN)
     * Space complexity : O(N) + O(N) => O(N)
     */
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return new int[][] {{}};

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<int[]> mergedIntervals = new ArrayList<>();
        int startTime = intervals[0][0], endTime = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= endTime) {
                endTime = Math.max(endTime, intervals[i][1]);
            } else {
                int[] interval = new int[] {startTime, endTime};
                mergedIntervals.add(interval);
                startTime = intervals[i][0];
                endTime = intervals[i][1];
            }
        }

        int[] lastInterval = new int[] {startTime, endTime};
        mergedIntervals.add(lastInterval);
        
        int[][] result = new int[mergedIntervals.size()][2];
        int index = 0;
        for (int[] interval : mergedIntervals) {
            result[index][0] = interval[0];
            result[index][1] = interval[1];
            index++;
        }

        return result;
    }
}