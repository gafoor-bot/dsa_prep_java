class Solution {

    /* Link: https://neetcode.io/problems/decode-ways/question?list=neetcode150
     * Time Complexity: O(n)
     *   - We iterate through the string once.
     *   - Each iteration performs constant-time operations.
     *
     * Space Complexity: O(n)
     *   - DP array of size (n + 1) is used.
     */
    public int numDecodings(String s) {

        // dp[i] represents the number of ways to decode
        // the substring s[0..i-1]
        int[] dp = new int[s.length() + 1];

        // Base case: empty string has one valid decoding
        dp[0] = 1;

        // Base case: first character
        // If it is '0', it cannot be decoded
        dp[1] = s.charAt(0) == '0' ? 0 : 1;

        // Build the dp array from left to right
        for (int i = 2; i <= s.length(); i++) {

            // One-digit number (current character)
            int oneDigit = s.charAt(i - 1) - '0';

            // Two-digit number (previous + current character)
            int twoDigit = Integer.parseInt(s.substring(i - 2, i));

            // If oneDigit is between 1 and 9, it is a valid character
            // Add ways from previous position
            if (oneDigit >= 1 && oneDigit <= 9) {
                dp[i] += dp[i - 1];
            }

            // If twoDigit is between 10 and 26, it is a valid character
            // Add ways from two positions back
            if (twoDigit >= 10 && twoDigit <= 26) {
                dp[i] += dp[i - 2];
            }
        }

        // The last element contains the total decoding ways
        return dp[s.length()];
    }
}
