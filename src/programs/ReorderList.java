package programs;

public class ReorderList {
public void reorderList(ListNode head) {
        
        //find middle
        ListNode slow = head, fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        // reverse from middle
        ListNode prev = null, current = slow;
        while(current != null) {
            ListNode temp = current.next;
            current.next = prev;
            prev = current; 
            current = temp;
        }
        
        ListNode first = head;
        while(prev.next != null) {
            ListNode temp = first.next;
            first.next = prev;
            first = temp;
            
            temp = prev.next;
            prev.next = first;
            prev = temp;
        }  
    }
}
