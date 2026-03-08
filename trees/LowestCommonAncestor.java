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

    /*Link: https://neetcode.io/problems/lowest-common-ancestor-in-binary-search-tree/question?list=neetcode150
     * Finds the Lowest Common Ancestor (LCA) of two nodes in a Binary Search Tree.
     *
     * In a BST:
     * - Left subtree values are smaller than the root.
     * - Right subtree values are greater than the root.
     *
     * Logic:
     * 1. If both p and q are smaller than root, LCA lies in the left subtree.
     * 2. If both p and q are greater than root, LCA lies in the right subtree.
     * 3. Otherwise, the current root is the split point and hence the LCA.
     *
     * Time Complexity: O(H)
     * - H is the height of the tree.
     * - Best case (balanced BST): O(log N)
     * - Worst case (skewed tree): O(N)
     *
     * Space Complexity: O(H)
     * - Due to recursive call stack.
     * - Best case: O(log N)
     * - Worst case: O(N)
     */

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        // Base case: if root is null, return null
        if (root == null) return null;

        // If both nodes are smaller than root, search in left subtree
        if (root.val > p.val && root.val > q.val) {
            return lowestCommonAncestor(root.left, p, q);
        }

        // If both nodes are greater than root, search in right subtree
        if (root.val < p.val && root.val < q.val) {
            return lowestCommonAncestor(root.right, p, q);
        }

        // If one node is on each side (or one equals root),
        // then current root is the Lowest Common Ancestor
        return root;
    }
}