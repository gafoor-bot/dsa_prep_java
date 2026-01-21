public class Solution {
     // Link: https://neetcode.io/problems/count-connected-components/question?list=neetcode150
    // Counts the number of connected components in an undirected graph
    public int countComponents(int n, int[][] edges) {

        // Adjacency list to represent the graph
        List<List<Integer>> adj = new ArrayList<>();

        // Visited array to track explored nodes
        boolean[] visit = new boolean[n];

        // Initialize adjacency list for each node
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        // Build the graph from the edge list (undirected graph)
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        int res = 0; // Stores number of connected components

        // Traverse all nodes
        for (int node = 0; node < n; node++) {
            // If node has not been visited, it starts a new connected component
            if (!visit[node]) {
                dfs(adj, visit, node);
                res++; // Increment count after completing DFS for one component
            }
        }

        return res;
    }

    // Depth First Search to explore all nodes in the same connected component
    private void dfs(List<List<Integer>> adj, boolean[] visit, int node) {

        // Mark current node as visited
        visit[node] = true;

        // Explore all adjacent neighbors
        for (int nei : adj.get(node)) {
            // If neighbor is not visited, continue DFS
            if (!visit[nei]) {
                dfs(adj, visit, nei);
            }
        }
    }

    /*
     * Time Complexity:
     * - Building adjacency list: O(n + e)
     * - DFS traversal: O(n + e)
     * Overall Time Complexity: O(n + e)
     * where n = number of nodes, e = number of edges
     *
     * Space Complexity:
     * - Adjacency list: O(n + e)
     * - Visited array: O(n)
     * - Recursion stack (DFS): O(n) in worst case
     * Overall Space Complexity: O(n + e)
     */
}
