/*
    https://leetcode.com/problems/majority-element/
*/

class Solution {
    /**
     * Time complexity : O(N)
     * Space complexity : O(1)
     */
    public int majorityElement(int[] nums) {
        int number = -1, count = 0;

        for (int i = 0; i < nums.length; i++) {
            if (count == 0) {
                number = nums[i];
                count = 1;
            } else {
                if (number == nums[i]) count++;
                else count--; 
            }
        }

        return number;
    }
}