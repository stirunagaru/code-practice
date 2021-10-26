package designquestions;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
//https://leetcode.com/problems/all-oone-data-structure/

//Your input: 
//          ["AllOne","inc","inc","inc","inc","inc","inc","inc","inc","inc","inc","inc","inc","getMinKey"]
//          [[],["a"],["b"],["c"],["d"],["a"],["b"],["c"],["d"],["c"],["d"],["d"],["a"],[]]
//Output :    [null,null,null,null,null,null,null,null,null,null,null,null,null,"b"]
//Expected :  [null,null,null,null,null,null,null,null,null,null,null,null,null,"b"]
public class AllOoneDataStructure {
	DllNode head;
    DllNode tail;
    Map<String, DllNode> map;
    
    public AllOoneDataStructure() {
        head = new DllNode(-1);
        tail = new DllNode(-1);
        map = new HashMap<>();
        this.head.prev = tail;
        this.tail.next = head;
    }
    
    public void inc(String key) {
        if(map.containsKey(key)) {
            DllNode existNd = map.get(key);
            if(existNd.count+1 == existNd.next.count) {
                existNd.next.keys.add(key);
                map.put(key, existNd.next);
            } else {
                DllNode newNode = new DllNode(existNd.count + 1);
                newNode.keys.add(key);
                insertNode(existNd, newNode); //insertion to dll
                map.put(key, newNode);        // add to map
            }
            existNd.keys.remove(key);
            if(existNd.keys.isEmpty())
                deleteNode(existNd);
        } else { // count = 1
            if(tail.next.count == 1) {
                tail.next.keys.add(key);
                map.put(key, tail.next);
            } else {
                DllNode node = new DllNode(1);
                node.keys.add(key);
                insertNode(tail, node); //insertion to dll
                map.put(key, node); // add to map
            }
        }
        
    }
    
    public void dec(String key) {
        if(!map.containsKey(key)) return; //gaurenteed - not required check
        DllNode decNode = map.get(key);
        if(decNode.count == 1)
            map.remove(key);
        else if(decNode.count -1 == decNode.prev.count) {
            decNode.prev.keys.add(key);
            map.put(key, decNode.prev);
        } else {
            DllNode newNode = new DllNode(decNode.count -1);
            newNode.keys.add(key);
            map.put(key, newNode);
            insertNode(decNode, newNode); //insertion to dll
        }
        decNode.keys.remove(key);
        if(decNode.keys.isEmpty())
            deleteNode(decNode);
    }
    
    public String getMaxKey() {
        return head.prev.keys.isEmpty() ? "" : head.prev.keys.iterator().next();
    }
    
    public String getMinKey() {
        return tail.next.keys.isEmpty() ? "" : tail.next.keys.iterator().next();        
    }
    
    private void insertNode(DllNode current, DllNode insertionNode) {
        current.next.prev = insertionNode;
        insertionNode.next = current.next;
        insertionNode.prev = current;
        current.next = insertionNode;
    }
    
    private void deleteNode(DllNode deletingNode) {
        deletingNode.next.prev = deletingNode.prev;
        deletingNode.prev.next = deletingNode.next;
        deletingNode.prev = null;
        deletingNode.next = null;
    }
    
    class DllNode {
        DllNode prev  = null;
        int count;
        DllNode next  = null;
        Set<String> keys;
        public DllNode(int count) {
            this.count = count;
            keys = new HashSet<>();
        }
    }
}
