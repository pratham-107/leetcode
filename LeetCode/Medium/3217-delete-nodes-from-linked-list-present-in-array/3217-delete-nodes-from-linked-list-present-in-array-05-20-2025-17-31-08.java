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
    public ListNode modifiedList(int[] nums, ListNode head) {
        ListNode dummy = new ListNode(0, head);
        Set<Integer> s = Arrays.stream(nums).boxed().collect(Collectors.toSet());

        for(ListNode curr = dummy; curr.next != null;){
            if(s.contains(curr.next.val)){
                curr.next = curr.next.next;
            }
            else{
                curr = curr.next;
            }
        }
        return dummy.next;
    }
}