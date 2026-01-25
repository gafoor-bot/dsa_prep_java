class Solution {

    /* Link: https://neetcode.io/problems/trapping-rain-water/question?list=neetcode150
     * Time Complexity: O(n)
     * - Three linear passes over the array
     *
     * Space Complexity: O(n)
     * - Uses two auxiliary arrays: max_left and max_right
     */
    public int trap(int[] height) {

        // If there are fewer than 3 bars, water cannot be trapped
        if (height.length <= 2) return 0;

        int n = height.length;

        // Arrays to store the maximum height to the left and right of each index
        int[] max_left = new int[n];
        int[] max_right = new int[n];

        // Initialize the left boundary
        max_left[0] = 0;
        int max = height[0];

        // Fill max_left array
        // max_left[i] stores the tallest bar to the left of index i
        for (int i = 1; i < n; i++) {
            max = Math.max(height[i], max);
            max_left[i] = max;
        }

        // Initialize the right boundary
        max_right[n - 1] = 0;
        max = height[n - 1];

        // Fill max_right array
        // max_right[i] stores the tallest bar to the right of index i
        for (int i = n - 2; i >= 0; i--) {
            max = Math.max(height[i], max);
            max_right[i] = max;
        }

        int trappedWater = 0;

        // Calculate trapped water at each index
        for (int i = 1; i < n - 1; i++) {

            // Water level is determined by the shorter boundary
            int minBoundary = Math.min(max_left[i], max_right[i]);

            // Add trapped water at current index (if any)
            if (minBoundary > height[i]) {
                trappedWater += minBoundary - height[i];
            }
        }

        // Return total trapped water
        return trappedWater;
    }
}
