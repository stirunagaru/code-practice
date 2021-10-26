package LinkedList;

import programs.ListNode;

public class AddTwoNumberII {
	 public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
	        ListNode curr1 = l1, curr2 = l2;
	        int n1 = 0, n2 = 0;
	        while (curr1 != null) {
	            curr1 = curr1.next; 
	            ++n1;    
	        }
	        while (curr2 != null) {
	            curr2 = curr2.next; 
	            ++n2;    
	        }
	        
	        curr1 = l1; 
	        curr2 = l2;
	        ListNode head = null;
	        while (n1 > 0 && n2 > 0) {
	            int val = 0;
	            if(n1 > n2) {
	                val += curr1.val;
	                curr1 = curr1.next; 
	                n1--;
	            } else if(n1 < n2) {
	                val += curr2.val;
	                curr2 = curr2.next;
	                n2--;
	            } else if(n1 == n2) {
	                val = curr1.val + curr2.val;
	                curr1 = curr1.next;
	                curr2 = curr2.next;
	                n1--; n2--;
	            }
	            ListNode curr = new ListNode(val);
	            curr.next = head;
	            head = curr;
	        }
	        
	        curr1 = head;
	        int carry = 0;
	        head = null;
	        while(curr1 != null) {
	            ListNode temp = new ListNode((curr1.val + carry) % 10);
	            temp.next = head;
	            head = temp;
	            carry = (curr1.val + carry) / 10;
	            
	            curr1 = curr1.next;
	        }
	        
	        if(carry != 0) {
	            ListNode temp = new ListNode(carry);
	            temp.next = head;
	            head = temp;
	        }
	        
	        return head;
	    }
	    
	    
	    
	    
	// n1:     7  2  4  3
//	               2
	// n2:     -  5  6  4
//	            3

	// head:   7  8  10 7  
	    
	// ac: 7  8  0  7
	    
//	     7
	    
	    
	    public ListNode addTwoNumbersWithReverseInputs(ListNode l1, ListNode l2) {
	        ListNode rL1 = reverseNodes(l1);
	        ListNode rL2 = reverseNodes(l2);
	        ListNode temp = new ListNode(-1);
	        ListNode add = temp;
	        int carry = 0;
	        while(rL1 != null && rL2 != null) {
	            carry = carry + rL1.val + rL2.val;
	            add.next = new ListNode(carry%10);
	            add = add.next;
	            carry = carry/10;
	            
	            rL1 = rL1.next;
	            rL2 = rL2.next;
	        }
	        
	        if(rL1 == null) { // l2 is big
	            while(rL2 != null) {
	                carry = carry + rL2.val;
	                add.next = new ListNode(carry%10);
	                add = add.next;
	                carry = carry/10;
	                rL2 = rL2.next;
	            }  
	        } else {
	            while(rL1 != null) {
	                carry = carry + rL1.val;
	                add.next = new ListNode(carry%10);
	                add = add.next;
	                carry = carry/10;

	                rL1 = rL1.next;
	            }
	        }
	        if(carry > 0)
	            add.next = new ListNode(carry);
	        return reverseNodes(temp.next);
	    }
	    
	    
	    ListNode reverseNodes(ListNode head) {
	        ListNode prev = null;
	        while(head != null) {
	            ListNode temp = head.next;
	            head.next = prev;
	            prev = head;
	            head = temp;
	        }
	        return prev;
	    }
}
