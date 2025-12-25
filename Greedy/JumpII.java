class Solution {
    /* Link: https://neetcode.io/problems/jump-game-ii/question
     * Function to find the minimum number of jumps needed 
     * to reach the last index of the array.
     *
     * @param nums Array of non-negative integers where each element
     *             represents the maximum jump length at that position.
     * @return Minimum number of jumps to reach the last index.
     */
    public int jump(int[] nums) {
        int jumps = 0;       // Number of jumps made
        int end = 0;         // The end of the current jump range
        int farthest = 0;    // The farthest index we can reach so far

        // We iterate until the second last element because
        // we don't need to jump from the last element
        for (int i = 0; i < nums.length - 1; i++) {
            // Update the farthest point reachable from this position
            farthest = Math.max(farthest, i + nums[i]);

            // If we have reached the end of the current jump range
            if (i == end) {
                jumps++;         // Make a jump
                end = farthest;  // Extend the jump range to the farthest reachable index
            }
        }

        return jumps;
    }
}
