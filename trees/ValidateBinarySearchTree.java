/*Link: https://neetcode.io/problems/valid-binary-search-tree/question
 * Problem: Validate Binary Search Tree
 *
 * A Binary Search Tree (BST) must satisfy the following rules:
 * 1. The left subtree of a node contains only nodes with values less than the node's value.
 * 2. The right subtree of a node contains only nodes with values greater than the node's value.
 * 3. Both the left and right subtrees must also be valid BSTs.
 *
 * Approach:
 * Instead of only comparing a node with its immediate children,
 * we maintain a valid range (min, max) for each node.
 *
 * - For the root node → valid range is (-∞, +∞)
 * - For the left child → range becomes (min, parent.val)
 * - For the right child → range becomes (parent.val, max)
 *
 * If any node violates this range constraint, the tree is not a valid BST.
 *
 * Example:
 *
 *        5
 *       / \
 *      3   7
 *
 * Range propagation:
 * 5 → (-∞, +∞)
 * 3 → (-∞, 5)
 * 7 → (5, +∞)
 *
 * This ensures all nodes follow the BST property across the entire subtree.
 *
 * Time Complexity: O(n)
 * - Every node in the tree is visited exactly once.
 *
 * Space Complexity: O(h)
 * - Due to recursion stack.
 * - h = height of the tree
 * - Worst case (skewed tree): O(n)
 * - Best case (balanced tree): O(log n)
 */

/**
 * Definition for a binary tree node.
 */
public class Solution {

    public boolean isValidBST(TreeNode root) {
        // Start recursion with the widest possible range
        return valid(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    /**
     * Helper function to validate BST using range limits
     *
     * @param node  current tree node
     * @param left  minimum allowed value
     * @param right maximum allowed value
     * @return true if subtree rooted at node is a valid BST
     */
    public boolean valid(TreeNode node, long left, long right) {

        // Base case: empty nodes are valid BSTs
        if (node == null) {
            return true;
        }

        // Check if the current node violates BST range constraint
        if (!(left < node.val && node.val < right)) {
            return false;
        }

        // Recursively validate left and right subtrees with updated ranges
        return valid(node.left, left, node.val) &&
               valid(node.right, node.val, right);
    }
}