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
        if(head == null || head.next == null || head.next.next == null){
            return new int[]{-1, -1};
        }

        int firstCritical = -1;
        int prevCritical = -1;
        int minDist = Integer.MAX_VALUE;

        ListNode prev = head;
        ListNode curr = head.next;
        int index = 1;

        while(curr.next != null){
            ListNode next = curr.next;
            boolean isMaxima = curr.val > prev.val && curr.val > next.val;
            boolean isMinima = curr.val < prev.val && curr.val < next.val;

            if(isMaxima || isMinima){
                if(firstCritical == -1){
                    firstCritical = index;
                } else{
                    minDist = Math.min(minDist, index - prevCritical);
                }
                prevCritical = index;
            }

            prev = curr;
            curr = next;
            index++;
        }

        if(firstCritical == -1 || firstCritical == prevCritical){
            return new int[]{-1, -1};
        }

        int maxDist = prevCritical - firstCritical;
        return new int[]{minDist, maxDist};
    }
}