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

public class Codec {

    /**
     * Encodes a binary tree to a single string using BFS (level-order traversal).
     *
     * Approach:
     * - Use a queue to traverse the tree level by level.
     * - Append node values to the string.
     * - Use "N" to represent null nodes.
     *
     * Time Complexity: O(n)
     * - We visit each node exactly once.
     *
     * Space Complexity: O(n)
     * - Queue stores nodes for BFS.
     * - Output string also stores all nodes.
     */
    public String serialize(TreeNode root) {
        // Base case: empty tree
        if (root == null) return "N";

        StringBuilder res = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        // Perform BFS traversal
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            if (node == null) {
                // Mark null nodes
                res.append("N,");
            } else {
                // Append current node value
                res.append(node.val).append(",");

                // Add children to queue (even if null)
                queue.add(node.left);
                queue.add(node.right);
            }
        }

        return res.toString();
    }

    /**
     * Decodes the encoded string back to a binary tree.
     *
     * Approach:
     * - Split the string by commas.
     * - Reconstruct the tree using BFS.
     * - Use a queue to assign left and right children.
     *
     * Time Complexity: O(n)
     * - Each node is processed once.
     *
     * Space Complexity: O(n)
     * - Queue stores nodes during reconstruction.
     */
    public TreeNode deserialize(String data) {
        String[] vals = data.split(",");

        // Base case: empty tree
        if (vals[0].equals("N")) return null;

        // Create root node
        TreeNode root = new TreeNode(Integer.parseInt(vals[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int index = 1;

        // Reconstruct tree using BFS
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            // Process left child
            if (!vals[index].equals("N")) {
                node.left = new TreeNode(Integer.parseInt(vals[index]));
                queue.add(node.left);
            }
            index++;

            // Process right child
            if (!vals[index].equals("N")) {
                node.right = new TreeNode(Integer.parseInt(vals[index]));
                queue.add(node.right);
            }
            index++;
        }

        return root;
    }
}