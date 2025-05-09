/*
    https://leetcode.com/problems/minimum-add-to-make-parentheses-valid/
*/

class Solution {
    /**
     * Time complexity : O(N), where N is the length of the string
     * Space complexity : O(1)
     */
    public int minAddToMakeValid(String s) {
        int openBrackets = 0, additionsRequired = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') openBrackets++;
            else {
                if (openBrackets > 0) openBrackets--;
                else additionsRequired++;
            }
        }

        additionsRequired+=openBrackets;

        return additionsRequired;
    }
}