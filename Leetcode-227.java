/*
    https://leetcode.com/problems/basic-calculator-ii/
*/

class Solution {
    public int calculate(String s) {
        int total = 0, number = 0, prev = 0;
        char operator = '+';

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (Character.isDigit(ch)) {
                number = number * 10 + (ch - '0');
            }

            if ((!Character.isDigit(ch) && ch != ' ') || i == s.length() - 1) {
                if (operator == '+') {
                    total+=number;
                    prev = number;
                } else if (operator == '-') {
                    number = -number;
                    total+=number;
                    prev = number;
                } else if (operator == '*') {
                    total-=prev;
                    total = total + prev * number;
                    prev = prev * number;
                } else if (operator == '/') {
                    total-=prev;
                    total = total + prev / number;
                    prev = prev / number;
                }

                operator = ch;
                number = 0;
            }
        }

        return total;
    }
}