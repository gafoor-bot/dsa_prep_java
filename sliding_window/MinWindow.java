class Solution {

    /*
     * Problem: Minimum Window Substring
     *
     * Given two strings s and t, return the minimum window substring of s
     * such that every character in t (including duplicates) is included.
     * If no such substring exists, return an empty string.
     *
     * Approach: Sliding Window + HashMaps
     *
     * Time Complexity: O(n)
     *   - Each character in string s is visited at most twice
     *     (once by the end pointer, once by the start pointer).
     *
     * Space Complexity: O(k)
     *   - Where k is the number of unique characters in t
     *   - Two hash maps are used to store character frequencies.
     */
    public String minWindow(String s, String t) {

        // Edge case: if source string is smaller than target, no solution possible
        if (s.length() < t.length()) return "";

        // Frequency map for characters in target string 't'
        // Example: t = "AABC" -> {A=2, B=1, C=1}
        Map<Character, Integer> targetFreq = new HashMap<>();
        for (char c : t.toCharArray()) {
            targetFreq.put(c, targetFreq.getOrDefault(c, 0) + 1);
        }

        // Frequency map for the current sliding window in string 's'
        Map<Character, Integer> windowFreq = new HashMap<>();

        // Number of unique characters that have met required frequency
        int match = 0;

        // Total number of unique characters needed to be matched
        int requiredMatch = targetFreq.size();

        // Left pointer of the sliding window
        int start = 0;

        // Track the minimum window length found so far
        int minLen = Integer.MAX_VALUE;

        // Track starting index of the minimum window
        int minStart = 0;

        // Right pointer expands the window
        for (int end = 0; end < s.length(); end++) {

            char c = s.charAt(end);

            // Add current character to window frequency
            windowFreq.put(c, windowFreq.getOrDefault(c, 0) + 1);

            /*
             * If current character is required and its frequency in the window
             * exactly matches the required frequency, increment match count.
             */
            if (targetFreq.containsKey(c) &&
                targetFreq.get(c).equals(windowFreq.get(c))) {
                match++;
            }

            /*
             * When all required characters are matched,
             * try to shrink the window from the left to find
             * the smallest valid window.
             */
            while (match == requiredMatch) {

                // Update minimum window if current window is smaller
                if (end - start + 1 < minLen) {
                    minLen = end - start + 1;
                    minStart = start;
                }

                // Character to remove from the left side of the window
                char startChar = s.charAt(start);
                windowFreq.put(startChar, windowFreq.get(startChar) - 1);

                /*
                 * If removing startChar causes its frequency to fall
                 * below what is required, we lose a matched character.
                 */
                if (targetFreq.containsKey(startChar) &&
                    windowFreq.get(startChar) < targetFreq.get(startChar)) {
                    match--;
                }

                // Move left pointer forward to shrink the window
                start++;
            }
        }

        // If no valid window was found, return empty string
        return minLen == Integer.MAX_VALUE
                ? ""
                : s.substring(minStart, minStart + minLen);
    }
}
