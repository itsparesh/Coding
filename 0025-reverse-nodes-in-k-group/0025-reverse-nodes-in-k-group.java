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
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) return head;

        ListNode res = new ListNode(0);
        res.next = head;
        ListNode prevGroupEnd = res;
        ListNode prevGroupStart = head;
        
        while (true) {
            ListNode kthNode = prevGroupEnd;
            for (int i = 0; i < k && kthNode != null; i++) {
                kthNode = kthNode.next;
            }

            if (kthNode == null) break;

            ListNode nextGroupStart = kthNode.next;
            ListNode curr = prevGroupStart;
            ListNode prev = nextGroupStart;

            while (curr != nextGroupStart) {
                ListNode temp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = temp;
            }

            prevGroupEnd.next = kthNode;
            prevGroupEnd = prevGroupStart;
            prevGroupStart = nextGroupStart;
        }
        return res.next;
    }
}