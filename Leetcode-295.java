/*
    https://leetcode.com/problems/find-median-from-data-stream/
*/

/**
 * Time complexity : O(logN) for addNum() & O(1) for findMedian()
 * Space complexity : O(N)
 */
class MedianFinder {
    PriorityQueue<Integer> maxHeap, minHeap;
    public MedianFinder() {
        maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        minHeap = new PriorityQueue<>();
    }
    /**
     * Time complexity : O(logN)
     */
    public void addNum(int num) {
        maxHeap.add(num);
        balance();
    }
    
    private void balance() {
        if (maxHeap.size() - minHeap.size() == 2) {
            minHeap.add(maxHeap.poll());
        }
        if (!minHeap.isEmpty() && maxHeap.peek() > minHeap.peek()) {
            minHeap.add(maxHeap.poll());
            maxHeap.add(minHeap.poll());
        }
    }

    /**
     * Time complexity : O(1)
     */
    public double findMedian() {
        int size = maxHeap.size() + minHeap.size();
        if (size % 2 == 1) return maxHeap.peek();
        return (maxHeap.peek() + minHeap.peek()) / 2.0;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */