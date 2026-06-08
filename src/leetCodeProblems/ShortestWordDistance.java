package leetCodeProblems;

public class ShortestWordDistance {
    public int shortestDistance(String[] words, String word1, String word2) {
        int idx1 = -1;
        int idx2 = -1;
        int minDistance = Integer.MAX_VALUE;

        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                idx1 = i;
            }
            if (words[i].equals(word2)) {
                idx2 = i;
            }

            // Only calculate if we've seen both words
            if (idx1!= -1 && idx2!= -1) {
                minDistance = Math.min(minDistance, Math.abs(idx1 - idx2));
            }
        }
        return minDistance;
    }

    public static void main(String[] args) {
        ShortestWordDistance sol = new ShortestWordDistance();

        String[] words1 = {"practice", "makes", "perfect", "coding", "makes"};
        System.out.println(sol.shortestDistance(words1, "coding", "practice")); // 3

        String[] words2 = {"practice", "makes", "perfect", "coding", "makes"};
        System.out.println(sol.shortestDistance(words2, "makes", "coding")); // 1
    }
}
