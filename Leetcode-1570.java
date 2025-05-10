/*
    https://leetcode.com/problems/dot-product-of-two-sparse-vectors/
*/

class SparseVector {
    Map<Integer, Integer> indexToValue;
    SparseVector(int[] nums) {
        indexToValue = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) indexToValue.put(i, nums[i]);
        }
    }
    
	// Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector vec) {
        if (indexToValue.size() > vec.indexToValue.size()) return vec.dotProduct(this);
        int dotProduct = 0;
        
        for (Map.Entry<Integer, Integer> entry : indexToValue.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();
            if (vec.indexToValue.containsKey(key)) 
                dotProduct+=(value * vec.indexToValue.get(key));
        }

        return dotProduct;
    }
}

// Your SparseVector object will be instantiated and called as such:
// SparseVector v1 = new SparseVector(nums1);
// SparseVector v2 = new SparseVector(nums2);
// int ans = v1.dotProduct(v2);