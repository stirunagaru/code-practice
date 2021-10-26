package designquestions;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

class FirstUnique {
    Queue<Integer> q = new ArrayDeque<>();
    Map<Integer, Boolean> unique =  new HashMap<>();
    

    public FirstUnique(int[] nums) {
        for(int i : nums) 
            this.add(i);
    }
    
    public int showFirstUnique() {
        while(!q.isEmpty() && !unique.get(q.peek())) {
            q.remove();
        }
        if(q.isEmpty()) return -1;
        return q.peek();
    
    }
    
    public void add(int value) {
        if(unique.containsKey(value)) {
            unique.put(value, false);
        } else {
            unique.put(value, true);
            q.add(value);
        }
    }
}
