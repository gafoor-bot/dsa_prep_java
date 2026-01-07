import java.util.Arrays;

class Solution {

    /* Link: https://neetcode.io/problems/longest-increasing-subsequence/question?list=neetcode150
     * Longest Increasing Subsequence (LIS)
     *
     * Given an integer array nums, return the length of the
     * longest strictly increasing subsequence.
     *
     * Approach:
     * - Use Dynamic Programming (1D DP)
     * - dp[i] represents the length of LIS ending at index i
     *
     * Time Complexity:  O(n^2)
     * Space Complexity: O(n)
     */
    public int lengthOfLIS(int[] nums) {

        // Edge case: empty array
        if (nums == null || nums.length == 0) {
            return 0;
        }

        // dp[i] = length of LIS ending at index i
        int[] dp = new int[nums.length];

        // Every element is an LIS of length 1 by itself
        Arrays.fill(dp, 1);

        // Build the dp array
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {

                // If nums[i] can extend the increasing subsequence ending at j
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        // Find the maximum value in dp[]
        int maxLIS = 0;
        for (int len : dp) {
            maxLIS = Math.max(maxLIS, len);
        }

        return maxLIS;
    }
}
