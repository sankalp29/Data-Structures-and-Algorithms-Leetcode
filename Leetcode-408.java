/*
    https://leetcode.com/problems/valid-word-abbreviation/
*/
class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        int wordIndex = 0, abbrIndex = 0;

        while (wordIndex < word.length() && abbrIndex < abbr.length()) {
            char ch = abbr.charAt(abbrIndex);
            
            if (Character.isLetter(ch)) {
                // Mismatch between 'word' and 'abbr'
                if (ch != word.charAt(wordIndex)) return false;
                wordIndex++;
                abbrIndex++;
            } else { // 'ch' is a digit
                if (ch == '0') return false; // Leading zero
                
                // Calculate the abbreviation number
                int number = 0;
                while (abbrIndex < abbr.length() && Character.isDigit(abbr.charAt(abbrIndex))) {
                    number = number*10 + (abbr.charAt(abbrIndex) - '0');
                    abbrIndex++;
                }
                wordIndex+=number; // Move 'number' places ahead (since it has been abbreviated)
            }
        }

        return wordIndex == word.length() && abbrIndex == abbr.length();
    }
}