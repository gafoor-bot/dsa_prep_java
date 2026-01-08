class Solution {

    /* Link: https://neetcode.io/problems/count-number-of-islands/question?list=neetcode150
     * Time Complexity: O(m * n)
     *   - Each cell in the grid is visited at most once.
     *
     * Space Complexity: O(m * n)
     *   - In the worst case, the recursion stack can go as deep as
     *     the number of cells in the grid (DFS).
     *   - No extra data structures are used apart from recursion.
     */
    public int numIslands(char[][] grid) {

        int count = 0;

        // Traverse every cell in the grid
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {

                // If land is found, it's a new island
                if (grid[i][j] == '1') {
                    count++;
                    // Perform DFS to mark the entire island as visited
                    dfs(grid, i, j);
                }
            }
        }
        return count;
    }

    // Depth First Search to mark connected land cells as visited
    private void dfs(char[][] grid, int i, int j) {

        // Boundary check and water check
        if (i < 0 || i >= grid.length ||
            j < 0 || j >= grid[0].length ||
            grid[i][j] == '0') {
            return;
        }

        // Mark current cell as visited by converting land to water
        grid[i][j] = '0';

        // Explore all four directions
        dfs(grid, i + 1, j); // down
        dfs(grid, i - 1, j); // up
        dfs(grid, i, j + 1); // right
        dfs(grid, i, j - 1); // left
    }
}
