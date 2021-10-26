package designquestions;

import java.util.HashMap;
import java.util.Map;

public class LFUCache {
//	https://leetcode.com/problems/lfu-cache/submissions/
	    Map<Integer, DLL> frequencies; //counts and nodes associated to it.
	    Map<Integer, Link> cache;
	    int capacity;
	    int minFeq;
	    

	    public LFUCache(int capacity) {
	        cache =  new HashMap<>(capacity);
	        frequencies =  new HashMap<>(capacity);
	        this.capacity = capacity;
	   }
	    
	    public int get(int key) {
	        if(cache.get(key) == null) return -1; // if not present send -1
	        
	        Link node = cache.get(key);
	        updateDLL(node);
	        
	        return node.value;
	    }
	    
	   void updateDLL(Link link) {
	        DLL feqList = frequencies.get(link.count);
	        feqList.removeNode(link);
	        
	        if(link.count == minFeq && feqList.size == 0) minFeq++; 
	        
	        link.count++;
	        DLL newFeq = frequencies.getOrDefault(link.count, new DLL());
	        newFeq.addNode(link);
	        frequencies.put(link.count, newFeq);
	    }
	    
	    public void put(int key, int value) {
	        if(capacity == 0) return;
	        
	        Link node = cache.get(key);
	        if(node == null) { // not present
	            if (cache.size() == capacity) {
	                DLL lastList = frequencies.get(minFeq);
	                Link lru = lastList.head.next;
	                cache.remove(lru.key);
	                lastList.removeNode(lru);
	            }

	           
	            Link newNode = new Link(key, value);
	            minFeq = newNode.count;
	            
	            DLL newList = frequencies.getOrDefault(newNode.count, new DLL());
	            newList.addNode(newNode);
	            frequencies.put(newNode.count, newList);
	            cache.put(key, newNode);
	        } else { // already present so, update the value
	            node.value = value;
	            updateDLL(node);
	        }
	    }
	    
	    class Link {
	        int key;
	        int value;
	        int count;
	        Link prev, next;
	        Link(int key, int val) {
	            this.key = key;
	            this.value = val;
	            this.count = 1;
	        }
	    }
	    
	    class DLL {
	        Link head;
	        Link tail;
	        int size;
	        DLL() {
	            head = new Link(0, 0);
	            tail = new Link(0, 0);
	            head.next = tail;
	            tail.prev = head;
	        }
	        
	        void addNode(Link node) { // add at the tail
	            node.prev = tail.prev;
	            node.next = tail;
	            tail.prev.next = node;
	            tail.prev = node;
	            size++;
	        }
	        
	        void removeNode(Link node) { // remove from head
	            node.prev.next = node.next; 
	            node.next.prev = node.prev;
	            size--;
	        }
	    }
	    
	}
