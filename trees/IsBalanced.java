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

    /* Link:https://neetcode.io/problems/balanced-binary-tree/question
     * Checks whether a binary tree is height-balanced.
     *
     * @param root root of the binary tree
     * @return true if balanced, false otherwise
     *
     * Time Complexity: O(n)
     * Space Complexity: O(h) where h is the height of the tree
     */
    public boolean isBalanced(TreeNode root) {

        // An empty tree is balanced
        if (root == null) return true;

        // height() returns -1 if the tree is unbalanced
        return height(root) != -1;
    }

    /**
     * Computes height of the tree and checks balance.
     *
     * @param root current node
     * @return height if balanced, -1 if unbalanced
     */
    public int height(TreeNode root) {

        // Base case
        if (root == null) return 0;

        // Compute heights of left and right subtrees
        int left = height(root.left);
        int right = height(root.right);

        // If any subtree is unbalanced or height difference > 1
        if (left == -1 || right == -1 || Math.abs(left - right) > 1)
            return -1;

        // Return height of current node
        return 1 + Math.max(left, right);
    }
}