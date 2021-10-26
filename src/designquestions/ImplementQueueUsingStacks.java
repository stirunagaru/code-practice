package designquestions;

import java.util.Stack;

public class ImplementQueueUsingStacks {
	    Stack<Integer> s1;
	    Stack<Integer> s2;
	    // int front;
	    public ImplementQueueUsingStacks() {
	        s1 = new Stack<>();
	        s2 = new Stack<>();
	    }
	    
	    public void push(int x) {
	        s1.push(x);
	    }
	    
	    private void prepareHead() {
	         if (s2.empty()) {
	            while (!s1.empty()) {
	                s2.push(s1.pop());
	            }
	        }
	    }
	    
	    public int peek() {
	        prepareHead();
	        return s2.peek();
	    }
	    
	    public int pop() {
	        prepareHead();        
	        return s2.pop();
	    }
	    
	    public boolean empty() {
	        return s1.isEmpty() && s2.empty();
	    }

	    // public void push(int x) {
	    //     if(s1.isEmpty())
	    //         front = x;
	    //     while(!s1.isEmpty())
	    //         s2.push(s1.pop());
	    //     s2.push(x);
	    //     while(!s2.isEmpty())
	    //         s1.push(s2.pop());
	    // }
	    
	    // public int pop() {
	    //     int val = s1.pop();
	    //     if(!s1.isEmpty())
	    //         front = s1.peek();
	    //     return val;
	    // }
}
