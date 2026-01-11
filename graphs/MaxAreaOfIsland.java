class Solution {
    // Link : https://neetcode.io/problems/max-area-of-island/question?list=neetcode150
    // Stores the maximum area (number of connected 1s) found so far
    int max_count = 0;

    // Used to count the area of the current island during DFS
    int count = 0;

    /**
     * Finds the maximum area of an island in the given grid.
     *
     * Time Complexity:
     *  - O(m * n), where m = number of rows and n = number of columns
     *  - Each cell is visited at most once.
     *
     * Space Complexity:
     *  - O(m * n) in the worst case due to recursion stack
     *    (when the grid is entirely filled with 1s).
     */
    public int maxAreaOfIsland(int[][] grid) {

        // Traverse every cell in the grid
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {

                // If land is found, start DFS to calculate island area
                if (grid[i][j] == 1) {
                    count = 0;            // Reset count for new island
                    isLand(i, j, grid);   // DFS traversal

                    // Update maximum island area
                    if (count > max_count) {
                        max_count = count;
                    }
                }
            }
        }
        return max_count;
    }

    /**
     * Performs Depth First Search (DFS) to explore the island.
     * Marks visited cells by setting them to 0.
     */
    public void isLand(int i, int j, int[][] grid) {

        // Base case: out of bounds or water cell
        if (i < 0 || i >= grid.length ||
            j < 0 || j >= grid[0].length ||
            grid[i][j] == 0) {
            return;
        }

        // Mark the current cell as visited
        grid[i][j] = 0;

        // Increment area count
        count++;

        // Explore all four directions (up, down, left, right)
        isLand(i + 1, j, grid);
        isLand(i - 1, j, grid);
        isLand(i, j + 1, grid);
        isLand(i, j - 1, grid);
    }
}
