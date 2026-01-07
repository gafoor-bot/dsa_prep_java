class Solution {

    /*Link: https://neetcode.io/problems/partition-equal-subset-sum/question
     * Partition Equal Subset Sum
     *
     * Given an integer array nums, return true if the array
     * can be partitioned into two subsets such that the sum
     * of elements in both subsets is equal.
     *
     * Approach:
     * - This is a classic 0/1 Knapsack problem.
     * - We check if there exists a subset with sum = totalSum / 2.
     *
     * Time Complexity:  O(n * target)
     * Space Complexity: O(n * target)
     * where n = number of elements in nums
     *       target = totalSum / 2
     */
    public boolean canPartition(int[] nums) {

        int sum = 0;

        // Calculate total sum of array
        for (int num : nums) {
            sum += num;
        }

        // If total sum is odd, it cannot be partitioned equally
        if (sum % 2 != 0) return false;

        int target = sum / 2;

        // dp[i][j] = true if a subset of first i elements can form sum j
        boolean[][] dp = new boolean[nums.length + 1][target + 1];

        // Base case: sum 0 is always possible (empty subset)
        for (int i = 0; i <= nums.length; i++) {
            dp[i][0] = true;
        }

        // Base case: with 0 elements, no positive sum can be formed
        for (int j = 1; j <= target; j++) {
            dp[0][j] = false;
        }

        // Fill the DP table
        for (int i = 1; i <= nums.length; i++) {
            for (int j = 1; j <= target; j++) {

                // If current number is greater than target sum j, skip it
                if (j < nums[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                }
                // Otherwise, choose to include or exclude the number
                else {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
                }
            }
        }

        // Final answer: can we form 'target' sum using all elements?
        return dp[nums.length][target];
    }
}
