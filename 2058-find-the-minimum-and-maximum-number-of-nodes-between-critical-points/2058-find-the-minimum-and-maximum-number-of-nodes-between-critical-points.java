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
    public int[] nodesBetweenCriticalPoints(ListNode head) {

        int first = -1;
        int prev = -1;

        int min = Integer.MAX_VALUE;
        int max = -1;

        int pos = 1;

        ListNode curr = head.next;
        ListNode before = head;

        while (curr.next != null) {

            int prevVal = before.val;
            int currVal = curr.val;
            int nextVal = curr.next.val;

            boolean critical =
                (currVal > prevVal && currVal > nextVal) ||
                (currVal < prevVal && currVal < nextVal);

            if (critical) {

                if (first == -1) {
                    // First critical point
                    first = pos;
                } else {
                    // Distance from previous critical point
                    min = Math.min(min, pos - prev);

                    // Distance from first critical point
                    max = Math.max(max, pos - first);
                }

                prev = pos;
            }

            before = curr;
            curr = curr.next;
            pos++;
        }

        if (first == -1 || prev == first) {
            return new int[]{-1, -1};
        }

        return new int[]{min, max};
    }
}