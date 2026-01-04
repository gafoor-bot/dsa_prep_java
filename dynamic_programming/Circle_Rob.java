class Solution {

    /* Link:https://neetcode.io/problems/house-robber-ii/question?list=neetcode150
     * Problem:
     * You are a professional robber planning to rob houses arranged in a circle.
     * Each house has a certain amount of money.
     * Adjacent houses cannot be robbed on the same night.
     * The first and last houses are also adjacent.
     * Return the maximum amount of money you can rob.
     */

    public int rob(int[] nums) {

        // Edge cases
        if (nums.length == 1) return nums[0];
        if (nums.length == 2)
            return Math.max(nums[0], nums[1]);

        // Case 1: Rob houses from index 0 to n-2 (exclude last house)
        int resultWithFirst = solve(nums, 0, nums.length - 2);

        // Case 2: Rob houses from index 1 to n-1 (exclude first house)
        int resultWithLast = solve(nums, 1, nums.length - 1);

        // Take the maximum of both cases
        return Math.max(resultWithFirst, resultWithLast);
    }

    /*
     * Helper method to solve the linear House Robber problem
     * from index 'start' to index 'end'
     */
    public int solve(int[] nums, int start, int end) {

        // If there is only one house in the range
        if (start == end)
            return nums[start];

        // money[i] represents the maximum money that can be robbed
        // from houses up to index i
        int[] money = new int[nums.length];

        // Base cases
        money[start] = nums[start];
        money[start + 1] = Math.max(nums[start], nums[start + 1]);

        // Fill the dp array using the recurrence relation:
        // money[i] = max(
        //     money[i - 1],            // skip current house
        //     money[i - 2] + nums[i]   // rob current house
        // )
        for (int i = start + 2; i <= end; i++) {
            money[i] = Math.max(money[i - 1], money[i - 2] + nums[i]);
        }

        // The answer is the maximum money that can be robbed in this range
        return money[end];
    }

    /*
     * Time Complexity: O(n)
     *   - We solve two linear DP problems, each in O(n) time.
     *
     * Space Complexity: O(n)
     *   - We use a dp array of size n.
     */
}
