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
        ListNode result = new ListNode(0);
        ListNode curr = result;

        while (true) {
            int minNode = -1;
            for (int i = 0; i < lists.length; i++) {
                if (lists[i] == null)
                    continue;
                if (minNode == -1 || lists[minNode].val > lists[i].val)
                    minNode = i;
            }
                if (minNode == -1)
                    break;
                curr.next = lists[minNode];
                curr = curr.next;
                lists[minNode] = lists[minNode].next;
            
        }
        return result.next;
    }
}
