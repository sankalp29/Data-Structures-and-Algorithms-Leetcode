/*
    https://leetcode.com/problems/car-pooling/
*/

class Solution {
    /**
     * Time complexity : O(N + 1000)
     * Space complexity : O(1000) => O(1) constant space
     */
    public boolean carPooling(int[][] trips, int capacity) {
        int[] passengersOnboard = new int[1001];
        for (int[] trip : trips) {
            int passengers = trips[0];
            int pickupPoint = trips[1];
            int dropPoint = trips[2];

            passengersOnboard[pickupPoint]+=passengers;
            passengersOnboard[dropPoint]-=passengers;
        }

        for (int i = 0; i <= 1000; i++) {
            if (passengersOnboard[i] > capacity) return false;
        }

        return true;
    }

    /**
     * Time complexity : O(NlogN)
     * Space complexity : O(N)
     */
    public boolean carPooling(int[][] trips, int capacity) {
        Arrays.sort(trips, (a, b) -> (a[1] - b[1]));
        
        Comparator<Pair> comparator = (p1, p2) -> p1.dropPoint - p2.dropPoint;
        PriorityQueue<Pair> queue = new PriorityQueue<>(comparator);

        int availableSeats = capacity;

        for (int i = 0; i < trips.length; i++) {
            int passengers = trips[i][0];
            int currentPoint = trips[i][1];
            int dropPoint = trips[i][2];

            while (!queue.isEmpty() && queue.peek().dropPoint <= currentPoint) {
                availableSeats+=queue.poll().numOfPassengers;
            }

            if (availableSeats >= passengers) {
                availableSeats-=passengers;
                queue.add(new Pair(passengers, dropPoint));
            } else return false;
        }

        return true;
    }

    private static class Pair {
        int numOfPassengers;
        int dropPoint;

        public Pair(int numOfPassengers, int dropPoint) {
            this.numOfPassengers = numOfPassengers;
            this.dropPoint = dropPoint;
        }
    }
}