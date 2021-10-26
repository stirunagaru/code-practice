package designquestions;

import java.util.LinkedList;
import java.util.Queue;

public class ImplementStackUsingQueues {

	    // two queues
	    private Queue<Integer> q1;
	    // private Queue<Integer> q2;
	    int top;
	    
	    public ImplementStackUsingQueues() {
	        q1 = new LinkedList<>();
	        // q2 = new LinkedList<>();
	    }
	    
	    public void push(int x) {
	        q1.add(x);
	        // top = x;
	        int s = q1.size();
	        
	        while(s-- > 1) {
	            q1.add(q1.remove());
	        }
	    }
	    
	    public int pop() {
	        return q1.remove();
	        // while(q1.size() > 1) {
	        //     top = q1.remove();
	        //     q2.add(top);
	        // }
	        // int x = q1.remove();
	        // Queue<Integer> t = q1;
	        // q1 = q2;
	        // q2 = t;
	        // return x;
	    }
	    
	    public int top() {
	        return q1.peek();
	    }
	    
	    public boolean empty() {
	        return q1.isEmpty();
	    }
	}
