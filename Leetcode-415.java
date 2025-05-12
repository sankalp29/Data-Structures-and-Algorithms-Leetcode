class Solution {
    /**
     * Time complexity : O(max(length1, length2))
     * Space complexity : O(1)
     */
    public String addStrings(String num1, String num2) {
        int index1 = num1.length()-1, index2 = num2.length()-1;
        int carry = 0;
        StringBuilder result = new StringBuilder();

        while (index1 >= 0 || index2 >= 0) {
            int digit1 = (index1 >= 0) ? num1.charAt(index1) - '0' : 0;
            int digit2 = (index2 >= 0) ? num2.charAt(index2) - '0' : 0;

            int digit = (digit1 + digit2 + carry) % 10;
            result.append(digit);
            carry = (digit1 + digit2 + carry) / 10;
            index1--;
            index2--;
        }

        if (carry > 0) result.append(carry);
        return result.reverse().toString();
    }
}