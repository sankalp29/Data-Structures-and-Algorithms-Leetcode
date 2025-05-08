/*
    https://leetcode.com/problems/merge-sorted-array/
*/

class Solution {
    /**
     * Time complexity : O(m+n)
     * Space complexity : O(1)
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int index1 = m-1, index2 = n-1, finalIndex = m+n-1;

        while (index1 >= 0 && index2 >= 0) {
            if (nums1[index1] >= nums2[index2]) {
                nums1[finalIndex] = nums1[index1];
                index1--;
            } else {
                nums1[finalIndex] = nums2[index2]; 
                index2--;
            }
            finalIndex--;
        }

        while (index2 >= 0) {
            nums1[finalIndex] = nums2[index2]; 
            index2--;
            finalIndex--;
        }
    }
}