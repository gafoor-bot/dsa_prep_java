class Solution {

    /* Link: https://neetcode.io/problems/longest-palindromic-substring/question?list=neetcode150
     * Problem:
     * Given a string s, return the longest palindromic substring in s.
     */

    public String longestPalindrome(String str) {

        int n = str.length();

        // If the string length is less than 2, the string itself is a palindrome
        if (n < 2) {
            return str;
        }

        // dp[i][j] = 1 if substring from index i to j is a palindrome, else 0
        int[][] dp = new int[n][n];

        int start = 0;   // starting index of longest palindrome
        int len = 1;     // length of longest palindrome (minimum is 1)

        // Every single character is a palindrome
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }

        // Check for palindromes of length 2
        for (int i = 0; i < n - 1; i++) {
            if (str.charAt(i) == str.charAt(i + 1)) {
                dp[i][i + 1] = 1;
                start = i;
                len = 2;
            }
        }

        // Check for palindromes of length 3 or more
        // k represents the length of the substring
        for (int k = 3; k <= n; k++) {
            for (int i = 0; i <= n - k; i++) {
                int j = i + k - 1;

                // A substring is a palindrome if:
                // 1. The inner substring is a palindrome
                // 2. The current characters match
                if (dp[i + 1][j - 1] == 1 && str.charAt(i) == str.charAt(j)) {
                    dp[i][j] = 1;

                    // Update longest palindrome found so far
                    if (k > len) {
                        len = k;
                        start = i;
                    }
                }
            }
        }

        // Return the longest palindromic substring
        return str.substring(start, start + len);
    }

    /*
     * Time Complexity: O(n^2)
     *   - Two nested loops are used to fill the DP table.
     *
     * Space Complexity: O(n^2)
     *   - A 2D DP table of size n x n is used.
     */
}
