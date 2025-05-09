/*
    https://leetcode.com/problems/simplify-path/
*/

class Solution {
    /**
     * Time complexity : O(N)
     * Space complexity : O(N)
     */
    public String simplifyPath(String path) {
        String[] paths = path.split("/");
        Deque<String> dq = new ArrayDeque<>();
        
        for (String currentWord : paths) {
            if (currentWord.equals("") || currentWord.equals(".")) continue;
            if (currentWord.equals("..")) {
                if (!dq.isEmpty()) dq.pollLast();
            } else dq.addLast(currentWord);
        }

        StringBuilder simplifiedPath = new StringBuilder();
        while (!dq.isEmpty()) {
            simplifiedPath.append("/").append(dq.pollFirst());
        }

        if (simplifiedPath.length() == 0) simplifiedPath.append("/");

        return simplifiedPath.toString();
    }
}