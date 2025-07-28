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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> queue = new PriorityQueue<>((a, b) -> a.val-b.val);
        for(ListNode listNode: lists) {
            while (listNode != null) {
                queue.add(listNode);
                listNode = listNode.next;
            }
        }

        ListNode res = new ListNode(0);
        ListNode temp = res;
        while (!queue.isEmpty()) {
            temp.next = queue.poll();
            temp = temp.next;
        }
        temp.next = null;
        return res.next;
    }
}