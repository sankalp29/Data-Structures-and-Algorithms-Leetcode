/*
    https://leetcode.com/problems/k-closest-points-to-origin/
*/

class Solution {

    private static class Tuple {
        int index;
        double distance;

        public Tuple(int index, double distance) {
            this.index = index;
            this.distance = distance;
        }
    }

    /**
     * Optimal solution using Quickselect
     * Time complexity : O(N) average case, O(N^2) worst case
     * Space complxeity : O(1)
     */
    public int[][] kClosest(int[][] points, int k) {
        int n = points.length;
        Tuple[] coords = new Tuple[n];
        
        for (int i = 0; i < n; i++) {
            int x = points[i][0], y = points[i][1];
            coords[i] = new Tuple(i, getDistanceFromOrigin(x, y));
        }

        quickSelect(coords, k-1, 0, n-1);

        int[][] result = new int[k][2];
        for (int i = 0; i < k; i++) {
            int origIndex = coords[i].index;
            result[i][0] = points[origIndex][0];
            result[i][1] = points[origIndex][1];
        }

        return result;
    }

    // Find the Kth smallest distance. Every distance before it will be smaller.
    private void quickSelect(Tuple[] points, int k, int left, int right) {
        while (left < right) {
            int pivotIndex = findPivotIndex(points, left, right);
        
            if (pivotIndex == k) return;
        
            if (pivotIndex > k) {
                right = pivotIndex - 1;
            } else {
                left = pivotIndex+1;
            }
        }
    }

    private int findPivotIndex(Tuple[] points, int left, int right) {
        double pivot = points[right].distance;
        int pIndex = left;

        for (int i = left; i < right; i++) {
            if (points[i].distance < pivot) {
                swap(points, i, pIndex);
                pIndex++;
            }
        }

        swap(points, pIndex, right);
        return pIndex;
    }

    private void swap(Tuple[] points, int index1, int index2) {
        Tuple temp = points[index1];
        points[index1] = points[index2];
        points[index2] = temp;
    }
    
    private double getDistanceFromOrigin(int x, int y) {
        return Math.sqrt(x*x + y*y);
    }

    /**
     * Heap based approach
     * Time complexity : O(NlogK)
     * Space complexity : O(K)
     */
     /*
    public int[][] kClosest(int[][] points, int k) {
        
        Comparator<Tuple> comparator = (t1, t2) -> (t1.distance < t2.distance) ? 1 : -1;
        PriorityQueue<Tuple> maxHeap = new PriorityQueue<>(comparator);

        for (int i = 0; i < points.length; i++) {
            int[] point = points[i];
            int x = point[0], y = point[1];
            double distance = getDistanceFromOrigin(x, y);
            maxHeap.add(new Tuple(i, distance));

            if (maxHeap.size() > k) maxHeap.poll();
        }

        int[][] result = new int[k][2];
        for (int i = 0; i < k; i++) {
            Tuple tuple = maxHeap.poll();
            int index = tuple.index;

            result[i][0] = points[index][0];
            result[i][1] = points[index][1];
        }

        return result;
    }
    */
}