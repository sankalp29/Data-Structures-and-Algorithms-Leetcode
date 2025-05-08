/*
    https://leetcode.com/problems/top-k-frequent-elements/
*/



// Solution 1 : Using Hashmap + MinHeap (Less optimal)
/*
class Solution {
    
    private static class Pair {
        int element;
        int frequency;

        public Pair(int element, int frequency) {
            this.element = element;
            this.frequency = frequency;
        }
    }

    /**
     * Time complexity : O(N) + O(NlogK) => O(NlogK)
     * Space complexity : O(N) + O(K)
     */
    public int[] topKFrequent(int[] nums, int k) { 
        Map<Integer, Integer> elementFreq = new HashMap<>();
        for (int num : nums) {
            elementFreq.put(num, elementFreq.getOrDefault(num, 0) + 1);
        }

        Comparator<Pair> comparator = (p1, p2) -> p1.frequency - p2.frequency;

        PriorityQueue<Pair> minHeap = new PriorityQueue<>(comparator);
        
        for (Integer key : elementFreq.keySet()) {
            minHeap.add(new Pair(key, elementFreq.get(key)));
            if (minHeap.size() > k) minHeap.poll();
        }

        int[] result = new int[k];
        for (int i = 0; i < k; i++) result[i] = minHeap.poll().element;

        return result;
        
    }
}

*/



// Solution 2 : Bucket sort (Most optimal)
class Solution {

    public int[] topKFrequent(int[] nums, int k) {        
        return bucketSort(nums, k);
    }


    /**
     * Time complexity : O(N)
     * Space complexity : O(N)
     */
    private int[] bucketSort(int[] nums, int k) {
        Map<Integer, Integer> elementFreq = new HashMap<>();
        for (int num : nums) {
            elementFreq.put(num, elementFreq.getOrDefault(num, 0) + 1);
        }

        // {Frequency, List of elements having that frequency}
        Map<Integer, List<Integer>> freqToElements = new HashMap<>();
        for (int key : elementFreq.keySet()) {
            int frequencyOfElement = elementFreq.get(key);
            freqToElements.putIfAbsent(frequencyOfElement, new ArrayList<>());
            freqToElements.get(frequencyOfElement).add(key);
        }

        int[] result = new int[k];
        int index = 0;
        for (int i = nums.length; i >= 1; i--) {
            for (int j = 0; j < freqToElements.getOrDefault(i, new ArrayList<>()).size() && index < k; j++) {
                result[index] = freqToElements.get(i).get(j);
                index++;
            }
        }

        return result;
    }
}
