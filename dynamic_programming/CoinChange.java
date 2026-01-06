class Solution {

    /*Link: https://neetcode.io/problems/coin-change/solution
     * Coin Change Problem (Unbounded Knapsack - Minimum Coins)
     *
     * Given coin denominations and a target amount,
     * return the minimum number of coins needed to make the amount.
     * If it is not possible, return -1.
     *
     * Time Complexity:  O(N * amount)
     * Space Complexity: O(N * amount)
     * where N = number of coins
     */
    public int coinChange(int[] coins, int amount) {

        // Base case: no coins needed to make amount 0
        if (amount == 0) return 0;

        // dp[i][j] = minimum number of coins needed to make amount j
        // using first i coins
        int[][] dp = new int[coins.length + 1][amount + 1];

        // Build the DP table bottom-up
        for (int i = 0; i <= coins.length; i++) {
            for (int j = 0; j <= amount; j++) {

                // If amount is 0, no coins are needed
                if (j == 0) {
                    dp[i][j] = 0;
                }
                // If no coins are available and amount > 0, impossible
                else if (i == 0) {
                    dp[i][j] = (int) 1e5; // represents infinity
                }
                // If current coin value is greater than amount,
                // we cannot include this coin
                else if (coins[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];
                }
                // Choice: include the coin or exclude it
                else {
                    dp[i][j] = Math.min(
                        1 + dp[i][j - coins[i - 1]], // take the coin
                        dp[i - 1][j]                 // skip the coin
                    );
                }
            }
        }

        // If the final value is still large, it means no solution exists
        return dp[coins.length][amount] > (int) 1e4 ? -1 : dp[coins.length][amount];
    }
}
