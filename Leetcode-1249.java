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

        /**
        * Second pass: Removes the unmached opening brackets in the expression
        */
        StringBuilder result = new StringBuilder();
        for (int i = expression.length() - 1; i >= 0; i--) {
            char ch = expression.charAt(i);
            if (expression.charAt(i) == '(' && openingBrackets > 0) openingBrackets--;
            else result.append(expression.charAt(i));
        }

        return result.reverse().toString();
    }


    /**
     * Use the stack method to remove minimum brackets to make the expression valid.
     * Time complexity : O(L) + O(L) => O(2L) => O(L)
     * Space complexity : O(L)
    */
    private String useStackMethod(String s) {
        Set<Integer> indexesToDelete = new HashSet<>();
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') st.add(i);
            else if (s.charAt(i) == ')') {
                if (st.isEmpty()) indexesToDelete.add(i);
                else st.pop();
            }
        }
        
        while (!st.isEmpty()) indexesToDelete.add(st.pop());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (!indexesToDelete.contains(i)) {
                sb.append(s.charAt(i));
            }
        }

        return sb.toString();
    }
}