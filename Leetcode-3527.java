/*
    https://leetcode.com/problems/find-the-most-common-response/
*/

class Solution {
    /**
     * Time complexity : O(N^2 * L)
     * Space complexity : O(N^2 + N)
     */
    public String findCommonResponse(List<List<String>> responses) {
        Map<String, Integer> responseFrequency = new HashMap<>();
        int maxFrequency = 0;
        String maxOccuringResponse = "";
        for (List<String> response : responses) { // O(N)
            Set<String> uniqueResponses = new HashSet<>(response); // O(N)

            for (String resp : uniqueResponses) { // O(L)
                responseFrequency.put(resp, responseFrequency.getOrDefault(resp, 0) + 1);
                if (responseFrequency.get(resp) > maxFrequency) {
                    maxFrequency = responseFrequency.get(resp);
                    maxOccuringResponse = resp;
                } else if (responseFrequency.get(resp) == maxFrequency && maxOccuringResponse.compareTo(resp) > 0) {
                    maxOccuringResponse = resp;
                }
            }
        }

        return maxOccuringResponse;
    }
}