package designquestions;

import java.util.ArrayList;
import java.util.List;

public class BrowserHistory {
	    // Stack<String> history = new Stack<>();
	    // Stack<String> future =  new Stack<>();
	    
	    List<String> visits;
	    int size;
	    int current;

	    public BrowserHistory(String homepage) {
	        // history.push(homepage);
	        visits = new ArrayList<>();
	        visits.add(homepage);
	        size = 1;
	        current = 0;
	    }
	    
	    public void visit(String url) {
	        // history.push(url);
	        // future =  new Stack<>();
	        if(current + 1 < visits.size()) visits.add(current+1, url);
	        else visits.add(url);
	        current++;
	        size = current+1;
	    }
	    
	    public String back(int steps) {
	        // while(steps > 0  && history.size() > 1) {
	        //     future.push(history.pop());
	        //     steps--;
	        // }
	        // return history.peek();
	        
	        current = Math.max(0, current-steps);;
	        return visits.get(current);
	    }
	    
	    public String forward(int steps) {
	        // while(steps > 0  && future.size() > 0) {
	        //     history.push(future.pop());
	        //     steps--;
	        // }
	        // return history.peek();
	        current = Math.min(size-1, current + steps);
	        return visits.get(current);
	    }
	}

	/**
	 * Your BrowserHistory object will be instantiated and called as such:
	 * BrowserHistory obj = new BrowserHistory(homepage);
	 * obj.visit(url);
	 * String param_2 = obj.back(steps);
	 * String param_3 = obj.forward(steps);
	 */