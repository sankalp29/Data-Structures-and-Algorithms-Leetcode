/*
    https://leetcode.com/problems/product-of-two-run-length-encoded-arrays/
*/

class Solution {
    /**
     * Time complexity : O(N)
     * Space complexity : O(1)
     */
    public List<List<Integer>> findRLEArray(int[][] encoded1, int[][] encoded2) {
        List<List<Integer>> rle = new ArrayList<>();

        int index1 = 0, index2 = 0, freqLeft1 = encoded1[0][1], freqLeft2 = encoded2[0][1];
        int prev = -1;

        while (index1 < encoded1.length) {
            int value1 = encoded1[index1][0];
            int value2 = encoded2[index2][0];
            int freq = Math.min(freqLeft1, freqLeft2);
            int product = value1 * value2;

            if (product == prev) {
                int index = rle.size() - 1;
                int prevFreq = rle.get(index).get(1);
                rle.set(index, List.of(product, prevFreq + freq));
            } else {
                rle.add(List.of(product, freq));
                prev = product;
            }

            freqLeft1-=freq;
            freqLeft2-=freq;

            if (freqLeft1 == 0) {
                index1++;
                if (index1 < encoded1.length) freqLeft1 = encoded1[index1][1];
            }
            if (freqLeft2 == 0) {
                index2++;
                if (index2 < encoded2.length) freqLeft2 = encoded2[index2][1];
            }
        }

        return rle;
    }
}