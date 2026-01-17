public class Solution {
     // Link: https://neetcode.io/problems/course-schedule/question?list=neetcode150
    // Map: course -> list of its prerequisites
    // Example: 0 -> [1, 3]
    private Map<Integer, List<Integer>> preMap = new HashMap<>();

    // Set to store courses in the CURRENT DFS path
    // Used to detect cycles
    private Set<Integer> visiting = new HashSet<>();

    /*
     * TIME COMPLEXITY:
     * O(numCourses + prerequisites.length)
     * Each course and prerequisite edge is visited once in DFS
     *
     * SPACE COMPLEXITY:
     * O(numCourses + prerequisites.length)
     * - Graph storage (preMap)
     * - DFS recursion stack
     * - Visiting set
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        // Initialize graph with empty prerequisite lists
        for (int i = 0; i < numCourses; i++) {
            preMap.put(i, new ArrayList<>());
        }

        // Build the graph
        // prereq[0] depends on prereq[1]
        for (int[] prereq : prerequisites) {
            preMap.get(prereq[0]).add(prereq[1]);
        }

        // Run DFS on every course
        // (Graph may be disconnected)
        for (int c = 0; c < numCourses; c++) {
            if (!dfs(c)) {
                return false; // cycle found
            }
        }

        return true; // no cycle found
    }

    // DFS helper to detect cycle
    private boolean dfs(int crs) {

        // If course is already in current DFS path,
        // we found a cycle
        if (visiting.contains(crs)) {
            return false;
        }

        // If course has no prerequisites,
        // it can be completed
        if (preMap.get(crs).isEmpty()) {
            return true;
        }

        // Mark this course as being visited
        visiting.add(crs);

        // Visit all prerequisites
        for (int pre : preMap.get(crs)) {
            if (!dfs(pre)) {
                return false; // cycle detected
            }
        }

        // Remove course from current DFS path
        // (backtracking step)
        visiting.remove(crs);

        return true;
    }
}
