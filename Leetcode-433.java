/*
https://leetcode.com/problems/minimum-genetic-mutation/
*/
class Solution {
    /**
     * Time complexity : O(N * L)
     * Space complexity : O(N * L)
     */
    public int minMutation(String startGene, String endGene, String[] bank) {
        if (startGene.equals(endGene)) return 0;

        Set<String> geneBank = new HashSet<>();
        for (String gene : bank) geneBank.add(gene);

        Queue<String> bfsQueue = new ArrayDeque<>();
        bfsQueue.add(startGene);
        geneBank.remove(startGene);
        int distance = 0;
        char[] choices = {'A', 'C', 'G', 'T'};

        while (!bfsQueue.isEmpty()) {
            int size = bfsQueue.size();

            while (size-- > 0) {
                String gene = bfsQueue.poll();

                if (gene.equals(endGene)) return distance;
                char[] current = gene.toCharArray();
                
                for (int i = 0; i < gene.length(); i++) {
                    for (char ch : choices) {
                        current[i] = ch;
                        String mutated = new String(current);
                        if (geneBank.contains(mutated)) {
                            bfsQueue.add(mutated);
                            geneBank.remove(mutated);
                        }
                    }
                    current[i] = gene.charAt(i);
                }
            }

            distance++;
        }

        return -1;
    }
}