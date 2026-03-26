//Link : https://neetcode.io/problems/valid-sudoku/question
import java.util.HashSet;

class Solution {
    public boolean isValidSudoku(char[][] board) {

        int n = board.length; // For generalized N x N Sudoku

        // Check all rows
        // Time: O(n^2)
        for (int i = 0; i < n; i++) {
            HashSet<Character> set = new HashSet<>();

            for (int j = 0; j < n; j++) {
                // If number already exists in the row → invalid
                if (set.contains(board[i][j]))
                    return false;

                // Ignore empty cells
                else if (board[i][j] != '.')
                    set.add(board[i][j]);
            }
        }

        // Check all columns
        // Time: O(n^2)
        for (int j = 0; j < n; j++) {
            HashSet<Character> set = new HashSet<>();

            for (int i = 0; i < n; i++) {
                // If number already exists in the column → invalid
                if (set.contains(board[i][j]))
                    return false;

                // Ignore empty cells
                else if (board[i][j] != '.')
                    set.add(board[i][j]);
            }
        }

        // Size of sub-box (√n x √n)
        int size = (int) Math.sqrt(n);

        // Check all sub-boxes
        // Time: O(n^2)
        for (int i = 0; i < n; i += size) {
            for (int j = 0; j < n; j += size) {
                if (!isValid(board, i, j, size))
                    return false;
            }
        }

        return true;
    }

    // Helper function to validate a sub-box
    boolean isValid(char[][] board, int row, int col, int size) {
        HashSet<Character> set = new HashSet<>();

        // Traverse sub-box
        // Time: O(size^2) = O(n)
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {

                // If number already exists → invalid
                if (set.contains(board[row + i][col + j]))
                    return false;

                // Ignore empty cells
                else if (board[row + i][col + j] != '.')
                    set.add(board[row + i][col + j]);
            }
        }

        return true;
    }
}

/*
----------------------------------------
Time Complexity:
----------------------------------------
- Row check: O(n^2)
- Column check: O(n^2)
- Sub-box check: O(n^2)

Total Time Complexity: O(n^2)

----------------------------------------
Space Complexity:
----------------------------------------
- HashSet used per row/column/sub-box: O(n)

Total Space Complexity: O(n)

----------------------------------------
Note:
- For standard Sudoku (9x9), this becomes O(1)
- For generalized N x N Sudoku, complexity scales to O(n^2)
*/