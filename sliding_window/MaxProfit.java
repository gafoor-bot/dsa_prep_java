class Solution {

    /* Link: https://neetcode.io/problems/buy-and-sell-crypto/question
     * Calculates the maximum profit from buying and selling a stock once.
     *
     * Approach:
     * - Track the minimum price seen so far.
     * - At each day, calculate profit if sold today.
     * - Update maximum profit accordingly.
     *
     * Time Complexity: O(n)
     *   - We traverse the prices array once.
     *
     * Space Complexity: O(1)
     *   - Only constant extra space is used.
     */
    public int maxProfit(int[] prices) {

        // Stores the maximum profit achievable
        int max_profit = 0;

        // Stores the minimum price seen so far (buy price)
        int min = prices[0];

        // Iterate through prices starting from day 1
        for (int i = 1; i < prices.length; i++) {

            // Calculate profit if selling on current day
            int profit = prices[i] - min;

            // Update maximum profit if current profit is higher
            max_profit = Math.max(max_profit, profit);

            // Update minimum price if a lower price is found
            min = Math.min(min, prices[i]);
        }

        // Return the maximum profit
        return max_profit;
    }
}
