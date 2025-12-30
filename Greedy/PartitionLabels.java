class Solution {

    /* Link: https://neetcode.io/problems/partition-labels/question?list=neetcode150
     * Time Complexity: O(n)
     * - First loop builds the last occurrence map → O(n)
     * - Second loop creates partitions → O(n)
     *
     * Space Complexity: O(1)
     * - HashMap stores at most 26 lowercase English letters
     * - Output list is required and does not count toward extra space
     */

    public List<Integer> partitionLabels(String s) {

        Map<Character, Integer> map = new HashMap<>();
        ArrayList<Integer> li = new ArrayList<>();

        // Store last occurrence index of each character
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), i);
        }

        int size = 0;
        int end = 0;

        // Traverse the string to form partitions
        for (int i = 0; i < s.length(); i++) {
            size++;
            end = Math.max(end, map.get(s.charAt(i)));

            // When current index reaches partition end
            if (i == end) {
                li.add(size);
                size = 0;
            }
        }

        return li;
    }
}
