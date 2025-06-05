/*
    https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string-ii/
*/

class Solution {
    /**
     * Time complexity : O(N)
     * Space complexity : O(N)
     */
    public String removeDuplicates(String str, int k) {
        Deque<CharCount> deque = new ArrayDeque<>();
        for (char ch : str.toCharArray()) {
            if (!deque.isEmpty() && deque.peekLast().ch == ch) {
                CharCount pair = deque.peekLast();
                pair.frequency++;
                if (pair.frequency == k) deque.pollLast();
            } else {
                deque.offerLast(new CharCount(ch, 1));
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!deque.isEmpty()) {
            CharCount pair = deque.pollFirst();
            int freq = pair.frequency;
            char ch = pair.ch;

            while (freq-- > 0) sb.append(ch);
        }

        return sb.toString();
    }

    private static class CharCount {
        Character ch;
        int frequency;

        public CharCount(Character ch, int frequency) {
            this.ch = ch;
            this.frequency = frequency;
        }
    }
}