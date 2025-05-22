/*
    https://leetcode.com/problems/kth-missing-positive-number/
*/

class Solution {
    /**
     * Time complexity : O(logN)
     * Space complexity : O(1)
     */
    public int findKthPositive(int[] arr, int k) {
        int n = arr.length;
        int low = 0, high = n-1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int missing = arr[mid] - (mid + 1);

            if (missing < k) low = mid + 1;
            else high = mid - 1;
        }

        // return arr[high] + more

        return k + low;

        /**
            more = K - (number of elements missing till arr[high] (J))
            J = arr[high] - (high + 1)

            more = K - (arr[high] - (high + 1))

            Answer = arr[high] + K - (arr[high] - (high + 1))
                   = arr[high] + K - arr[high] + (high + 1)
                   = K + (high + 1)

            But low = (high + 1) because that's why the loop ends

            Answer = K + low
         */
    }

    /**
     * Time complexity : O(N)
     * Space complexity : O(1)
     /*
    public int findKthPositive(int[] arr, int k) {
        int lastSeen = 0;
        for (int i = 0; i < arr.length; i++) {
            int numsSkipped = arr[i] - lastSeen - 1;
            if (numsSkipped >= k) break;
            k = k - numsSkipped;
            lastSeen = arr[i];
        }

        return lastSeen + k;
    }
    */
}