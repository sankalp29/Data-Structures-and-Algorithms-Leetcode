/*
    https://leetcode.com/problems/distribute-candies-among-children-ii/
*/

/**
 * Time complexity : O(1)
 * Space complexity : O(1)
 */
class Solution {
    public long distributeCandies(int n, int limit) {
        long totalWaysWithoutLimit = nCr(n+2);
        long oneChildOverLimit = nCr(n - (limit+1) + 2);
        long twoChildrenOverLimit = nCr(n - 2*(limit+1) + 2);
        long threeChildrenOverLimit = nCr(n - 3*(limit+1) + 2);

        return totalWaysWithoutLimit - 3*oneChildOverLimit + 3*twoChildrenOverLimit - threeChildrenOverLimit;
    }

    // Perform nC2 operation since r = 2
    private long nCr(int n) { 
        if (n < 0) return 0;

        return ((long)n * (n-1)) / 2;
    }
}
/**
Total distributions without any restriction = all (valid + invalid) = C(n + 2, 2)

Subtract distributions where at least 1 child gets more than limit:

This includes:

1. Only A exceeds
2. Only B exceeds
3. Only C exceeds

But also includes overlap like:
1. A and B exceed
2. B and C exceed
3. A and C exceed
4. A, B, and C exceed (all 3 exceed)

So we over-subtracted the 2-child and 3-child cases multiple times.
1. Add back the number of ways 2 children get more than limit (we subtracted them twice, need to add once).
2. But now 3-children-over-limit case is added back 3 times, once for each pair (AB, BC, AC), but was also subtracted 3 times in step 2. Net, we need to subtract it once. So subtract it.
 */