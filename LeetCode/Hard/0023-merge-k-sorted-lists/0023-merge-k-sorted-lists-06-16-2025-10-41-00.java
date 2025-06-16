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
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        Queue<ListNode> minHeap = new PriorityQueue<> (Comparator.comparingInt(node -> node.val));

        for(ListNode x : lists){
            if(x != null){
                minHeap.offer(x);
            }
        }

        while(!minHeap.isEmpty()){
            ListNode node = minHeap.poll();
                curr.next = node;
                curr = curr.next;
                if(node.next != null){
            minHeap.offer(node.next);
        }
        }
        return dummy.next;
    }
}