/*
    https://leetcode.com/problems/text-justification/
*/

/**
* Time complexity : O(N * maxWidth)
* Space complexity : O(maxWidth)
*/
class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int currentLength = 0, n = words.length;

        int i = 0;
        while (i < n) {
            int j = i + 1;
            int sentenceLen = words[i].length();

            while (j < n && sentenceLen + 1 + words[j].length() <= maxWidth) {
                sentenceLen+=(1 + words[j].length());
                j++;
            }
            
            int numOfWords = j - i;
            int totalSpaces = maxWidth - (sentenceLen - (numOfWords - 1));
            StringBuilder sentence = new StringBuilder();

            // Left justfify the last sentence
            if (j == n || numOfWords == 1) {
                for (int wordNo = i; wordNo < j; wordNo++) {
                    sentence.append(words[wordNo]);
                    if (wordNo != j-1) sentence.append(" ");
                }
                int remaining = maxWidth - sentence.length();
                for (int k = 0; k < remaining; k++) sentence.append(" ");
            } else {
                StringBuilder spacesStr = new StringBuilder();
                int spacesBetweenWords = totalSpaces / (numOfWords - 1);
                int extraSpaces = totalSpaces % (numOfWords - 1);
                for (int k = 0; k < spacesBetweenWords; k++) spacesStr.append(" ");

                for (int wordNo = i; wordNo < j-1; wordNo++) {
                    sentence.append(words[wordNo]).append(spacesStr);
                    if (extraSpaces-- > 0) sentence.append(" ");
                }
                sentence.append(words[j-1]);
            }

            result.add(sentence.toString());
            i = j;
        }

        return result;
    }
}