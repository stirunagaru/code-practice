package designquestions;

import java.util.HashMap;
import java.util.Map;
//https://leetcode.com/problems/lru-cache/submissions/
//["LRUCache","put","put","get","put","get","put","get","get","get"]
//[[2],[1,1],[2,2],[1],[3,3],[2],[4,4],[1],[3],[4]]
//Expected : [null,null,null,1,null,-1,null,-1,3,4]
public class LRUCache {
	    private Map<Integer, DLL> cache = new HashMap<>();
	    private int capacity;
	    private DLL head, tail;
	    
	    public LRUCache(int capacity) {
	        head = new DLL();
	        tail = new DLL();
	        head.next = tail; tail.prev = head;
	        this.capacity = capacity;
	    }
	    
	    public int get(int key) {
	        DLL node = cache.get(key);
	        if(node == null) return -1;
	        removeNode(node);
	        addNode(node);
	        return node.value;
	    }
	    
	    public void put(int key, int value) {
	        
	        DLL node = cache.get(key);
	        if(node == null) {
	            // add the value
	            DLL n = new DLL(key, value);
	            addNode(n);
	            cache.put(key, n);
	            if(cache.size() > capacity){
	                cache.remove(head.next.key);
	                removeNode(head.next);
	            }
	        } else {
	            //update the existing value and move to the tail
	            node.value = value;
	            removeNode(node); addNode(node);
	        }
	    }
	    
	  class DLL {
	    int key;
	    int value;
	    DLL prev;
	    DLL next;
	    public DLL() {}
	    public DLL(int key, int value) {this.key = key; this.value = value;}
	  }
	    
	  //adding at the tail  
	  void addNode(DLL node) {
	      node.prev = tail.prev;
	      node.next = tail;
	      
	      tail.prev.next = node; 
	      tail.prev = node;
	  }
	   
	  //remove node - inorder or to maintain access order, we need to remove and add it again at the tail to maintain order
	  void removeNode(DLL node) {
	      node.prev.next = node.next; 
	      node.next.prev = node.prev;
	  }
}
