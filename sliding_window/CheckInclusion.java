public class Solution {

    /* Link: https://neetcode.io/problems/permutation-string/question?list=neetcode150
     * Problem: Permutation in String
     *
     * Given two strings s1 and s2, return true if s2 contains
     * a permutation of s1, otherwise return false.
     *
     * Approach: Sliding Window + Frequency Count
     *
     * Time Complexity: O(n)
     *   - n = length of s2
     *   - Each character is processed once while sliding the window
     *   - Frequency comparison is constant time (26 letters)
     *
     * Space Complexity: O(1)
     *   - Two fixed-size arrays of length 26 are used
     *   - Space does not grow with input size
     */
    public boolean checkInclusion(String s1, String s2) {

        // If s1 is longer than s2, permutation is impossible
        if (s1.length() > s2.length())
            return false;

        // Frequency arrays for characters in s1 and current window in s2
        // Index 0 -> 'a', 1 -> 'b', ..., 25 -> 'z'
        int[] s1arr = new int[26];
        int[] s2arr = new int[26];

        // Initialize frequency counts for s1
        // and the first window of s2 with size equal to s1.length()
        for (int i = 0; i < s1.length(); i++) {
            s1arr[s1.charAt(i) - 'a']++;
            s2arr[s2.charAt(i) - 'a']++;
        }

        // Slide the window across s2
        for (int i = 0; i < s2.length() - s1.length(); i++) {

            // Check if current window matches s1's frequency
            if (matches(s1arr, s2arr))
                return true;

            // Add next character to the window
            s2arr[s2.charAt(i + s1.length()) - 'a']++;

            // Remove the leftmost character from the window
            s2arr[s2.charAt(i) - 'a']--;
        }

        // Check the final window
        return matches(s1arr, s2arr);
    }

    /*
     * Helper method to compare two frequency arrays
     *
     * Returns true if both arrays have identical counts
     * for all 26 lowercase English letters.
     */
    public boolean matches(int[] s1arr, int[] s2arr) {
        for (int i = 0; i < 26; i++) {
            if (s1arr[i] != s2arr[i])
                return false;
        }
        return true;
    }
}
