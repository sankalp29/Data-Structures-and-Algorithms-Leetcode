/*
https://leetcode.com/problems/course-schedule-iii/
*/
class Solution {
    /**
     * Time complexity : O(NlogN)
     * Space complexity : O(N)
     */
    public int scheduleCourse(int[][] courses) {
        int n = courses.length;
        int time = 0;

        Arrays.sort(courses, (a, b) -> a[1] - b[1]);
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

        for (int i = 0; i < courses.length; i++) {
            int duration = courses[i][0];
            int lastDay = courses[i][1];
            if (duration > lastDay) continue;

            time+=duration;
            maxHeap.add(duration);

            if (time > lastDay) {
                time-=maxHeap.poll();
            }
        }

        return maxHeap.size();
    }
}