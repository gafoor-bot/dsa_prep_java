/*Link: https://neetcode.io/problems/binary-tree-right-side-view/question
 * Binary Tree Right Side View
 *
 * Approach:
 * We use Breadth First Search (Level Order Traversal).
 * At every level, we traverse all nodes but keep updating a variable
 * called "rightSide". The last node encountered at that level will
 * represent the rightmost node visible from the right side.
 *
 * After finishing the level, we add that node's value to the result list.
 *
 * Time Complexity: O(N)
 * Each node in the tree is processed exactly once.
 *
 * Space Complexity: O(N)
 * The queue can contain up to N nodes in the worst case (wide tree).
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

    public List<Integer> rightSideView(TreeNode root) {

        // List to store the final right side view
        List<Integer> res = new ArrayList<>();

        // Queue used for level order traversal (BFS)
        Queue<TreeNode> q = new LinkedList<>();

        // Start with root node
        q.offer(root);

        // Continue traversal until queue becomes empty
        while (!q.isEmpty()) {

            // Variable to store the rightmost node of current level
            TreeNode rightSide = null;

            // Number of nodes at the current level
            int qLen = q.size();

            // Traverse all nodes in this level
            for (int i = 0; i < qLen; i++) {

                // Remove node from queue
                TreeNode node = q.poll();

                // If node is not null
                if (node != null) {

                    // Update rightSide to current node
                    // The last node processed will be the rightmost node
                    rightSide = node;

                    // Add left child to queue
                    q.offer(node.left);

                    // Add right child to queue
                    q.offer(node.right);
                }
            }

            // After finishing this level,
            // add the rightmost node value to result
            if (rightSide != null) {
                res.add(rightSide.val);
            }
        }

        // Return the final right side view list
        return res;
    }
}