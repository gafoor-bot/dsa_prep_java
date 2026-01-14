class Solution {

    /**
     * Time Complexity:
     * O(R * C) where R = number of rows, C = number of columns.
     * Each cell is processed at most once during BFS.
     *
     * Space Complexity:
     * O(R * C) in the worst case due to the queue storing all grid cells.
     */

    public int orangesRotting(int[][] grid) {

        // Edge case: empty grid
        if (grid == null || grid.length == 0) return 0;

        int rows = grid.length;
        int cols = grid[0].length;

        // Queue to perform multi-source BFS
        // Each element stores the position {row, col} of a rotten orange
        Queue<int[]> queue = new LinkedList<>();

        // Count of fresh oranges present initially
        int count_fresh = 0;

        // Traverse the grid to:
        // 1. Add all initially rotten oranges to the queue
        // 2. Count the number of fresh oranges
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 2) {
                    // Add rotten oranges as starting points for BFS
                    queue.offer(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    // Count fresh oranges
                    count_fresh++;
                }
            }
        }

        // If there are no fresh oranges, no time is required
        if (count_fresh == 0) return 0;

        // Minutes counter
        int count = 0;

        // Direction vectors: down, up, right, left
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        // Perform BFS level by level (each level represents 1 minute)
        while (!queue.isEmpty()) {

            // Increment minute counter for each BFS level
            ++count;

            // Number of rotten oranges at the current minute
            int size = queue.size();

            // Process all rotten oranges of the current minute
            for (int i = 0; i < size; i++) {

                int[] point = queue.poll();

                // Check all 4 adjacent cells
                for (int[] dir : dirs) {

                    int x = point[0] + dir[0];
                    int y = point[1] + dir[1];

                    // Skip if:
                    // 1. Out of grid bounds
                    // 2. Cell is empty
                    // 3. Cell already contains a rotten orange
                    if (x < 0 || y < 0 || x >= rows || y >= cols ||
                        grid[x][y] == 0 || grid[x][y] == 2) {
                        continue;
                    }

                    // Convert fresh orange to rotten
                    grid[x][y] = 2;

                    // Add newly rotten orange to the queue
                    queue.offer(new int[]{x, y});

                    // Decrease fresh orange count
                    count_fresh--;
                }
            }
        }

        // If all fresh oranges have rotted, return time taken
        // Subtract 1 because count is incremented one extra time
        return count_fresh == 0 ? count - 1 : -1;
    }
}
