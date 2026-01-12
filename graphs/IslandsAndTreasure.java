import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    /* Link: https://neetcode.io/problems/islands-and-treasure/question?list=neetcode150
     * Problem:
     * 0  -> Treasure (Gate)
     * -1 -> Wall
     * INF (Integer.MAX_VALUE) -> Empty land
     *
     * Goal:
     * Fill each empty land with the distance to the nearest treasure.
     *
     * Approach:
     * - Use Multi-Source BFS
     * - Start BFS from all treasure cells (0s) at once
     * - BFS guarantees shortest distance
     */

    public void islandsAndTreasure(int[][] grid) {

        // Queue for BFS, stores cell positions as {row, col}
        Queue<int[]> q = new LinkedList<>();

        int m = grid.length;        // number of rows
        int n = grid[0].length;     // number of columns

        /*
         * Step 1: Add all treasure cells (0) to the queue
         * These act as starting points for BFS
         */
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    q.add(new int[] { i, j });
                }
            }
        }

        // If there are no treasures, no distances can be updated
        if (q.isEmpty()) return;

        /*
         * Step 2: Directions array to move
         * Up, Left, Down, Right
         */
        int[][] dirs = {
                { -1, 0 }, // up
                { 0, -1 }, // left
                { 1, 0 },  // down
                { 0, 1 }   // right
        };

        /*
         * Step 3: Perform BFS
         * Process cells level by level to ensure shortest distance
         */
        while (!q.isEmpty()) {

            // Get the current cell
            int[] node = q.poll();
            int row = node[0];
            int col = node[1];

            // Explore all 4 neighboring cells
            for (int[] dir : dirs) {
                int r = row + dir[0];
                int c = col + dir[1];

                /*
                 * Skip if:
                 * - Out of grid boundaries
                 * - Cell is not empty land (already visited, wall, or treasure)
                 */
                if (r < 0 || r >= m || c < 0 || c >= n ||
                        grid[r][c] != Integer.MAX_VALUE) {
                    continue;
                }

                /*
                 * Update distance:
                 * Neighbor distance = current cell distance + 1
                 * Since BFS is used, this is the shortest path
                 */
                grid[r][c] = grid[row][col] + 1;

                // Add neighbor to queue for further BFS expansion
                q.add(new int[] { r, c });
            }
        }
    }

    /*
     * Time Complexity:
     * O(m * n)
     * - Each cell is visited at most once during BFS
     *
     * Space Complexity:
     * O(m * n)
     * - Queue can hold all cells in the worst case
     */
}
