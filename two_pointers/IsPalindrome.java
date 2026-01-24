class Solution {

    /* Link: https://neetcode.io/problems/is-palindrome/question?list=neetcode150
     * Checks whether a given string is a palindrome.
     * A palindrome reads the same forward and backward after:
     *  - converting all letters to lowercase
     *  - removing all non-alphanumeric characters
     *
     * @param s the input string
     * @return true if the string is a palindrome, false otherwise
     *
     * Time Complexity: O(n)
     *   - Each character is visited at most once by the two pointers.
     *
     * Space Complexity: O(1)
     *   - Uses constant extra space (no additional data structures).
     */
    public boolean isPalindrome(String s) {

        // Two pointers: one starting from the beginning, one from the end
        int i = 0, j = s.length() - 1;

        // Continue until the two pointers meet
        while (i < j) {

            // Skip non-alphanumeric characters from the left
            if (!Character.isLetterOrDigit(s.charAt(i))) {
                i++;
            }
            // Skip non-alphanumeric characters from the right
            else if (!Character.isLetterOrDigit(s.charAt(j))) {
                j--;
            }
            // Compare characters in a case-insensitive manner
            else if (Character.toLowerCase(s.charAt(i)) !=
                     Character.toLowerCase(s.charAt(j))) {
                return false; // Mismatch found
            }
            // Characters match, move both pointers inward
            else {
                i++;
                j--;
            }
        }

        // All characters matched
        return true;
    }
}
