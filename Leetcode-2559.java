/**
 * Time complexity : O(N + K)
 * Space complexity : O(N)
 */
class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        int[] prefixVowels = new int[words.length + 1];

        for (int i = 1; i <= words.length; i++) {
            prefixVowels[i] = prefixVowels[i-1] + (isVowelString(words[i-1]) ? 1 : 0);
        }

        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int start = queries[i][0];
            int end = queries[i][1] + 1;
            result[i] = prefixVowels[end] - prefixVowels[start];
        }

        return result;
    }

    private boolean isVowelString(String word) {
        return isVowel(word.charAt(0)) && isVowel(word.charAt(word.length() - 1));
    }

    private boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }
}