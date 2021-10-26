package programs;

import java.util.*;

class MaxStack {
//two stacks
    Stack<Integer> s;
    Stack<Integer> max;

    public MaxStack() {
        s = new Stack<>();
        max = new Stack<>();    
    }
    
    public void push(int x) {
        s.push(x);
        int maxNum = max.isEmpty() ? x : max.peek();
        max.push(maxNum > x ? maxNum : x);
    }
    
    public int pop() {
        max.pop();
        return s.pop();
    }
    
    public int top() {
        return s.peek();
    }
    
    public int peekMax() {
        return max.peek();
    }
    
    public int popMax() {
        int val = max.peek();
        Stack<Integer> temp = new Stack<>();
        while(s.peek() != val) {
            temp.push(pop());
        }
        pop();
        while(!temp.isEmpty()) {
            push(temp.pop());
        }
        return val;
    }
	
//	Follow up: Could you come up with a solution that supports O(1) for each top call and O(logn) for each other call? 
//    class Node {
//        int val;
//        Node prev;
//        Node next;
//        public Node(int x){
//            this.val = x;
//            this.prev = null;
//            this.next = null;
//        }
//        public Node(int x, Node prev, Node next){
//            this.val = x;
//            this.prev = prev;
//            this.next = next;
//        }
//    }
//    
//    
//    Node head; Node tail;
//    TreeMap<Integer, List<Node>> map;
//        
//    /** initialize your data structure here. */
//    public MaxStack() {
//        head = new Node(0);
//        tail = new Node(0);
//        head.next = tail;
//        tail.prev = head;
//        
//        map =new TreeMap<>(); //sorted set 
//    }
//    
//    public void push(int x) {
//        
//        Node n = new Node(x, tail.prev, tail);
//        tail.prev.next = n;
//        tail.prev = n;
//        
//        if(!map.containsKey(x)) map.put(x, new ArrayList<>());
//        map.get(x).add(n);
//        
//    }
//    
//    public int pop() {
//        int popVal = tail.prev.val;
//        removeNode(tail.prev);
//        
//        List<Node> valNodes = map.get(popVal);
//        int size = valNodes.size();
//        valNodes.remove(size-1);
//        
//        if(size == 1) map.remove(popVal);
//        
//        return popVal;
//    }
//    
//    private void removeNode(Node remove) {
//        remove.prev.next = remove.next;
//        remove.next.prev = remove.prev;        
//    }
//    
//    public int top() {
//        return tail.prev.val;
//    }
//    
//    public int peekMax() {
//        return map.lastKey();
//    }
//    
//    public int popMax() {
//        int popMaxVal = map.lastKey();
//        int listSize = map.get(popMaxVal).size();
//        
//        Node node = map.get(popMaxVal).remove(listSize - 1);
//        removeNode(node);
//
//        if(listSize == 1) map.remove(popMaxVal);
//        return popMaxVal;
//    }
}

/**
 * Your MaxStack object will be instantiated and called as such:
 * MaxStack obj = new MaxStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.peekMax();
 * int param_5 = obj.popMax();
 */