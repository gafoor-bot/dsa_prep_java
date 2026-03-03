/*
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

    // Stores the maximum diameter found so far
    // Diameter = number of edges in the longest path between any two nodes
    private int maxDiameter = 0;

    /**
     * Computes the height of the tree while updating the diameter.
     *
     * Height of a node = max height of left/right subtree + 1
     * Diameter at a node = height(left) + height(right)
     *
     * @param node current tree node
     * @return height of the current node
     */
    private int height(TreeNode node) {

        // Base case: empty subtree has height 0
        if (node == null) return 0;

        // Recursively calculate heights of left and right subtrees
        int left = height(node.left);
        int right = height(node.right);

        // Update the maximum diameter if the path through this node is larger
        maxDiameter = Math.max(maxDiameter, left + right);

        // Return height of current node
        return Math.max(left, right) + 1;
    }

    /**
     * Returns the diameter of the binary tree.
     *
     * @param root the root of the binary tree
     * @return the diameter of the tree
     *
     * Time Complexity:
     * O(n) — where n is the number of nodes in the tree.
     * Each node is visited exactly once.
     *
     * Space Complexity:
     * O(h) — where h is the height of the tree.
     * Used by the recursion stack.
     * Worst case (skewed tree): O(n)
     * Best case (balanced tree): O(log n)
     */
    public int diameterOfBinaryTree(TreeNode root) {

        // Compute heights and update diameter
        height(root);

        // Return the maximum diameter found
        return maxDiameter;
    }
}