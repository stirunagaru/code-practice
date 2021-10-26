package designquestions;

import java.util.HashMap;
import java.util.Map;

public class FirstUniqueDLL {
	
	    Map<Integer, DLL> unique =  new HashMap<>();
	    DLL head, tail;
	    
	    public FirstUniqueDLL(int[] nums) {
	        head = new DLL(-1);
	        tail = new DLL(-1);

	        head.next = tail;
	        tail.prev = head;
	        
	        for(int i : nums) 
	            add(i);
	    }
	    
	     public void add(int value) {
	         if(unique.containsKey(value)) {
	             remove(unique.get(value));
	         } else {
	             DLL node = new DLL(value);
	             unique.put(value, node);
	             insertDLL(node);
	         }
	     }
	    
	    void insertDLL(DLL node) {
	        DLL last = tail.prev;
	        last.next = node;
	        node.prev = last;
	        node.next = tail;
	        tail.prev = node;
	    }
	    
	    void remove(DLL node) {
	        if(node.prev == null && node.next == null) // allready removed 
	            return;
	        
	        node.prev.next = node.next;
	        node.next.prev = node.prev;
	        
	        node.prev = null;
	        node.next = null;
	    }
	    
	    
	    
	    public int showFirstUnique() {
	        return head.next == tail ? -1 : head.next.value;
	    
	    }

	    class DLL {
	        int value;
	        DLL prev;
	        DLL next;
	        public DLL(int val) {
	            this.value = val;
	        }
	    }
	}

	/**
	 * Your FirstUnique object will be instantiated and called as such:
	 * FirstUnique obj = new FirstUnique(nums);
	 * int param_1 = obj.showFirstUnique();
	 * obj.add(value);
	 */
