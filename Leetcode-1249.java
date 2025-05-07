/* 
    Question Link : https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/
*/

class Solution {
    /**
     * Removes unmatched brackets.
     * Time complexity : O(L) + O(L) + O(L) => O(3L) => O(L) 
                       : 2 passes + reversing
     * Space complexity : O(L) to return the answer
     */
    public String minRemoveToMakeValid(String s) {
        if (s == null || s.length() == 0) return "";
        StringBuilder sb = new StringBuilder();
        int openingBrackets = 0;
        
        // First pass: Remove the unmatching closing brackets
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                sb.append(ch);
                openingBrackets++;
            } else if (ch == ')') {
                if (openingBrackets == 0) continue;
                sb.append(ch);
                openingBrackets--;
            } else {
                sb.append(ch);
            }
        }

        // Second pass: Remove the unmatching opening brackets
        return removeUnmatchedOpeningBrackets(sb, openingBrackets);
    }

    /**
     * Removes the unmached opening brackets in the expression
     */
    private String removeUnmatchedOpeningBrackets(StringBuilder expression, int openingBrackets) {
        StringBuilder result = new StringBuilder();
        for (int i = expression.length() - 1; i >= 0; i--) {
            char ch = expression.charAt(i);
            if (expression.charAt(i) == '(' && openingBrackets > 0) openingBrackets--;
            else result.append(expression.charAt(i));
        }

        return result.reverse().toString();
    }
}