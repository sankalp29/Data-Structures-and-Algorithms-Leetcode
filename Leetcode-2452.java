/*
https://leetcode.com/problems/words-within-two-edits-of-dictionary/
*/ 
class Solution {
    /**
     * Time complexity : O(N * M * L)
     * Space complexity : O(1)
     */
    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        List<String> result = new ArrayList<>();

        for (String query : queries) {
            if (compare(query, dictionary)) result.add(query);
        }

        return result;
    }

    private boolean compare(String query, String[] dictionary) {
        for (String word : dictionary) {
            int differs = 0, n = query.length();
            for (int i = 0; i < n; i++) {
                if (query.charAt(i) != word.charAt(i)) differs++;
                if (differs > 2) break;
            }

            if (differs <= 2) return true;
        }

        return false;
    }
}