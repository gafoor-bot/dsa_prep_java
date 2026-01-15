class Solution {
    /*Link: https://neetcode.io/problems/surrounded-regions/question?list=neetcode150
     * Problem: Surrounded Regions
     * Goal: Capture all 'O's that are completely surrounded by 'X' by converting them to 'X'.
     * Any 'O' connected to the boundary should not be flipped.
     */

    public void solve(char[][] board) {
        int r = board.length;
        int c = board[0].length;

        // Step 1: Start DFS from all boundary 'O's to mark safe regions
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                // Check if the cell is on the boundary
                if (i == 0 || i == r - 1 || j == 0 || j == c - 1) {
                    if (board[i][j] == 'O') {
                        // Mark all 'O's connected to this boundary cell
                        dfs(board, i, j);
                    }
                }
            }
        }

        // Step 2: Flip all unmarked 'O's to 'X', and restore marked '1's back to 'O'
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X'; // Surrounded 'O's
                } else if (board[i][j] == '1') {
                    board[i][j] = 'O'; // Restore safe 'O's
                }
            }
        }
    }

    /**
     * DFS to mark all 'O's connected to the current cell
     * @param board 2D grid
     * @param r current row
     * @param c current column
     */
    public void dfs(char[][] board, int r, int c) {
        // Base cases: out of bounds or not 'O'
        if (r < 0 || r >= board.length || c < 0 || c >= board[0].length || board[r][c] != 'O')
            return;

        board[r][c] = '1'; // Temporarily mark this 'O' as safe

        // Explore all four directions
        dfs(board, r + 1, c);
        dfs(board, r - 1, c);
        dfs(board, r, c + 1);
        dfs(board, r, c - 1);
    }
}

/*
Time Complexity: O(m * n)
- We potentially visit each cell once during DFS.  
- Let m = number of rows, n = number of columns.

Space Complexity: O(m * n) in worst case due to recursion stack
- In worst case, DFS can go as deep as the total number of 'O's connected.
- If using iterative BFS instead, the queue can also take O(m*n) in worst case.
*/
