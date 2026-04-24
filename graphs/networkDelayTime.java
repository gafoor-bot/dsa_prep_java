
//Link: https://neetcode.io/problems/network-delay-time/history?list=neetcode150&submissionIndex=0
class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {

        HashMap<Integer, List<int[]>> graph = new HashMap<>();

        // Build graph
        for (int[] time : times) {
            if (!graph.containsKey(time[0])) {
                graph.put(time[0], new ArrayList<>());
            }
            graph.get(time[0]).add(new int[]{time[1], time[2]});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[k] = 0;
        pq.offer(new int[]{0, k}); // start node

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int time = curr[0];
            int node = curr[1];

            if (time > dist[node]) continue;

            if (graph.containsKey(node)) {
                for (int[] nei : graph.get(node)) {
                    int nextNode = nei[0];
                    int travelTime = nei[1];

                    if (time + travelTime < dist[nextNode]) {
                        dist[nextNode] = time + travelTime;
                        pq.offer(new int[]{dist[nextNode], nextNode});
                    }
                }
            }
        }

        int max = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] == Integer.MAX_VALUE) return -1;
            max = Math.max(max, dist[i]);
        }

        return max;
    }
}