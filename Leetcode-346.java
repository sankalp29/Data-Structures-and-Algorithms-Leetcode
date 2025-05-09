/*
    https://leetcode.com/problems/moving-average-from-data-stream/
*/

class MovingAverage {
    Deque<Integer> stream;
    int capacity, sum;
    
    public MovingAverage(int size) {
        this.capacity = size;
        this.sum = 0;
        this.stream = new LinkedList<>();
    }
    
    public double next(int val) {
        sum+=val;
        stream.addLast(val);
        if (stream.size() > capacity) sum-=stream.pollFirst();

        return (1.0 * sum / stream.size());
    }
}


/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */