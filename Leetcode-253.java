/**
 * Time complexity : O(NlogN)
 * Space complexity : O(N)
 */
class Solution {
    public int minMeetingRooms(int[][] intervals) {
        TreeMap<Integer, Integer> roomsRequired = new TreeMap<>();
        for (int[] interval : intervals) {
            int start = interval[0];
            int end = interval[1];

            roomsRequired.put(start, roomsRequired.getOrDefault(start, 0) + 1);
            roomsRequired.put(end, roomsRequired.getOrDefault(end, 0) - 1);
        }

        int maxRoomsRequired = 0, rooms = 0;
        for (Integer key : roomsRequired.keySet()) {
            rooms+=roomsRequired.get(key);
            maxRoomsRequired = Math.max(maxRoomsRequired, rooms);
        }

        return maxRoomsRequired;
    }
}