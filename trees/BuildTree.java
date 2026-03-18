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

    /* Link:https://neetcode.io/problems/binary-tree-from-preorder-and-inorder-traversal/question
     * Time Complexity: O(n)
     * - Each node is processed exactly once.
     * - HashMap allows O(1) lookup for inorder indices.
     *
     * Space Complexity: O(n)
     * - HashMap stores n elements → O(n)
     * - Recursion stack:
     *     Worst case (skewed tree): O(n)
     *     Best case (balanced tree): O(log n)
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        // Create a map to store value -> index for inorder traversal
        HashMap<Integer, Integer> inmap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inmap.put(inorder[i], i);
        }

        // Start recursion with full array range
        return helper(preorder, inorder,
                0, preorder.length - 1,
                0, inorder.length - 1,
                inmap);
    }

    public TreeNode helper(int[] preorder, int[] inorder,
                           int preStart, int preEnd,
                           int inStart, int inEnd,
                           HashMap<Integer, Integer> inmap) {

        // Base case:
        // If range becomes invalid → no elements → return null
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }

        // First element in preorder is always the root
        TreeNode root = new TreeNode(preorder[preStart]);

        // Find root position in inorder
        int inroot = inmap.get(root.val);

        // Calculate number of nodes in left subtree
        int nums_left = inroot - inStart;

        // Build left subtree
        root.left = helper(preorder, inorder,
                preStart + 1,                   // skip root
                preStart + nums_left,           // left subtree range
                inStart,
                inroot - 1,
                inmap);

        // Build right subtree
        root.right = helper(preorder, inorder,
                preStart + nums_left + 1,       // skip root + left subtree
                preEnd,
                inroot + 1,
                inEnd,
                inmap);

        return root;
    }
}