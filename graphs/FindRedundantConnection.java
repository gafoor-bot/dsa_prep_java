/* Link:https://neetcode.io/problems/redundant-connection/question?list=neetcode150
 * Problem: Find the redundant connection in an undirected graph.
 * A redundant connection is an edge that, if removed, leaves the graph as a tree.
 * 
 * Approach: 
 * - Use DFS to check if adding an edge would create a cycle.
 * - If DFS finds that the second node is already reachable from the first, 
 *   the edge is redundant.
 * 
 * Time Complexity: O(n^2) in worst case
 *   - For each edge, DFS may traverse all nodes in the graph.
 *   - n = number of nodes (equal to edges.length)
 * 
 * Space Complexity: O(n^2)
 *   - Adjacency list stores all edges → O(n + e) ~ O(n^2 in worst case)
 *   - DFS recursion stack + visited set → O(n)
 */

import java.util.*;

class Solution {

    public int[] findRedundantConnection(int[][] edges) {
        // Adjacency list to represent the graph (1-indexed nodes)
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= edges.length; i++) {  // nodes 1..n
            adj.add(new ArrayList<>());
        }

        // Iterate through all edges
        for (int[] edge : edges) {
            Set<Integer> visit = new HashSet<>(); // visited nodes for DFS
            int u = edge[0], v = edge[1];

            // If v is already reachable from u → this edge forms a cycle → redundant
            if (dfs(adj, u, v, -1, visit)) {
                return edge;
            }

            // Otherwise, safely add the edge to adjacency list
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        // Default return (not reached for valid inputs)
        return new int[0];
    }

    /**
     * DFS helper function to check if `target` is reachable from `node`
     * 
     * @param adj Adjacency list of the graph
     * @param node Current node being visited
     * @param target Node we want to reach
     * @param parent Parent node to avoid trivial backtracking
     * @param visit Set of already visited nodes
     * @return true if target is reachable from node, false otherwise
     */
    private boolean dfs(List<List<Integer>> adj, int node, int target, int parent, Set<Integer> visit) {
        // Base case: target reached
        if (node == target) return true;

        visit.add(node); // mark current node as visited

        // Explore all neighbors
        for (int nei : adj.get(node)) {
            // Skip visited neighbors
            if (!visit.contains(nei)) {
                if (dfs(adj, nei, target, node, visit)) {
                    return true; // path to target found
                }
            }
        }

        return false; // target not reachable from this path
    }
}
