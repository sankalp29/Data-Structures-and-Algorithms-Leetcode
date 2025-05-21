/*
    https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/
*/

class Solution {
    /**
     * Time complexity : O(N)
     * Space complexity : O(N)
     */
    public String removeDuplicates(String s) {
        StringBuilder updated = new StringBuilder();
        for (char ch : s.toCharArray()) {
            int length = updated.length();
            if (length == 0 || updated.charAt(length - 1) != ch) updated.append(ch);
            else updated.setLength(length - 1);
        }

        return updated.toString();
    }

    /**
     * Time complexity : O(N)
     * Space complexity : O(N)
     */
     /*
    public String removeDuplicates(String s) {
        Stack<Character> st = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (st.isEmpty() || !st.peek().equals(ch)) st.add(ch);
            else st.pop();
        }

        StringBuilder updated = new StringBuilder();
        while (!st.isEmpty()) updated.append(st.pop());

        updated.reverse();
        return updated.toString();
    }
    */
}