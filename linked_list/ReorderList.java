/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;          // Value stored in the node
 *     ListNode next;    // Pointer to the next node
 *
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) {
 *         this.val = val;
 *         this.next = next;
 *     }
 * }
 */

class Solution {

    /**
     * Reorders a singly linked list in-place.
     *
     * Example:
     * Input:  1 -> 2 -> 3 -> 4
     * Output: 1 -> 4 -> 2 -> 3
     *
     * Approach:
     * 1. Find the middle of the list using slow & fast pointers.
     * 2. Reverse the second half of the list.
     * 3. Merge the two halves alternately.
     *
     * Time Complexity: O(n)
     * - Each node is visited a constant number of times.
     *
     * Space Complexity: O(1)
     * - Reordering is done in-place without extra memory.
     */
    public void reorderList(ListNode head) {

        // Edge case: empty list or single node
        if (head == null || head.next == null) return;

        // Step 1: Find the middle of the list
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;          // Move one step
            fast = fast.next.next;    // Move two steps
        }

        // Step 2: Reverse the second half
        ListNode second = slow.next;
        slow.next = null;  // Split the list into two halves
        ListNode prev = null;

        while (second != null) {
            ListNode next = second.next;
            second.next = prev;
            prev = second;
            second = next;
        }

        // Step 3: Merge the two halves
        ListNode first = head;
        second = prev;

        while (second != null) {
            ListNode t1 = first.next;
            ListNode t2 = second.next;

            first.next = second;
            second.next = t1;

            first = t1;
            second = t2;
        }
    }
}
