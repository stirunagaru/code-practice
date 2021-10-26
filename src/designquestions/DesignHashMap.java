package designquestions;
//https://leetcode.com/problems/design-hashmap/
public class DesignHashMap {
	    class Bucket {
	        int key;
	        int value;
	        Bucket next;
	         Bucket(int k, int v, Bucket n) {
	            this.key = k;
	            this.value = v;
	            this.next = n;
	        }
	    }
	    
	    Bucket[] hashMap;
	    int mapSize;

	    /** Initialize your data structure here. */
	    public DesignHashMap() {
	        mapSize = 10000;
	        hashMap = new Bucket[mapSize];
	    }
	        
	    public void put(int key, int value) {
	        int hashKey = key % this.mapSize;
	        Bucket node = findBucket(hashMap[hashKey], key);
	        if( node == null) {
	            hashMap[hashKey] = new Bucket(key, value, hashMap[hashKey]);
	        } else {
	            node.value = value;
	        }
	    }
	    
	    public int get(int key) {
	        int hashKey = key%this.mapSize;
	        Bucket node = findBucket(hashMap[hashKey], key);        
	        return node == null ?  -1 : node.value;
	    }
	    
	    public void remove(int key) {
	        int hashKey = key%this.mapSize;
	        hashMap[hashKey] = removeBucket(hashMap[hashKey], key);        
	    }
	    
	    Bucket findBucket(Bucket buck, int key) {
	        if(buck == null) return null;
	        if(buck.key == key) return buck;
	        return findBucket(buck.next, key);
//	         Bucket node = buck; Bucket previous = null; while(node != null && node.key != key) { previous = node; node = node.next; } return previous;
	   }
	    
	    Bucket removeBucket(Bucket node, int key) {
	        if(node == null) return null;
	        if(node.key == key) return node.next;
	        node.next = removeBucket(node.next, key);
	        return node;
	    }
	}
