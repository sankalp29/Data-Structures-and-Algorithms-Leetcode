/**
 * Time complexity : O(NlogN)
 * Space complexity : O(N)
 * But N is at the most 26, so the time and space complexity practically are O(1)
 */
class Solution {
    public String rankTeams(String[] votes) {
        int n = votes[0].length();
        int[][] charRankFrequency = new int[26][n];
        List<Character> uniqueChars = new ArrayList<>();

        for (String vote : votes) {
            for (int i = 0; i < vote.length(); i++) {
                char ch = vote.charAt(i);
                charRankFrequency[ch - 'A'][i]++;
            }
        }

        for (char ch : votes[0].toCharArray()) uniqueChars.add(ch);

        uniqueChars.sort((ch1, ch2) -> {
            for (int i = 0; i < n; i++) {
                if (charRankFrequency[ch1 - 'A'][i] == charRankFrequency[ch2 - 'A'][i]) continue;
                return Integer.compare(charRankFrequency[ch2 - 'A'][i], charRankFrequency[ch1 - 'A'][i]);
            }
            return ch1 - ch2;
        });

        StringBuilder result = new StringBuilder();
        for (char ch : uniqueChars) result.append(ch);

        return result.toString();
    }
}