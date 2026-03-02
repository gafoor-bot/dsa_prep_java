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

    /*Link: https://neetcode.io/problems/invert-a-binary-tree/question
     * Inverts a binary tree by recursively swapping
     * the left and right subtrees of each node.
     *
     * @param root the root of the binary tree
     * @return the root of the inverted binary tree
     *
     * Time Complexity:
     * O(n) — where n is the number of nodes in the tree.
     * Each node is visited exactly once.
     *
     * Space Complexity:
     * O(h) — where h is the height of the tree.
     * This is due to the recursion stack.
     * In the worst case (skewed tree), h = n.
     * In the best case (balanced tree), h = log n.
     */
    public TreeNode invertTree(TreeNode root) {

        // Base case: if the tree is empty, return null
        if (root == null) return null;

        // Recursively invert the right subtree
        TreeNode r = invertTree(root.right);

        // Recursively invert the left subtree
        TreeNode l = invertTree(root.left);

        // Swap the left and right children
        root.left = r;
        root.right = l;

        // Return the current node after inversion
        return root;
    }
}