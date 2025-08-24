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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode res = new ListNode(0);
        res.next = head;
        ListNode prev = res;
        ListNode node = res;
        for (int i = 0; i <= n; i++) {
            node = node.next;
        }
        while (node != null) {
            node = node.next;
            prev = prev.next;
        }
        prev.next = prev.next.next;
        return res.next;
    }
}