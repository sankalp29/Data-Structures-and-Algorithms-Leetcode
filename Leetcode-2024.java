class Solution {
    /**
     * Time complexity : O(N)
     * Space compleity : O(1)
     */
    public int maxConsecutiveAnswers(String answerKey, int k) {
        int left = 0, right = 0, longest = 0, trueFreq = 0, falseFreq = 0;

        while (right < answerKey.length()) {
            char ch = answerKey.charAt(right);
            if (ch == 'T') trueFreq++;
            else falseFreq++;

            // We can flip at most 'k' occurrences of the less frequent character
            while (Math.min(trueFreq, falseFreq) > k) {
                if (answerKey.charAt(left) == 'T') trueFreq--;
                else falseFreq--;
                left++;
            }

            longest = Math.max(longest, right - left + 1);
            right++;
        }
        
        return longest;
    }
}