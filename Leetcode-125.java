// Solution 1:
class Solution {
    /**
     * Time complexity : O(N) + O(N) => O(N)
     * Space complexity : O(N) (to create a new string)
     */
    
    /*
    public boolean isPalindrome(String s) {
        // Solution 1
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isLetter(ch)) {
                if (Character.isUpperCase(ch)) sb.append(Character.toLowerCase(ch));
                else sb.append(ch);
            } else if (Character.isDigit(ch)) sb.append(ch);
        }

        return isPalindrome(sb);
        */
    }

    private boolean isPalindrome(StringBuilder sb) {
        int left = 0, right = sb.length() - 1;
        while (left < right) {
            if (sb.charAt(left) != sb.charAt(right)) return false;
            left++;
            right--;
        }

        return true;
    }
}
*/

class Solution {
    /**
     * Time complexity : O(N)
     * Space complexity : O(1)
    /*
    public boolean isPalindrome(String s) {

        int left = 0, right = s.length() - 1;
        while (left < right) {
            char leftChar = s.charAt(left);
            char rightChar = s.charAt(right);
            if (!isValid(leftChar)) {
                left++;
                continue;
            }
            if (!isValid(rightChar)) {
                right--;
                continue;
            }

            leftChar = (Character.isLetter(leftChar) && Character.isUpperCase(leftChar)) ? Character.toLowerCase(leftChar) : leftChar;
            rightChar = (Character.isLetter(rightChar) && Character.isUpperCase(rightChar)) ? Character.toLowerCase(rightChar) : rightChar;

            if (leftChar != rightChar) return false;
            left++;
            right--;
        }

        return true;
    }

    private boolean isValid(char ch) {
        return Character.isLetter(ch) || Character.isDigit(ch);
    }
}
