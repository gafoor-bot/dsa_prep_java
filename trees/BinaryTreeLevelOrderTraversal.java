/* Link: https://neetcode.io/problems/level-order-traversal-of-binary-tree/question
 * Binary Tree Level Order Traversal (BFS)
 *
 * Approach:
 * We use a Queue to perform Breadth First Search (BFS).
 * Each iteration processes one level of the tree.
 * The size of the queue at the start of the loop represents
 * the number of nodes at the current level.
 *
 * Time Complexity: O(N)
 * - Every node in the tree is visited exactly once.
 *
 * Space Complexity: O(N)
 * - Queue can store up to N nodes in the worst case (last level of the tree).
 * - Output list also stores N elements.
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

    // Final result list storing nodes level by level
    List<List<Integer>> list = new ArrayList<>();

    public List<List<Integer>> levelOrder(TreeNode root) {

        // Edge case: if tree is empty return empty list
        if (root == null) return list;

        // Queue used for BFS traversal
        Queue<TreeNode> q = new LinkedList<>();

        // Add root node to start traversal
        q.add(root);

        // Continue until all nodes are processed
        while (!q.isEmpty()) {

            // List to store values of current level
            List<Integer> li = new ArrayList<>();

            // Number of nodes at current level
            int n = q.size();

            // Process all nodes of the current level
            for (int i = 0; i < n; i++) {

                // Remove node from queue
                TreeNode temp = q.remove();

                // Add left child to queue if it exists
                if (temp.left != null) {
                    q.add(temp.left);
                }

                // Add right child to queue if it exists
                if (temp.right != null) {
                    q.add(temp.right);
                }

                // Add current node value to level list
                li.add(temp.val);
            }

            // Add current level list to final result
            list.add(li);
        }

        // Return level order traversal
        return list;
    }
}