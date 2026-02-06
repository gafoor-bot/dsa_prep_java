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

    /* Link: https://neetcode.io/problems/merge-k-sorted-linked-lists/history
     * Merges k sorted linked lists into one sorted list.
     * The lists are merged one by one using merge-two-lists logic.
     */
    public ListNode mergeKLists(ListNode[] lists) {

        // Edge case: if no lists are provided
        if (lists == null || lists.length == 0) {
            return null;
        }

        // Iteratively merge lists:
        // merge list[0] with list[1],
        // then merge the result with list[2], and so on
        for (int i = 1; i < lists.length; i++) {
            lists[i] = merge(lists[i], lists[i - 1]);
        }

        // Final merged list will be stored in the last index
        return lists[lists.length - 1];
    }

    /**
     * Merges two sorted linked lists into one sorted list.
     * This is done in-place by rearranging existing node pointers.
     */
    private ListNode merge(ListNode l1, ListNode l2) {

        // Dummy node to simplify edge cases
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        // Traverse both lists and attach the smaller node each time
        while (l1 != null && l2 != null) {

            if (l1.val <= l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }

            // Move the current pointer forward
            curr = curr.next;
        }

        // Attach the remaining nodes (only one of l1 or l2 will be non-null)
        if (l1 != null) {
            curr.next = l1;
        } else {
            curr.next = l2;
        }

        // Return the merged list (skipping the dummy node)
        return dummy.next;
    }
}
