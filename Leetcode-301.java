class Solution {
    /**
     * Time complexity : O(2^N * N)
     * Space complexity : O(2^N * N)
     */
    public List<String> removeInvalidParentheses(String s) {
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        List<String> result = new ArrayList<>();

        queue.add(s);
        visited.add(s);
        boolean foundClosest = false;
        while (!queue.isEmpty()) {
            String current = queue.poll();

            if (isValid(current)) {
                result.add(current);
                foundClosest = true;
            }

            if (foundClosest) continue;

            for (int i = 0; i < current.length(); i++) {
                if (isAlphabet(current.charAt(i))) continue;
                String next = current.substring(0, i) + current.substring(i+1);
                if (!visited.contains(next)) {
                    visited.add(next);
                    queue.add(next);
                }
            }
        }

        return result;
    }

    private boolean isValid(String current) {
        int openingBrackets = 0;

        for (char ch : current.toCharArray()) {
            if (ch == '(') openingBrackets++;
            else if (ch == ')') {
                if (openingBrackets == 0) return false;
                openingBrackets--;
            }
        }

        return openingBrackets == 0;
    }

    private boolean isAlphabet(char ch) {
        return (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z');
    }

    /**
     * Time complexity : O(2*p * n)
     * Space complexity : O(2*p * n) + O(n) call stack
     */
     /*
    public List<String> removeInvalidParentheses(String s) {
        int minRemovals = calculateMinRemovals(s);
        Set<String> result = new HashSet<>();
        generateValidExpr(s, 0, minRemovals, result, new StringBuilder());

        return new ArrayList<>(result);
    }

    private void generateValidExpr(String s, int index, int removalsLeft, Set<String> result, StringBuilder current) {
        if (index == s.length()) {
            if (isValid(current)) result.add(new String(current));
            return;
        }

        if (removalsLeft > 0 && !isAlphabet(s.charAt(index))) 
            generateValidExpr(s, index + 1, removalsLeft - 1, result, current);
        
        current.append(s.charAt(index));
        generateValidExpr(s, index + 1, removalsLeft, result, current);
        current.deleteCharAt(current.length() - 1);
    }

    private boolean isValid(StringBuilder current) {
        int openingBrackets = 0;

        for (int i = 0; i < current.length(); i++) {
            char ch = current.charAt(i);
            if (ch == '(') openingBrackets++;
            else if (ch == ')') {
                if (openingBrackets == 0) return false;
                openingBrackets--;
            }
        }

        return openingBrackets == 0;
    }

    private int calculateMinRemovals(String s) {
        int openingBrackets = 0, removals = 0;

        for (char ch : s.toCharArray()) {
            if (ch == '(') openingBrackets++;
            else if (ch == ')') {
                if (openingBrackets > 0) openingBrackets--;
                else removals++;
            }
        }
        removals+=openingBrackets;
        
        return removals;
    }

    private boolean isAlphabet(char ch) {
        return (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z');
    }
    */
}