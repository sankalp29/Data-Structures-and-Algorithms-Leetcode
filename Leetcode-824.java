/*
    https://leetcode.com/problems/goat-latin/
*/

class Solution {
     /**
        * Time Complexity: O(n + w^2)
        * - O(n) for splitting and processing each word (including substring operations)
        * - O(w^2) for appending a progressively growing number of 'a's
        * - O(n) for creating substrings from (1..Length-1) => O(L) for 'w' words making it O(L*w) = O(n) since 
        * number of words * length of each word = n (length of the sentence)
        * 
        * Space Complexity: O(n + w)
        * - O(n) for storing split words and final output
        * - O(w) for the incremental 'a' string
    */
    public String toGoatLatin(String sentence) {
        String[] words = sentence.split(" ");
        StringBuilder goatSentence = new StringBuilder();
        StringBuilder aCounter = new StringBuilder("a");
        String ma = "ma";
        String a = "a";

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (isVowel(word.charAt(0))) {
                goatSentence.append(word);
            } else {
                goatSentence.append(word.substring(1)).append(word.charAt(0));
            }

            goatSentence.append(ma).append(aCounter).append(" ");
            aCounter.append(a);
        }

        String goat = goatSentence.toString().trim();
        return goat;
    }

    private boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' ||
               ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U' ; 
    }
}