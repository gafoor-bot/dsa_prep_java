class Solution {
    //link :https://neetcode.io/problems/jump-game/question?list=neetcode150
    // This method determines whether we can reach the last index of the array
    public boolean canJump(int[] nums) {

        // i is not used in the logic but kept as declared
        int i = 0;

        // max keeps track of the farthest index that can be reached so far
        int max = 0;

        // jump stores the farthest reach from the current index
        int jump = 0;

        // Iterate through each index of the array
        for (int j = 0; j < nums.length; j++) {

            // If the current index is beyond the farthest reachable index,
            // it means we cannot proceed further
            if (j > max)
                return false;

            // Calculate the farthest index reachable from current position
            jump = j + nums[j];

            // Update the maximum reachable index
            max = Math.max(max, jump);
        }

        // If the loop completes, the last index is reachable
        return true;
    }
}
