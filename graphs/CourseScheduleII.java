class Solution {
    // Link: https://neetcode.io/problems/course-schedule-ii/history
    // List to store the final course order (topological order)
    List<Integer> result = new ArrayList<>();
    
    // Adjacency list representing the graph: course -> list of prerequisites
    Map<Integer, List<Integer>> course = new HashMap<>();
    
    // Set to track nodes currently in the DFS path (for cycle detection)
    Set<Integer> visiting = new HashSet<>();
    
    // Set to track nodes that have been fully processed (to avoid duplicate work)
    Set<Integer> visited = new HashSet<>();
    
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // Step 1: Build the graph
        for (int i = 0; i < numCourses; i++)
            course.put(i, new ArrayList<>());
        
        for (int[] pre : prerequisites)
            course.get(pre[0]).add(pre[1]);
        
        // Step 2: Run DFS for each course
        for (int i = 0; i < numCourses; i++)
            if (!dfs(i)) // cycle detected → cannot finish all courses
                return new int[0];
        
        // Step 3: Convert the result list to an array
        int[] result1 = new int[result.size()];
        for (int i = 0; i < result.size(); i++)
            result1[i] = result.get(i);
        
        return result1;
    }
    
    // DFS function to process course 'crs'
    public boolean dfs(int crs) {
        // If this course has already been processed, no need to do DFS again
        if (visited.contains(crs)) return true;
        
        // If this course is currently in the DFS path → cycle detected
        if (visiting.contains(crs)) return false;
        
        // Mark this course as visiting
        visiting.add(crs);
        
        // Recursively DFS all prerequisites of this course
        for (int pre : course.get(crs))
            if (!dfs(pre)) return false; // if any prerequisite has a cycle, stop
        
        // DFS finished for this course → remove from current path (backtracking)
        visiting.remove(crs);
        
        // Mark this course as fully processed
        visited.add(crs);
        
        // Add this course to the result (topological order)
        result.add(crs);
        
        return true; // successfully processed
    }
    
    /*
    Time Complexity:
    - Building the graph: O(P) where P = prerequisites.length
    - DFS traversal: O(V + E), V = numCourses, E = number of edges in graph (prerequisites)
        * Each course is processed once (visited set prevents revisiting)
        * Each edge is explored once
    Total: O(V + E)

    Space Complexity:
    - Graph adjacency list: O(V + E)
    - Result list: O(V)
    - Visiting set (DFS path): O(V) in worst case recursion
    - Visited set: O(V)
    - Recursion stack: O(V) in worst case
    Total: O(V + E)
    */
}
