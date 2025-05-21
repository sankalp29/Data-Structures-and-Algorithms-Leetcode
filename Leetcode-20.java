/*
    https://leetcode.com/problems/valid-parentheses/
*/

class Solution {
    /**
     * Time complexity : O(N)
     * Space complexity : O(N)
     */
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (isOpeningBracket(ch)) st.add(ch);
            else if (st.isEmpty() || !isBracketOfSameType(st.peek(), ch)) return false;
            else st.pop();
        }

        return st.isEmpty();
    }

    private boolean isOpeningBracket(char ch) {
        return ch == '(' || ch == '[' || ch == '{';
    }

    private boolean isBracketOfSameType(char open, char close) {
        return (open == '(' && close == ')') || 
               (open == '[' && close == ']') || 
               (open == '{' && close == '}');
    }
}