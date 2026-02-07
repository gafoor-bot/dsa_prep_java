/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {

    /* Link: https://neetcode.io/problems/reverse-nodes-in-k-group/question
     * Reverses nodes of the linked list in groups of size k.
     * If the number of nodes is not a multiple of k,
     * the remaining nodes at the end are left as-is.
     *
     * Time Complexity: O(N)
     *   - Each node is visited and reversed exactly once.
     *
     * Space Complexity: O(1)
     *   - Reversal is done in-place using constant extra pointers.
     */
    public ListNode reverseKGroup(ListNode head, int k) {

        // Edge case: empty list
        if (head == null) return null;

        // Dummy node to simplify head handling
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        // Pointers to track k-sized groups
        ListNode slow = head;
        ListNode fast = head;
        ListNode next = head;

        int count = 1;

        // Traverse the list using fast pointer
        while (fast != null) {

            // When k nodes are found
            if (count == k) {

                // Save the next group start
                next = fast.next;

                // Temporarily break the list
                fast.next = null;

                // Reverse current k-group and attach to result
                curr.next = reverse(slow);

                // Move curr to the end of the reversed group
                while (curr.next != null) {
                    curr = curr.next;
                }

                // Reset pointers for next group
                slow = next;
                fast = next;
                count = 1;
            } 
            else {
                fast = fast.next;
                count++;
            }
        }

        // Attach remaining nodes (less than k, not reversed)
        if (curr != slow) {
            curr.next = slow;
        }

        return dummy.next;
    }

    /**
     * Reverses a singly linked list.
     *
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     */
    private ListNode reverse(ListNode head) {

        ListNode prev = null;
        ListNode curr = head;

        // Standard iterative linked list reversal
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }
}
