class Solution {

    /* Link: https://neetcode.io/problems/house-robber/question?list=neetcode150
     * Problem:
     * You are a professional robber planning to rob houses along a street.
     * Each house has a certain amount of money.
     * Adjacent houses cannot be robbed on the same night.
     * Return the maximum amount of money you can rob.
     */

    public int rob(int[] nums) {

        // Handle edge cases
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);

        // dp[i] represents the maximum amount of money
        // that can be robbed from the first i+1 houses
        int[] dp = new int[nums.length];

        // Base cases
        dp[0] = nums[0];                       // Only one house
        dp[1] = Math.max(nums[0], nums[1]);    // Choose the richer of the first two houses

        // Fill the dp array using the recurrence relation:
        // dp[i] = max(
        //     dp[i - 1],            // skip the current house
        //     dp[i - 2] + nums[i]   // rob the current house
        // )
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }

        // The answer is the maximum money that can be robbed from all houses
        return dp[nums.length - 1];
    }

    /*
     * Time Complexity: O(n)
     *   - We iterate through the houses once.
     *
     * Space Complexity: O(n)
     *   - We use a dp array of size n.
     */
}
