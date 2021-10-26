package LinkedList;

import programs.ListNode;

public class PartitionLLByX {
    public ListNode partition(ListNode head, int x) {
        
        ListNode smallNext = new ListNode(0);
        ListNode bigNext = new ListNode(0);
        ListNode small = smallNext;
        ListNode big = bigNext;
        
        while(head != null) {
            if(head.val < x) {
                smallNext.next = head;
                smallNext = smallNext.next;
            } else {
                bigNext.next = head;
                bigNext = bigNext.next;
            }
            head = head.next;
        }
        bigNext.next = null;
        smallNext.next = big.next;
        return small.next;
        
    }
}
