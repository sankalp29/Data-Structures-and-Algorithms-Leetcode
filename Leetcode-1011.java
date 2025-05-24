/*
    https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/
*/

class Solution {
    /**
     * Time complexity : O(N * log(sum(weights) - maxWeight))
     * Space complexity : O(1)
     */
    public int shipWithinDays(int[] weights, int days) {
        int weightsSum = 0, heaviestPackage = -1;
        for (int weight : weights) {
            weightsSum+=weight;
            heaviestPackage = Math.max(heaviestPackage, weight);
        }

        int low = heaviestPackage, high = weightsSum;

        while (low < high) {
            int shipCapacity = low + (high - low) / 2;
            
            if (canShipWithCapacity(weights, shipCapacity, days)) {
                high = shipCapacity;
            } else {
                low = shipCapacity + 1;
            }
        }

        return high;
    }

    private boolean canShipWithCapacity(int[] weights, int shipCapacity, int daysAllowed) {
        int daysRequired = 1;
        int currentWeight = 0;
        for (int weight : weights) {
            if (currentWeight + weight <= shipCapacity) {
                currentWeight+=weight;
            } else {
                daysRequired++;
                currentWeight = weight;
            }
        }

        return daysRequired <= daysAllowed;
    }
}