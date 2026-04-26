//Link: https://neetcode.io/problems/reconstruct-flight-path/question
class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {

        Map<String, PriorityQueue<String>> adj = new HashMap<>();

        // Build graph
        for (List<String> e : tickets) {
            String from = e.get(0);
            String to = e.get(1);
            adj.computeIfAbsent(from, k -> new PriorityQueue<>()).add(to);
        }

        LinkedList<String> res = new LinkedList<>();
        Stack<String> st = new Stack<>();
        st.push("JFK");

        while (!st.isEmpty()) {
            String curr = st.peek();

            if (!adj.containsKey(curr) || adj.get(curr).isEmpty()) {
                res.addFirst(st.pop());
            } else {
                st.push(adj.get(curr).poll());
            }
        }

        return res;
    }
}