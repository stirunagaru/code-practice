package programs;

public class RotateLL {
	public ListNode rotateRight(ListNode head, int k) {
        
        if (head == null || head.next == null || k == 0) return head;
      
      ListNode old = head; int n;
      for(n=1; old.next != null; n++) 
          old = old.next;
      
      if(n == k) return head;
      
      old.next = head; //cll
      
      ListNode new_tail = head;
      for (int i = 0; i < n - k % n - 1; i++)
        new_tail = new_tail.next;
      ListNode new_head = new_tail.next;

      // break the ring
      new_tail.next = null;

      return new_head;
      
       
  }

}
