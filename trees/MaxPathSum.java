//Link :https://neetcode.io/problems/binary-tree-maximum-path-sum/question
class Solution {
    // Global variable to track the maximum path sum found so far
    private int maxSum;

    /**
     * Main function to compute maximum path sum in a binary tree.
     */
    public int maxPathSum(TreeNode root) {
        // Initialize with smallest possible value to handle negative nodes
        maxSum = Integer.MIN_VALUE;

        // Start DFS traversal
        dfs(root);

        return maxSum;
    }

    /**
     * DFS helper function.
     *
     * For each node:
     * - Compute max gain from left and right subtrees (ignore negatives)
     * - Calculate max path passing THROUGH the current node
     * - Update global maximum
     * - Return max gain if we continue the path upward
     */
    private int dfs(TreeNode node) {
        if (node == null) return 0;

        // Max contribution from left subtree (ignore negative paths)
        int left = Math.max(0, dfs(node.left));

        // Max contribution from right subtree (ignore negative paths)
        int right = Math.max(0, dfs(node.right));

        // Max path sum where current node is the highest node (split allowed)
        int currentPath = node.val + left + right;

        // Update global maximum path sum
        maxSum = Math.max(maxSum, currentPath);

        // Return max sum of a path extending to parent (no split allowed)
        return node.val + Math.max(left, right);
    }

    /*
     * ---------------------------
     * Time Complexity: O(n)
     * ---------------------------
     * Each node is visited exactly once in the DFS traversal.
     *
     * ---------------------------
     * Space Complexity: O(h)
     * ---------------------------
     * Recursion stack space, where:
     * h = height of the tree
     * - Balanced tree: O(log n)
     * - Skewed tree: O(n)
     */
}