/**
 * Problem: Kth Smallest Element in a Binary Search Tree
 *
 * Approach:
 * A Binary Search Tree (BST) has the property that an inorder traversal
 * (Left -> Root -> Right) visits nodes in ascending sorted order.
 *
 * Therefore, the kth node visited during an inorder traversal
 * is the kth smallest element in the BST.
 *
 * Steps:
 * 1. Traverse the left subtree.
 * 2. Visit the current node and increment the counter.
 * 3. If the counter equals k, store the current node value.
 * 4. Traverse the right subtree.
 *
 * Time Complexity:
 * O(n) in the worst case, where n is the number of nodes in the tree,
 * because we may need to traverse all nodes.
 *
 * Space Complexity:
 * O(h) due to recursion stack space, where h is the height of the tree.
 * - Best case (balanced BST): O(log n)
 * - Worst case (skewed BST): O(n)
 */

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

    // Counter to track number of visited nodes during inorder traversal
    int count = 0;

    // Variable to store the kth smallest value
    int result = 0;

    public int kthSmallest(TreeNode root, int k) {
        find(root, k);
        return result;
    }

    // Perform inorder traversal of the BST
    public void find(TreeNode root, int k) {

        // Base case: if node is null, return
        if (root == null) return;

        // Traverse left subtree
        find(root.left, k);

        // Visit current node
        count++;

        // If count equals k, store the result
        if (count == k) {
            result = root.val;
            return;
        }

        // Traverse right subtree
        find(root.right, k);
    }
}