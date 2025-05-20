/*
    https://leetcode.com/problems/group-shifted-strings/
*/

class Solution {
    /**
     * Time complexity : O(N*L)
     * Space complexity : O(N*L)
     */
    public List<List<String>> groupStrings(String[] strings) {
        Map<String, List<String>> comparisonMap = new HashMap<>();

        for (int i = 0; i < strings.length; i++) {
            String diff = getDifferenceString(strings[i]);
            comparisonMap.putIfAbsent(diff, new ArrayList<>());
            comparisonMap.get(diff).add(strings[i]);
        }

        return new ArrayList<>(comparisonMap.values());
    }

    private String getDifferenceString(String str) {
        StringBuilder diff = new StringBuilder();
        for (int i = 1; i < str.length(); i++) {
            char prev = str.charAt(i - 1);
            char curr = str.charAt(i);

            int difference = (curr - prev + 26) % 26;

            diff.append(difference).append(",");
        }

        if (diff.length() == 0) return "-";
        return diff.toString();
    }
}