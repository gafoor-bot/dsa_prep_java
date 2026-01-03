class Solution {

    /*Link :https://neetcode.io/problems/min-cost-climbing-stairs/question?list=neetcode150
     * Problem:
     * You are given an integer array cost where cost[i] is the cost of the ith step.
     * Once you pay the cost, you can either climb one or two steps.
     * You can either start from step 0 or step 1.
     * Return the minimum cost to reach the top of the floor.
     */

    public int minCostClimbingStairs(int[] cost) {

        // dp[i] represents the minimum cost to reach step i
        int[] dp = new int[cost.length + 1];

        // Base cases:
        // It costs nothing to start at step 0 or step 1
        dp[0] = 0;
        dp[1] = 0;

        // Fill the dp array using the recurrence relation:
        // dp[i] = min(
        //     dp[i - 1] + cost[i - 1],  // take 1 step from i-1
        //     dp[i - 2] + cost[i - 2]   // take 2 steps from i-2
        // )
        for (int i = 2; i <= cost.length; i++) {
            dp[i] = Math.min(
                dp[i - 1] + cost[i - 1],
                dp[i - 2] + cost[i - 2]
            );
        }

        // The answer is the minimum cost to reach the top (beyond the last step)
        return dp[cost.length];
    }

    /*
     * Time Complexity: O(n)
     *   - We iterate through the cost array once.
     *
     * Space Complexity: O(n)
     *   - We use a dp array of size n + 1.
     */
}
