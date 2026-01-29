/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;          // Value of the node
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

    /* Link: https://neetcode.io/problems/linked-list-cycle-detection/history
     * Detects if a linked list has a cycle using Floyd’s Cycle Detection Algorithm
     * (also known as the Tortoise and Hare algorithm).
     *
     * Approach:
     * - Use two pointers:
     *   slow -> moves one step at a time
     *   fast -> moves two steps at a time
     * - If there is a cycle, fast and slow will eventually meet.
     * - If fast reaches null, the list does not contain a cycle.
     *
     * @param head The head of the linked list
     * @return true if a cycle exists, false otherwise
     *
     * Time Complexity: O(n)
     * - Each pointer traverses the list at most once.
     *
     * Space Complexity: O(1)
     * - Only constant extra space is used.
     */
    public boolean hasCycle(ListNode head) {
        // Initialize two pointers at the head
        ListNode slow = head;
        ListNode fast = head;

        // Traverse the list while fast and fast.next are not null
        while (fast != null && fast.next != null) {
            slow = slow.next;         // Move slow pointer by one step
            fast = fast.next.next;   // Move fast pointer by two steps

            // If slow and fast meet, a cycle exists
            if (slow == fast) {
                return true;
            }
        }

        // If fast reaches null, there is no cycle
        return false;
    }
}
