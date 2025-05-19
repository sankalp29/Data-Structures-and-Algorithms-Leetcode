/*
    https://leetcode.com/problems/exclusive-time-of-functions/
*/

class Solution {
    /**
     * Time complexity : O(L) (number of logs)
     * Space complexity : O(L) (number of logs)
     */
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] result = new int[n];
        Stack<Integer> process = new Stack<>();
        int startTime = 0;

        for (int i = 0; i < logs.size(); i++) {
            String[] details = logs.get(i).split(":");
            int id = Integer.parseInt(details[0]);
            int time = Integer.parseInt(details[2]);

            if (details[1].equals("start")) {
                if (!process.isEmpty()) {
                    result[process.peek()]+=(time - startTime);
                }
                process.add(id);
                startTime = time;
            } else {
                result[process.pop()]+=(time - startTime + 1);
                startTime = time + 1;
            }
        }

        return result;
    }
}