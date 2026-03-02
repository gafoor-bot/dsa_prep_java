/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {

    /*Link: https://neetcode.io/problems/depth-of-binary-tree/question
     * Computes the maximum depth (height) of a binary tree.
     * The maximum depth is the number of nodes along the longest
     * path from the root node down to the farthest leaf node.
     *
     * @param root the root of the binary tree
     * @return the maximum depth of the tree
     *
     * Time Complexity:
     * O(n) — where n is the number of nodes in the tree.
     * Each node is visited exactly once.
     *
     * Space Complexity:
     * O(h) — where h is the height of the tree.
     * This space is used by the recursion stack.
     * Worst case (skewed tree): O(n)
     * Best case (balanced tree): O(log n)
     */
    public int maxDepth(TreeNode root) {

        // Base case: if the tree is empty, depth is 0
        if (root == null) return 0;

        // Recursively compute the depth of left and right subtrees
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);

        // The depth of the current node is the max of both subtrees + 1
        return Math.max(leftDepth, rightDepth) + 1;
    }
}