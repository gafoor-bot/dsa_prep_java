//Link: https://neetcode.io/problems/interleaving-string/question
class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        // Lengths of s1 and s2
        int m = s1.length();
        int n = s2.length();

        // If total lengths don't match, interleaving is impossible
        if (m + n != s3.length()) return false;

        // dp[i][j] = true if s3[0...(i+j-1)] can be formed
        // by interleaving s1[0...(i-1)] and s2[0...(j-1)]
        boolean[][] dp = new boolean[m + 1][n + 1];

        // Base case: empty s1 and s2 form empty s3
        dp[0][0] = true;

        // Fill the DP table
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {

                // If taking character from s1
                if (i > 0) {
                    // Check if current char of s1 matches corresponding char in s3
                    if (s1.charAt(i - 1) == s3.charAt(i + j - 1)) {
                        // If previous state was valid, mark current as valid
                        dp[i][j] = dp[i][j] || dp[i - 1][j];
                    }
                }

                // If taking character from s2
                if (j > 0) {
                    // Check if current char of s2 matches corresponding char in s3
                    if (s2.charAt(j - 1) == s3.charAt(i + j - 1)) {
                        // If previous state was valid, mark current as valid
                        dp[i][j] = dp[i][j] || dp[i][j - 1];
                    }
                }
            }
        }

        // Final answer: whether full s1 and s2 can form full s3
        return dp[m][n];
    }
}

/*
Time Complexity:
O(m * n)
- We iterate through a 2D DP table of size (m+1) * (n+1)

Space Complexity:
O(m * n)
- The DP table stores m*n boolean values

Optional Optimization:
- Space can be reduced to O(n) using a 1D DP array
*/