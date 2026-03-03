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

    /*Link: https://neetcode.io/problems/same-binary-tree/question?list=neetcode150
     * Checks whether two binary trees are identical.
     *
     * Two trees are the same if:
     * 1. They have the same structure
     * 2. All corresponding node values are equal
     *
     * @param p root of first tree
     * @param q root of second tree
     * @return true if trees are the same, false otherwise
     *
     * Time Complexity: O(n)
     * Space Complexity: O(h)
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {

        // If both nodes are null, trees match at this branch
        if (p == null && q == null) return true;

        // If one node is null and the other isn't, trees differ
        if (p == null || q == null) return false;

        // Check current node value and recurse on both subtrees
        return (p.val == q.val)
                && isSameTree(p.left, q.left)
                && isSameTree(p.right, q.right);
    }
}