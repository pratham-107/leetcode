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
    public ListNode insertionSortList(ListNode head) {
        ListNode dummyHead = new ListNode(0);
        ListNode curr = head;

        while(curr != null){
            ListNode prev = dummyHead;
            ListNode next = dummyHead.next;

            while(next != null && curr.val > next.val){
                prev = next;
                next = next.next;
            }

            ListNode temp = curr.next;
            curr.next = next;
            prev.next = curr;
            curr = temp;
        }
        return dummyHead.next;
    }
}