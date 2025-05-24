/*
    https://leetcode.com/problems/accounts-merge/
*/

class Solution {
    Map<String, List<String>> adjList;
    Set<String> visited;

    /**
     * Time complexity : O(NK + NK + NKlogNK)
     * Space complexity : O(NK)
     */
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        adjList = new HashMap<>();
        visited = new HashSet<>();

        // Step 1 : Construct adjacency list
        for (List<String> account : accounts) {
            String firstEmail = account.get(1);

            for (int i = 2; i < account.size(); i++) {
                String email = account.get(i);
                adjList.putIfAbsent(firstEmail, new ArrayList<>());
                adjList.putIfAbsent(email, new ArrayList<>());

                adjList.get(firstEmail).add(email);
                adjList.get(email).add(firstEmail);
            }
        }

        List<List<String>> mergedAccounts = new ArrayList<>();
        // Step 2 : Perform DFS
        for (List<String> account : accounts) {
            String name = account.get(0);
            String firstEmail = account.get(1);
            List<String> connectedEmails = new ArrayList<>();
            
            if (!visited.contains(firstEmail)) {
                dfs(firstEmail, connectedEmails);
                Collections.sort(connectedEmails);
                List<String> connectedEmailsDetails = new ArrayList<>();
                connectedEmailsDetails.add(name);
                connectedEmailsDetails.addAll(connectedEmails);
                mergedAccounts.add(connectedEmailsDetails);
            }
        }

        return mergedAccounts;
    }

    private void dfs(String email, List<String> connectedEmails) {
        connectedEmails.add(email);
        visited.add(email);

        for (String neighbourEmail : adjList.getOrDefault(email, new ArrayList<>())) {
            if (!visited.contains(neighbourEmail)) {
                dfs(neighbourEmail, connectedEmails);
            }
        }
    }
}