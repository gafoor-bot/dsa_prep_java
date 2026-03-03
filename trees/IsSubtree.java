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

    /*Link: https://neetcode.io/problems/subtree-of-a-binary-tree/question
     * Checks if subRoot is a subtree of root.
     *
     * Time Complexity: O(n * m)
     * Space Complexity: O(h)
     */
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {

        // An empty tree is always a subtree
        if (subRoot == null) return true;

        // If main tree is empty but subRoot is not
        if (root == null) return false;

        // Check match at current node or search in left/right subtrees
        return isSame(root, subRoot)
                || isSubtree(root.left, subRoot)
                || isSubtree(root.right, subRoot);
    }

    /**
     * Checks whether two binary trees are identical.
     */
    private boolean isSame(TreeNode root, TreeNode subRoot) {

        // Both trees are empty
        if (root == null && subRoot == null) return true;

        // One tree is empty or values differ
        if (root == null || subRoot == null || root.val != subRoot.val)
            return false;

        // Check left and right subtrees
        return isSame(root.left, subRoot.left)
                && isSame(root.right, subRoot.right);
    }
}