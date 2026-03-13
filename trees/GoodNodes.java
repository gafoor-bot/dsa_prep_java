/*Link: https://neetcode.io/problems/count-good-nodes-in-binary-tree/question
 * Problem: Good Nodes in Binary Tree
 *
 * A node X in the tree is considered "good" if on the path from the root
 * to X there are no nodes with a value greater than X.
 *
 * Approach:
 * We use DFS (Preorder Traversal) to visit each node.
 * While traversing, we keep track of the maximum value seen so far
 * on the path from the root to the current node.
 *
 * If the current node's value is greater than or equal to the max value
 * seen so far, it is considered a "good node".
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

    // Global counter to store number of good nodes
    int count = 0;

    /**
     * Main function that starts traversal
     *
     * @param root root of the binary tree
     * @return total number of good nodes
     */
    public int goodNodes(TreeNode root) {

        // Edge case: empty tree
        if (root == null) return 0;

        // Start preorder traversal with root value as initial maximum
        return preorder(root, root.val);
    }

    /**
     * Preorder DFS traversal
     *
     * @param root current node
     * @param max maximum value seen so far on the path
     * @return number of good nodes
     */
    public int preorder(TreeNode root, int max) {

        // Base case: if node is null, stop recursion
        if (root == null) return 0;

        // Check if current node is a good node
        if (root.val >= max) {

            // Increment good node count
            count++;

            // Update maximum value for the path
            max = root.val;
        }

        // Traverse left subtree
        preorder(root.left, max);

        // Traverse right subtree
        preorder(root.right, max);

        // Return total count of good nodes
        return count;
    }
}


/*
-----------------------------------
Time Complexity: O(N)
-----------------------------------
N = number of nodes in the tree

Each node is visited exactly once during DFS traversal.

-----------------------------------
Space Complexity: O(H)
-----------------------------------
H = height of the binary tree

The recursion stack will store at most H function calls.

Best Case (balanced tree): O(log N)
Worst Case (skewed tree): O(N)
-----------------------------------
*/