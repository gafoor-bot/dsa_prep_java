import java.util.HashSet;

/**
 * Solution class to find the length of the longest substring without repeating characters.
 *
 * Time Complexity:
 * - O(n), where n is the length of the input string.
 *   Each character is visited at most twice (once when added to the HashSet, once when removed).
 *
 * Space Complexity:
 * - O(min(n, k)), where k is the character set size.
 *   The HashSet stores unique characters of the current sliding window.
 */
class Solution {

    public int lengthOfLongestSubstring(String s) {

        // Handle edge cases
        if (s.length() == 0) return 0;
        if (s.length() == 1) return 1;

        int maxLength = 0;

        // HashSet to store unique characters in the current sliding window
        HashSet<Character> set = new HashSet<>();

        // Two pointers to define the sliding window
        int start = 0, end = 0;

        // Traverse the string once → O(n)
        while (end < s.length()) {
            char ch = s.charAt(end);

            // If character is already in the set, shrink the window from the left
            if (set.contains(ch)) {
                set.remove(s.charAt(start));
                start++;
            } else {
                // Add character to the set and expand the window
                set.add(ch);
                end++;

                // Update maximum length of substring
                maxLength = Math.max(maxLength, set.size());
            }
        }

        return maxLength;
    }
}
