class Solution {

    /* Link: https://neetcode.io/problems/word-ladder/question?list=neetcode150
     * Time Complexity:
     * O(N * L * 26)
     * where:
     * N = number of words in wordList
     * L = length of each word
     * 26 = number of lowercase English letters
     *
     * Space Complexity:
     * O(N)
     * for the queue, visited set, and word set
     */

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        // Convert wordList to a Set for O(1) lookup time
        Set<String> wordSet = new HashSet<>(wordList);

        // If endWord is not present, no valid transformation exists
        if (!wordSet.contains(endWord)) return 0;

        // Set to keep track of visited words to avoid revisiting
        Set<String> visited = new HashSet<>();

        // Queue for BFS traversal (level-by-level)
        Queue<String> queue = new LinkedList<>();

        // Start BFS with the beginWord
        queue.offer(beginWord);
        visited.add(beginWord);

        int len = 0; // Represents the current transformation length

        // Perform BFS
        while (!queue.isEmpty()) {

            int size = queue.size(); // Number of words at current BFS level
            len++; // Increment transformation level

            // Process all words at the current level
            for (int i = 0; i < size; i++) {

                String cstr = queue.poll(); // Get current word

                // Try changing each character of the word
                for (int j = 0; j < cstr.length(); j++) {

                    char[] temp = cstr.toCharArray();

                    // Replace the character with 'a' to 'z'
                    for (char ch = 'a'; ch <= 'z'; ch++) {

                        temp[j] = ch;
                        String newWord = new String(temp);

                        // If endWord is found, return total transformation length
                        if (newWord.equals(endWord)) {
                            return len + 1;
                        }

                        // If the new word is valid and not visited, add to queue
                        if (wordSet.contains(newWord) && !visited.contains(newWord)) {
                            queue.offer(newWord);
                            visited.add(newWord);
                        }
                    }
                }
            }
        }

        // If no transformation sequence exists
        return 0;
    }
}