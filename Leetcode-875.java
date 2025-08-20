/**
 * Time complexity : O(NlogB) (B = max bananas in a pile)
 * Space complexity : O(1)
 */
class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        long bananas = 0;
        for (int pile : piles) bananas = Math.max(bananas, pile);

        long lower = 1, upper = bananas, minEatPerHour = -1;

        while (lower <= upper) {
            long eatPerHour = lower + (upper - lower) / 2;
            long hoursNeeded = calculateHoursNeeded(piles, eatPerHour);

            if (hoursNeeded > h) lower = eatPerHour + 1;
            else {
                minEatPerHour = eatPerHour;
                upper = eatPerHour - 1;
            }
        }

        return (int) minEatPerHour;
    }

    private long calculateHoursNeeded(int[] piles, long eatPerHour) {
        long hoursNeeded = 0;
        for (int bananas : piles) {
            hoursNeeded+= (bananas + eatPerHour - 1) / eatPerHour;
        }

        return hoursNeeded;
    }
}