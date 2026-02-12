class Solution {

    /* Link: https://neetcode.io/problems/longest-repeating-substring-with-replacement/question
     * Problem: Longest Repeating Character Replacement
     *
     * Approach:
     * - Sliding Window with two pointers (l, r)
     * - Maintain frequency count of characters in the current window
     * - Track the maximum frequency of any single character in the window
     * - Window is valid if:
     *      (window size - max frequency) <= k
     *   because we can replace at most k characters to make all characters same
     */

    public int characterReplacement(String s, int k) {

        int maxLen = 0;      // Stores maximum valid window length
        int maxFreq = 0;    // Stores frequency of the most frequent character in current window
        int l = 0;          // Left pointer of sliding window
        int r = 0;          // Right pointer of sliding window

        int size = s.length();
        Map<Character, Integer> map = new HashMap<>(); // Character frequency map

        // Expand the window using right pointer
        while (r < size) {

            char ch = s.charAt(r);
            map.put(ch, map.getOrDefault(ch, 0) + 1);

            // Update maximum frequency seen so far in the window
            maxFreq = Math.max(maxFreq, map.get(ch));

            /*
             * If number of characters to replace exceeds k,
             * shrink the window from the left
             */
            while ((r - l + 1) - maxFreq > k) {
                char leftChar = s.charAt(l);
                map.put(leftChar, map.get(leftChar) - 1);

                if (map.get(leftChar) == 0) {
                    map.remove(leftChar);
                }
                l++; // Shrink window
            }

            // Update maximum length of a valid window
            maxLen = Math.max(maxLen, r - l + 1);

            r++; // Expand window
        }

        return maxLen;
    }

    /*
     * Time Complexity: O(N)
     * - Each character is processed at most twice (once by r, once by l)
     *
     * Space Complexity: O(1)
     * - HashMap stores at most 26 characters (uppercase English letters)
     */
}
