/**
 * Option 1:
 * Time complexity : O(NlogN) for updates, O(1) for min-max
 * Space complexity : O(N)
 */
class StockPrice {
    Map<Integer, Integer> priceMap;
    TreeMap<Integer, Integer> priceFreq;
    int currentTimestamp;
    public StockPrice() {
        priceMap = new HashMap<>();
        priceFreq = new TreeMap<>();
        currentTimestamp = -1;        
    }
    
    public void update(int timestamp, int price) {
        if (priceMap.containsKey(timestamp)) {
            int prevPrice = priceMap.get(timestamp);
            priceFreq.put(prevPrice, priceFreq.get(prevPrice) - 1);
            if (priceFreq.get(prevPrice) == 0) priceFreq.remove(prevPrice);
        }
        priceMap.put(timestamp, price);
        priceFreq.put(price, priceFreq.getOrDefault(price, 0) + 1);

        if (timestamp >= currentTimestamp) {
            currentTimestamp = timestamp;
        }
    }
    
    public int current() {
        return priceMap.get(currentTimestamp);
    }
    
    public int maximum() {
        return priceFreq.lastKey();
    }
    
    public int minimum() {
        return priceFreq.firstKey();
    }
}

/*
 * Option 2 
 * Time complexity : O(NlogN) for updates, O(N^2 logN) worst case for min-max
 * Space complexity : O(3*N) => O(N)
class StockPrice {
    Map<Integer, PriceInfo> priceMap;
    PriorityQueue<PriceInfo> minHeap;
    PriorityQueue<PriceInfo> maxHeap;
    int currentTimestamp;
    public StockPrice() {
        priceMap = new HashMap<>();
        minHeap = new PriorityQueue<>((a, b) -> a.price - b.price);
        maxHeap = new PriorityQueue<>((a, b) -> b.price - a.price);
        currentTimestamp = -1;
        currentPrice = -1;
    }
    
    public void update(int timestamp, int price) {
        if (priceMap.containsKey(timestamp)) {
            priceMap.get(timestamp).isValid = false;
        }
        PriceInfo priceInfo = new PriceInfo(price);
        minHeap.add(priceInfo);
        maxHeap.add(priceInfo);
        priceMap.put(timestamp, priceInfo);
        
        if (timestamp >= currentTimestamp) {
            currentTimestamp = timestamp;
        }
    }
    
    public int current() {
        return priceMap.get(currentTimestamp);
    }
    
    public int maximum() {
        while (!maxHeap.isEmpty() && !maxHeap.peek().isValid) maxHeap.poll();

        return maxHeap.peek().price;
    }
    
    public int minimum() {
        while (!minHeap.isEmpty() && !minHeap.peek().isValid) minHeap.poll();

        return minHeap.peek().price;
    }

    private static class PriceInfo {
        public int price;
        public boolean isValid;

        public PriceInfo(int price) {
            this.price = price;
            isValid = true;
        }
    }
}
*/

