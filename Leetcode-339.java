/*
    https://leetcode.com/problems/nested-list-weight-sum/
*/

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // The result is undefined if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // The result is undefined if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
class Solution {
    /**
     * Time complexity : O(N) where N is the number of integers in the Data structure
     * Space complexity : O(N) (because of the Queue data structure)
     */
    public int depthSum(List<NestedInteger> nestedList) {
        if (nestedList == null || nestedList.size() == 0) return 0;

        int depth = 1, answer = 0;
        Queue<NestedInteger> queue = new LinkedList<>();
        for (NestedInteger nested : nestedList) queue.add(nested);
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                NestedInteger nested = queue.poll();
                if (nested.isInteger()) answer+=depth*nested.getInteger();
                else {
                    for (NestedInteger nest : nested.getList()) {
                        queue.add(nest);
                    }
                }
            }
            depth++;
        }

        return answer;
    }
}