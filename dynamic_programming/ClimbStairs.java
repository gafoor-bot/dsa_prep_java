class Solution {

    /* Link:https://neetcode.io/problems/climbing-stairs/question?list=neetcode150
     * Problem:
     * You are climbing a staircase. It takes n steps to reach the top.
     * Each time you can either climb 1 or 2 steps.
     * In how many distinct ways can you climb to the top?
     */

    public int climbStairs(int n) {

        // dp[i] represents the number of ways to reach step i
        int[] dp = new int[n + 1];

        // Base cases:
        // There is exactly 1 way to stay at step 0 (do nothing)
        dp[0] = 1;

        // There is exactly 1 way to reach step 1 (1 step)
        dp[1] = 1;

        // Fill the dp array using the recurrence relation:
        // dp[i] = dp[i - 1] + dp[i - 2]
        // (from step i-1 by taking 1 step, or from step i-2 by taking 2 steps)
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        // The answer is the number of ways to reach step n
        return dp[n];
    }

    /*
     * Time Complexity: O(n)
     *   - We iterate once from 2 to n.
     *
     * Space Complexity: O(n)
     *   - We use a dp array of size n + 1.
     */
}
